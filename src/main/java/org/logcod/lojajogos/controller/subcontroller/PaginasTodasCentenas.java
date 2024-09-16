package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.service.CentenaGratisService;

public class PaginasTodasCentenas implements InvokeSubControllers {

    CentenaGratisService centenaGratisService = new CentenaGratisService();

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("gratis", centenaGratisService.listaCompraComCentenasGratis());
            return "views/centena/consultar-todas-centenas.jsp";
        } catch (Exception e) {
            return "views/centena/consultar-todas-centenas.jsp";
        }

    }

}
