
package Modelo.jpa_controllers;

import Modelo.entities.Venta;
import Modelo.entities.Telefono_asesor;
import Modelo.entities.Pago;
import Modelo.entities.Correo_asesor;
import Modelo.entities.Asesor;
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
            asesor.setListaVentas(new LinkedList<Venta>());
        }
        if (asesor.getListaPagos() == null) {
            asesor.setListaPagos(new LinkedList<Pago>());
        }
        if (asesor.getListaTelefonosCliente() == null) {
            asesor.setListaTelefonosCliente(new LinkedList<Telefono_asesor>());
        }
        if (asesor.getListaCorreoCliente() == null) {
            asesor.setListaCorreoCliente(new LinkedList<Correo_asesor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LinkedList<Venta> attachedListaVentas = new LinkedList<Venta>();
            for (Venta listaVentasVentaToAttach : asesor.getListaVentas()) {
                listaVentasVentaToAttach = em.getReference(listaVentasVentaToAttach.getClass(), listaVentasVentaToAttach.getId_venta());
                attachedListaVentas.add(listaVentasVentaToAttach);
            }
            asesor.setListaVentas(attachedListaVentas);
            LinkedList<Pago> attachedListaPagos = new LinkedList<Pago>();
            for (Pago listaPagosPagoToAttach : asesor.getListaPagos()) {
                listaPagosPagoToAttach = em.getReference(listaPagosPagoToAttach.getClass(), listaPagosPagoToAttach.getId_pago());
                attachedListaPagos.add(listaPagosPagoToAttach);
            }
            asesor.setListaPagos(attachedListaPagos);
            LinkedList<Telefono_asesor> attachedListaTelefonosCliente = new LinkedList<Telefono_asesor>();
            for (Telefono_asesor listaTelefonosClienteTelefono_asesorToAttach : asesor.getListaTelefonosCliente()) {
                listaTelefonosClienteTelefono_asesorToAttach = em.getReference(listaTelefonosClienteTelefono_asesorToAttach.getClass(), listaTelefonosClienteTelefono_asesorToAttach.getId());
                attachedListaTelefonosCliente.add(listaTelefonosClienteTelefono_asesorToAttach);
            }
            asesor.setListaTelefonosCliente(attachedListaTelefonosCliente);
            LinkedList<Correo_asesor> attachedListaCorreoCliente = new LinkedList<Correo_asesor>();
            for (Correo_asesor listaCorreoClienteCorreo_asesorToAttach : asesor.getListaCorreoCliente()) {
                listaCorreoClienteCorreo_asesorToAttach = em.getReference(listaCorreoClienteCorreo_asesorToAttach.getClass(), listaCorreoClienteCorreo_asesorToAttach.getId());
                attachedListaCorreoCliente.add(listaCorreoClienteCorreo_asesorToAttach);
            }
            asesor.setListaCorreoCliente(attachedListaCorreoCliente);
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
            for (Telefono_asesor listaTelefonosClienteTelefono_asesor : asesor.getListaTelefonosCliente()) {
                Asesor oldAsesorOfListaTelefonosClienteTelefono_asesor = listaTelefonosClienteTelefono_asesor.getAsesor();
                listaTelefonosClienteTelefono_asesor.setAsesor(asesor);
                listaTelefonosClienteTelefono_asesor = em.merge(listaTelefonosClienteTelefono_asesor);
                if (oldAsesorOfListaTelefonosClienteTelefono_asesor != null) {
                    oldAsesorOfListaTelefonosClienteTelefono_asesor.getListaTelefonosCliente().remove(listaTelefonosClienteTelefono_asesor);
                    oldAsesorOfListaTelefonosClienteTelefono_asesor = em.merge(oldAsesorOfListaTelefonosClienteTelefono_asesor);
                }
            }
            for (Correo_asesor listaCorreoClienteCorreo_asesor : asesor.getListaCorreoCliente()) {
                Asesor oldAsesorOfListaCorreoClienteCorreo_asesor = listaCorreoClienteCorreo_asesor.getAsesor();
                listaCorreoClienteCorreo_asesor.setAsesor(asesor);
                listaCorreoClienteCorreo_asesor = em.merge(listaCorreoClienteCorreo_asesor);
                if (oldAsesorOfListaCorreoClienteCorreo_asesor != null) {
                    oldAsesorOfListaCorreoClienteCorreo_asesor.getListaCorreoCliente().remove(listaCorreoClienteCorreo_asesor);
                    oldAsesorOfListaCorreoClienteCorreo_asesor = em.merge(oldAsesorOfListaCorreoClienteCorreo_asesor);
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
            LinkedList<Venta> listaVentasOld = persistentAsesor.getListaVentas();
            LinkedList<Venta> listaVentasNew = asesor.getListaVentas();
            LinkedList<Pago> listaPagosOld = persistentAsesor.getListaPagos();
            LinkedList<Pago> listaPagosNew = asesor.getListaPagos();
            LinkedList<Telefono_asesor> listaTelefonosClienteOld = persistentAsesor.getListaTelefonosCliente();
            LinkedList<Telefono_asesor> listaTelefonosClienteNew = asesor.getListaTelefonosCliente();
            LinkedList<Correo_asesor> listaCorreoClienteOld = persistentAsesor.getListaCorreoCliente();
            LinkedList<Correo_asesor> listaCorreoClienteNew = asesor.getListaCorreoCliente();
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
            for (Telefono_asesor listaTelefonosClienteOldTelefono_asesor : listaTelefonosClienteOld) {
                if (!listaTelefonosClienteNew.contains(listaTelefonosClienteOldTelefono_asesor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Telefono_asesor " + listaTelefonosClienteOldTelefono_asesor + " since its asesor field is not nullable.");
                }
            }
            for (Correo_asesor listaCorreoClienteOldCorreo_asesor : listaCorreoClienteOld) {
                if (!listaCorreoClienteNew.contains(listaCorreoClienteOldCorreo_asesor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Correo_asesor " + listaCorreoClienteOldCorreo_asesor + " since its asesor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            LinkedList<Venta> attachedListaVentasNew = new LinkedList<Venta>();
            for (Venta listaVentasNewVentaToAttach : listaVentasNew) {
                listaVentasNewVentaToAttach = em.getReference(listaVentasNewVentaToAttach.getClass(), listaVentasNewVentaToAttach.getId_venta());
                attachedListaVentasNew.add(listaVentasNewVentaToAttach);
            }
            listaVentasNew = attachedListaVentasNew;
            asesor.setListaVentas(listaVentasNew);
            LinkedList<Pago> attachedListaPagosNew = new LinkedList<Pago>();
            for (Pago listaPagosNewPagoToAttach : listaPagosNew) {
                listaPagosNewPagoToAttach = em.getReference(listaPagosNewPagoToAttach.getClass(), listaPagosNewPagoToAttach.getId_pago());
                attachedListaPagosNew.add(listaPagosNewPagoToAttach);
            }
            listaPagosNew = attachedListaPagosNew;
            asesor.setListaPagos(listaPagosNew);
            LinkedList<Telefono_asesor> attachedListaTelefonosClienteNew = new LinkedList<Telefono_asesor>();
            for (Telefono_asesor listaTelefonosClienteNewTelefono_asesorToAttach : listaTelefonosClienteNew) {
                listaTelefonosClienteNewTelefono_asesorToAttach = em.getReference(listaTelefonosClienteNewTelefono_asesorToAttach.getClass(), listaTelefonosClienteNewTelefono_asesorToAttach.getId());
                attachedListaTelefonosClienteNew.add(listaTelefonosClienteNewTelefono_asesorToAttach);
            }
            listaTelefonosClienteNew = attachedListaTelefonosClienteNew;
            asesor.setListaTelefonosCliente(listaTelefonosClienteNew);
            LinkedList<Correo_asesor> attachedListaCorreoClienteNew = new LinkedList<Correo_asesor>();
            for (Correo_asesor listaCorreoClienteNewCorreo_asesorToAttach : listaCorreoClienteNew) {
                listaCorreoClienteNewCorreo_asesorToAttach = em.getReference(listaCorreoClienteNewCorreo_asesorToAttach.getClass(), listaCorreoClienteNewCorreo_asesorToAttach.getId());
                attachedListaCorreoClienteNew.add(listaCorreoClienteNewCorreo_asesorToAttach);
            }
            listaCorreoClienteNew = attachedListaCorreoClienteNew;
            asesor.setListaCorreoCliente(listaCorreoClienteNew);
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
            for (Telefono_asesor listaTelefonosClienteNewTelefono_asesor : listaTelefonosClienteNew) {
                if (!listaTelefonosClienteOld.contains(listaTelefonosClienteNewTelefono_asesor)) {
                    Asesor oldAsesorOfListaTelefonosClienteNewTelefono_asesor = listaTelefonosClienteNewTelefono_asesor.getAsesor();
                    listaTelefonosClienteNewTelefono_asesor.setAsesor(asesor);
                    listaTelefonosClienteNewTelefono_asesor = em.merge(listaTelefonosClienteNewTelefono_asesor);
                    if (oldAsesorOfListaTelefonosClienteNewTelefono_asesor != null && !oldAsesorOfListaTelefonosClienteNewTelefono_asesor.equals(asesor)) {
                        oldAsesorOfListaTelefonosClienteNewTelefono_asesor.getListaTelefonosCliente().remove(listaTelefonosClienteNewTelefono_asesor);
                        oldAsesorOfListaTelefonosClienteNewTelefono_asesor = em.merge(oldAsesorOfListaTelefonosClienteNewTelefono_asesor);
                    }
                }
            }
            for (Correo_asesor listaCorreoClienteNewCorreo_asesor : listaCorreoClienteNew) {
                if (!listaCorreoClienteOld.contains(listaCorreoClienteNewCorreo_asesor)) {
                    Asesor oldAsesorOfListaCorreoClienteNewCorreo_asesor = listaCorreoClienteNewCorreo_asesor.getAsesor();
                    listaCorreoClienteNewCorreo_asesor.setAsesor(asesor);
                    listaCorreoClienteNewCorreo_asesor = em.merge(listaCorreoClienteNewCorreo_asesor);
                    if (oldAsesorOfListaCorreoClienteNewCorreo_asesor != null && !oldAsesorOfListaCorreoClienteNewCorreo_asesor.equals(asesor)) {
                        oldAsesorOfListaCorreoClienteNewCorreo_asesor.getListaCorreoCliente().remove(listaCorreoClienteNewCorreo_asesor);
                        oldAsesorOfListaCorreoClienteNewCorreo_asesor = em.merge(oldAsesorOfListaCorreoClienteNewCorreo_asesor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = asesor.getCedula();
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

    public void destroy(int id) throws IllegalOrphanException, NonexistentEntityException {
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
            LinkedList<Venta> listaVentasOrphanCheck = asesor.getListaVentas();
            for (Venta listaVentasOrphanCheckVenta : listaVentasOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Asesor (" + asesor + ") cannot be destroyed since the Venta " + listaVentasOrphanCheckVenta + " in its listaVentas field has a non-nullable asesor field.");
            }
            LinkedList<Pago> listaPagosOrphanCheck = asesor.getListaPagos();
            for (Pago listaPagosOrphanCheckPago : listaPagosOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Asesor (" + asesor + ") cannot be destroyed since the Pago " + listaPagosOrphanCheckPago + " in its listaPagos field has a non-nullable asesor field.");
            }
            LinkedList<Telefono_asesor> listaTelefonosClienteOrphanCheck = asesor.getListaTelefonosCliente();
            for (Telefono_asesor listaTelefonosClienteOrphanCheckTelefono_asesor : listaTelefonosClienteOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Asesor (" + asesor + ") cannot be destroyed since the Telefono_asesor " + listaTelefonosClienteOrphanCheckTelefono_asesor + " in its listaTelefonosCliente field has a non-nullable asesor field.");
            }
            LinkedList<Correo_asesor> listaCorreoClienteOrphanCheck = asesor.getListaCorreoCliente();
            for (Correo_asesor listaCorreoClienteOrphanCheckCorreo_asesor : listaCorreoClienteOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Asesor (" + asesor + ") cannot be destroyed since the Correo_asesor " + listaCorreoClienteOrphanCheckCorreo_asesor + " in its listaCorreoCliente field has a non-nullable asesor field.");
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

    public Asesor findAsesor(int id) {
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
