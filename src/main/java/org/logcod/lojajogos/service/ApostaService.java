package org.logcod.lojajogos.service;

import java.util.Collection;
import java.util.List;

import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.repository.RepositoryAposta;

public class ApostaService {

	protected RepositoryAposta repositoryAposta = new RepositoryAposta();
	protected static ApostaService apostaService = new ApostaService();
	protected static CompraService compraService = new CompraService();
	protected static MilharService milharService = new MilharService();

	public void save(Aposta aposta) {
		repositoryAposta.save(aposta);
	}
	
	public Aposta apostaPorNumero(String value) {
		return repositoryAposta.apostaPorNumero(value);
	}

	public int update(int chavePK) {
		return repositoryAposta.update(chavePK);
	}

	public Aposta get(int id) {
		return repositoryAposta.get(id);
	}
	
	public Aposta get(int idaposta, int idcompra) {
		return repositoryAposta.get(idaposta, idcompra);
	}

	public Collection<Aposta> consultarApostasIdCompra(int chavePK) {
		return repositoryAposta.consultarApostasIdCompra(chavePK);
	}
        
	public List<Aposta> listaCompletadeApostaPorCliente(){
		return repositoryAposta.listaCompletadeApostaPorCliente();
	}

	public Collection<Aposta> consultarApostaId(String value) {
		return repositoryAposta.consultarApostasNumero(value);
	}
	
	public void deleteAposta(int idaposta) {
		repositoryAposta.deleteAposta(idaposta);		
	}
	public List<Compra> listaCompletaSemFiltrosApostas(){
		return repositoryAposta.listaCompletaSemFiltrosApostas();
	}
        
        public List<Compra> listaCompletaSemFiltrosApostasConcluidas(){
		return repositoryAposta.listaCompletaSemFiltrosApostasConcluidas();
	}

		public void removerMilharAhMais(int id) {
			repositoryAposta.removerMilharAhMais(id);
		}

}
