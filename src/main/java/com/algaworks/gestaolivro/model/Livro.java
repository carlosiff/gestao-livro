package com.algaworks.gestaolivro.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue
	private Long idLivro;
	@NotNull(message = "Autora é Inválido ou Inexistente")
	@ManyToOne
	@JoinColumn(name = "id_autora")
	private Autora autora;
	
	@NotEmpty(message="O nome do livro é obrigatório!")
	private String nomeL;
	
	@NotNull(message = "Data é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE )
	private Date dataL;
	
	@NotNull(message = "O valor é obrigatória")
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	private Float valor;
	
	public Long getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}
	public Autora getAutora() {
		return autora;
	}
	public void setAutora(Autora autora) {
		this.autora = autora;
	}
	public String getNomeL() {
		return nomeL;
	}
	public void setNomeL(String nomeL) {
		this.nomeL = nomeL;
	}
	public Date getDataL() {
		return dataL;
	}
	public void setDataL(Date dataL) {
		this.dataL = dataL;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	

}
