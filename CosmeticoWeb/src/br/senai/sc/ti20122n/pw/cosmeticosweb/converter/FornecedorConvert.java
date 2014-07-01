package br.senai.sc.ti20122n.pw.cosmeticosweb.converter;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.ti2012n.pw.cosmeticosweb.mb.FornecedorMb;
import br.senai.sc.ti2012n.pw.cosmeticosweb.model.entity.Fornecedor;



@FacesConverter(forClass=Fornecedor.class)
public class FornecedorConvert implements Converter{
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		ELContext elContext = facesContext.getELContext();
		ELResolver elResolver = elContext.getELResolver();
		
		FornecedorMb fornecedorMb = (FornecedorMb) elResolver.getValue(elContext, null, "fornecedorMb");
		
		Long id = Long.parseLong(value);
		return fornecedorMb.buscarFornecedorPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
		Fornecedor fornecedor = (Fornecedor) object;
		return String.valueOf(fornecedor.getId());
	}

}
