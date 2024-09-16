package org.logcod.lojajogos;

import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.LocalService;

public class TestMain {

    public static void main(String[] args) {
        FuncionarioService fs = new FuncionarioService();
        fs.todos().forEach(a -> {
            System.out.println("Id:" + a.getIdFuncionario());
            System.out.println("Nome:" + a.getNome());
            System.out.println("Login:" + a.getLogin());
            System.out.println("Senha:" + a.getSenha());
        });
    }

}
