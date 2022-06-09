package br.unitins.almox.model;

import java.util.ArrayList;
import java.util.List;

public enum Perfil {
	
	ADMINISTRADOR(1, "Administrador"), 
	FUNCIONARIO(2, "Funcionário");
	
	private int id;
	private String label;
	private List<String> paginasComPermissao;
	
	Perfil(int id, String label) {
		this.id = id;
		this.label = label;
		paginasComPermissao = new ArrayList<String>();
		if (id == 1) {
			paginasComPermissao.add("/Almox/faces/admin/cidade.xhtml");
			paginasComPermissao.add("/Almox/faces/admin/estado.xhtml");
		} else {
			paginasComPermissao.add("/Almox/faces/admin/cidade.xhtml");
			paginasComPermissao.add("/Almox/faces/admin/cidadelisting.xhtml");
			paginasComPermissao.add("/Almox/faces/admin/cidadelistingsql.xhtml");
		}
		
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public List<String> getPaginasComPermissao() {
		return paginasComPermissao;
	}
	
	public static Perfil valueOf(int id) {
		for (Perfil perfil : Perfil.values()) {
			if (perfil.getId() == id)
				return perfil;
		}
		return null;
	}

}