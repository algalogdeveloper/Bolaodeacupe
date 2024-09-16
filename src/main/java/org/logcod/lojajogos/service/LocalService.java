package org.logcod.lojajogos.service;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.repository.RepositoryLocal;

public class LocalService {

    RepositoryLocal ls = new RepositoryLocal();

    public Set<Local> consultarEnderecosComPessoas() {
        return ls.consultarEnderecosComPessoas();
    }

    public Set<Local> consultarEnderecosComPessoasSempagar() {
        System.out.println("Endereços sem pagar");
        return ls.consultarEnderecosComPessoasSempagar();
    }

    public Local get(int idLocal) {
        return ls.getEndereco(idLocal);
    }

    public List<Local> listaVendasEmaberto() {
        return ls.listaVendasEmaberto();
    }

    public Collection<Local> getLocals() {
        return ls.getLocals();
    }

    public Collection<Local> consultaEndereco(String consulta) {
        if (Objects.isNull(consulta)) {
            consulta = "";
        }
        return ls.consultaEndereco(consulta);
    }

    public void save(Local l) {
        ls.save(l);
    }

    public void update(Local l) {
        ls.update(l);
    }

    public int delete(int idlocal) {
        return ls.delete(idlocal);
    }

    public Local obterLocal(String descricao) {
        // TODO Auto-generated method stub
        return ls.obterLocal(descricao);
    }
    
    public LinkedHashSet<Local> listaEnderecosCompraDoFuncionario(int id) {
        return ls.listaEnderecosCompraDoFuncionario(id);
    }

}
