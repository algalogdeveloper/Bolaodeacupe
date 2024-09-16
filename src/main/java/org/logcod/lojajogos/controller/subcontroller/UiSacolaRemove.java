package org.logcod.lojajogos.controller.subcontroller;

import java.util.LinkedHashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.service.CarrinhoService;

public class UiSacolaRemove implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        CarrinhoService cs = CarrinhoService.createCarrinho();
        try {
            String param = request.getParameter("param");
            LinkedHashSet<Milhar> minhaSacola = (LinkedHashSet<Milhar>) request.getSession().getAttribute("sacola");
            if(!minhaSacola.isEmpty()){              
                cs.excluirNumero(minhaSacola, param);
                request.setAttribute("msg", "O milhar "+param+ " foi removido pelo seu código com sucesso!");
                request.setAttribute("carregado", minhaSacola.size());
            }
        } catch (Exception e) {
        }
        return "controller?operacao=UISacola";
    }

}
