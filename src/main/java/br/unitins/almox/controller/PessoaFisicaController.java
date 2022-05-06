package br.unitins.almox.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.almox.controller.listing.EstadoListing;
import br.unitins.almox.controller.listing.PessoaFisicaListing;
import br.unitins.almox.model.Estado;
import br.unitins.almox.model.PessoaFisica;
import br.unitins.almox.repository.PessoaFisicaRepository;

@Named
@ViewScoped
public class PessoaFisicaController extends Controller<PessoaFisica> implements Serializable {

	private static final long serialVersionUID = -4101744608976135973L;

	public PessoaFisicaController() {
		super(new PessoaFisicaRepository());
	}
	
	@Override
	protected void limparRelacionamentosNaoObrigatorios() {
		if (getEntity().getEstado().getId() == null)
			getEntity().setEstado(null);
	}
	
	@Override
	public PessoaFisica getEntity() {
		if (entity == null) {
			entity = new PessoaFisica();
			entity.setEstado(new Estado());
		}
		
		return entity;
	}
	
	public void abrirPessoaFisicaListing() {
		PessoaFisicaListing listing = new PessoaFisicaListing();
		listing.open();
	}
	
	public void obterPessoaFisicaListing(SelectEvent<PessoaFisica> event) {
		setEntity(event.getObject());
		if (getEntity().getEstado() == null)
			getEntity().setEstado(new Estado());
	}
	
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent<Estado> event) {
		getEntity().setEstado(event.getObject());
	}
	

	
}
