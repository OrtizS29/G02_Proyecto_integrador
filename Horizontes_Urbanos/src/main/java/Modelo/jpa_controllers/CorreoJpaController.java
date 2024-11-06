
package Modelo.jpa_controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.entities.Asesor;
import Modelo.entities.Cliente;
import Modelo.entities.Correo;
import Modelo.jpa_controllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Santiago
 */
public class CorreoJpaController implements Serializable {

    public CorreoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public CorreoJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Correo correo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asesor asesor = correo.getAsesor();
            if (asesor != null) {
                asesor = em.getReference(asesor.getClass(), asesor.getCedula());
                correo.setAsesor(asesor);
            }
            Cliente cliente = correo.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getCedula());
                correo.setCliente(cliente);
            }
            em.persist(correo);
            if (asesor != null) {
                asesor.getListaCorreos().add(correo);
                asesor = em.merge(asesor);
            }
            if (cliente != null) {
                cliente.getListaCorreosCliente().add(correo);
                cliente = em.merge(cliente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Correo correo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Correo persistentCorreo = em.find(Correo.class, correo.getId());
            Asesor asesorOld = persistentCorreo.getAsesor();
            Asesor asesorNew = correo.getAsesor();
            Cliente clienteOld = persistentCorreo.getCliente();
            Cliente clienteNew = correo.getCliente();
            if (asesorNew != null) {
                asesorNew = em.getReference(asesorNew.getClass(), asesorNew.getCedula());
                correo.setAsesor(asesorNew);
            }
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getCedula());
                correo.setCliente(clienteNew);
            }
            correo = em.merge(correo);
            if (asesorOld != null && !asesorOld.equals(asesorNew)) {
                asesorOld.getListaCorreos().remove(correo);
                asesorOld = em.merge(asesorOld);
            }
            if (asesorNew != null && !asesorNew.equals(asesorOld)) {
                asesorNew.getListaCorreos().add(correo);
                asesorNew = em.merge(asesorNew);
            }
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getListaCorreosCliente().remove(correo);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getListaCorreosCliente().add(correo);
                clienteNew = em.merge(clienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = correo.getId();
                if (findCorreo(id) == null) {
                    throw new NonexistentEntityException("The correo with id " + id + " no longer exists.");
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
            Correo correo;
            try {
                correo = em.getReference(Correo.class, id);
                correo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The correo with id " + id + " no longer exists.", enfe);
            }
            Asesor asesor = correo.getAsesor();
            if (asesor != null) {
                asesor.getListaCorreos().remove(correo);
                asesor = em.merge(asesor);
            }
            Cliente cliente = correo.getCliente();
            if (cliente != null) {
                cliente.getListaCorreosCliente().remove(correo);
                cliente = em.merge(cliente);
            }
            em.remove(correo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Correo> findCorreoEntities() {
        return findCorreoEntities(true, -1, -1);
    }

    public List<Correo> findCorreoEntities(int maxResults, int firstResult) {
        return findCorreoEntities(false, maxResults, firstResult);
    }

    private List<Correo> findCorreoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Correo.class));
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

    public Correo findCorreo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Correo.class, id);
        } finally {
            em.close();
        }
    }

    public int getCorreoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Correo> rt = cq.from(Correo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
