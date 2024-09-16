package org.logcod.lojajogos.controller.subcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.MilharService;

public class EnviarListaNumerosParaCliente implements InvokeSubControllers {

    CompraService cs = new CompraService();
    MilharService ms = new MilharService();
    List<Milhar> milhars = new ArrayList<>();

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        String[] values = request.getParameter("lista").split(" +");
        String id = request.getParameter("addidcompra");
        Compra compra = cs.get(Integer.parseInt(id));
        try {
            int count = 0;
            int valid = 0;
            for (String data : values) {
                Milhar milhar = ms.getJogo(data);
                if (Objects.nonNull(milhar)) {
                    milhars.add(milhar);
                    count++;
                } else {
                    valid++;
                }
            }

            if ( calcularQtd(milhars.size(), compra.getQtdAlternativa()) > 0 && valid == 0) {
                compra.setQtd_cartela((milhars.size() / compra.getQtdAlternativa()) + compra.getQtd_cartela() + calcularCanhotosIncompletos(milhars.size(), compra.getQtdAlternativa()));
                compra.setValor((compra.getQtd_cartela() * compra.getValorBilhete()) - compra.getDesconto());
                cs.inserirMilharParaPessoa(compra.getIdCompra(), compra.getPessoa().getIdPessoa(), milhars);
                cs.alterarQtdValor(compra);
                request.setAttribute("msg", "Os números foram enviados para o cliente: "+compra.getPessoa().getNome());
            } else {
                request.setAttribute("valid", "A sequência nao foi enviada. Pode existir milhar vendido!");
            }
            valid = 0;
        } catch (Exception e) {
            request.setAttribute("valid", "Existe milhar indisponível!");
        }
        return "controller?operacao=ConsultasController&consulta=compras&buscar="
                + compra.getPessoa().getLocal().getIdLocal();
    }
    
     public int calcularCanhotosIncompletos(int qtdNaSacola, int qtdCanhoto) {
        int calculo = 0;
        if (qtdNaSacola % qtdCanhoto > 0) {
            calculo = qtdNaSacola % qtdCanhoto;
        }
        if ((qtdCanhoto - calculo) == 1) {
            return 1;
        }
        return 0;
    }
     
      public int calcularQtd(int qtdNaSacola, int qtdCanhoto) {
        return (qtdNaSacola >= qtdCanhoto) ? qtdNaSacola / qtdCanhoto : 0;
    }

}
    