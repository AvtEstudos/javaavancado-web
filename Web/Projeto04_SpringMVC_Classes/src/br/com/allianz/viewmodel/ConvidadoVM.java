package br.com.allianz.viewmodel;

public class ConvidadoVM {
	
	private int idEvento;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	
	//Construtores	
	public ConvidadoVM() {
		super();		
	}
	
	public ConvidadoVM(int idEvento, String cpf, String nome, String telefone, String email) {
		super();
		this.idEvento = idEvento;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public int getIdEvento() {
		return idEvento;
	}	
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
