package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetalhesElemento implements InvokeSubControllers {

	public DetalhesElemento() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		return "controller?operacao=CarregarPaginaReizinho";
	}

}
