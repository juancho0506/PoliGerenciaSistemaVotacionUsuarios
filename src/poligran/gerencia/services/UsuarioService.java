package poligran.gerencia.services;

import java.util.List;

import javax.jws.WebService;

import poligran.gerencia.jpa.entities.Usuario;

@WebService(targetNamespace = "http://superbiz.org/wsdl")
public interface UsuarioService {
	
	public List<Usuario> listarUsuarios() throws Exception;
	
	public List<Usuario> registrarUsuario(String username, String password) throws Exception;
	
	public Usuario autenticar();
}
