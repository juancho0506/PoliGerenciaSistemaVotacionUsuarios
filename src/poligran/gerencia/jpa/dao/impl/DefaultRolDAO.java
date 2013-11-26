/**
 * 
 */
package poligran.gerencia.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import poligran.gerencia.jpa.dao.RolDAO;
import poligran.gerencia.jpa.entities.Rol;

/**
 * @author Bosz2013
 *
 */
public class DefaultRolDAO implements RolDAO {
	
	private static final String PERSISTENCE_UNIT_NAME = "GerenciaSisUsuariosEM";
	private EntityManagerFactory entityFactory;
	
	private EntityManager em;
	

	public DefaultRolDAO() {
		entityFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = entityFactory.createEntityManager();
		em.setFlushMode(FlushModeType.COMMIT);
		em.getEntityManagerFactory().getCache().evictAll();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.RolDAO#loadAll()
	 */
	@Override
	public List<Rol> loadAll() throws PersistenceException {
		return em.createNamedQuery("rol.loadAll", Rol.class).getResultList();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.RolDAO#getRol(int)
	 */
	@Override
	public Rol getRol(int id) throws PersistenceException {
		return em.find(Rol.class, id);
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.RolDAO#registrarRol(poligran.gerencia.jpa.entities.Rol)
	 */
	@Override
	public void registrarRol(Rol r) throws PersistenceException {
		em.getTransaction().begin();
		em.persist(r);
		em.flush();
		em.getTransaction().commit();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.RolDAO#actualizarRol(poligran.gerencia.jpa.entities.Rol)
	 */
	@Override
	public void actualizarRol(Rol r) throws PersistenceException {
		em.getTransaction().begin();
		em.merge(r);
		em.flush();
		em.getTransaction().commit();
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
