
package Modelo.jpa_controllers;

import Modelo.entities.Correo_asesor;
import Modelo.entities.Asesor;
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
public class Correo_asesorJpaController implements Serializable {

    public Correo_asesorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public Correo_asesorJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Correo_asesor correo_asesor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asesor asesor = correo_asesor.getAsesor();
            if (asesor != null) {
                asesor = em.getReference(asesor.getClass(), asesor.getCedula());
                correo_asesor.setAsesor(asesor);
            }
            em.persist(correo_asesor);
            if (asesor != null) {
                asesor.getListaCorreoCliente().add(correo_asesor);
                asesor = em.merge(asesor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Correo_asesor correo_asesor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Correo_asesor persistentCorreo_asesor = em.find(Correo_asesor.class, correo_asesor.getId());
            Asesor asesorOld = persistentCorreo_asesor.getAsesor();
            Asesor asesorNew = correo_asesor.getAsesor();
            if (asesorNew != null) {
                asesorNew = em.getReference(asesorNew.getClass(), asesorNew.getCedula());
                correo_asesor.setAsesor(asesorNew);
            }
            correo_asesor = em.merge(correo_asesor);
            if (asesorOld != null && !asesorOld.equals(asesorNew)) {
                asesorOld.getListaCorreoCliente().remove(correo_asesor);
                asesorOld = em.merge(asesorOld);
            }
            if (asesorNew != null && !asesorNew.equals(asesorOld)) {
                asesorNew.getListaCorreoCliente().add(correo_asesor);
                asesorNew = em.merge(asesorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = correo_asesor.getId();
                if (findCorreo_asesor(id) == null) {
                    throw new NonexistentEntityException("The correo_asesor with id " + id + " no longer exists.");
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
            Correo_asesor correo_asesor;
            try {
                correo_asesor = em.getReference(Correo_asesor.class, id);
                correo_asesor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The correo_asesor with id " + id + " no longer exists.", enfe);
            }
            Asesor asesor = correo_asesor.getAsesor();
            if (asesor != null) {
                asesor.getListaCorreoCliente().remove(correo_asesor);
                asesor = em.merge(asesor);
            }
            em.remove(correo_asesor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Correo_asesor> findCorreo_asesorEntities() {
        return findCorreo_asesorEntities(true, -1, -1);
    }

    public List<Correo_asesor> findCorreo_asesorEntities(int maxResults, int firstResult) {
        return findCorreo_asesorEntities(false, maxResults, firstResult);
    }

    private List<Correo_asesor> findCorreo_asesorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Correo_asesor.class));
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

    public Correo_asesor findCorreo_asesor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Correo_asesor.class, id);
        } finally {
            em.close();
        }
    }

    public int getCorreo_asesorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Correo_asesor> rt = cq.from(Correo_asesor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
