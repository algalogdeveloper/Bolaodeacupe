package org.logcod.lojajogos.jdbc.queries.endereco;

public class CreateNamedQueryEndereco {

	public static String consultarEnderecosComPessoas() {
		return "select e.idendereco as id,e.descricao as dr,e.cidade as cd from endereco e, pessoa p where e.idendereco = p.idendereco ";
	}
        
        public static String consultarEnderecosComPessoasSempagar() {
		return "select e.idendereco as id,e.descricao as dr,e.cidade as cd from endereco e, pessoa p, compra c where e.idendereco = p.idendereco and p.idpessoa = c.idpessoa and not pagou";
	}

	public static String getLocals() {
		return "SELECT * FROM endereco e order by e.descricao";
	}

	public static String listaVendasEmaberto() {
		// TODO Auto-generated method stub
		return "select  DISTINCT(e.idendereco) as chave,e.descricao,e.cidade from public.endereco e \n"
    			+ "INNER JOIN public.pessoa p ON e.idendereco = p.idendereco \n"
    			+ "INNER Join public.compra c on p.idpessoa = c.idpessoa where not pagou ";
	}

	public static String consultaEndereco() {
		return "SELECT * FROM endereco e where e.descricao like ?";
	}

	public static String getEndereco() {
		return "SELECT * FROM endereco e where e.idendereco = ?";
	}

	public static String retornarChave() {
		// TODO Auto-generated method stub
		return "select max(idendereco) as chave from endereco";
	}

	public static String obterLocal() {
		// TODO Auto-generated method stub
		return "SELECT * FROM endereco e where e.descricao = ?";
	}

}
