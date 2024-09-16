package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.repository.RecargaRepository;
import org.logcod.lojajogos.service.RecargaService;

public class RemoverRecarga implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        RecargaService rs = new RecargaService(new RecargaRepository());
        try {
            String codigoRecarga = request.getParameter("idrecarga");
            rs.removerRecarga(codigoRecarga);
        } catch (Exception e) {
            System.out.println("Erro: "+e);
        }
        return "controller?operacao=PainelAdministrador";
    }

}
