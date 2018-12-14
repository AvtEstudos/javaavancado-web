package br.com.allianz.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.allianz.models.Usuario;
import br.com.allianz.utils.Utils;

@Repository
public class UsuariosDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Usuario usuario) {
		
		usuario.setSenha(Utils.verificarMD5(usuario.getSenha()));
		
		manager.persist(usuario);
	}

}
