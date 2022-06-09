package br.unitins.almox.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.almox.application.RepositoryException;
import br.unitins.almox.application.Util;
import br.unitins.almox.model.Usuario;
import br.unitins.almox.repository.UsuarioRepository;
import jakarta.mail.Session;

@Named
@RequestScoped
public class LoginController {
	
	private Usuario usuario;

	public void entrar() {
		UsuarioRepository repo = new UsuarioRepository();
		Usuario usuarioLogado = null;
		try {
			usuarioLogado = repo.validarLogin(getUsuario());
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		if (usuarioLogado != null) {
			FacesContext.getCurrentInstance()
			.getExternalContext()
			.getSessionMap()
			.put("usuarioLogado", usuarioLogado);
			
			Util.redirect("usuario.xhtml");
		}
		Util.addErrorMessage("Login ou senha inválido.");

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
