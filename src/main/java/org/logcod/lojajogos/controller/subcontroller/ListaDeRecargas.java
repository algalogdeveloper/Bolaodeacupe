package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.repository.RecargaRepository;
import org.logcod.lojajogos.service.RecargaService;

public class ListaDeRecargas implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        RecargaService rs = new RecargaService(new RecargaRepository());
        request.setAttribute("recargas", rs.todasRecargas());

        return "views/recargas/lista-de-recargas.jsp";
    }

}
