
package org.logcod.lojajogos.model.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Recarga {
    private long idRecarga;
    private LocalDate dataRecarga;
    private String descricao;
    private double valor;
}
