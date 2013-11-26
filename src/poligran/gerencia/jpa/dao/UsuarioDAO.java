/**
 * 
 */
package poligran.gerencia.jpa.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import poligran.gerencia.jpa.entities.Rol;
import poligran.gerencia.jpa.entities.Usuario;

/**
 * @author Bosz2013
 *
 */
public interface UsuarioDAO {
	
	public List<Usuario> loadAll()throws PersistenceException;
	
	public List<Usuario> loadByRol(Rol r)throws PersistenceException;
	
	public Usuario getUsuario(int id) throws PersistenceException;
	
	public Usuario getUsuarioByUsername(String username) throws PersistenceException;
	
	public Usuario validarUsuario(String username, String password) throws PersistenceException;
	
	public void registrarUsuario(Usuario e) throws PersistenceException;
	
	public void actualizarUsuario(Usuario e) throws PersistenceException;
	
	public void desactivarUsuario(Usuario e) throws PersistenceException;
	
	public void activarUsuario(Usuario e) throws PersistenceException;
}
