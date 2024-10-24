
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
public class Telefono_clienteJpaController implements Serializable {

    public Telefono_clienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public Telefono_clienteJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Telefono_cliente telefono_cliente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente = telefono_cliente.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getCedula());
                telefono_cliente.setCliente(cliente);
            }
            em.persist(telefono_cliente);
            if (cliente != null) {
                cliente.getListaTelefonosCliente().add(telefono_cliente);
                cliente = em.merge(cliente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Telefono_cliente telefono_cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Telefono_cliente persistentTelefono_cliente = em.find(Telefono_cliente.class, telefono_cliente.getId());
            Cliente clienteOld = persistentTelefono_cliente.getCliente();
            Cliente clienteNew = telefono_cliente.getCliente();
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getCedula());
                telefono_cliente.setCliente(clienteNew);
            }
            telefono_cliente = em.merge(telefono_cliente);
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getListaTelefonosCliente().remove(telefono_cliente);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getListaTelefonosCliente().add(telefono_cliente);
                clienteNew = em.merge(clienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = telefono_cliente.getId();
                if (findTelefono_cliente(id) == null) {
                    throw new NonexistentEntityException("The telefono_cliente with id " + id + " no longer exists.");
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
            Telefono_cliente telefono_cliente;
            try {
                telefono_cliente = em.getReference(Telefono_cliente.class, id);
                telefono_cliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The telefono_cliente with id " + id + " no longer exists.", enfe);
            }
            Cliente cliente = telefono_cliente.getCliente();
            if (cliente != null) {
                cliente.getListaTelefonosCliente().remove(telefono_cliente);
                cliente = em.merge(cliente);
            }
            em.remove(telefono_cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Telefono_cliente> findTelefono_clienteEntities() {
        return findTelefono_clienteEntities(true, -1, -1);
    }

    public List<Telefono_cliente> findTelefono_clienteEntities(int maxResults, int firstResult) {
        return findTelefono_clienteEntities(false, maxResults, firstResult);
    }

    private List<Telefono_cliente> findTelefono_clienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Telefono_cliente.class));
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

    public Telefono_cliente findTelefono_cliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Telefono_cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getTelefono_clienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Telefono_cliente> rt = cq.from(Telefono_cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
