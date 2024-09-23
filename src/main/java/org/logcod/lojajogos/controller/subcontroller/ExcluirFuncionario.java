/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.service.FuncionarioService;

/**
 *
 * @author Leandro
 */
public class ExcluirFuncionario implements InvokeSubControllers{
    
    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        FuncionarioService fs = new FuncionarioService();
        try {
            String acao = request.getParameter("acao");
            fs.remove(acao);
            return  "controller?operacao=CatalogoFuncionario";
        } catch (Exception e) {
                   
        throw new UnsupportedOperationException("Nao foi possivel excluir."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 
        }
    }
    
}
