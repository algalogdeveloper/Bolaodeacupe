package org.logcod.lojajogos.controller.subcontroller;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.repository.RecargaRepository;
import org.logcod.lojajogos.service.RecargaService;

public class EnviarDataRecarga implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        try {
            RecargaService rs = new RecargaService(new RecargaRepository());
            String idrecarga = request.getParameter("idrecarga");
            LocalDate dataLancamento = LocalDate.parse(request.getParameter("datarecarga"));
            String descricao = request.getParameter("descricao");
            double valorCredito = Double.parseDouble(request.getParameter("valor"));
            rs.enviarRecarga(Long.valueOf(idrecarga), dataLancamento, descricao, valorCredito);
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "controller?operacao=PainelAdministrador");
            return "/";
        } catch (Exception e) {
            System.out.println("Erro:"+e);
        }
        return "controller?operacao=PainelAdministrador";
    }

}
