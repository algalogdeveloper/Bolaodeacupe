package org.logcod.lojajogos.controller.subcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.AreaAdministradorService;

public class ComprasSemClientes implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        AreaAdministradorService as = new AreaAdministradorService();
        List<Compra> comprasSemClientes = as.solicitarListaDeComprasSemCliente();
        request.setAttribute("compras", comprasSemClientes);
        return "views/compras/consultar-compras-sem-cliente.jsp";
    }

}
