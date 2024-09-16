package org.logcod.lojajogos.controller.subcontroller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.relatorio.FabricaRelatorios;

public class FabricaRelatorioComprasEndereco implements InvokeSubControllers{
    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
       try {
           String descricao = request.getParameter("descricao");
           if(Objects.isNull(descricao)){
               descricao = "0";
           }
           else
           {
               FabricaRelatorios.carregarRelatorioDisplayView(response,request, descricao);
           }
           }catch (Exception e){
       }
         return "controller?operacao=PainelAdministrativo";
    }
}
