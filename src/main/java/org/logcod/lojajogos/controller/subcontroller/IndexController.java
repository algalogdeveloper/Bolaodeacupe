package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController implements InvokeSubControllers {

	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return "index.jsp";
	}
	
	

}
