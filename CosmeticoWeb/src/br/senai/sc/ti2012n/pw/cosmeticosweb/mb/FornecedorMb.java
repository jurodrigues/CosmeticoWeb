package br.senai.sc.ti2012n.pw.cosmeticosweb.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.ti2012n.pw.cosmeticosweb.model.entity.Fornecedor;
import br.senai.sc.ti2012n.pw.cosmeticosweb.util.FacesContextUtil;



@ManagedBean
public class FornecedorMb {
	private List<Fornecedor> fornecedores;
	private Fornecedor fornecedor;
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		fornecedor = new Fornecedor();
		entityManager = FacesContextUtil.getEntityManager();
	}

	public List<Fornecedor> getfornecedores() {
		if (fornecedores == null) {
			Query query = entityManager.createQuery(
					"select f from Fornecedor f", Fornecedor.class);
			fornecedores = query.getResultList();
		}
		return fornecedores;
	}

	public void setfornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Fornecedor buscarFornecedorPorId(Long id) {
		return entityManager.find(Fornecedor.class, id);
	}

	public Fornecedor getfornecedor() {
		return fornecedor;
	}

	public void setfornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String salvar() {
		entityManager.merge(fornecedor);
		return "listarFornecedores";
	}

	public String editar(Long id) {
		fornecedor = entityManager.find(Fornecedor.class, id);
		return "cadastrarFornecedor";
	}
}
