package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.CompraService;

public class TruncateTable implements InvokeSubControllers {
    CompraService compraService = new CompraService();
	
	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		compraService.truncarDataTables();
		compraService.ativarTodosCartelasParaVenda();
		request.setAttribute("msg", "Iniciar venda de cartelas novamente.");
		
		return "controller?operacao=CarrinhoController&carrinho=loja";
	}

}
