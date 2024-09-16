package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.CompraService;

public class HabilitarCobranca implements InvokeSubControllers {
    CompraService cs = new CompraService(); 
	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		cs.habilitarCobranca();
		return "controller?operacao=PagamentoController";
	}

}
