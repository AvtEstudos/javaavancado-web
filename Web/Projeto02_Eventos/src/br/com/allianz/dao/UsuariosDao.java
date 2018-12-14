package br.com.allianz.dao;

import br.com.allianz.models.Usuario;
import br.com.allianz.utils.Utils;

public class UsuariosDao extends Dao<Usuario, String> {
	
	@Override
	public void Incluir(Usuario elemento) throws Exception {
		try {			
			abrirConexao();	
			
			stmt = cn.prepareStatement("INSERT INTO USUARIOS (NOME, SENHA, NIVEL) "
					+ "VALUES (?, ?, ?) ");
			
			stmt.setString(1, elemento.getNome());			
			stmt.setString(2, Utils.verificarMD5(elemento.getSenha()));
			stmt.setInt(3, elemento.getNivel());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {			
			throw e;
		}finally {
			fecharConexao();
		}		
	}
	
	public Usuario Buscar(String chave, String senha) throws Exception {
		
		Usuario usuario = null;
		
		try {
			
			abrirConexao();
			
			stmt = cn.prepareStatement("SELECT * FROM USUARIOS WHERE NOME=? AND SENHA=?");
			stmt.setString(1, chave);
			stmt.setString(2, Utils.verificarMD5(senha));
			
			rs = stmt.executeQuery();			
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setNome(rs.getString("NOME"));								
				usuario.setNivel(rs.getInt("NIVEL"));				
			}
			
		} catch (Exception e) {
			throw e;
		}finally {
			fecharConexao();
		}
		
		return usuario;		
	}

	@Override
	public Usuario Buscar(String chave) throws Exception {
		
		Usuario usuario = null;
		
		try {
			
			abrirConexao();
			
			stmt = cn.prepareStatement("SELECT * FROM USUARIO WHERE NOME=?");
			stmt.setString(1, chave);
			
			rs = stmt.executeQuery();			
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setNome(rs.getString("NOME"));
				usuario.setSenha(rs.getString("SENHA"));				
				usuario.setNivel(rs.getInt("NIVEL"));				
				
			}
			
		} catch (Exception e) {
			throw e;
		}finally {
			fecharConexao();
		}
		
		return usuario;		
	}
	
//	public List<Evento> ListarEventos() throws Exception {
//	
//		List<Evento> eventos = new ArrayList<>();
//		
//		try {
//			
//			abrirConexao();
//			stmt = cn.prepareStatement("SELECT * FROM EVENTOS");
//			rs = stmt.executeQuery();
//			
//			while (rs.next()) {
//				
//				Evento evento = new Evento();
//				evento.setId(rs.getInt("ID"));
//				evento.setDescricao(rs.getString("DESCRICAO"));				
//				evento.setData(rs.getDate("DATA"));
//				evento.setResponsavel(rs.getString("RESPONSAVEL"));
//				evento.setPreco(rs.getDouble("PRECO"));				
//				eventos.add(evento);
//			}
//			
//		} catch (Exception e) {
//			throw e;
//		}finally {
//			fecharConexao();			
//		}
//		
//		return eventos;
//	}	

}
