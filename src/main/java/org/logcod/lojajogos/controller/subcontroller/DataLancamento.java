package org.logcod.lojajogos.controller.subcontroller;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.repository.RecargaRepository;
import org.logcod.lojajogos.service.RecargaService;

public class DataLancamento implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        try {
            RecargaService rs = new RecargaService(new RecargaRepository());
            LocalDate dataLancamento = LocalDate.parse(request.getParameter("dataLancamento"));
            String descricao = request.getParameter("descricao");
            double valorCredito = Double.parseDouble(request.getParameter("valorcredito"));
            rs.enviarRecarga(dataLancamento, descricao, valorCredito);
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "controller?operacao=areaadmin");
            return "/";
        } catch (Exception e) {

        }
        return "controller?operacao=areaadmin";
    }

}
