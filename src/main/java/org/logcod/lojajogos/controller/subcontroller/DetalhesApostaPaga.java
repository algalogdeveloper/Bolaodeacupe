package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.service.ConsultasService;

public class DetalhesApostaPaga implements InvokeSubControllers{
	ConsultasService cs = new ConsultasService();
	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		String acao = request.getParameter("acao");		
		request.setAttribute("apostas", cs.detalhesAposta(DataSourceUtil.configDataIntegerValue(acao)));
		return "views/pagamento/detalhesComprasPagas.jsp";
		
	}

	

}
