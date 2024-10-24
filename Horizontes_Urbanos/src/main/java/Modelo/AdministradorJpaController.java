
package Modelo;

import Modelo.exceptions.IllegalOrphanException;
import Modelo.exceptions.NonexistentEntityException;
import Modelo.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Santiago
 */
public class AdministradorJpaController implements Serializable {

    public AdministradorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public AdministradorJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Administrador administrador) throws PreexistingEntityException, Exception {
        if (administrador.getListaProyectos() == null) {
            administrador.setListaProyectos(new LinkedList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LinkedList<Proyecto> attachedListaProyectos = new LinkedList<Proyecto>();
            for (Proyecto listaProyectosProyectoToAttach : administrador.getListaProyectos()) {
                listaProyectosProyectoToAttach = em.getReference(listaProyectosProyectoToAttach.getClass(), listaProyectosProyectoToAttach.getId_proyecto());
                attachedListaProyectos.add(listaProyectosProyectoToAttach);
            }
            administrador.setListaProyectos(attachedListaProyectos);
            em.persist(administrador);
            for (Proyecto listaProyectosProyecto : administrador.getListaProyectos()) {
                Administrador oldAdministradorOfListaProyectosProyecto = listaProyectosProyecto.getAdministrador();
                listaProyectosProyecto.setAdministrador(administrador);
                listaProyectosProyecto = em.merge(listaProyectosProyecto);
                if (oldAdministradorOfListaProyectosProyecto != null) {
                    oldAdministradorOfListaProyectosProyecto.getListaProyectos().remove(listaProyectosProyecto);
                    oldAdministradorOfListaProyectosProyecto = em.merge(oldAdministradorOfListaProyectosProyecto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAdministrador(administrador.getCedula()) != null) {
                throw new PreexistingEntityException("Administrador " + administrador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Administrador administrador) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrador persistentAdministrador = em.find(Administrador.class, administrador.getCedula());
            LinkedList<Proyecto> listaProyectosOld = persistentAdministrador.getListaProyectos();
            LinkedList<Proyecto> listaProyectosNew = administrador.getListaProyectos();
            List<String> illegalOrphanMessages = null;
            for (Proyecto listaProyectosOldProyecto : listaProyectosOld) {
                if (!listaProyectosNew.contains(listaProyectosOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + listaProyectosOldProyecto + " since its administrador field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            LinkedList<Proyecto> attachedListaProyectosNew = new LinkedList<Proyecto>();
            for (Proyecto listaProyectosNewProyectoToAttach : listaProyectosNew) {
                listaProyectosNewProyectoToAttach = em.getReference(listaProyectosNewProyectoToAttach.getClass(), listaProyectosNewProyectoToAttach.getId_proyecto());
                attachedListaProyectosNew.add(listaProyectosNewProyectoToAttach);
            }
            listaProyectosNew = attachedListaProyectosNew;
            administrador.setListaProyectos(listaProyectosNew);
            administrador = em.merge(administrador);
            for (Proyecto listaProyectosNewProyecto : listaProyectosNew) {
                if (!listaProyectosOld.contains(listaProyectosNewProyecto)) {
                    Administrador oldAdministradorOfListaProyectosNewProyecto = listaProyectosNewProyecto.getAdministrador();
                    listaProyectosNewProyecto.setAdministrador(administrador);
                    listaProyectosNewProyecto = em.merge(listaProyectosNewProyecto);
                    if (oldAdministradorOfListaProyectosNewProyecto != null && !oldAdministradorOfListaProyectosNewProyecto.equals(administrador)) {
                        oldAdministradorOfListaProyectosNewProyecto.getListaProyectos().remove(listaProyectosNewProyecto);
                        oldAdministradorOfListaProyectosNewProyecto = em.merge(oldAdministradorOfListaProyectosNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = administrador.getCedula();
                if (findAdministrador(id) == null) {
                    throw new NonexistentEntityException("The administrador with id " + id + " no longer exists.");
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
            Administrador administrador;
            try {
                administrador = em.getReference(Administrador.class, id);
                administrador.getCedula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administrador with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            LinkedList<Proyecto> listaProyectosOrphanCheck = administrador.getListaProyectos();
            for (Proyecto listaProyectosOrphanCheckProyecto : listaProyectosOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Administrador (" + administrador + ") cannot be destroyed since the Proyecto " + listaProyectosOrphanCheckProyecto + " in its listaProyectos field has a non-nullable administrador field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(administrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Administrador> findAdministradorEntities() {
        return findAdministradorEntities(true, -1, -1);
    }

    public List<Administrador> findAdministradorEntities(int maxResults, int firstResult) {
        return findAdministradorEntities(false, maxResults, firstResult);
    }

    private List<Administrador> findAdministradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Administrador.class));
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

    public Administrador findAdministrador(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Administrador.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Administrador> rt = cq.from(Administrador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
