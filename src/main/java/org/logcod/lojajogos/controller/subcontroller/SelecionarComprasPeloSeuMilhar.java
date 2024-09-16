package org.logcod.lojajogos.controller.subcontroller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.MilharService;

public class SelecionarComprasPeloSeuMilhar implements InvokeSubControllers {
	protected CompraService cs = new CompraService();
	protected ConsultasService sc = new ConsultasService();
	protected MilharService ms = new MilharService();
   
	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		String filtro = request.getParameter("filtro");
		Collection<Compra> compras = cs.selecionarComprasPeloSeuMilharDeCadastro(filtro);	
		System.out.println("Mostrar: "+compras);
		request.setAttribute("compras", compras);			
		return "views/compras/compraspormilhar.jsp";
	}

}
