package br.unitins.almox.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.almox.application.Util;
import br.unitins.almox.model.Usuario;
import br.unitins.almox.repository.TelefoneRepository;
import br.unitins.almox.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = -5405951262794133772L;
	
	private Usuario usuario;
	
	public void incluir() {
		UsuarioRepository repo = new UsuarioRepository();
		repo.save(getUsuario());
		Util.addInfoMessage("Inclusão realizada com sucesso.");
		limpar();
		
		
		TelefoneRepository tr = new TelefoneRepository();
		tr.sa
	}
	public void alterar() {
		
	}
	public void excluir() {
		
	}
	public void limpar() {
		usuario = null;
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
}
