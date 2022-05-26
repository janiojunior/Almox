package br.unitins.almox.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.almox.application.RepositoryException;
import br.unitins.almox.application.Util;
import br.unitins.almox.model.Cidade;
import br.unitins.almox.repository.CidadeRepository;

@Named
@ViewScoped
public class CidadeListingSQL extends ListingSQL<Cidade> {

	private static final long serialVersionUID = -902597686959786947L;
	private String filtro;

	public CidadeListingSQL() {
		super("cidadelistingsql", new CidadeRepository());
	}

	@Override
	public void pesquisar() {
		CidadeRepository repo = new CidadeRepository();
		try {
			setList(repo.findByNomeSQL(filtro));
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
