package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LimparApostaPremiada implements InvokeSubControllers {

	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CarregarMilharPremiado.getApostas().clear();
		return "controller?operacao=ObterMilharPremiado";
	}

}
