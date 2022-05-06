package br.unitins.almox.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.almox.controller.listing.CidadeListing;
import br.unitins.almox.controller.listing.EstadoListing;
import br.unitins.almox.model.Cidade;
import br.unitins.almox.model.Estado;
import br.unitins.almox.repository.CidadeRepository;

@Named
@ViewScoped
public class CidadeController extends Controller<Cidade> implements Serializable {

	private static final long serialVersionUID = 3557577173819542977L;

	public CidadeController() {
		super(new CidadeRepository());
	}
	
	@Override
	public Cidade getEntity() {
		if (entity == null) {
			entity = new Cidade();
			entity.setEstado(new Estado());
		}
		return entity;
	}
	
	public void abrirCidadeListing() {
		CidadeListing listing = new CidadeListing();
		listing.open();
	}
	
	public void obterCidadeListing(SelectEvent<Cidade> event) {
		setEntity(event.getObject());
	}
	
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent<Estado> event) {
		getEntity().setEstado(event.getObject());
	}
	

	
}
