package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.service.CompraService;

public class ViewQtdDiferenteValorAposta implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        CompraService cs = new CompraService();
        request.setAttribute("valorperdido", cs.valorPerdido());        
        request.setAttribute("compras", cs.listaDeComprasValorDiferenteQtd());
        return "views/compras/consultar-compras-qtd_valor_dif.jsp";
    }

}
