
package Modelo.jpa_controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.entities.Asesor;
import Modelo.entities.Cliente;
import Modelo.entities.Telefono;
import Modelo.jpa_controllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Santiago
 */
public class TelefonoJpaController implements Serializable {

    public TelefonoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public TelefonoJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Telefono telefono) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asesor asesor = telefono.getAsesor();
            if (asesor != null) {
                asesor = em.getReference(asesor.getClass(), asesor.getCedula());
                telefono.setAsesor(asesor);
            }
            Cliente cliente = telefono.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getCedula());
                telefono.setCliente(cliente);
            }
            em.persist(telefono);
            if (asesor != null) {
                asesor.getListaTelefonosCliente().add(telefono);
                asesor = em.merge(asesor);
            }
            if (cliente != null) {
                cliente.getListaTelefonosCliente().add(telefono);
                cliente = em.merge(cliente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Telefono telefono) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Telefono persistentTelefono = em.find(Telefono.class, telefono.getId());
            Asesor asesorOld = persistentTelefono.getAsesor();
            Asesor asesorNew = telefono.getAsesor();
            Cliente clienteOld = persistentTelefono.getCliente();
            Cliente clienteNew = telefono.getCliente();
            if (asesorNew != null) {
                asesorNew = em.getReference(asesorNew.getClass(), asesorNew.getCedula());
                telefono.setAsesor(asesorNew);
            }
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getCedula());
                telefono.setCliente(clienteNew);
            }
            telefono = em.merge(telefono);
            if (asesorOld != null && !asesorOld.equals(asesorNew)) {
                asesorOld.getListaTelefonosCliente().remove(telefono);
                asesorOld = em.merge(asesorOld);
            }
            if (asesorNew != null && !asesorNew.equals(asesorOld)) {
                asesorNew.getListaTelefonosCliente().add(telefono);
                asesorNew = em.merge(asesorNew);
            }
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getListaTelefonosCliente().remove(telefono);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getListaTelefonosCliente().add(telefono);
                clienteNew = em.merge(clienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = telefono.getId();
                if (findTelefono(id) == null) {
                    throw new NonexistentEntityException("The telefono with id " + id + " no longer exists.");
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
            Telefono telefono;
            try {
                telefono = em.getReference(Telefono.class, id);
                telefono.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The telefono with id " + id + " no longer exists.", enfe);
            }
            Asesor asesor = telefono.getAsesor();
            if (asesor != null) {
                asesor.getListaTelefonosCliente().remove(telefono);
                asesor = em.merge(asesor);
            }
            Cliente cliente = telefono.getCliente();
            if (cliente != null) {
                cliente.getListaTelefonosCliente().remove(telefono);
                cliente = em.merge(cliente);
            }
            em.remove(telefono);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Telefono> findTelefonoEntities() {
        return findTelefonoEntities(true, -1, -1);
    }

    public List<Telefono> findTelefonoEntities(int maxResults, int firstResult) {
        return findTelefonoEntities(false, maxResults, firstResult);
    }

    private List<Telefono> findTelefonoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Telefono.class));
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

    public Telefono findTelefono(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Telefono.class, id);
        } finally {
            em.close();
        }
    }

    public int getTelefonoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Telefono> rt = cq.from(Telefono.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
