package org.logcod.lojajogos.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.repository.RepositoryMilhar;

public class MilharService {

    protected RepositoryMilhar rj = new RepositoryMilhar();

    public Milhar obterMilhar(String numero) {
        return rj.obterMilhar(numero);
    }

    public void save(Milhar jogo) {
        rj.salvarJogo(jogo);
    }

    public List<Milhar> getJogos(String value) {
        return rj.getJogos(value);
    }

    public Milhar getJogo(String value) {
        return rj.getJogo(value);
    }

    public Milhar find(String value) {
        return rj.find(value);
    }

    public Collection<Milhar> selecioneMilharVendidos(String buscar) {
        if (Objects.isNull(buscar)) {
            buscar = "";
        }
        return rj.selecioneMilharVendidos(buscar);
    }

    public Milhar getJogo(Integer value) {
        return rj.getJogo(value);
    }

    public int getNaoDisponivel(Milhar jogo) {
        return rj.getNaoDisponivel(jogo);

    }

    public int getDisponivel(Milhar milhar) {
        return rj.getDisponivel(milhar);
    }

    public int getDisponivel(String milhar) {
        return rj.getDisponivel(milhar);
    }

    public int getNaoDisponivel(int jogo) {
        return rj.getNaoDisponivel(jogo);
    }

}
