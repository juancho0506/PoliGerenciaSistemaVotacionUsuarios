/**
 * 
 */
package poligran.gerencia.jpa.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import poligran.gerencia.jpa.entities.Rol;

/**
 * @author Rodrigo Torres
 *
 */
public interface RolDAO {
	
	public List<Rol> loadAll()throws PersistenceException;
	
	public Rol getRol(int id)throws PersistenceException;
	
	public void registrarRol(Rol e) throws PersistenceException;
	
	public void actualizarRol(Rol e) throws PersistenceException;
	
}
