
package Modelo;

import Modelo.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Santiago
 */
public class PagoJpaController implements Serializable {

    public PagoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public PagoJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pago pago) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta venta = pago.getVenta();
            if (venta != null) {
                venta = em.getReference(venta.getClass(), venta.getId_venta());
                pago.setVenta(venta);
            }
            Asesor asesor = pago.getAsesor();
            if (asesor != null) {
                asesor = em.getReference(asesor.getClass(), asesor.getCedula());
                pago.setAsesor(asesor);
            }
            Cliente cliente = pago.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getCedula());
                pago.setCliente(cliente);
            }
            em.persist(pago);
            if (venta != null) {
                venta.getListaPagos().add(pago);
                venta = em.merge(venta);
            }
            if (asesor != null) {
                asesor.getListaPagos().add(pago);
                asesor = em.merge(asesor);
            }
            if (cliente != null) {
                cliente.getListaPagos().add(pago);
                cliente = em.merge(cliente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pago pago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pago persistentPago = em.find(Pago.class, pago.getId_pago());
            Venta ventaOld = persistentPago.getVenta();
            Venta ventaNew = pago.getVenta();
            Asesor asesorOld = persistentPago.getAsesor();
            Asesor asesorNew = pago.getAsesor();
            Cliente clienteOld = persistentPago.getCliente();
            Cliente clienteNew = pago.getCliente();
            if (ventaNew != null) {
                ventaNew = em.getReference(ventaNew.getClass(), ventaNew.getId_venta());
                pago.setVenta(ventaNew);
            }
            if (asesorNew != null) {
                asesorNew = em.getReference(asesorNew.getClass(), asesorNew.getCedula());
                pago.setAsesor(asesorNew);
            }
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getCedula());
                pago.setCliente(clienteNew);
            }
            pago = em.merge(pago);
            if (ventaOld != null && !ventaOld.equals(ventaNew)) {
                ventaOld.getListaPagos().remove(pago);
                ventaOld = em.merge(ventaOld);
            }
            if (ventaNew != null && !ventaNew.equals(ventaOld)) {
                ventaNew.getListaPagos().add(pago);
                ventaNew = em.merge(ventaNew);
            }
            if (asesorOld != null && !asesorOld.equals(asesorNew)) {
                asesorOld.getListaPagos().remove(pago);
                asesorOld = em.merge(asesorOld);
            }
            if (asesorNew != null && !asesorNew.equals(asesorOld)) {
                asesorNew.getListaPagos().add(pago);
                asesorNew = em.merge(asesorNew);
            }
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getListaPagos().remove(pago);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getListaPagos().add(pago);
                clienteNew = em.merge(clienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = pago.getId_pago();
                if (findPago(id) == null) {
                    throw new NonexistentEntityException("The pago with id " + id + " no longer exists.");
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
            Pago pago;
            try {
                pago = em.getReference(Pago.class, id);
                pago.getId_pago();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pago with id " + id + " no longer exists.", enfe);
            }
            Venta venta = pago.getVenta();
            if (venta != null) {
                venta.getListaPagos().remove(pago);
                venta = em.merge(venta);
            }
            Asesor asesor = pago.getAsesor();
            if (asesor != null) {
                asesor.getListaPagos().remove(pago);
                asesor = em.merge(asesor);
            }
            Cliente cliente = pago.getCliente();
            if (cliente != null) {
                cliente.getListaPagos().remove(pago);
                cliente = em.merge(cliente);
            }
            em.remove(pago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pago> findPagoEntities() {
        return findPagoEntities(true, -1, -1);
    }

    public List<Pago> findPagoEntities(int maxResults, int firstResult) {
        return findPagoEntities(false, maxResults, firstResult);
    }

    private List<Pago> findPagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pago.class));
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

    public Pago findPago(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pago.class, id);
        } finally {
            em.close();
        }
    }

    public int getPagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pago> rt = cq.from(Pago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
