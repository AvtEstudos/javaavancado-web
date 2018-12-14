package br.com.allianz.models;

import java.util.Date;
import java.util.Set;

public class Evento {
	
	private int id;
	private String descricao;
	private String responsavel;
	private Date data;
	private double preco;
	private Set<Convidado> convidados;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Set<Convidado> getConvidados() {
		return convidados;
	}
	public void setConvidados(Set<Convidado> convidados) {
		this.convidados = convidados;
	}
	

}
