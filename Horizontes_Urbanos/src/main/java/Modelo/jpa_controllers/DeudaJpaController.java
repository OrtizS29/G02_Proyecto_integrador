
package Modelo.jpa_controllers;

import Modelo.entities.Deuda;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.entities.Venta;
import Modelo.jpa_controllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Santiago
 */
public class DeudaJpaController implements Serializable {

    public DeudaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public DeudaJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Deuda deuda) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta venta = deuda.getVenta();
            if (venta != null) {
                venta = em.getReference(venta.getClass(), venta.getId_venta());
                deuda.setVenta(venta);
            }
            em.persist(deuda);
            if (venta != null) {
                venta.getListaDeuda().add(deuda);
                venta = em.merge(venta);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Deuda deuda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Deuda persistentDeuda = em.find(Deuda.class, deuda.getId_deuda());
            Venta ventaOld = persistentDeuda.getVenta();
            Venta ventaNew = deuda.getVenta();
            if (ventaNew != null) {
                ventaNew = em.getReference(ventaNew.getClass(), ventaNew.getId_venta());
                deuda.setVenta(ventaNew);
            }
            deuda = em.merge(deuda);
            if (ventaOld != null && !ventaOld.equals(ventaNew)) {
                ventaOld.getListaDeuda().remove(deuda);
                ventaOld = em.merge(ventaOld);
            }
            if (ventaNew != null && !ventaNew.equals(ventaOld)) {
                ventaNew.getListaDeuda().add(deuda);
                ventaNew = em.merge(ventaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = deuda.getId_deuda();
                if (findDeuda(id) == null) {
                    throw new NonexistentEntityException("The deuda with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Deuda deuda;
            try {
                deuda = em.getReference(Deuda.class, id);
                deuda.getId_deuda();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The deuda with id " + id + " no longer exists.", enfe);
            }
            Venta venta = deuda.getVenta();
            if (venta != null) {
                venta.getListaDeuda().remove(deuda);
                venta = em.merge(venta);
            }
            em.remove(deuda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Deuda> findDeudaEntities() {
        return findDeudaEntities(true, -1, -1);
    }

    public List<Deuda> findDeudaEntities(int maxResults, int firstResult) {
        return findDeudaEntities(false, maxResults, firstResult);
    }

    private List<Deuda> findDeudaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Deuda.class));
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

    public Deuda findDeuda(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Deuda.class, id);
        } finally {
            em.close();
        }
    }

    public int getDeudaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Deuda> rt = cq.from(Deuda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
