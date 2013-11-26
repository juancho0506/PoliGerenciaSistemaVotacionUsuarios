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
import javax.persistence.Query;

import poligran.gerencia.jpa.dao.UsuarioDAO;
import poligran.gerencia.jpa.entities.Rol;
import poligran.gerencia.jpa.entities.Usuario;

/**
 * @author Rodrigo Torres
 *
 */
public class DefaultUsuarioDAO implements UsuarioDAO {
	
	private static final String PERSISTENCE_UNIT_NAME = "GerenciaSisUsuariosEM";
	private EntityManagerFactory entityFactory;
	
	private EntityManager em;
	
	
	/**
	 * 
	 */
	public DefaultUsuarioDAO() {
		entityFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = entityFactory.createEntityManager();
		em.setFlushMode(FlushModeType.COMMIT);
		em.getEntityManagerFactory().getCache().evictAll();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.UsuarioDAO#loadAll()
	 */
	@Override
	public List<Usuario> loadAll() throws PersistenceException {
		return em.createNamedQuery("usuario.loadAll", Usuario.class).getResultList();
	}

	@Override
	public List<Usuario> loadByRol(Rol r) throws PersistenceException {
		Query q = em.createNamedQuery("usuario.loadByRol", Usuario.class);
		q.setParameter("rol", r);
		return q.getResultList();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.UsuarioDAO#getUsuario(int)
	 */
	@Override
	public Usuario getUsuario(int id) throws PersistenceException {
		return em.find(Usuario.class, id);
	}

	@Override
	public Usuario validarUsuario(String password) throws PersistenceException {
		Usuario u = null;
		Query q = em.createNamedQuery("usuario.searchByPassword", Usuario.class);
		q.setParameter("password", password);
		return u;
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.UsuarioDAO#registrarUsuario(poligran.gerencia.jpa.entities.Usuario)
	 */
	@Override
	public void registrarUsuario(Usuario u) throws PersistenceException {
		em.getTransaction().begin();
		em.persist(u);
		em.flush();
		em.getTransaction().commit();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.UsuarioDAO#actualizarUsuario(poligran.gerencia.jpa.entities.Usuario)
	 */
	@Override
	public void actualizarUsuario(Usuario u) throws PersistenceException {
		em.getTransaction().begin();
		em.merge(u);
		em.flush();
		em.getTransaction().commit();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.UsuarioDAO#desactivarUsuario(poligran.gerencia.jpa.entities.Usuario)
	 */
	@Override
	public void desactivarUsuario(Usuario u) throws PersistenceException {
		u.setActivo(false);
		this.actualizarUsuario(u);

	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.UsuarioDAO#activarUsuario(poligran.gerencia.jpa.entities.Usuario)
	 */
	@Override
	public void activarUsuario(Usuario u) throws PersistenceException {
		u.setActivo(true);
		this.actualizarUsuario(u);
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
