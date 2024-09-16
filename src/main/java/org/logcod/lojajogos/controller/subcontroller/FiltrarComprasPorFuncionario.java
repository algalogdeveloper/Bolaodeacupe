package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.PessoaService;

public class FiltrarComprasPorFuncionario implements InvokeSubControllers {
	PessoaService ps = new PessoaService();
	LocalService sl = new LocalService();
	CompraService compraService = new CompraService();
	FuncionarioService fs = new FuncionarioService();

	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		try {
			Funcionario funcionario = fs.getFuncionario(Integer.valueOf(request.getParameter("idfuncionario")));
			Local endereco = sl.get(Integer.valueOf(request.getParameter("idlocal")));
			request.setAttribute("endereco", endereco);
			request.setAttribute("compras",
					compraService.filtrarCompraPorFuncionario(funcionario, endereco, pegarSituacao(request)));
		} catch (Exception e) {
			System.out.println(e);
		}
		request.setAttribute("locais", sl.consultarEnderecosComPessoas());
		request.setAttribute("funcionarios", fs.getFuncionarios(20));
		return "views/funcionario/filtrar-compras-por-funcionario.jsp";
	}

	public String pegarSituacao(HttpServletRequest request) {
		String situacao = request.getParameter("situacao");
		return situacao;
	}

}
