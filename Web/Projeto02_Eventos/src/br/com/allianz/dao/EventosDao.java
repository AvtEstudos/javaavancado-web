package br.com.allianz.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.allianz.models.Evento;

public class EventosDao extends Dao<Evento, Integer> {

	@Override
	public void Incluir(Evento elemento) throws Exception {
		try {			
			abrirConexao();	
			
			stmt = cn.prepareStatement("INSERT INTO EVENTOS (DESCRICAO, DATA, RESPONSAVEL, PRECO) "
					+ "VALUES (?, ?, ?, ?) ");
			stmt.setString(1, elemento.getDescricao());
			stmt.setDate(2, new java.sql.Date(elemento.getData().getTime()));
			stmt.setString(3, elemento.getResponsavel());
			stmt.setDouble(4, elemento.getPreco());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {			
			throw e;
		}finally {
			fecharConexao();
		}		
	}

	@Override
	public Evento Buscar(Integer chave) throws Exception {
		
		Evento evento = null;
		
		try {
			abrirConexao();
			
			stmt = cn.prepareStatement("SELECT * FROM EVENTOS WHERE ID=?");
			stmt.setInt(1, chave);
			
			rs = stmt.executeQuery();			
			if(rs.next()) {
				evento = new Evento();
				evento.setId(rs.getInt("ID"));
				evento.setDescricao(rs.getString("DESCRICAO"));				
				evento.setData(rs.getDate("DATA"));
				evento.setResponsavel(rs.getString("RESPONSAVEL"));
				evento.setPreco(rs.getDouble("PRECO"));	
			}
			
		} catch (Exception e) {
			throw e;
		}finally {
			fecharConexao();
		}
		
		return evento;		
	}
	
	public List<Evento> ListarEventos() throws Exception {
	
		List<Evento> eventos = new ArrayList<>();
		
		try {
			
			abrirConexao();
			stmt = cn.prepareStatement("SELECT * FROM EVENTOS");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Evento evento = new Evento();
				evento.setId(rs.getInt("ID"));
				evento.setDescricao(rs.getString("DESCRICAO"));				
				evento.setData(rs.getDate("DATA"));
				evento.setResponsavel(rs.getString("RESPONSAVEL"));
				evento.setPreco(rs.getDouble("PRECO"));				
				eventos.add(evento);
			}
			
		} catch (Exception e) {
			throw e;
		}finally {
			fecharConexao();			
		}
		
		return eventos;
	}	

}
