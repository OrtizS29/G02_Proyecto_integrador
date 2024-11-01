/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.jpa_controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.entities.Administrador;
import Modelo.entities.Proyecto;
import Modelo.entities.Torre;
import Modelo.jpa_controllers.exceptions.IllegalOrphanException;
import Modelo.jpa_controllers.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author CLAUDIA
 */
public class ProyectoJpaController implements Serializable {

    public ProyectoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ProyectoJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proyecto proyecto) {
        if (proyecto.getListaTorres() == null) {
            proyecto.setListaTorres(new ArrayList<Torre>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrador administrador = proyecto.getAdministrador();
            if (administrador != null) {
                administrador = em.getReference(administrador.getClass(), administrador.getCedula());
                proyecto.setAdministrador(administrador);
            }
            ArrayList<Torre> attachedListaTorres = new ArrayList<Torre>();
            for (Torre listaTorresTorreToAttach : proyecto.getListaTorres()) {
                listaTorresTorreToAttach = em.getReference(listaTorresTorreToAttach.getClass(), listaTorresTorreToAttach.getId_torre());
                attachedListaTorres.add(listaTorresTorreToAttach);
            }
            proyecto.setListaTorres(attachedListaTorres);
            em.persist(proyecto);
            if (administrador != null) {
                administrador.getListaProyectos().add(proyecto);
                administrador = em.merge(administrador);
            }
            for (Torre listaTorresTorre : proyecto.getListaTorres()) {
                Proyecto oldProyectoOfListaTorresTorre = listaTorresTorre.getProyecto();
                listaTorresTorre.setProyecto(proyecto);
                listaTorresTorre = em.merge(listaTorresTorre);
                if (oldProyectoOfListaTorresTorre != null) {
                    oldProyectoOfListaTorresTorre.getListaTorres().remove(listaTorresTorre);
                    oldProyectoOfListaTorresTorre = em.merge(oldProyectoOfListaTorresTorre);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proyecto proyecto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyecto persistentProyecto = em.find(Proyecto.class, proyecto.getId_proyecto());
            Administrador administradorOld = persistentProyecto.getAdministrador();
            Administrador administradorNew = proyecto.getAdministrador();
            ArrayList<Torre> listaTorresOld = persistentProyecto.getListaTorres();
            ArrayList<Torre> listaTorresNew = proyecto.getListaTorres();
            List<String> illegalOrphanMessages = null;
            for (Torre listaTorresOldTorre : listaTorresOld) {
                if (!listaTorresNew.contains(listaTorresOldTorre)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Torre " + listaTorresOldTorre + " since its proyecto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (administradorNew != null) {
                administradorNew = em.getReference(administradorNew.getClass(), administradorNew.getCedula());
                proyecto.setAdministrador(administradorNew);
            }
            ArrayList<Torre> attachedListaTorresNew = new ArrayList<Torre>();
            for (Torre listaTorresNewTorreToAttach : listaTorresNew) {
                listaTorresNewTorreToAttach = em.getReference(listaTorresNewTorreToAttach.getClass(), listaTorresNewTorreToAttach.getId_torre());
                attachedListaTorresNew.add(listaTorresNewTorreToAttach);
            }
            listaTorresNew = attachedListaTorresNew;
            proyecto.setListaTorres(listaTorresNew);
            proyecto = em.merge(proyecto);
            if (administradorOld != null && !administradorOld.equals(administradorNew)) {
                administradorOld.getListaProyectos().remove(proyecto);
                administradorOld = em.merge(administradorOld);
            }
            if (administradorNew != null && !administradorNew.equals(administradorOld)) {
                administradorNew.getListaProyectos().add(proyecto);
                administradorNew = em.merge(administradorNew);
            }
            for (Torre listaTorresNewTorre : listaTorresNew) {
                if (!listaTorresOld.contains(listaTorresNewTorre)) {
                    Proyecto oldProyectoOfListaTorresNewTorre = listaTorresNewTorre.getProyecto();
                    listaTorresNewTorre.setProyecto(proyecto);
                    listaTorresNewTorre = em.merge(listaTorresNewTorre);
                    if (oldProyectoOfListaTorresNewTorre != null && !oldProyectoOfListaTorresNewTorre.equals(proyecto)) {
                        oldProyectoOfListaTorresNewTorre.getListaTorres().remove(listaTorresNewTorre);
                        oldProyectoOfListaTorresNewTorre = em.merge(oldProyectoOfListaTorresNewTorre);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = proyecto.getId_proyecto();
                if (findProyecto(id) == null) {
                    throw new NonexistentEntityException("The proyecto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void editarNombreYProyecto(Proyecto proyecto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            proyecto = em.merge(proyecto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = proyecto.getId_proyecto();
                if (findProyecto(id) == null) {
                    throw new NonexistentEntityException("El proyecto con id " + id + " no existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyecto proyecto;
            try {
                proyecto = em.getReference(Proyecto.class, id);
                proyecto.getId_proyecto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proyecto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            ArrayList<Torre> listaTorresOrphanCheck = proyecto.getListaTorres();
            for (Torre listaTorresOrphanCheckTorre : listaTorresOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Proyecto (" + proyecto + ") cannot be destroyed since the Torre " + listaTorresOrphanCheckTorre + " in its listaTorres field has a non-nullable proyecto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Administrador administrador = proyecto.getAdministrador();
            if (administrador != null) {
                administrador.getListaProyectos().remove(proyecto);
                administrador = em.merge(administrador);
            }
            em.remove(proyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proyecto> findProyectoEntities() {
        return findProyectoEntities(true, -1, -1);
    }

    public List<Proyecto> findProyectoEntities(int maxResults, int firstResult) {
        return findProyectoEntities(false, maxResults, firstResult);
    }

    private List<Proyecto> findProyectoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proyecto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Proyecto findProyecto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proyecto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProyectoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proyecto> rt = cq.from(Proyecto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Object[]> contarNTorres(){
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT p.nombre_proyecto, COUNT(t) AS numTorres " +
                                          "FROM Proyecto p JOIN p.listaTorres t " +
                                          "GROUP BY p.id_proyecto, p.nombre_proyecto"
            );
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}
