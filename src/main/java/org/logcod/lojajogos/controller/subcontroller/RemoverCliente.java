package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.service.PessoaService;

public class RemoverCliente implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        PessoaService ps = new PessoaService();
        String remove = request.getParameter("remover");
        ps.delete(Integer.parseInt(remove));
        request.setAttribute("message", "Pessoa sem aposta foi removida com sucesso!");
        return "controller?operacao=ComprasSemClientes";
    }

}
