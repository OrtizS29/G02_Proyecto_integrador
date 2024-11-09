
package Modelo.jpa_controllers;

import Modelo.entities.Asesor;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.entities.Venta;
import java.util.ArrayList;
import Modelo.entities.Pago;
import Modelo.jpa_controllers.exceptions.IllegalOrphanException;
import Modelo.jpa_controllers.exceptions.NonexistentEntityException;
import Modelo.jpa_controllers.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Santiago
 */
public class AsesorJpaController implements Serializable {

    public AsesorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public AsesorJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Asesor asesor) throws PreexistingEntityException, Exception {
        if (asesor.getListaVentas() == null) {
            asesor.setListaVentas(new ArrayList<Venta>());
        }
        if (asesor.getListaPagos() == null) {
            asesor.setListaPagos(new ArrayList<Pago>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Venta> attachedListaVentas = new ArrayList<Venta>();
            for (Venta listaVentasVentaToAttach : asesor.getListaVentas()) {
                listaVentasVentaToAttach = em.getReference(listaVentasVentaToAttach.getClass(), listaVentasVentaToAttach.getId_venta());
                attachedListaVentas.add(listaVentasVentaToAttach);
            }
            asesor.setListaVentas(attachedListaVentas);
            ArrayList<Pago> attachedListaPagos = new ArrayList<Pago>();
            for (Pago listaPagosPagoToAttach : asesor.getListaPagos()) {
                listaPagosPagoToAttach = em.getReference(listaPagosPagoToAttach.getClass(), listaPagosPagoToAttach.getId_pago());
                attachedListaPagos.add(listaPagosPagoToAttach);
            }
            asesor.setListaPagos(attachedListaPagos);
            em.persist(asesor);
            for (Venta listaVentasVenta : asesor.getListaVentas()) {
                Asesor oldAsesorOfListaVentasVenta = listaVentasVenta.getAsesor();
                listaVentasVenta.setAsesor(asesor);
                listaVentasVenta = em.merge(listaVentasVenta);
                if (oldAsesorOfListaVentasVenta != null) {
                    oldAsesorOfListaVentasVenta.getListaVentas().remove(listaVentasVenta);
                    oldAsesorOfListaVentasVenta = em.merge(oldAsesorOfListaVentasVenta);
                }
            }
            for (Pago listaPagosPago : asesor.getListaPagos()) {
                Asesor oldAsesorOfListaPagosPago = listaPagosPago.getAsesor();
                listaPagosPago.setAsesor(asesor);
                listaPagosPago = em.merge(listaPagosPago);
                if (oldAsesorOfListaPagosPago != null) {
                    oldAsesorOfListaPagosPago.getListaPagos().remove(listaPagosPago);
                    oldAsesorOfListaPagosPago = em.merge(oldAsesorOfListaPagosPago);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAsesor(asesor.getCedula()) != null) {
                throw new PreexistingEntityException("Asesor " + asesor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Asesor asesor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asesor persistentAsesor = em.find(Asesor.class, asesor.getCedula());
            ArrayList<Venta> listaVentasOld = persistentAsesor.getListaVentas();
            ArrayList<Venta> listaVentasNew = asesor.getListaVentas();
            ArrayList<Pago> listaPagosOld = persistentAsesor.getListaPagos();
            ArrayList<Pago> listaPagosNew = asesor.getListaPagos();
            List<String> illegalOrphanMessages = null;
            for (Venta listaVentasOldVenta : listaVentasOld) {
                if (!listaVentasNew.contains(listaVentasOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + listaVentasOldVenta + " since its asesor field is not nullable.");
                }
            }
            for (Pago listaPagosOldPago : listaPagosOld) {
                if (!listaPagosNew.contains(listaPagosOldPago)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pago " + listaPagosOldPago + " since its asesor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            ArrayList<Venta> attachedListaVentasNew = new ArrayList<Venta>();
            for (Venta listaVentasNewVentaToAttach : listaVentasNew) {
                listaVentasNewVentaToAttach = em.getReference(listaVentasNewVentaToAttach.getClass(), listaVentasNewVentaToAttach.getId_venta());
                attachedListaVentasNew.add(listaVentasNewVentaToAttach);
            }
            listaVentasNew = attachedListaVentasNew;
            asesor.setListaVentas(listaVentasNew);
            ArrayList<Pago> attachedListaPagosNew = new ArrayList<Pago>();
            for (Pago listaPagosNewPagoToAttach : listaPagosNew) {
                listaPagosNewPagoToAttach = em.getReference(listaPagosNewPagoToAttach.getClass(), listaPagosNewPagoToAttach.getId_pago());
                attachedListaPagosNew.add(listaPagosNewPagoToAttach);
            }
            listaPagosNew = attachedListaPagosNew;
            asesor.setListaPagos(listaPagosNew);
            asesor = em.merge(asesor);
            for (Venta listaVentasNewVenta : listaVentasNew) {
                if (!listaVentasOld.contains(listaVentasNewVenta)) {
                    Asesor oldAsesorOfListaVentasNewVenta = listaVentasNewVenta.getAsesor();
                    listaVentasNewVenta.setAsesor(asesor);
                    listaVentasNewVenta = em.merge(listaVentasNewVenta);
                    if (oldAsesorOfListaVentasNewVenta != null && !oldAsesorOfListaVentasNewVenta.equals(asesor)) {
                        oldAsesorOfListaVentasNewVenta.getListaVentas().remove(listaVentasNewVenta);
                        oldAsesorOfListaVentasNewVenta = em.merge(oldAsesorOfListaVentasNewVenta);
                    }
                }
            }
            for (Pago listaPagosNewPago : listaPagosNew) {
                if (!listaPagosOld.contains(listaPagosNewPago)) {
                    Asesor oldAsesorOfListaPagosNewPago = listaPagosNewPago.getAsesor();
                    listaPagosNewPago.setAsesor(asesor);
                    listaPagosNewPago = em.merge(listaPagosNewPago);
                    if (oldAsesorOfListaPagosNewPago != null && !oldAsesorOfListaPagosNewPago.equals(asesor)) {
                        oldAsesorOfListaPagosNewPago.getListaPagos().remove(listaPagosNewPago);
                        oldAsesorOfListaPagosNewPago = em.merge(oldAsesorOfListaPagosNewPago);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = asesor.getCedula();
                if (findAsesor(id) == null) {
                    throw new NonexistentEntityException("The asesor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asesor asesor;
            try {
                asesor = em.getReference(Asesor.class, id);
                asesor.getCedula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asesor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            ArrayList<Venta> listaVentasOrphanCheck = asesor.getListaVentas();
            for (Venta listaVentasOrphanCheckVenta : listaVentasOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Asesor (" + asesor + ") cannot be destroyed since the Venta " + listaVentasOrphanCheckVenta + " in its listaVentas field has a non-nullable asesor field.");
            }
            ArrayList<Pago> listaPagosOrphanCheck = asesor.getListaPagos();
            for (Pago listaPagosOrphanCheckPago : listaPagosOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Asesor (" + asesor + ") cannot be destroyed since the Pago " + listaPagosOrphanCheckPago + " in its listaPagos field has a non-nullable asesor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(asesor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Asesor> findAsesorEntities() {
        return findAsesorEntities(true, -1, -1);
    }

    public List<Asesor> findAsesorEntities(int maxResults, int firstResult) {
        return findAsesorEntities(false, maxResults, firstResult);
    }

    private List<Asesor> findAsesorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Asesor.class));
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

    public Asesor findAsesor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Asesor.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsesorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Asesor> rt = cq.from(Asesor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
