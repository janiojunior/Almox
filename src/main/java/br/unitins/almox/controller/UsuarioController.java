package br.unitins.almox.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.almox.application.RepositoryException;
import br.unitins.almox.controller.listing.UsuarioListing;
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
	
	public void abrirUsuarioListing() {
		UsuarioListing listing = new UsuarioListing();
		listing.open();
	}
	
	public void obterUsuarioListing(SelectEvent<Usuario> event) {
		setEntity(event.getObject());
	}
	

	
}
