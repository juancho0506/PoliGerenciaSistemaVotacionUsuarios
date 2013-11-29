/**
 * 
 */
package poligran.gerencia.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import poligran.gerencia.jpa.entities.Usuario;
import poligran.gerencia.services.DefaultUsuarioService;
import poligran.gerencia.services.UsuarioService;

/**
 * @author Rodrigo Torres
 *
 */
@ManagedBean(name="usuarioBean")
public class UsuarioBean {
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private String value = "This editor is provided by PrimeFaces";
	
	private String message = "";
	private UsuarioService usuarioServ;
	
	 
	/**
	 * 
	 */
	public UsuarioBean() {
		usuarioServ = new DefaultUsuarioService();
		try {
			usuarios = usuarioServ.listarUsuarios();
		} catch (Exception e) {
			message = "ERROR no se pudo crear la instancia de la pagina!";
		}
	}

	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getValue() {
		return value;
	}
 
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
