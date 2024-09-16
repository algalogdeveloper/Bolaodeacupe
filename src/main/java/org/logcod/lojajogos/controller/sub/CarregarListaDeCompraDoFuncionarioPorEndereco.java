package org.logcod.lojajogos.controller.sub;

import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import org.logcod.lojajogos.service.CompraService;

public class CarregarListaDeCompraDoFuncionarioPorEndereco implements Invoke {

    @Override
    public Object invokeJson(HttpServletRequest request) {
         CompraService cs = new CompraService();
        return new Gson().toJson(cs.selecionarComprasPeloSeuEnderecoDeCadastroListaCompleta(request.getParameter("obter")));
    }

}
