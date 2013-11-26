package poligran.gerencia.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poligran.gerencia.jpa.entities.Usuario;

public class DefaultUsuarioServiceTest {
	
	Service service;
	UsuarioService usuarioS;

	@Before
	public void setUp() throws Exception {
		Properties properties = new Properties();
        properties.setProperty("openejb.embedded.remotable", "true");
        //properties.setProperty("httpejbd.print", "true");
        //properties.setProperty("httpejbd.indent.xml", "true");
        EJBContainer.createEJBContainer(properties);
        
        service = Service.create(
                new URL("http://localhost:8080/PoliGerenciaSistemaVotacionUsuarios/webservices/DefaultUsuarioService?wsdl"),
                new QName("http://superbiz.org/wsdl", "SistemaVotacionUsuariosService"));
        
    
        assertNotNull(service);
        usuarioS = service.getPort(UsuarioService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListarUsuarios() {
        try {
	        System.out.println("Usuarios: ");
	        for (Usuario user : usuarioS.listarUsuarios()) {
				System.out.println(user.getUsername());
	        }
	        System.out.println("*** fin lista de usuarios....");
        
        }catch(Exception e){
        	e.printStackTrace();
        	fail();
        }
		
	}

	@Test
	public void testRegistrarUsuario() {
		String username = "admin";
		String password = "admin";
		
		try {
			usuarioS.registrarUsuario(username, password);
		} catch (Exception e) {			
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testCambiarContrasena() {
		fail("Not yet implemented");
	}

	@Test
	public void testAutenticar() {
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
