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
import Modelo.entities.Telefono_asesor;
import Modelo.jpa_controllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author CLAUDIA
 */
public class Telefono_asesorJpaController implements Serializable {

    public Telefono_asesorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public Telefono_asesorJpaController() {
	emf = Persistence.createEntityManagerFactory("HU_constructora");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Telefono_asesor telefono_asesor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asesor asesor = telefono_asesor.getAsesor();
            if (asesor != null) {
                asesor = em.getReference(asesor.getClass(), asesor.getCedula());
                telefono_asesor.setAsesor(asesor);
            }
            em.persist(telefono_asesor);
            if (asesor != null) {
                asesor.getListaTelefonosCliente().add(telefono_asesor);
                asesor = em.merge(asesor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Telefono_asesor telefono_asesor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Telefono_asesor persistentTelefono_asesor = em.find(Telefono_asesor.class, telefono_asesor.getId());
            Asesor asesorOld = persistentTelefono_asesor.getAsesor();
            Asesor asesorNew = telefono_asesor.getAsesor();
            if (asesorNew != null) {
                asesorNew = em.getReference(asesorNew.getClass(), asesorNew.getCedula());
                telefono_asesor.setAsesor(asesorNew);
            }
            telefono_asesor = em.merge(telefono_asesor);
            if (asesorOld != null && !asesorOld.equals(asesorNew)) {
                asesorOld.getListaTelefonosCliente().remove(telefono_asesor);
                asesorOld = em.merge(asesorOld);
            }
            if (asesorNew != null && !asesorNew.equals(asesorOld)) {
                asesorNew.getListaTelefonosCliente().add(telefono_asesor);
                asesorNew = em.merge(asesorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = telefono_asesor.getId();
                if (findTelefono_asesor(id) == null) {
                    throw new NonexistentEntityException("The telefono_asesor with id " + id + " no longer exists.");
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
            Telefono_asesor telefono_asesor;
            try {
                telefono_asesor = em.getReference(Telefono_asesor.class, id);
                telefono_asesor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The telefono_asesor with id " + id + " no longer exists.", enfe);
            }
            Asesor asesor = telefono_asesor.getAsesor();
            if (asesor != null) {
                asesor.getListaTelefonosCliente().remove(telefono_asesor);
                asesor = em.merge(asesor);
            }
            em.remove(telefono_asesor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Telefono_asesor> findTelefono_asesorEntities() {
        return findTelefono_asesorEntities(true, -1, -1);
    }

    public List<Telefono_asesor> findTelefono_asesorEntities(int maxResults, int firstResult) {
        return findTelefono_asesorEntities(false, maxResults, firstResult);
    }

    private List<Telefono_asesor> findTelefono_asesorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Telefono_asesor.class));
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

    public Telefono_asesor findTelefono_asesor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Telefono_asesor.class, id);
        } finally {
            em.close();
        }
    }

    public int getTelefono_asesorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Telefono_asesor> rt = cq.from(Telefono_asesor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
