/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.jpa_controllers;

import Modelo.entities.Apartamento;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.entities.Torre;
import Modelo.entities.Venta;
import Modelo.jpa_controllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author CLAUDIA
 */
public class ApartamentoJpaController implements Serializable {

    public ApartamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ApartamentoJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Apartamento apartamento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torre torre = apartamento.getTorre();
            if (torre != null) {
                torre = em.getReference(torre.getClass(), torre.getId_torre());
                apartamento.setTorre(torre);
            }
            Venta venta = apartamento.getVenta();
            if (venta != null) {
                venta = em.getReference(venta.getClass(), venta.getId_venta());
                apartamento.setVenta(venta);
            }
            em.persist(apartamento);
            if (torre != null) {
                torre.getListaApartamentos().add(apartamento);
                torre = em.merge(torre);
            }
            if (venta != null) {
                venta.getListaApartamentos().add(apartamento);
                venta = em.merge(venta);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Apartamento apartamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Apartamento persistentApartamento = em.find(Apartamento.class, apartamento.getId_apartamento());
            Torre torreOld = persistentApartamento.getTorre();
            Torre torreNew = apartamento.getTorre();
            Venta ventaOld = persistentApartamento.getVenta();
            Venta ventaNew = apartamento.getVenta();
            if (torreNew != null) {
                torreNew = em.getReference(torreNew.getClass(), torreNew.getId_torre());
                apartamento.setTorre(torreNew);
            }
            if (ventaNew != null) {
                ventaNew = em.getReference(ventaNew.getClass(), ventaNew.getId_venta());
                apartamento.setVenta(ventaNew);
            }
            apartamento = em.merge(apartamento);
            if (torreOld != null && !torreOld.equals(torreNew)) {
                torreOld.getListaApartamentos().remove(apartamento);
                torreOld = em.merge(torreOld);
            }
            if (torreNew != null && !torreNew.equals(torreOld)) {
                torreNew.getListaApartamentos().add(apartamento);
                torreNew = em.merge(torreNew);
            }
            if (ventaOld != null && !ventaOld.equals(ventaNew)) {
                ventaOld.getListaApartamentos().remove(apartamento);
                ventaOld = em.merge(ventaOld);
            }
            if (ventaNew != null && !ventaNew.equals(ventaOld)) {
                ventaNew.getListaApartamentos().add(apartamento);
                ventaNew = em.merge(ventaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = apartamento.getId_apartamento();
                if (findApartamento(id) == null) {
                    throw new NonexistentEntityException("The apartamento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Apartamento apartamento;
            try {
                apartamento = em.getReference(Apartamento.class, id);
                apartamento.getId_apartamento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The apartamento with id " + id + " no longer exists.", enfe);
            }
            Torre torre = apartamento.getTorre();
            if (torre != null) {
                torre.getListaApartamentos().remove(apartamento);
                torre = em.merge(torre);
            }
            Venta venta = apartamento.getVenta();
            if (venta != null) {
                venta.getListaApartamentos().remove(apartamento);
                venta = em.merge(venta);
            }
            em.remove(apartamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Apartamento> findApartamentoEntities() {
        return findApartamentoEntities(true, -1, -1);
    }

    public List<Apartamento> findApartamentoEntities(int maxResults, int firstResult) {
        return findApartamentoEntities(false, maxResults, firstResult);
    }

    private List<Apartamento> findApartamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Apartamento.class));
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

    public Apartamento findApartamento(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Apartamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getApartamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Apartamento> rt = cq.from(Apartamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
