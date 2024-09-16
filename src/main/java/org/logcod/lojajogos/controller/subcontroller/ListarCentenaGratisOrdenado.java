package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.service.CentenaGratisService;

public class ListarCentenaGratisOrdenado implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        CentenaGratisService cgs = new CentenaGratisService();
        try {
            request.setAttribute("centenas", cgs.listaCompraComCentenasGratis());
            return "views/centena/lista-centena-ordenada.jsp";
        } catch (Exception e) {
            return "views/centena/lista-centena-ordenada.jsp";
        }
    }

}
