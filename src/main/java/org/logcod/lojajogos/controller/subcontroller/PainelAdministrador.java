package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.repository.RecargaRepository;
import org.logcod.lojajogos.service.RecargaService;

public class PainelAdministrador implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        RecargaService rs = new RecargaService(new RecargaRepository());
        try {
           Object permissaoDeAcesso = request.getSession().getAttribute("permissao");
        System.out.println("Permissao = "+permissaoDeAcesso);
        if (permissaoDeAcesso.equals(4)){
            request.setAttribute("recargas", rs.todasRecargas());
            return "admin/painel-do-adminstrador.jsp";
        } else {
            request.setAttribute("msg", "Sua sessão foi destruida!");
            return "controller?operacao=IndexController";
        } 
        } catch (Exception e) {
            request.setAttribute("msg", "Sua sessão foi destruida!");
            return "controller?operacao=IndexController";
        }
        

    }

}
