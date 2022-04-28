package br.unitins.almox.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.almox.application.RepositoryException;
import br.unitins.almox.application.Util;
import br.unitins.almox.model.PessoaFisica;
import br.unitins.almox.repository.PessoaFisicaRepository;

@Named
@ViewScoped
public class PessoaFisicaListing extends Listing<PessoaFisica> {

	private static final long serialVersionUID = -2800428910149904765L;

	private String filtro;

	public PessoaFisicaListing() {
		super("pessoafisicalisting", new PessoaFisicaRepository());
	}

	@Override
	public void pesquisar() {
		PessoaFisicaRepository repo = new PessoaFisicaRepository();
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
