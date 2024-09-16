package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

public class ViewAjustarValorCliente implements InvokeSubControllers {

    CompraService cs = new CompraService();

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        String valor = request.getParameter("valor");
        String cliente = request.getParameter("cliente");
        String idc = request.getParameter("idc");
        Compra compra = cs.obterCompra(Integer.parseInt(idc));
        boolean ok = cs.modificarValor(Integer.parseInt(idc), Double.parseDouble(valor));
        String valid = null;
        String msg = null;
        if (ok) {
            msg = "O valor foi atualizada com sucesso: " + cliente;
        } else {
            valid = "Nao foi possivel atualizar o valor: " + cliente;
        }
        request.setAttribute("msg", msg);
        return "controller?operacao=ConsultasController&consulta=compras&buscar=" + compra
                .getPessoa()
                .getLocal()
                .getIdLocal();
    }

}
