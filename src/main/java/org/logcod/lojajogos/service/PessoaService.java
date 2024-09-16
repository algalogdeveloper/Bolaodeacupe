package org.logcod.lojajogos.service;

import java.util.Collection;
import java.util.Objects;

import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.repository.RepositoryPessoa;

public class PessoaService {

    public RepositoryPessoa rp;

    public PessoaService() {
        rp = new RepositoryPessoa();
    }

    public Pessoa save(Pessoa p) {
        Pessoa pessoa = rp.referenciaCartela(p.getContato());
        if (Objects.isNull(pessoa)) {
            pessoa = rp.save(p);
        }
        return pessoa;
    }

    public Pessoa referenciaCartela(String numero) {
        return rp.referenciaCartela(numero);
    }

    public Pessoa get(int idPessoa) {
        return rp.get(idPessoa);
    }

    public int update(Pessoa p) {
        return rp.update(p);
    }

    public Collection<Pessoa> consultaPessoas(String nome, String email, String contato) {
        if (Objects.isNull(nome)) {
            nome = "";
        }
        return rp.consultasPessoas(nome, email, contato);

    }

    public Pessoa consultarPeloEmailContato(String email, String contato) {
        return rp.consultarPeloEmailContato(email, contato);
    }

    public Pessoa consultarPeloContato(String contato) {
        return rp.consultarPeloNome(contato);
    }

    public Pessoa consultarPeloNome(String contato) {

        return rp.consultarPeloNome(contato);
    }

    public void delete(int idPessoa) {
        rp.delete(idPessoa);
    }

}
