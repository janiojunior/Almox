package br.unitins.almox.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.almox.application.RepositoryException;
import br.unitins.almox.controller.listing.EstadoListing;
import br.unitins.almox.model.Estado;
import br.unitins.almox.repository.EstadoRepository;

@Named
@ViewScoped
public class EstadoController extends Controller<Estado> implements Serializable {

	private static final long serialVersionUID = 1038263747851557502L;

	public EstadoController() {
		super(new EstadoRepository());
	}
	
	@Override
	public Estado getEntity() {
		if (entity == null)
			entity = new Estado();
		return entity;
	}
	
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent<Estado> event) {
		setEntity(event.getObject());
	}
	

	
}
