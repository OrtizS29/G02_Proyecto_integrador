
package Modelo.jpa_controllers;

import Modelo.entities.Venta;
import Modelo.entities.Telefono_cliente;
import Modelo.entities.Pago;
import Modelo.entities.Correo_cliente;
import Modelo.entities.Cliente;
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
            cliente.setListaTelefonosCliente(new LinkedList<Telefono_cliente>());
        }
        if (cliente.getListaCorreosCliente() == null) {
            cliente.setListaCorreosCliente(new LinkedList<Correo_cliente>());
        }
        if (cliente.getListaVentas() == null) {
            cliente.setListaVentas(new LinkedList<Venta>());
        }
        if (cliente.getListaPagos() == null) {
            cliente.setListaPagos(new LinkedList<Pago>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LinkedList<Telefono_cliente> attachedListaTelefonosCliente = new LinkedList<Telefono_cliente>();
            for (Telefono_cliente listaTelefonosClienteTelefono_clienteToAttach : cliente.getListaTelefonosCliente()) {
                listaTelefonosClienteTelefono_clienteToAttach = em.getReference(listaTelefonosClienteTelefono_clienteToAttach.getClass(), listaTelefonosClienteTelefono_clienteToAttach.getId());
                attachedListaTelefonosCliente.add(listaTelefonosClienteTelefono_clienteToAttach);
            }
            cliente.setListaTelefonosCliente(attachedListaTelefonosCliente);
            LinkedList<Correo_cliente> attachedListaCorreosCliente = new LinkedList<Correo_cliente>();
            for (Correo_cliente listaCorreosClienteCorreo_clienteToAttach : cliente.getListaCorreosCliente()) {
                listaCorreosClienteCorreo_clienteToAttach = em.getReference(listaCorreosClienteCorreo_clienteToAttach.getClass(), listaCorreosClienteCorreo_clienteToAttach.getId());
                attachedListaCorreosCliente.add(listaCorreosClienteCorreo_clienteToAttach);
            }
            cliente.setListaCorreosCliente(attachedListaCorreosCliente);
            LinkedList<Venta> attachedListaVentas = new LinkedList<Venta>();
            for (Venta listaVentasVentaToAttach : cliente.getListaVentas()) {
                listaVentasVentaToAttach = em.getReference(listaVentasVentaToAttach.getClass(), listaVentasVentaToAttach.getId_venta());
                attachedListaVentas.add(listaVentasVentaToAttach);
            }
            cliente.setListaVentas(attachedListaVentas);
            LinkedList<Pago> attachedListaPagos = new LinkedList<Pago>();
            for (Pago listaPagosPagoToAttach : cliente.getListaPagos()) {
                listaPagosPagoToAttach = em.getReference(listaPagosPagoToAttach.getClass(), listaPagosPagoToAttach.getId_pago());
                attachedListaPagos.add(listaPagosPagoToAttach);
            }
            cliente.setListaPagos(attachedListaPagos);
            em.persist(cliente);
            for (Telefono_cliente listaTelefonosClienteTelefono_cliente : cliente.getListaTelefonosCliente()) {
                Cliente oldClienteOfListaTelefonosClienteTelefono_cliente = listaTelefonosClienteTelefono_cliente.getCliente();
                listaTelefonosClienteTelefono_cliente.setCliente(cliente);
                listaTelefonosClienteTelefono_cliente = em.merge(listaTelefonosClienteTelefono_cliente);
                if (oldClienteOfListaTelefonosClienteTelefono_cliente != null) {
                    oldClienteOfListaTelefonosClienteTelefono_cliente.getListaTelefonosCliente().remove(listaTelefonosClienteTelefono_cliente);
                    oldClienteOfListaTelefonosClienteTelefono_cliente = em.merge(oldClienteOfListaTelefonosClienteTelefono_cliente);
                }
            }
            for (Correo_cliente listaCorreosClienteCorreo_cliente : cliente.getListaCorreosCliente()) {
                Cliente oldClienteOfListaCorreosClienteCorreo_cliente = listaCorreosClienteCorreo_cliente.getCliente();
                listaCorreosClienteCorreo_cliente.setCliente(cliente);
                listaCorreosClienteCorreo_cliente = em.merge(listaCorreosClienteCorreo_cliente);
                if (oldClienteOfListaCorreosClienteCorreo_cliente != null) {
                    oldClienteOfListaCorreosClienteCorreo_cliente.getListaCorreosCliente().remove(listaCorreosClienteCorreo_cliente);
                    oldClienteOfListaCorreosClienteCorreo_cliente = em.merge(oldClienteOfListaCorreosClienteCorreo_cliente);
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
            LinkedList<Telefono_cliente> listaTelefonosClienteOld = persistentCliente.getListaTelefonosCliente();
            LinkedList<Telefono_cliente> listaTelefonosClienteNew = cliente.getListaTelefonosCliente();
            LinkedList<Correo_cliente> listaCorreosClienteOld = persistentCliente.getListaCorreosCliente();
            LinkedList<Correo_cliente> listaCorreosClienteNew = cliente.getListaCorreosCliente();
            LinkedList<Venta> listaVentasOld = persistentCliente.getListaVentas();
            LinkedList<Venta> listaVentasNew = cliente.getListaVentas();
            LinkedList<Pago> listaPagosOld = persistentCliente.getListaPagos();
            LinkedList<Pago> listaPagosNew = cliente.getListaPagos();
            List<String> illegalOrphanMessages = null;
            for (Telefono_cliente listaTelefonosClienteOldTelefono_cliente : listaTelefonosClienteOld) {
                if (!listaTelefonosClienteNew.contains(listaTelefonosClienteOldTelefono_cliente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Telefono_cliente " + listaTelefonosClienteOldTelefono_cliente + " since its cliente field is not nullable.");
                }
            }
            for (Correo_cliente listaCorreosClienteOldCorreo_cliente : listaCorreosClienteOld) {
                if (!listaCorreosClienteNew.contains(listaCorreosClienteOldCorreo_cliente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Correo_cliente " + listaCorreosClienteOldCorreo_cliente + " since its cliente field is not nullable.");
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
            LinkedList<Telefono_cliente> attachedListaTelefonosClienteNew = new LinkedList<Telefono_cliente>();
            for (Telefono_cliente listaTelefonosClienteNewTelefono_clienteToAttach : listaTelefonosClienteNew) {
                listaTelefonosClienteNewTelefono_clienteToAttach = em.getReference(listaTelefonosClienteNewTelefono_clienteToAttach.getClass(), listaTelefonosClienteNewTelefono_clienteToAttach.getId());
                attachedListaTelefonosClienteNew.add(listaTelefonosClienteNewTelefono_clienteToAttach);
            }
            listaTelefonosClienteNew = attachedListaTelefonosClienteNew;
            cliente.setListaTelefonosCliente(listaTelefonosClienteNew);
            LinkedList<Correo_cliente> attachedListaCorreosClienteNew = new LinkedList<Correo_cliente>();
            for (Correo_cliente listaCorreosClienteNewCorreo_clienteToAttach : listaCorreosClienteNew) {
                listaCorreosClienteNewCorreo_clienteToAttach = em.getReference(listaCorreosClienteNewCorreo_clienteToAttach.getClass(), listaCorreosClienteNewCorreo_clienteToAttach.getId());
                attachedListaCorreosClienteNew.add(listaCorreosClienteNewCorreo_clienteToAttach);
            }
            listaCorreosClienteNew = attachedListaCorreosClienteNew;
            cliente.setListaCorreosCliente(listaCorreosClienteNew);
            LinkedList<Venta> attachedListaVentasNew = new LinkedList<Venta>();
            for (Venta listaVentasNewVentaToAttach : listaVentasNew) {
                listaVentasNewVentaToAttach = em.getReference(listaVentasNewVentaToAttach.getClass(), listaVentasNewVentaToAttach.getId_venta());
                attachedListaVentasNew.add(listaVentasNewVentaToAttach);
            }
            listaVentasNew = attachedListaVentasNew;
            cliente.setListaVentas(listaVentasNew);
            LinkedList<Pago> attachedListaPagosNew = new LinkedList<Pago>();
            for (Pago listaPagosNewPagoToAttach : listaPagosNew) {
                listaPagosNewPagoToAttach = em.getReference(listaPagosNewPagoToAttach.getClass(), listaPagosNewPagoToAttach.getId_pago());
                attachedListaPagosNew.add(listaPagosNewPagoToAttach);
            }
            listaPagosNew = attachedListaPagosNew;
            cliente.setListaPagos(listaPagosNew);
            cliente = em.merge(cliente);
            for (Telefono_cliente listaTelefonosClienteNewTelefono_cliente : listaTelefonosClienteNew) {
                if (!listaTelefonosClienteOld.contains(listaTelefonosClienteNewTelefono_cliente)) {
                    Cliente oldClienteOfListaTelefonosClienteNewTelefono_cliente = listaTelefonosClienteNewTelefono_cliente.getCliente();
                    listaTelefonosClienteNewTelefono_cliente.setCliente(cliente);
                    listaTelefonosClienteNewTelefono_cliente = em.merge(listaTelefonosClienteNewTelefono_cliente);
                    if (oldClienteOfListaTelefonosClienteNewTelefono_cliente != null && !oldClienteOfListaTelefonosClienteNewTelefono_cliente.equals(cliente)) {
                        oldClienteOfListaTelefonosClienteNewTelefono_cliente.getListaTelefonosCliente().remove(listaTelefonosClienteNewTelefono_cliente);
                        oldClienteOfListaTelefonosClienteNewTelefono_cliente = em.merge(oldClienteOfListaTelefonosClienteNewTelefono_cliente);
                    }
                }
            }
            for (Correo_cliente listaCorreosClienteNewCorreo_cliente : listaCorreosClienteNew) {
                if (!listaCorreosClienteOld.contains(listaCorreosClienteNewCorreo_cliente)) {
                    Cliente oldClienteOfListaCorreosClienteNewCorreo_cliente = listaCorreosClienteNewCorreo_cliente.getCliente();
                    listaCorreosClienteNewCorreo_cliente.setCliente(cliente);
                    listaCorreosClienteNewCorreo_cliente = em.merge(listaCorreosClienteNewCorreo_cliente);
                    if (oldClienteOfListaCorreosClienteNewCorreo_cliente != null && !oldClienteOfListaCorreosClienteNewCorreo_cliente.equals(cliente)) {
                        oldClienteOfListaCorreosClienteNewCorreo_cliente.getListaCorreosCliente().remove(listaCorreosClienteNewCorreo_cliente);
                        oldClienteOfListaCorreosClienteNewCorreo_cliente = em.merge(oldClienteOfListaCorreosClienteNewCorreo_cliente);
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
            LinkedList<Telefono_cliente> listaTelefonosClienteOrphanCheck = cliente.getListaTelefonosCliente();
            for (Telefono_cliente listaTelefonosClienteOrphanCheckTelefono_cliente : listaTelefonosClienteOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Telefono_cliente " + listaTelefonosClienteOrphanCheckTelefono_cliente + " in its listaTelefonosCliente field has a non-nullable cliente field.");
            }
            LinkedList<Correo_cliente> listaCorreosClienteOrphanCheck = cliente.getListaCorreosCliente();
            for (Correo_cliente listaCorreosClienteOrphanCheckCorreo_cliente : listaCorreosClienteOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Correo_cliente " + listaCorreosClienteOrphanCheckCorreo_cliente + " in its listaCorreosCliente field has a non-nullable cliente field.");
            }
            LinkedList<Venta> listaVentasOrphanCheck = cliente.getListaVentas();
            for (Venta listaVentasOrphanCheckVenta : listaVentasOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Venta " + listaVentasOrphanCheckVenta + " in its listaVentas field has a non-nullable cliente field.");
            }
            LinkedList<Pago> listaPagosOrphanCheck = cliente.getListaPagos();
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
