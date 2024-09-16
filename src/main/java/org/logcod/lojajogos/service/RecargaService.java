package org.logcod.lojajogos.service;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import org.logcod.lojajogos.model.entity.Recarga;
import org.logcod.lojajogos.repository.RecargaRepository;

@AllArgsConstructor
public class RecargaService {

    private RecargaRepository rr;

    public void enviarRecarga(LocalDate dataCredito, String descricao, double valor) {
        rr.enviarRecarga(new Recarga(0, dataCredito, descricao, valor));
    }

    public void enviarRecarga(Long id, LocalDate dataCredito, String descricao, double valor) {
        Recarga r = new Recarga(id, dataCredito, descricao, valor);
        if (r.getIdRecarga() <= 0) {
            rr.enviarRecarga(r);
        } else {
            rr.updateRecarga(r);
        }
    }

    public Recarga ultimaRecarga() {
        return rr.ultimaRecarga();
    }

    public List<Recarga> todasRecargas() {
        return rr.todasRecargas();
    }

    public void updateRecarga(Recarga r) {
        rr.updateRecarga(r);
    }

    public void removerRecarga(String codigoRecarga) {
        rr.remover(Long.parseLong(codigoRecarga));
    }
}
