package org.logcod.lojajogos.controller.subcontroller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.service.AreaAdministradorService;

public class CarregarPageItemCliente implements InvokeSubControllers {

    AreaAdministradorService as = new AreaAdministradorService();

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        pagination1(request);
        return "views/compras/view-catalogo-de-milhar-sem-cliente.jsp";
    }

    public void pagination1(HttpServletRequest request) {
        String page = request.getParameter("data");
        if (Objects.isNull(page)) {
            page = "1";
        }
        int pagina = Integer.parseInt(page);
        int qtdData = as.quantidadeRegistrosSalvos();
        int limite = as.obterLimite(240);
        int offset = (pagina * limite) - limite;
        int qtdPage = qtdData / limite;
        if (qtdData % limite != 0) {
            qtdPage++;
        }
        int proxima = 1;
        int anterior = 1;

        if (pagina > 1) {
            anterior = pagina - 1;
        }
        if ((qtdData - pagina * limite) > 0) {
            proxima = pagina + 1;
        }
        request.setAttribute("qtddata", qtdData);
        request.setAttribute("qtdpage", qtdPage);
        request.setAttribute("page", pagina);
        request.setAttribute("anterior", anterior);
        request.setAttribute("proxima", proxima);
        List<Aposta> apostas = as.catalogoDeapostasSemMilhar(offset, limite);
        request.setAttribute("apostas", apostas);
        request.setAttribute("limite", limite);
    }

}
