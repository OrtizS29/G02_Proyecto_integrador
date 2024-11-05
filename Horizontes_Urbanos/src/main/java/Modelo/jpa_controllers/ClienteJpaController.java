
package Modelo.jpa_controllers;

import Modelo.entities.Cliente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.entities.Telefono;
import java.util.ArrayList;
import Modelo.entities.Correo;
import Modelo.entities.Venta;
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
 * @author CLAUDIA
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ClienteJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) throws PreexistingEntityException, Exception {
        if (cliente.getListaTelefonosCliente() == null) {
            cliente.setListaTelefonosCliente(new ArrayList<Telefono>());
        }
        if (cliente.getListaCorreosCliente() == null) {
            cliente.setListaCorreosCliente(new ArrayList<Correo>());
        }
        if (cliente.getListaVentas() == null) {
            cliente.setListaVentas(new ArrayList<Venta>());
        }
        if (cliente.getListaPagos() == null) {
            cliente.setListaPagos(new ArrayList<Pago>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Telefono> attachedListaTelefonosCliente = new ArrayList<Telefono>();
            for (Telefono listaTelefonosClienteTelefonoToAttach : cliente.getListaTelefonosCliente()) {
                listaTelefonosClienteTelefonoToAttach = em.getReference(listaTelefonosClienteTelefonoToAttach.getClass(), listaTelefonosClienteTelefonoToAttach.getId());
                attachedListaTelefonosCliente.add(listaTelefonosClienteTelefonoToAttach);
            }
            cliente.setListaTelefonosCliente(attachedListaTelefonosCliente);
            ArrayList<Correo> attachedListaCorreosCliente = new ArrayList<Correo>();
            for (Correo listaCorreosClienteCorreoToAttach : cliente.getListaCorreosCliente()) {
                listaCorreosClienteCorreoToAttach = em.getReference(listaCorreosClienteCorreoToAttach.getClass(), listaCorreosClienteCorreoToAttach.getId());
                attachedListaCorreosCliente.add(listaCorreosClienteCorreoToAttach);
            }
            cliente.setListaCorreosCliente(attachedListaCorreosCliente);
            ArrayList<Venta> attachedListaVentas = new ArrayList<Venta>();
            for (Venta listaVentasVentaToAttach : cliente.getListaVentas()) {
                listaVentasVentaToAttach = em.getReference(listaVentasVentaToAttach.getClass(), listaVentasVentaToAttach.getId_venta());
                attachedListaVentas.add(listaVentasVentaToAttach);
            }
            cliente.setListaVentas(attachedListaVentas);
            ArrayList<Pago> attachedListaPagos = new ArrayList<Pago>();
            for (Pago listaPagosPagoToAttach : cliente.getListaPagos()) {
                listaPagosPagoToAttach = em.getReference(listaPagosPagoToAttach.getClass(), listaPagosPagoToAttach.getId_pago());
                attachedListaPagos.add(listaPagosPagoToAttach);
            }
            cliente.setListaPagos(attachedListaPagos);
            em.persist(cliente);
            for (Telefono listaTelefonosClienteTelefono : cliente.getListaTelefonosCliente()) {
                Cliente oldClienteOfListaTelefonosClienteTelefono = listaTelefonosClienteTelefono.getCliente();
                listaTelefonosClienteTelefono.setCliente(cliente);
                listaTelefonosClienteTelefono = em.merge(listaTelefonosClienteTelefono);
                if (oldClienteOfListaTelefonosClienteTelefono != null) {
                    oldClienteOfListaTelefonosClienteTelefono.getListaTelefonosCliente().remove(listaTelefonosClienteTelefono);
                    oldClienteOfListaTelefonosClienteTelefono = em.merge(oldClienteOfListaTelefonosClienteTelefono);
                }
            }
            for (Correo listaCorreosClienteCorreo : cliente.getListaCorreosCliente()) {
                Cliente oldClienteOfListaCorreosClienteCorreo = listaCorreosClienteCorreo.getCliente();
                listaCorreosClienteCorreo.setCliente(cliente);
                listaCorreosClienteCorreo = em.merge(listaCorreosClienteCorreo);
                if (oldClienteOfListaCorreosClienteCorreo != null) {
                    oldClienteOfListaCorreosClienteCorreo.getListaCorreosCliente().remove(listaCorreosClienteCorreo);
                    oldClienteOfListaCorreosClienteCorreo = em.merge(oldClienteOfListaCorreosClienteCorreo);
                }
            }
            for (Venta listaVentasVenta : cliente.getListaVentas()) {
                Cliente oldClienteOfListaVentasVenta = listaVentasVenta.getCliente();
                listaVentasVenta.setCliente(cliente);
                listaVentasVenta = em.merge(listaVentasVenta);
                if (oldClienteOfListaVentasVenta != null) {
                    oldClienteOfListaVentasVenta.getListaVentas().remove(listaVentasVenta);
                    oldClienteOfListaVentasVenta = em.merge(oldClienteOfListaVentasVenta);
                }
            }
            for (Pago listaPagosPago : cliente.getListaPagos()) {
                Cliente oldClienteOfListaPagosPago = listaPagosPago.getCliente();
                listaPagosPago.setCliente(cliente);
                listaPagosPago = em.merge(listaPagosPago);
                if (oldClienteOfListaPagosPago != null) {
                    oldClienteOfListaPagosPago.getListaPagos().remove(listaPagosPago);
                    oldClienteOfListaPagosPago = em.merge(oldClienteOfListaPagosPago);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCliente(cliente.getCedula()) != null) {
                throw new PreexistingEntityException("Cliente " + cliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getCedula());
            ArrayList<Telefono> listaTelefonosClienteOld = persistentCliente.getListaTelefonosCliente();
            ArrayList<Telefono> listaTelefonosClienteNew = cliente.getListaTelefonosCliente();
            ArrayList<Correo> listaCorreosClienteOld = persistentCliente.getListaCorreosCliente();
            ArrayList<Correo> listaCorreosClienteNew = cliente.getListaCorreosCliente();
            ArrayList<Venta> listaVentasOld = persistentCliente.getListaVentas();
            ArrayList<Venta> listaVentasNew = cliente.getListaVentas();
            ArrayList<Pago> listaPagosOld = persistentCliente.getListaPagos();
            ArrayList<Pago> listaPagosNew = cliente.getListaPagos();
            List<String> illegalOrphanMessages = null;
            for (Telefono listaTelefonosClienteOldTelefono : listaTelefonosClienteOld) {
                if (!listaTelefonosClienteNew.contains(listaTelefonosClienteOldTelefono)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Telefono " + listaTelefonosClienteOldTelefono + " since its cliente field is not nullable.");
                }
            }
            for (Correo listaCorreosClienteOldCorreo : listaCorreosClienteOld) {
                if (!listaCorreosClienteNew.contains(listaCorreosClienteOldCorreo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Correo " + listaCorreosClienteOldCorreo + " since its cliente field is not nullable.");
                }
            }
            for (Venta listaVentasOldVenta : listaVentasOld) {
                if (!listaVentasNew.contains(listaVentasOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + listaVentasOldVenta + " since its cliente field is not nullable.");
                }
            }
            for (Pago listaPagosOldPago : listaPagosOld) {
                if (!listaPagosNew.contains(listaPagosOldPago)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pago " + listaPagosOldPago + " since its cliente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            ArrayList<Telefono> attachedListaTelefonosClienteNew = new ArrayList<Telefono>();
            for (Telefono listaTelefonosClienteNewTelefonoToAttach : listaTelefonosClienteNew) {
                listaTelefonosClienteNewTelefonoToAttach = em.getReference(listaTelefonosClienteNewTelefonoToAttach.getClass(), listaTelefonosClienteNewTelefonoToAttach.getId());
                attachedListaTelefonosClienteNew.add(listaTelefonosClienteNewTelefonoToAttach);
            }
            listaTelefonosClienteNew = attachedListaTelefonosClienteNew;
            cliente.setListaTelefonosCliente(listaTelefonosClienteNew);
            ArrayList<Correo> attachedListaCorreosClienteNew = new ArrayList<Correo>();
            for (Correo listaCorreosClienteNewCorreoToAttach : listaCorreosClienteNew) {
                listaCorreosClienteNewCorreoToAttach = em.getReference(listaCorreosClienteNewCorreoToAttach.getClass(), listaCorreosClienteNewCorreoToAttach.getId());
                attachedListaCorreosClienteNew.add(listaCorreosClienteNewCorreoToAttach);
            }
            listaCorreosClienteNew = attachedListaCorreosClienteNew;
            cliente.setListaCorreosCliente(listaCorreosClienteNew);
            ArrayList<Venta> attachedListaVentasNew = new ArrayList<Venta>();
            for (Venta listaVentasNewVentaToAttach : listaVentasNew) {
                listaVentasNewVentaToAttach = em.getReference(listaVentasNewVentaToAttach.getClass(), listaVentasNewVentaToAttach.getId_venta());
                attachedListaVentasNew.add(listaVentasNewVentaToAttach);
            }
            listaVentasNew = attachedListaVentasNew;
            cliente.setListaVentas(listaVentasNew);
            ArrayList<Pago> attachedListaPagosNew = new ArrayList<Pago>();
            for (Pago listaPagosNewPagoToAttach : listaPagosNew) {
                listaPagosNewPagoToAttach = em.getReference(listaPagosNewPagoToAttach.getClass(), listaPagosNewPagoToAttach.getId_pago());
                attachedListaPagosNew.add(listaPagosNewPagoToAttach);
            }
            listaPagosNew = attachedListaPagosNew;
            cliente.setListaPagos(listaPagosNew);
            cliente = em.merge(cliente);
            for (Telefono listaTelefonosClienteNewTelefono : listaTelefonosClienteNew) {
                if (!listaTelefonosClienteOld.contains(listaTelefonosClienteNewTelefono)) {
                    Cliente oldClienteOfListaTelefonosClienteNewTelefono = listaTelefonosClienteNewTelefono.getCliente();
                    listaTelefonosClienteNewTelefono.setCliente(cliente);
                    listaTelefonosClienteNewTelefono = em.merge(listaTelefonosClienteNewTelefono);
                    if (oldClienteOfListaTelefonosClienteNewTelefono != null && !oldClienteOfListaTelefonosClienteNewTelefono.equals(cliente)) {
                        oldClienteOfListaTelefonosClienteNewTelefono.getListaTelefonosCliente().remove(listaTelefonosClienteNewTelefono);
                        oldClienteOfListaTelefonosClienteNewTelefono = em.merge(oldClienteOfListaTelefonosClienteNewTelefono);
                    }
                }
            }
            for (Correo listaCorreosClienteNewCorreo : listaCorreosClienteNew) {
                if (!listaCorreosClienteOld.contains(listaCorreosClienteNewCorreo)) {
                    Cliente oldClienteOfListaCorreosClienteNewCorreo = listaCorreosClienteNewCorreo.getCliente();
                    listaCorreosClienteNewCorreo.setCliente(cliente);
                    listaCorreosClienteNewCorreo = em.merge(listaCorreosClienteNewCorreo);
                    if (oldClienteOfListaCorreosClienteNewCorreo != null && !oldClienteOfListaCorreosClienteNewCorreo.equals(cliente)) {
                        oldClienteOfListaCorreosClienteNewCorreo.getListaCorreosCliente().remove(listaCorreosClienteNewCorreo);
                        oldClienteOfListaCorreosClienteNewCorreo = em.merge(oldClienteOfListaCorreosClienteNewCorreo);
                    }
                }
            }
            for (Venta listaVentasNewVenta : listaVentasNew) {
                if (!listaVentasOld.contains(listaVentasNewVenta)) {
                    Cliente oldClienteOfListaVentasNewVenta = listaVentasNewVenta.getCliente();
                    listaVentasNewVenta.setCliente(cliente);
                    listaVentasNewVenta = em.merge(listaVentasNewVenta);
                    if (oldClienteOfListaVentasNewVenta != null && !oldClienteOfListaVentasNewVenta.equals(cliente)) {
                        oldClienteOfListaVentasNewVenta.getListaVentas().remove(listaVentasNewVenta);
                        oldClienteOfListaVentasNewVenta = em.merge(oldClienteOfListaVentasNewVenta);
                    }
                }
            }
            for (Pago listaPagosNewPago : listaPagosNew) {
                if (!listaPagosOld.contains(listaPagosNewPago)) {
                    Cliente oldClienteOfListaPagosNewPago = listaPagosNewPago.getCliente();
                    listaPagosNewPago.setCliente(cliente);
                    listaPagosNewPago = em.merge(listaPagosNewPago);
                    if (oldClienteOfListaPagosNewPago != null && !oldClienteOfListaPagosNewPago.equals(cliente)) {
                        oldClienteOfListaPagosNewPago.getListaPagos().remove(listaPagosNewPago);
                        oldClienteOfListaPagosNewPago = em.merge(oldClienteOfListaPagosNewPago);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cliente.getCedula();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getCedula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            ArrayList<Telefono> listaTelefonosClienteOrphanCheck = cliente.getListaTelefonosCliente();
            for (Telefono listaTelefonosClienteOrphanCheckTelefono : listaTelefonosClienteOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Telefono " + listaTelefonosClienteOrphanCheckTelefono + " in its listaTelefonosCliente field has a non-nullable cliente field.");
            }
            ArrayList<Correo> listaCorreosClienteOrphanCheck = cliente.getListaCorreosCliente();
            for (Correo listaCorreosClienteOrphanCheckCorreo : listaCorreosClienteOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Correo " + listaCorreosClienteOrphanCheckCorreo + " in its listaCorreosCliente field has a non-nullable cliente field.");
            }
            ArrayList<Venta> listaVentasOrphanCheck = cliente.getListaVentas();
            for (Venta listaVentasOrphanCheckVenta : listaVentasOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Venta " + listaVentasOrphanCheckVenta + " in its listaVentas field has a non-nullable cliente field.");
            }
            ArrayList<Pago> listaPagosOrphanCheck = cliente.getListaPagos();
            for (Pago listaPagosOrphanCheckPago : listaPagosOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Pago " + listaPagosOrphanCheckPago + " in its listaPagos field has a non-nullable cliente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
