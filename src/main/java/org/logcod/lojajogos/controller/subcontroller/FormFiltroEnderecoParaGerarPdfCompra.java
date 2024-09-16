package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.LocalService;

public class FormFiltroEnderecoParaGerarPdfCompra implements InvokeSubControllers{
    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        LocalService localService = new LocalService();
        FuncionarioService funcionarioService = new FuncionarioService();
        request.setAttribute("locais",localService.consultarEnderecosComPessoas());
        request.setAttribute("funcionarios",funcionarioService.consultarFuncionarios(""));
        return "views/compras/filtrar-compras-por-endereco-gerando-pdf.jsp";
    }
}
