package br.unitins.almox.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.almox.model.DefaultEntity;
import br.unitins.almox.model.Usuario;
import br.unitins.almox.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = -5405951262794133772L;
	
	public UsuarioController() {
		super(new UsuarioRepository());
	}

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}
	
}
