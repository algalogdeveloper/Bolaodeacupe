package org.logcod.lojajogos.controller.subcontroller;

import java.util.Collection;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.MilharService;
import org.logcod.lojajogos.service.PessoaService;

public class ConsultasController implements InvokeSubControllers {
	
	protected ConsultasService consultasService = new ConsultasService();
	protected MilharService ms = new MilharService();
	protected PessoaService ps = new PessoaService();
	protected ApostaService as = new ApostaService();
	protected CompraService rp = new CompraService();
	protected LocalService localService = new LocalService();
	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		String logado = (String) request.getSession().getAttribute("logado");

		String url = "index.jsp";
		if (Objects.nonNull(logado)) {

			String action = request.getParameter("consulta");

			switch (action) {
			case "compras":
				url = selecionarPaginaCompras(request);
				break;
			case "ativa":
				url = consultarMilhar(request);
				break;
			case "habilitar":
				ativarMilhar(request);
				break;
			case "cartela-por-pessoa":
				System.out.println("solicitado cartelas por pessoa:");
				url = comprasPorPessoa(request);
				break;
			case "pagamento":
				break;
			}
		}
		return url;
	}

	private void ativarMilhar(HttpServletRequest request) {
		try {
			ms.getDisponivel(request.getParameter("habilitar"));
		} catch (Exception e) {

		}

	}

	String buscar = " ";

	private String consultarMilhar(HttpServletRequest request) {
		try {
			buscar = request.getParameter("buscar");
			Collection<Milhar> all = ms.selecioneMilharVendidos(buscar);
			request.setAttribute("selecionados", all);
			request.setAttribute("size", all.size());

		} catch (Exception e) {
			System.out.println(e.getCause());
		}
		return "views/loja/jogos.jsp";
	}



	public String selecionarPaginaCompras(HttpServletRequest request) {
		try {
			String buscar = request.getParameter("buscar");
			int id = Integer.parseInt(buscar);
			Local local = localService.get(id) == null ? new Local(0,"Selecione", "ok"):localService.get(id);
			request.setAttribute("locais", localService.consultarEnderecosComPessoas());
			request.setAttribute("local_filt", local);		
			request.setAttribute("qtd_taloes",rp.encontrarQuantidadeDeTaloesDoEndereco(local.getIdLocal()) );	
			request.setAttribute("valorEmaberto", rp.encontrarValorEmaberto(local.getIdLocal()));
			request.setAttribute("valorConcluido",  rp.encontrarValorEmConcluido(local.getIdLocal()));
			request.setAttribute("compras", consultasService.listarComprasDetalhes(local.getIdLocal()));
			return "views/loja/loja.jsp";
		} catch (Exception e) {
			System.out.println("Excption: "+e);					
		}
		request.setAttribute("locais", localService.consultarEnderecosComPessoas());		
		return "views/loja/loja.jsp";
	}

	private String comprasPorPessoa(HttpServletRequest request) {
		try {
			String filtro = request.getParameter("buscar");
			Collection<Compra> compras = consultasService.consultarCompraPorPessoa(filtro);
			Collection<Aposta> apostas = consultasService.consultarApostas();
			request.setAttribute("size", compras.size());
			request.setAttribute("compras", compras);
			request.setAttribute("apostas", apostas);
		} catch (Exception e) {
			System.out.println(e.getCause());
		}
		return "views/compras/comprasporpessoa.jsp";
	}

}
