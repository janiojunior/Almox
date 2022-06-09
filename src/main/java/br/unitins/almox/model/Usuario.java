package br.unitins.almox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Usuario extends DefaultEntity implements Serializable{

	private static final long serialVersionUID = -7801673358747779362L;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true)
	private PessoaFisica pessoaFisica;

	@Column(length = 60)
	private String login;
	
	@Column(length = 60)
	private String senha;
	
	private Perfil perfil;

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	

}
