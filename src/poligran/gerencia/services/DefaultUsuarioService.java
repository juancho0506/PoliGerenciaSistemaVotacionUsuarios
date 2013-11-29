/**
 * 
 */
package poligran.gerencia.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import poligran.gerencia.jpa.dao.UsuarioDAO;
import poligran.gerencia.jpa.dao.impl.DefaultUsuarioDAO;
import poligran.gerencia.jpa.entities.Usuario;

/**
 * @author Rodrigo Torres
 *
 */
@Stateless
@WebService(
    portName = "SistemaVotacionUsuariosServicePort",
    serviceName = "SistemaVotacionUsuariosService",
    targetNamespace = "http://superbiz.org/wsdl",
    endpointInterface = "poligran.gerencia.services.UsuarioService"
)
public class DefaultUsuarioService implements UsuarioService {

	
	private UsuarioDAO usuarioDAO;
	
	
	/**
	 * 
	 */
	public DefaultUsuarioService() {
		usuarioDAO = new DefaultUsuarioDAO();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.services.UsuarioService#listarUsuarios()
	 */
	@Override
	public List<Usuario> listarUsuarios() throws Exception {
		return usuarioDAO.loadAll();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.services.UsuarioService#registrarUsuario(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario registrarUsuario(String username, String password)
			throws Exception {
		Usuario user = new Usuario();
		user.setActivo(true);
		user.setUsername(username);
		user.setPassword(password);
		usuarioDAO.registrarUsuario(user);
		return user;
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.services.UsuarioService#cambiarContrasena(java.lang.String, java.lang.String)
	 */
	@Override
	public void cambiarContrasena(String username, String password)
			throws Exception {
		
		Usuario user = usuarioDAO.getUsuarioByUsername(username);
		user.setPassword(password);
		usuarioDAO.actualizarUsuario(user);

	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.services.UsuarioService#autenticar(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario autenticar(String username, String password)
			throws Exception {
		
		Usuario user = null;
		try {
			user = usuarioDAO.validarUsuario(username, password);
		} catch(javax.persistence.NoResultException e){ 
			return null;
		}catch (Exception e) {
			throw e;
		}
				
		return user;
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.services.UsuarioService#desactivarUsuario(java.lang.String)
	 */
	@Override
	public void desactivarUsuario(String username) throws Exception {
		Usuario user = usuarioDAO.getUsuarioByUsername(username);
		usuarioDAO.desactivarUsuario(user);

	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.services.UsuarioService#activarUsuario(java.lang.String)
	 */
	@Override
	public void activarUsuario(String username) throws Exception {
		Usuario user = usuarioDAO.getUsuarioByUsername(username);
		usuarioDAO.activarUsuario(user);
	}

}
