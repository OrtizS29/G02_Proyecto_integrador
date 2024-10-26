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
import Modelo.entities.Proyecto;
import Modelo.entities.Apartamento;
import Modelo.entities.Torre;
import Modelo.jpa_controllers.exceptions.IllegalOrphanException;
import Modelo.jpa_controllers.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author CLAUDIA
 */
public class TorreJpaController implements Serializable {

    public TorreJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Torre torre) {
        if (torre.getListaApartamentos() == null) {
            torre.setListaApartamentos(new ArrayList<Apartamento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyecto proyecto = torre.getProyecto();
            if (proyecto != null) {
                proyecto = em.getReference(proyecto.getClass(), proyecto.getId_proyecto());
                torre.setProyecto(proyecto);
            }
            ArrayList<Apartamento> attachedListaApartamentos = new ArrayList<Apartamento>();
            for (Apartamento listaApartamentosApartamentoToAttach : torre.getListaApartamentos()) {
                listaApartamentosApartamentoToAttach = em.getReference(listaApartamentosApartamentoToAttach.getClass(), listaApartamentosApartamentoToAttach.getId_apartamento());
                attachedListaApartamentos.add(listaApartamentosApartamentoToAttach);
            }
            torre.setListaApartamentos(attachedListaApartamentos);
            em.persist(torre);
            if (proyecto != null) {
                proyecto.getListaTorres().add(torre);
                proyecto = em.merge(proyecto);
            }
            for (Apartamento listaApartamentosApartamento : torre.getListaApartamentos()) {
                Torre oldTorreOfListaApartamentosApartamento = listaApartamentosApartamento.getTorre();
                listaApartamentosApartamento.setTorre(torre);
                listaApartamentosApartamento = em.merge(listaApartamentosApartamento);
                if (oldTorreOfListaApartamentosApartamento != null) {
                    oldTorreOfListaApartamentosApartamento.getListaApartamentos().remove(listaApartamentosApartamento);
                    oldTorreOfListaApartamentosApartamento = em.merge(oldTorreOfListaApartamentosApartamento);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Torre torre) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torre persistentTorre = em.find(Torre.class, torre.getId_torre());
            Proyecto proyectoOld = persistentTorre.getProyecto();
            Proyecto proyectoNew = torre.getProyecto();
            ArrayList<Apartamento> listaApartamentosOld = persistentTorre.getListaApartamentos();
            ArrayList<Apartamento> listaApartamentosNew = torre.getListaApartamentos();
            List<String> illegalOrphanMessages = null;
            for (Apartamento listaApartamentosOldApartamento : listaApartamentosOld) {
                if (!listaApartamentosNew.contains(listaApartamentosOldApartamento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Apartamento " + listaApartamentosOldApartamento + " since its torre field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (proyectoNew != null) {
                proyectoNew = em.getReference(proyectoNew.getClass(), proyectoNew.getId_proyecto());
                torre.setProyecto(proyectoNew);
            }
            ArrayList<Apartamento> attachedListaApartamentosNew = new ArrayList<Apartamento>();
            for (Apartamento listaApartamentosNewApartamentoToAttach : listaApartamentosNew) {
                listaApartamentosNewApartamentoToAttach = em.getReference(listaApartamentosNewApartamentoToAttach.getClass(), listaApartamentosNewApartamentoToAttach.getId_apartamento());
                attachedListaApartamentosNew.add(listaApartamentosNewApartamentoToAttach);
            }
            listaApartamentosNew = attachedListaApartamentosNew;
            torre.setListaApartamentos(listaApartamentosNew);
            torre = em.merge(torre);
            if (proyectoOld != null && !proyectoOld.equals(proyectoNew)) {
                proyectoOld.getListaTorres().remove(torre);
                proyectoOld = em.merge(proyectoOld);
            }
            if (proyectoNew != null && !proyectoNew.equals(proyectoOld)) {
                proyectoNew.getListaTorres().add(torre);
                proyectoNew = em.merge(proyectoNew);
            }
            for (Apartamento listaApartamentosNewApartamento : listaApartamentosNew) {
                if (!listaApartamentosOld.contains(listaApartamentosNewApartamento)) {
                    Torre oldTorreOfListaApartamentosNewApartamento = listaApartamentosNewApartamento.getTorre();
                    listaApartamentosNewApartamento.setTorre(torre);
                    listaApartamentosNewApartamento = em.merge(listaApartamentosNewApartamento);
                    if (oldTorreOfListaApartamentosNewApartamento != null && !oldTorreOfListaApartamentosNewApartamento.equals(torre)) {
                        oldTorreOfListaApartamentosNewApartamento.getListaApartamentos().remove(listaApartamentosNewApartamento);
                        oldTorreOfListaApartamentosNewApartamento = em.merge(oldTorreOfListaApartamentosNewApartamento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = torre.getId_torre();
                if (findTorre(id) == null) {
                    throw new NonexistentEntityException("The torre with id " + id + " no longer exists.");
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
            Torre torre;
            try {
                torre = em.getReference(Torre.class, id);
                torre.getId_torre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The torre with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            ArrayList<Apartamento> listaApartamentosOrphanCheck = torre.getListaApartamentos();
            for (Apartamento listaApartamentosOrphanCheckApartamento : listaApartamentosOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Torre (" + torre + ") cannot be destroyed since the Apartamento " + listaApartamentosOrphanCheckApartamento + " in its listaApartamentos field has a non-nullable torre field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Proyecto proyecto = torre.getProyecto();
            if (proyecto != null) {
                proyecto.getListaTorres().remove(torre);
                proyecto = em.merge(proyecto);
            }
            em.remove(torre);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Torre> findTorreEntities() {
        return findTorreEntities(true, -1, -1);
    }

    public List<Torre> findTorreEntities(int maxResults, int firstResult) {
        return findTorreEntities(false, maxResults, firstResult);
    }

    private List<Torre> findTorreEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Torre.class));
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

    public Torre findTorre(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Torre.class, id);
        } finally {
            em.close();
        }
    }

    public int getTorreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Torre> rt = cq.from(Torre.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
