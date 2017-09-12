package com.algaworks.gestaolivro.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Autora {
	
	@Id
	@GeneratedValue
	@Column(name="id_autora")
	private Long idAutora;

	@NotEmpty(message="O nome é obrigatório!")
	private String nome;
	
	@NotEmpty(message="O Email é obrigatório!")
	private String email;
	
	@NotNull(message = "Data de Nascimento é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE )
	private Date dtNascimento;

	
	@OneToMany(mappedBy = "autora", cascade = CascadeType.ALL)
	private Set<Livro> livros;


	public Long getIdAutora() {
		return idAutora;
	}


	public void setIdAutora(Long idAutora) {
		this.idAutora = idAutora;
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


	public Date getDtNascimento() {
		return dtNascimento;
	}


	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}


	public Set<Livro> getLivros() {
		return livros;
	}


	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}
	
	

}
