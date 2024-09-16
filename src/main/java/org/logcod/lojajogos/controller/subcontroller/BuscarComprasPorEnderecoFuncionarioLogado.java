package org.logcod.lojajogos.controller.subcontroller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.service.LocalService;

public class BuscarComprasPorEnderecoFuncionarioLogado implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        LocalService ls = new LocalService();
        try {
            HashMap<Object, Object> model = new HashMap<>();
            Object object = request.getSession().getAttribute("logado");
            Object acesso =  request.getSession().getAttribute("chave_acesso");
            model.put("object", object);
            model.put("acesso", acesso);
            model.put("locais", ls.listaEnderecosCompraDoFuncionario((Integer)(acesso)));
            request.setAttribute("model", model);
            return "views/funcionario/funcionarios-com-vendas.jsp";
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        }
    }

}
