package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ObterMilharPremiado implements InvokeSubControllers {
	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		return "views/pagamento/verificar-ganhaodor.jsp";

	}



}
