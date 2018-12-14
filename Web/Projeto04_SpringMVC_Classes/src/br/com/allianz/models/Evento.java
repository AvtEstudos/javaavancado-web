package br.com.allianz.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "eventos")
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="ID")	
	private int id;
	
	@Column(name="DESCRICAO", length=45)
	@NotNull
	@NotEmpty(message="{erro.evento.descricao.vazio}")
	@Size(min=5, max=45, message="{erro.evento.descricao.tamanho}")
	private String descricao;
	
	@Column(name="RESPONSAVEL", length=45)
	@NotNull
	@NotEmpty(message="{erro.evento.responsavel.vazio}")
	@Size(min=5, max=45, message="{erro.evento.responsavel.tamanho}")
	private String responsavel;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="DATA")
	@NotNull(message="{erro.evento.data.vazio}")		
	private Date data;
	
	@Column(name="PRECO")
	@NotNull(message="{Preço não pode ser vazio}")
	@Min(value=1, message="{erro.evento.preco.min}")
	private double preco;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="evento")
	private Set<Convidado> convidados = new HashSet<>();
	
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
	
	//propriedade de conveniencia
	public void setDataString(String data) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.setData(df.parse(data));			
			
		} catch (Exception e) {
			this.setData(new Date());
		}
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
