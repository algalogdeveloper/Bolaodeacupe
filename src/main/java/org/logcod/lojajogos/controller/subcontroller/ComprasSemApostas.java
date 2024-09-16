package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.AreaAdministradorService;

public class ComprasSemApostas implements InvokeSubControllers {

	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		AreaAdministradorService as = new AreaAdministradorService();
		request.setAttribute("compras",as.solicitarListaDeApostasSemCompras());
		return "views/compras/consultar-compras-sem-apostas.jsp";
	}

}
