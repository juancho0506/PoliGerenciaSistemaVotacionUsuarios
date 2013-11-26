package poligran.gerencia.jpa.dao.impl;

import static org.junit.Assert.fail;

import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poligran.gerencia.jpa.entities.Usuario;

public class DefaultUsuarioDAOTest {
	
	DefaultUsuarioDAO dao = new DefaultUsuarioDAO();
	EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		// Open a database connection
        // (create a new database if it doesn't exist yet):
		try {
			emf = Persistence.createEntityManagerFactory("GerenciaSisUsuariosEM");
		    dao.setEm(emf.createEntityManager());
		    dao.getEm().setFlushMode(FlushModeType.COMMIT);
		    dao.getEm().getEntityManagerFactory().getCache().evictAll();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@After
	public void tearDown() throws Exception {
		if(emf!=null){
			emf.close();
		}
	}

	@Test
	public void testLoadAll() {
		try {
			System.out.println("Usuarios: ");
			for (Usuario elem : dao.loadAll()) {
				System.out.println("- "+elem.getUsername());
			}			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testLoadByRol() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsuarioByUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegistrarUsuario() {
		Usuario user = new Usuario();
		user.setActivo(true);
		user.setUsername("admin");
		user.setPassword("admin");
		
		try {
			dao.registrarUsuario(user);
			this.testLoadAll();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}

	@Test
	public void testActualizarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testDesactivarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testActivarUsuario() {
		fail("Not yet implemented");
	}

}
