package br.com.allianz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="convidados")
public class Convidado {
	
	@Id
	@NotNull
	@NotEmpty(message="{erro.convidado.cpf.vazio}")
	@Size(min=11, max=11, message = "{erro.convidado.cpf.tamanho}")
	private String cpf;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IDEVENTO")	
	private Evento evento;
	
	@Column(name="NOME", length=45)
	@NotNull
	@NotEmpty(message="{erro.convidado.nome.vazio}")
	@Size(min=5, max=45, message="{erro.convidado.nome.tamanho}")
	private String nome;
	
	@Column(name="EMAIL", length=45)
	@NotNull
	@NotEmpty(message="{erro.convidado.email.vazio}")
	@Size(min=5, max=45, message="{erro.convidado.email.tamanho}")
	@Email(regexp="\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*",
	       message="{erro.convidado.email.valido}")
	private String email;
	
	@Column(name="TELEFONE", length=20)
	@NotNull
	@NotEmpty(message="{erro.convidado.telefone.vazio}")
	@Size(min=8, max=20, message="{erro.convidado.telefone.tamanho}")
	private String telefone;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

}
