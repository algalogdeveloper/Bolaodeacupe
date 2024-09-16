package org.logcod.lojajogos.controller.subcontroller;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Recarga;
import org.logcod.lojajogos.repository.RecargaRepository;
import org.logcod.lojajogos.service.RecargaService;

public class ModififarDataRecarga implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        try {
            RecargaService rs = new RecargaService(new RecargaRepository());
            rs.updateRecarga(new Recarga(Long.parseLong(request.getParameter("idrecarga")), LocalDate.parse(request.getParameter("datarecarga")), request.getParameter("descricao"), 0.00));

        } catch (Exception e) {
        }
        return "controller?operacao=ListaDeRecargas";
    }

}
