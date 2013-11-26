package poligran.gerencia.jpa.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="usuario.loadAll", query="SELECT u FROM Usuario u"),
	@NamedQuery(name="usuario.loadByRol", query="SELECT u FROM Usuario u WHERE u.rol.id =:rol"),
	@NamedQuery(name="usuario.searchByPassword", query="SELECT u FROM Usuario u WHERE u.password =:password")
})
public class Usuario {
	
	@Id
	@Column
	@Basic(optional=false)
	private String username;
	
	@Column
	private String password;
	
	@Column
	private boolean activo;
	
	@ManyToOne(targetEntity=Rol.class)
	@JoinColumn(name="id")
	private Rol rol;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
