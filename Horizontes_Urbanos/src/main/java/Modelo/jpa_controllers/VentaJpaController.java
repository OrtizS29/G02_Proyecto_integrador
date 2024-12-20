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
import Modelo.entities.Asesor;
import Modelo.entities.Cliente;
import Modelo.entities.Apartamento;
import java.util.ArrayList;
import Modelo.entities.Pago;
import Modelo.entities.Deuda;
import Modelo.entities.Venta;
import Modelo.jpa_controllers.exceptions.IllegalOrphanException;
import Modelo.jpa_controllers.exceptions.NonexistentEntityException;
import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author CLAUDIA
 */
public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public VentaJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) {
        if (venta.getListaApartamentos() == null) {
            venta.setListaApartamentos(new ArrayList<Apartamento>());
        }
        if (venta.getListaPagos() == null) {
            venta.setListaPagos(new ArrayList<Pago>());
        }
        if (venta.getListaDeuda() == null) {
            venta.setListaDeuda(new ArrayList<Deuda>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asesor asesor = venta.getAsesor();
            if (asesor != null) {
                asesor = em.getReference(asesor.getClass(), asesor.getCedula());
                venta.setAsesor(asesor);
            }
            Cliente cliente = venta.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getCedula());
                venta.setCliente(cliente);
            }
            ArrayList<Apartamento> attachedListaApartamentos = new ArrayList<Apartamento>();
            for (Apartamento listaApartamentosApartamentoToAttach : venta.getListaApartamentos()) {
                listaApartamentosApartamentoToAttach = em.getReference(listaApartamentosApartamentoToAttach.getClass(), listaApartamentosApartamentoToAttach.getId_apartamento());
                attachedListaApartamentos.add(listaApartamentosApartamentoToAttach);
            }
            venta.setListaApartamentos(attachedListaApartamentos);
            ArrayList<Pago> attachedListaPagos = new ArrayList<Pago>();
            for (Pago listaPagosPagoToAttach : venta.getListaPagos()) {
                listaPagosPagoToAttach = em.getReference(listaPagosPagoToAttach.getClass(), listaPagosPagoToAttach.getId_pago());
                attachedListaPagos.add(listaPagosPagoToAttach);
            }
            venta.setListaPagos(attachedListaPagos);
            ArrayList<Deuda> attachedListaDeuda = new ArrayList<Deuda>();
            for (Deuda listaDeudaDeudaToAttach : venta.getListaDeuda()) {
                listaDeudaDeudaToAttach = em.getReference(listaDeudaDeudaToAttach.getClass(), listaDeudaDeudaToAttach.getId_deuda());
                attachedListaDeuda.add(listaDeudaDeudaToAttach);
            }
            venta.setListaDeuda(attachedListaDeuda);
            em.persist(venta);
            if (asesor != null) {
                asesor.getListaVentas().add(venta);
                asesor = em.merge(asesor);
            }
            if (cliente != null) {
                cliente.getListaVentas().add(venta);
                cliente = em.merge(cliente);
            }
            for (Apartamento listaApartamentosApartamento : venta.getListaApartamentos()) {
                Venta oldVentaOfListaApartamentosApartamento = listaApartamentosApartamento.getVenta();
                listaApartamentosApartamento.setVenta(venta);
                listaApartamentosApartamento = em.merge(listaApartamentosApartamento);
                if (oldVentaOfListaApartamentosApartamento != null) {
                    oldVentaOfListaApartamentosApartamento.getListaApartamentos().remove(listaApartamentosApartamento);
                    oldVentaOfListaApartamentosApartamento = em.merge(oldVentaOfListaApartamentosApartamento);
                }
            }
            for (Pago listaPagosPago : venta.getListaPagos()) {
                Venta oldVentaOfListaPagosPago = listaPagosPago.getVenta();
                listaPagosPago.setVenta(venta);
                listaPagosPago = em.merge(listaPagosPago);
                if (oldVentaOfListaPagosPago != null) {
                    oldVentaOfListaPagosPago.getListaPagos().remove(listaPagosPago);
                    oldVentaOfListaPagosPago = em.merge(oldVentaOfListaPagosPago);
                }
            }
            for (Deuda listaDeudaDeuda : venta.getListaDeuda()) {
                Venta oldVentaOfListaDeudaDeuda = listaDeudaDeuda.getVenta();
                listaDeudaDeuda.setVenta(venta);
                listaDeudaDeuda = em.merge(listaDeudaDeuda);
                if (oldVentaOfListaDeudaDeuda != null) {
                    oldVentaOfListaDeudaDeuda.getListaDeuda().remove(listaDeudaDeuda);
                    oldVentaOfListaDeudaDeuda = em.merge(oldVentaOfListaDeudaDeuda);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editarVentaC(Venta venta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            venta = em.merge(venta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = venta.getId_venta();
                if (findVenta(id) == null) {
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
    
    public void edit(Venta venta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getId_venta());
            Asesor asesorOld = persistentVenta.getAsesor();
            Asesor asesorNew = venta.getAsesor();
            Cliente clienteOld = persistentVenta.getCliente();
            Cliente clienteNew = venta.getCliente();
            ArrayList<Apartamento> listaApartamentosOld = persistentVenta.getListaApartamentos();
            ArrayList<Apartamento> listaApartamentosNew = venta.getListaApartamentos();
            ArrayList<Pago> listaPagosOld = persistentVenta.getListaPagos();
            ArrayList<Pago> listaPagosNew = venta.getListaPagos();
            ArrayList<Deuda> listaDeudaOld = persistentVenta.getListaDeuda();
            ArrayList<Deuda> listaDeudaNew = venta.getListaDeuda();
            List<String> illegalOrphanMessages = null;
            for (Pago listaPagosOldPago : listaPagosOld) {
                if (!listaPagosNew.contains(listaPagosOldPago)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pago " + listaPagosOldPago + " since its venta field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (asesorNew != null) {
                asesorNew = em.getReference(asesorNew.getClass(), asesorNew.getCedula());
                venta.setAsesor(asesorNew);
            }
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getCedula());
                venta.setCliente(clienteNew);
            }
            ArrayList<Apartamento> attachedListaApartamentosNew = new ArrayList<Apartamento>();
            for (Apartamento listaApartamentosNewApartamentoToAttach : listaApartamentosNew) {
                listaApartamentosNewApartamentoToAttach = em.getReference(listaApartamentosNewApartamentoToAttach.getClass(), listaApartamentosNewApartamentoToAttach.getId_apartamento());
                attachedListaApartamentosNew.add(listaApartamentosNewApartamentoToAttach);
            }
            listaApartamentosNew = attachedListaApartamentosNew;
            venta.setListaApartamentos(listaApartamentosNew);
            ArrayList<Pago> attachedListaPagosNew = new ArrayList<Pago>();
            for (Pago listaPagosNewPagoToAttach : listaPagosNew) {
                listaPagosNewPagoToAttach = em.getReference(listaPagosNewPagoToAttach.getClass(), listaPagosNewPagoToAttach.getId_pago());
                attachedListaPagosNew.add(listaPagosNewPagoToAttach);
            }
            listaPagosNew = attachedListaPagosNew;
            venta.setListaPagos(listaPagosNew);
            ArrayList<Deuda> attachedListaDeudaNew = new ArrayList<Deuda>();
            for (Deuda listaDeudaNewDeudaToAttach : listaDeudaNew) {
                listaDeudaNewDeudaToAttach = em.getReference(listaDeudaNewDeudaToAttach.getClass(), listaDeudaNewDeudaToAttach.getId_deuda());
                attachedListaDeudaNew.add(listaDeudaNewDeudaToAttach);
            }
            listaDeudaNew = attachedListaDeudaNew;
            venta.setListaDeuda(listaDeudaNew);
            venta = em.merge(venta);
            if (asesorOld != null && !asesorOld.equals(asesorNew)) {
                asesorOld.getListaVentas().remove(venta);
                asesorOld = em.merge(asesorOld);
            }
            if (asesorNew != null && !asesorNew.equals(asesorOld)) {
                asesorNew.getListaVentas().add(venta);
                asesorNew = em.merge(asesorNew);
            }
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getListaVentas().remove(venta);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getListaVentas().add(venta);
                clienteNew = em.merge(clienteNew);
            }
            for (Apartamento listaApartamentosOldApartamento : listaApartamentosOld) {
                if (!listaApartamentosNew.contains(listaApartamentosOldApartamento)) {
                    listaApartamentosOldApartamento.setVenta(null);
                    listaApartamentosOldApartamento = em.merge(listaApartamentosOldApartamento);
                }
            }
            for (Apartamento listaApartamentosNewApartamento : listaApartamentosNew) {
                if (!listaApartamentosOld.contains(listaApartamentosNewApartamento)) {
                    Venta oldVentaOfListaApartamentosNewApartamento = listaApartamentosNewApartamento.getVenta();
                    listaApartamentosNewApartamento.setVenta(venta);
                    listaApartamentosNewApartamento = em.merge(listaApartamentosNewApartamento);
                    if (oldVentaOfListaApartamentosNewApartamento != null && !oldVentaOfListaApartamentosNewApartamento.equals(venta)) {
                        oldVentaOfListaApartamentosNewApartamento.getListaApartamentos().remove(listaApartamentosNewApartamento);
                        oldVentaOfListaApartamentosNewApartamento = em.merge(oldVentaOfListaApartamentosNewApartamento);
                    }
                }
            }
            for (Pago listaPagosNewPago : listaPagosNew) {
                if (!listaPagosOld.contains(listaPagosNewPago)) {
                    Venta oldVentaOfListaPagosNewPago = listaPagosNewPago.getVenta();
                    listaPagosNewPago.setVenta(venta);
                    listaPagosNewPago = em.merge(listaPagosNewPago);
                    if (oldVentaOfListaPagosNewPago != null && !oldVentaOfListaPagosNewPago.equals(venta)) {
                        oldVentaOfListaPagosNewPago.getListaPagos().remove(listaPagosNewPago);
                        oldVentaOfListaPagosNewPago = em.merge(oldVentaOfListaPagosNewPago);
                    }
                }
            }
            for (Deuda listaDeudaOldDeuda : listaDeudaOld) {
                if (!listaDeudaNew.contains(listaDeudaOldDeuda)) {
                    listaDeudaOldDeuda.setVenta(null);
                    listaDeudaOldDeuda = em.merge(listaDeudaOldDeuda);
                }
            }
            for (Deuda listaDeudaNewDeuda : listaDeudaNew) {
                if (!listaDeudaOld.contains(listaDeudaNewDeuda)) {
                    Venta oldVentaOfListaDeudaNewDeuda = listaDeudaNewDeuda.getVenta();
                    listaDeudaNewDeuda.setVenta(venta);
                    listaDeudaNewDeuda = em.merge(listaDeudaNewDeuda);
                    if (oldVentaOfListaDeudaNewDeuda != null && !oldVentaOfListaDeudaNewDeuda.equals(venta)) {
                        oldVentaOfListaDeudaNewDeuda.getListaDeuda().remove(listaDeudaNewDeuda);
                        oldVentaOfListaDeudaNewDeuda = em.merge(oldVentaOfListaDeudaNewDeuda);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = venta.getId_venta();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
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
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getId_venta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            ArrayList<Pago> listaPagosOrphanCheck = venta.getListaPagos();
            for (Pago listaPagosOrphanCheckPago : listaPagosOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Venta (" + venta + ") cannot be destroyed since the Pago " + listaPagosOrphanCheckPago + " in its listaPagos field has a non-nullable venta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Asesor asesor = venta.getAsesor();
            if (asesor != null) {
                asesor.getListaVentas().remove(venta);
                asesor = em.merge(asesor);
            }
            Cliente cliente = venta.getCliente();
            if (cliente != null) {
                cliente.getListaVentas().remove(venta);
                cliente = em.merge(cliente);
            }
            ArrayList<Apartamento> listaApartamentos = venta.getListaApartamentos();
            for (Apartamento listaApartamentosApartamento : listaApartamentos) {
                listaApartamentosApartamento.setVenta(null);
                listaApartamentosApartamento = em.merge(listaApartamentosApartamento);
            }
            ArrayList<Deuda> listaDeuda = venta.getListaDeuda();
            for (Deuda listaDeudaDeuda : listaDeuda) {
                listaDeudaDeuda.setVenta(null);
                listaDeudaDeuda = em.merge(listaDeudaDeuda);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
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

    public Venta findVenta(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Apartamento> obtenerAptosNoVendidos(){
        EntityManager em = getEntityManager();
        
        List<Apartamento> apartamentosNoVendidos = new ArrayList<Apartamento>();
        
        StoredProcedureQuery query = em.createStoredProcedureQuery("obtenerAptosNoVendidos",Apartamento.class);
        query.registerStoredProcedureParameter(1,  ResultSet.class, ParameterMode.REF_CURSOR);
        query.execute();
        
        apartamentosNoVendidos = query.getResultList();
        
        return apartamentosNoVendidos;
    }

    public int contarNPagos(Long id_venta) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNativeQuery("SELECT contarNPagos(?) FROM dual");
            query.setParameter(1, id_venta);
            
            Number numPagos = (Number) query.getSingleResult();
            return numPagos != null ? numPagos.intValue() : 0;
        } finally {
            em.close();
        }
    }
    
    public int contarNDeudas(Long id_venta) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNativeQuery("SELECT contarNDeudas(?) FROM dual");
            query.setParameter(1, id_venta);
            
            Number numPagos = (Number) query.getSingleResult();
            return numPagos != null ? numPagos.intValue() : 0;
        } finally {
            em.close();
        }
    }

    public List<Apartamento> obtenerAptosVendidos(Long id_venta, Long ced_cliente) {
        EntityManager em = getEntityManager();
        
        List<Apartamento> apartamentosVendidos = new ArrayList<Apartamento>();
        
        StoredProcedureQuery query = em.createStoredProcedureQuery("obtenerAptosVendidos", Apartamento.class);
        
        query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, Void.class, ParameterMode.REF_CURSOR);
        
        query.setParameter(1, id_venta);
        query.setParameter(2, ced_cliente);
        
        query.execute();
        
        apartamentosVendidos = query.getResultList();
        
        return apartamentosVendidos;
    }
}
