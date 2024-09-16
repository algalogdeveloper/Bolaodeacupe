package org.logcod.lojajogos.controller.subcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

public class ConsultaRapidaComprasCliente implements InvokeSubControllers {
	CompraService cs = new CompraService();
	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		try {
			String data = request.getParameter("buscar").toUpperCase();
			List<Compra> compras = cs.buscarCompraClienteMobile(data.trim());
			request.setAttribute("data_send", data);
			request.setAttribute("compras", compras);
		} catch (Exception e) {
			
		}
		return "views/compras/consulta-rapida-de-compras.jsp";
	}

}
