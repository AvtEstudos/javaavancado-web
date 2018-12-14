package br.com.allianz.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public abstract class Dao<T, K> {
	
	//elementos de acesso a dados
	protected Connection cn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	//string de conexao - JDBC MySQL
	private String conexao = "jdbc:mysql://localhost:3306/db_eventos";
	
	//método para abrir a conexão com o banco de dados
	protected void abrirConexao() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		cn = DriverManager.getConnection(conexao, "root", "p@ssword");
		
	}
	
	protected void fecharConexao() throws Exception {
		if (cn != null && !cn.isClosed()) {
			cn.close();	
		}		
	}
	
	public abstract void Incluir(T elemento) throws Exception;
	
	public abstract T Buscar(K chave) throws Exception;

}
