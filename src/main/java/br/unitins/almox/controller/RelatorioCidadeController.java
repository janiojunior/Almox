package br.unitins.almox.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.almox.model.Cidade;

@Named
@ViewScoped
public class RelatorioCidadeController implements Serializable{

	private static final long serialVersionUID = 7404338910158355389L;
	
	private String filtro;
	private List<Cidade> listaCidade;

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Cidade> getListaCidade() {
		return listaCidade;
	}

	public void setListaCidade(List<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}
	
	

}
