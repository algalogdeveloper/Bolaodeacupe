package org.logcod.lojajogos.controller.subcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

public class ConsultarPagamentosDoDia implements InvokeSubControllers {
	CompraService cs = new CompraService();

	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Compra> lista = cs.vizualizarPagamentosDoDia();			
			request.setAttribute("compras", lista);
		} catch (Exception e) {
		}
		return "views/pagamento/pagamentosdodia.jsp";
	}

}
