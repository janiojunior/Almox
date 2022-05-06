package br.unitins.almox.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.almox.application.RepositoryException;
import br.unitins.almox.controller.listing.PessoaFisicaListing;
import br.unitins.almox.model.PessoaFisica;
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
		if (entity == null) {
			entity = new Usuario();
			entity.setPessoaFisica(new PessoaFisica());
		}
		return entity;
	}
	
	public void abrirPessoaFisicaListing() {
		PessoaFisicaListing listing = new PessoaFisicaListing();
		listing.open();
	}
	
	public void obterPessoaFisicaListing(SelectEvent<PessoaFisica> event) {
		PessoaFisica pf = event.getObject();
		UsuarioRepository repo = new UsuarioRepository();
		Usuario usuario = null;
		try {
			usuario = repo.findByIdPessoaFisica(pf.getId());
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		if (usuario != null) 
			setEntity(usuario);
		else
			getEntity().setPessoaFisica(pf);	
	}
	

	
}
