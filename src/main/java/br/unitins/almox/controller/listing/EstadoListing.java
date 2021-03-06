package br.unitins.almox.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.almox.application.RepositoryException;
import br.unitins.almox.application.Util;
import br.unitins.almox.model.Estado;
import br.unitins.almox.repository.EstadoRepository;

@Named
@ViewScoped
public class EstadoListing extends Listing<Estado> {

	private static final long serialVersionUID = -2800428910149904765L;

	private String filtro;

	public EstadoListing() {
		super("estadolisting", new EstadoRepository());
	}

	@Override
	public void pesquisar() {
		EstadoRepository repo = new EstadoRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage("Problema ao realizar a consulta.");
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
