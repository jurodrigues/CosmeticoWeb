package br.senai.sc.ti2012n.pw.cosmeticosweb.mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.Part;

import br.senai.sc.ti2012n.pw.cosmeticosweb.model.entity.Cosmeticos;
import br.senai.sc.ti2012n.pw.cosmeticosweb.util.FacesContextUtil;
import br.senai.sc.ti2012n.pw.cosmeticosweb.util.ImagemUtil;


@ManagedBean
public class CosmeticosMb {
	private List<Cosmeticos> Cosmeticos;
	private Cosmeticos cosmetico;
	private EntityManager entityManager;
	private Part foto;
	private String fotoAntiga;
	private long idCosmetico;

	@PostConstruct
	public void init() {
		cosmetico = new Cosmeticos();
		entityManager = FacesContextUtil.getEntityManager();
	}

	public List<Cosmeticos> getCosmeticos() {
		if (Cosmeticos == null) {
			Query query = entityManager.createQuery(
					"select f from Cosmeticos f", Cosmeticos.class);
			Cosmeticos = query.getResultList();
		}
		return Cosmeticos;
	}

	public void setCosmeticos(List<Cosmeticos> Cosmeticos) {
		this.Cosmeticos = Cosmeticos;
	}

	public Cosmeticos buscarCosmeticosPorId(Long id) {
		return entityManager.find(Cosmeticos.class, id);
	}

	public Cosmeticos getCosmetico() {
		return cosmetico;
	}

	public void setCosmetico(Cosmeticos Cosmeticos) {
		this.cosmetico = Cosmeticos;
	}

	public String salvar() throws IOException {
		fotoAntiga = cosmetico.getFoto();
		cosmetico = entityManager.merge(cosmetico);
		cosmetico.setFoto(ImagemUtil.copiar(foto, fotoAntiga));
		return "listarCosmeticos";
	}

	public String editar(Long id) {
		cosmetico = entityManager.find(Cosmeticos.class, id);
		return "cadastrarCosmetico";
	}
	
	public String excluir(Long id){
		Cosmeticos cosmetico = entityManager.find(Cosmeticos.class, id);
		entityManager.remove(cosmetico);
		Cosmeticos = null;
		return "listarCosmeticos";
	}

	public Part getFoto() {
		return foto;
	}

	public void setFoto(Part foto) {
		this.foto = foto;
	}

	public String getFotoAntiga() {
		return fotoAntiga;
	}

	public void setFotoAntiga(String fotoAntiga) {
		this.fotoAntiga = fotoAntiga;
	}
	
	public String getCaminhoRelativo(String nomeImagem) {
		return ImagemUtil.getCaminhoRelativo(nomeImagem);
	}

	public long getIdCosmetico() {
		return idCosmetico;
	}

	public void setIdCosmetico(long idCosmetico) {
		this.idCosmetico = idCosmetico;
	}
	
	public void abreCosmetico(){
		cosmetico = entityManager.find(Cosmeticos.class, idCosmetico);
	}
}
