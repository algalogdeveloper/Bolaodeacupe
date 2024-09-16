package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.CentenaGratisService;

public class DeleteCentena implements InvokeSubControllers {

    public DeleteCentena() {
        // TODO Auto-generated constructor stub
    }

    CentenaGratisService service = new CentenaGratisService();

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        try {

            if (service.deleteCentena(Integer.parseInt(request.getParameter("id")))) {
                request.setAttribute("msg", "Centena excluida com sucesso: ");
            } else {
                request.setAttribute("msg", "Não excluida a centena!");
            }

            return "controller?operacao=PaginasTodasCentenas";
        } catch (Exception e) {
            return "controller?operacao=PaginasTodasCentenas";
        }

    }

}
