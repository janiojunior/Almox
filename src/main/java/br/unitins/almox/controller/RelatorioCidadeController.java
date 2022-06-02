package br.unitins.almox.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.almox.application.RepositoryException;
import br.unitins.almox.application.Util;
import br.unitins.almox.model.Cidade;
import br.unitins.almox.repository.CidadeRepository;

@Named
@ViewScoped
public class RelatorioCidadeController implements Serializable{

	private static final long serialVersionUID = 7404338910158355389L;
	
	private String filtro;
	private List<Cidade> listaCidade;
	
	public void pesquisar() {
		CidadeRepository repo = new CidadeRepository();
		try {
			setListaCidade(repo.findByNomeEstado(filtro));
		} catch (RepositoryException e) {
			setListaCidade(null);
		}
	}
	
	public void limpar() {
		filtro = null;
		setListaCidade(null);
	}
	
	public void gerarRelatorio() {
		Util.redirect("/Almox/relatoriocidades.xhtml?ESTADO="+getFiltro().trim());
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Cidade> getListaCidade() {
		if (listaCidade == null)
			listaCidade = new ArrayList<Cidade>();
		return listaCidade;
	}

	public void setListaCidade(List<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}
	
	

}
