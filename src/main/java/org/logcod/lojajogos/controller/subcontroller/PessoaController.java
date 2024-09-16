package org.logcod.lojajogos.controller.subcontroller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.PessoaService;

public class PessoaController implements InvokeSubControllers {

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        CompraService cs = new CompraService();
        try {
            String url = "controller?operacao=PessoaController&pessoa=listar";
            String logado = (String) request.getSession().getAttribute("logado");
            if (Objects.nonNull(logado)) {
                String menu = request.getParameter("pessoa");
                switch (menu) {
                    case "listar":
                        url = selecionarPessoas(request);
                        request.setAttribute("qtdtalao", cs.qtdTalaoInseridos());
                        break;
                    case "save":
                        url = savePessoa(request);
                        break;
                    case "remove":
                        url = deletePessoa(request);
                        break;
                }
            } else {
                url = "LoginUser?restricao=logar";
            }
            System.out.println("teste uri: " + url);
            return url;

        } catch (Exception e) {
            System.out.println("log:" + e.getLocalizedMessage());

            return "index.jsp";
        }

    }

    public String deletePessoa(HttpServletRequest request) {
        try {

            Pessoa pessoa = ps.get(Integer.parseInt(request.getParameter("codpessoa")));
            ps.delete(pessoa.getIdPessoa());
            request.setAttribute("msg", "Exclusão realizada com sucesso");
        } catch (NumberFormatException e) {
            System.out.println("Log: " + e.getLocalizedMessage());
        }

        return "controller?operacao=PessoaController&pessoa=listar";

    }

    public String savePessoa(HttpServletRequest request) {
        try {
            String idpessoa = request.getParameter("idPessoa");
            Pessoa pessoa = new Pessoa(Integer.parseInt(idpessoa), request.getParameter("nome"),
                    request.getParameter("email"), request.getParameter("contato"), request.getParameter("referencia"),
                    sl.get(Integer.valueOf(request.getParameter("idLocal"))));
            String msg = "";
            if (pessoa.getIdPessoa() == 0) {
                ps.save(pessoa);
                msg = "Cadatrado com sucesso " + pessoa.getNome();
            } else {
                ps.update(pessoa);
                cs.alterarNumeroReferencia(pessoa.getReferencia(), pessoa.getIdPessoa());
                msg = "Atualizada com sucesso " + pessoa.getNome();

            }
            request.setAttribute("msg", msg);
            return "controller?operacao=PessoaController&pessoa=listar";
            // request.setAttribute("msg", msg);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return "controller?operacao=PessoaController&pessoa=listar";
        }

    }

    PessoaService ps = new PessoaService();
    LocalService sl = new LocalService();
    CompraService cs = new CompraService();

    public String selecionarPessoas(HttpServletRequest request) {
        request.setAttribute("pessoas", ps.consultaPessoas("", "", ""));
        request.setAttribute("enderecos", sl.getLocals());
        return "views/pessoa/consultar.jsp";
    }

}
