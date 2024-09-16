package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.AreaAdministradorService;

public class EnviaPageQtdIrregulares implements InvokeSubControllers {

	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		try {
			AreaAdministradorService as = new AreaAdministradorService();
			request.setAttribute("comprasAbaixo", as.carregarTaloesAbaixo());
			request.setAttribute("comprasAcima", as.carregarListaDeTaloesQtdAcima());
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		return "views/compras/view-compras-acima-e-abaixa.jsp";
	}

}
