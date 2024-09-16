
package org.logcod.lojajogos.controller.subcontroller;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

public class FormalizarPagamentoDosClienteDoEndereco implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        String endereco = request.getParameter("local");
        System.out.println("Endereco:"+endereco);
        CompraService cs = new CompraService();
        Collection<Compra> compras = cs.selecionarComprasPeloSeuEnderecoDeCadastro(endereco);
        for (Compra compra : compras) {
            cs.pagarCompra(compra.getIdCompra(), (int) request.getSession().getAttribute("chave_acesso"));
        }
        return "controller?operacao=PagamentoController"; 
    }
    
}
