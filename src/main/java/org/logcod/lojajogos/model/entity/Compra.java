
package org.logcod.lojajogos.model.entity;

import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.logcod.lojajogos.service.ApostaService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Compra {

	private int idCompra;
	private Calendar dataJogo;
	private Pessoa pessoa;
	private boolean pagou;
	private boolean cancelar;
	private double valor;
	private Calendar dataPg;
	private String numero_cartela;
	private String premio;
	private int qtd_cartela;
	private double valorBilhete;
	private Funcionario funcionario;
	private int qtdAlternativa;
        private double desconto;
	private Collection<Aposta> apostas;
        private LinkedHashSet<CentenaGratis> todasCentenasGratis;
        private LinkedHashSet<CentenaGratisinha> todasCentenasGratisinha;
        
	public Compra(Pessoa p) {
		this.pessoa = p;
	}
	public Compra(int id, Pessoa p) {
		this.idCompra = id;
		this.pessoa = p;
	}

	public Collection<Aposta> obter(int id) {
		apostas.size();
		return new ApostaService().consultarApostasIdCompra(id);
	}
	
	

}
