package org.logcod.lojajogos.login;

import java.io.IOException;
import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.service.AdminService;
import org.logcod.lojajogos.service.FuncionarioService;

@SuppressWarnings("serial")
public class LoginUser extends HttpServlet {

    private static int qtdacesso = 0;
    protected AdminService sa = new AdminService();
    protected FuncionarioService fs = new FuncionarioService();
    protected String url = "index.jsp";
    protected HttpSession session = null;
    protected Funcionario funcionario;
    protected String msg;

    public String destruirSessao(String logado, HttpServletRequest session) {
        session.getSession().invalidate();
        return Objects.nonNull(logado) ? null : null;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("restricao");
            String logado = (String) request.getSession().getAttribute("logado");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            logado = destruirSessao(logado, request);
            if (Objects.isNull(logado)) {
                switch (action) {
                    case "permission":
                        if (fs.validarLogin(login, senha)) {
                            funcionario = fs.logarFuncionario(login.trim(), senha.trim());
                            funcionario.setHostacesso(request.getRemoteAddr());
                            url = permissaoFuncionario(request, funcionario, session);
                        } else {
                            qtdacesso++;
                            msg = "Login ou senha invalidos!";
                            if (qtdacesso == 4) {
                                request.setAttribute("qtdacesso", qtdacesso);
                                msg = "Atenção você já fez " + qtdacesso + " tentivas a plataforma vai bloquear!";
                            }
                            request.setAttribute("msg", msg);
                            url = "index.jsp";
                            RequestDispatcher d = request.getRequestDispatcher(url);
                            d.forward(request, response);
                        }
                        break;
                }

            }
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", url);
        } catch (IOException | ServletException e) {
            throw new IllegalArgumentException(e);
        }

    }

    public String permissaoFuncionario(HttpServletRequest request, Funcionario funcionario, HttpSession session) {
        session = request.getSession(true);
        session.setAttribute("chave_acesso", funcionario.getIdFuncionario());
        session.setAttribute("trabalhador", funcionario);
        session.setAttribute("usuario", funcionario.getNome());
        session.setAttribute("logado", funcionario.getLogin());
        session.setAttribute("permissao", funcionario.getPermissao());
        session.setAttribute("dataAcesso", Calendar.getInstance().getTime());
        String url = "index.jsp";

        switch (funcionario.getPermissao()) {
            case 1:
                url = "controller?operacao=PainelAdministrativo";
                break;
            case 2:
                url = "controller?operacao=PainelAdministrativo";
                break;
            case 3:
                url = "controller?operacao=PainelAdministrativo";
                break;
            case 4:
                url = "controller?operacao=PainelAdministrador";
                break;

        }
        return url;
    }

    public long tempodaSessao(HttpSession session) {
        Long segundos = session.getMaxInactiveInterval()
                - (System.currentTimeMillis() - session.getLastAccessedTime()) / 1000;
        return TimeUnit.SECONDS.toMinutes(segundos);
    }

}
