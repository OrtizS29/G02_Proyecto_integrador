
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
public class Correo_clienteJpaController implements Serializable {

    public Correo_clienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public Correo_clienteJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Correo_cliente correo_cliente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente = correo_cliente.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getCedula());
                correo_cliente.setCliente(cliente);
            }
            em.persist(correo_cliente);
            if (cliente != null) {
                cliente.getListaCorreosCliente().add(correo_cliente);
                cliente = em.merge(cliente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Correo_cliente correo_cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Correo_cliente persistentCorreo_cliente = em.find(Correo_cliente.class, correo_cliente.getId());
            Cliente clienteOld = persistentCorreo_cliente.getCliente();
            Cliente clienteNew = correo_cliente.getCliente();
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getCedula());
                correo_cliente.setCliente(clienteNew);
            }
            correo_cliente = em.merge(correo_cliente);
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getListaCorreosCliente().remove(correo_cliente);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getListaCorreosCliente().add(correo_cliente);
                clienteNew = em.merge(clienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = correo_cliente.getId();
                if (findCorreo_cliente(id) == null) {
                    throw new NonexistentEntityException("The correo_cliente with id " + id + " no longer exists.");
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
            Correo_cliente correo_cliente;
            try {
                correo_cliente = em.getReference(Correo_cliente.class, id);
                correo_cliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The correo_cliente with id " + id + " no longer exists.", enfe);
            }
            Cliente cliente = correo_cliente.getCliente();
            if (cliente != null) {
                cliente.getListaCorreosCliente().remove(correo_cliente);
                cliente = em.merge(cliente);
            }
            em.remove(correo_cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Correo_cliente> findCorreo_clienteEntities() {
        return findCorreo_clienteEntities(true, -1, -1);
    }

    public List<Correo_cliente> findCorreo_clienteEntities(int maxResults, int firstResult) {
        return findCorreo_clienteEntities(false, maxResults, firstResult);
    }

    private List<Correo_cliente> findCorreo_clienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Correo_cliente.class));
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

    public Correo_cliente findCorreo_cliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Correo_cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getCorreo_clienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Correo_cliente> rt = cq.from(Correo_cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
