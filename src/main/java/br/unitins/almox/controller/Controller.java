package br.unitins.almox.controller;

import br.unitins.almox.application.RepositoryException;
import br.unitins.almox.application.Util;
import br.unitins.almox.application.VersionException;
import br.unitins.almox.model.DefaultEntity;
import br.unitins.almox.repository.Repository;
import br.unitins.almox.repository.UsuarioRepository;

public abstract class Controller <T extends DefaultEntity> {

	private Repository<T> repository;
	protected T entity;
	
	public Controller(Repository<T> repository) {
		super();
		this.repository = repository;
	}

	public void incluir() {
		try {
			limparRelacionamentosNaoObrigatorios();
			setEntity(getRepository().save(getEntity()));
			Util.addInfoMessage("Inclusão realizada com sucesso.");
			limpar();
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		} catch (VersionException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
	}
	
	public void salvarSemLimpar() {
		try {
			limparRelacionamentosNaoObrigatorios();
			setEntity(getRepository().save(getEntity()));
			Util.addInfoMessage("Salvo com sucesso.");
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		} catch (VersionException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
	}
	
	protected void limparRelacionamentosNaoObrigatorios() {
		
	}

	public void alterar() {
		try {
			limparRelacionamentosNaoObrigatorios();
			setEntity(getRepository().save(getEntity()));
			Util.addInfoMessage("Alteração realizada com sucesso.");
			limpar();
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		} catch (VersionException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
	}

	
	public void excluir() {
		try {
			getRepository().remove(getEntity());
			Util.addInfoMessage("Exclusão realizada com sucesso.");
			limpar();
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
	}

	
	public void limpar() {
		entity = null;
	}
	
	public Repository<T> getRepository() {
		return repository;
	}
	
	public abstract T getEntity();
	
	public void setEntity(T entity) {
		this.entity = entity;
	}

}