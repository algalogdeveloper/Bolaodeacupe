package org.logcod.lojajogos.controller.subcontroller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PainelAdministrativo implements InvokeSubControllers {
    
    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
       
        return "views/admin/adminpainelacoes.jsp";
    }
    
}
