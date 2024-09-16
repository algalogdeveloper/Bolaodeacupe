
package org.logcod.lojajogos.controller.subcontroller;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

public class BuscarCentenaGratisEnCompraCliente implements InvokeSubControllers{

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        CompraService cs = new CompraService();
        LinkedHashSet<Compra> comprasComCentenaGratis = cs.todasComprasComCentenasEhMilharDoCliente();
        Map<Object,Object> model = new HashMap<>();
        model.put("compras", comprasComCentenaGratis);
        request.setAttribute("model", model);
     return "views/centena/ordercentenaUI.jsp"; 
    }
    
}
