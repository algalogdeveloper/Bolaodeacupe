package org.logcod.lojajogos.controller.subcontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.config.util.Informacoes;
import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.MilharService;
import org.logcod.lojajogos.service.PessoaService;

public class CarrinhoController implements InvokeSubControllers {

    String url = "index.jsp";
    protected LocalService sl = new LocalService();
    protected CompraService sc = new CompraService();
    protected PessoaService ps = new PessoaService();
    protected ConsultasService cs = new ConsultasService();
    protected ApostaService as = new ApostaService();
    protected MilharService ms = new MilharService();
    protected Compra compra;
    protected FuncionarioService fs = new FuncionarioService();
    protected HttpSession session;
    int guardarIdLocal = 0;

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {

        try {
            String menu = request.getParameter("carrinho");
            String logado = (String) request.getSession().getAttribute("logado");
            @SuppressWarnings("unchecked")
            List<Milhar> products = (ArrayList<Milhar>) request.getSession().getAttribute("meuCarrinho");
            session = request.getSession(true);
            int permisao = (Integer) request.getSession().getAttribute("permissao");
            if (Objects.nonNull(menu) && Objects.nonNull(logado)) {
                switch (menu) {
                    case "loja":
                        if (permisao == 1 || permisao == 3 || permisao == 2) {
                            url = lojaProdutosDisponivel(request);
                        } else {
                            request.setAttribute("msg", "Você não tem permissão filho!");
                            url = "controller?operacao=PainelAdministrativo";
                        }
                        break;
                    case "agregar":
                        url = agregarElementos(session, request, products);
                        break;
                    case "sequencia":
                        url = dobroDeElementos(session, products, request);
                        break;
                    case "trocar":
                        url = trocarMilhardoCarrinho(session,request, products);
                        break;
                    case "compra":
                        url = cadastrarCartela(session, request, products, response);
                        break;
                    case "pessoa":
                        url = pegarElementosdoFormulario(request);
                        break;
                    case "apagarcompra":
                        url = apagarCompra(request);
                        break;
                    case "cartelas":
                        url = cartelasCompradas(request);
                        break;
                    case "alterar":
                        url = alterarMilharPessoa(request);
                        System.out.println(url);
                        break;
                    case "Limpar":
                        url = limparCarrinho(products);
                        break;
                }
            } else {
                url = "index.jsp";
            }
            request.setAttribute("qtd_numero", products.size());
            return url;
        } catch (Exception e) {
            System.out.println("sessão: " + e.getCause());
            return url;
        }

    }

    private String limparCarrinho(List<Milhar> products) {
        products.clear();
        return "controller?operacao=CarrinhoController&carrinho=loja";
    }

    private String alterarMilharPessoa(javax.servlet.http.HttpServletRequest request) {
        try {
            int idcompra = Integer.parseInt(request.getParameter("idcompra"));
            int idaposta = Integer.parseInt(request.getParameter("idaposta"));
            int idpessoa = Integer.parseInt(request.getParameter("idpessoa"));
            String oldMilhar = request.getParameter("milhar_old");
            Milhar novoMilhar = ms.getJogo(request.getParameter("milhar01"));
            if (idaposta > 0) {
                if (Objects.nonNull(novoMilhar)) {
                    if (!Objects.equals(novoMilhar.getValue(), oldMilhar)) {
                        Aposta aposta = as.get(idaposta, idcompra);
                        if (Objects.nonNull(aposta)) {
                            sc.alterarMilharPessoa(aposta, novoMilhar.getIdMilhar());
                            ms.getNaoDisponivel(novoMilhar.getIdMilhar());
                            ms.getDisponivel(oldMilhar);
                            request.setAttribute("message",
                                    "Milhar foi modificado com sucesso: " + novoMilhar.getValue());
                        }

                    } else {
                        request.setAttribute("info", "Milhar são iguais");
                    }
                } else {
                    request.setAttribute("info", "Milhar não esta disponível");
                }
            } else {
                if (Objects.nonNull(novoMilhar)) {
                    Aposta aposta = new Aposta();
                    compra = sc.get(idcompra);
                    aposta.setCompra(compra);
                    aposta.setMilhar(novoMilhar);
                    ms.getNaoDisponivel(novoMilhar.getIdMilhar());
                    as.save(aposta);
                    request.setAttribute("message", "Milhar cadastrado com sucesso:" + novoMilhar.getValue());
                } else {
                    request.setAttribute("info", "Milhar não esta disponível!");
                }
            }
            return "controller?operacao=CarrinhoController&carrinho=cartelas&idcompra=" + idcompra + "&idpessoa="
                    + idpessoa + "";
        } catch (Exception e) {
            request.setAttribute("info", "Milhar não esta disponível");
            return "controller?operacao=CarrinhoController&carrinho=cartelas";

        }

    }

    private String cartelasCompradas(javax.servlet.http.HttpServletRequest request) {
        try {
            int idcompra = Integer.parseInt(request.getParameter("idcompra"));
            int idpessoa = Integer.parseInt(request.getParameter("idpessoa"));
            Collection<Aposta> apostas = cs.detalhesAposta(idcompra);
            Compra compra = sc.getPessoa(idcompra, idpessoa);
            request.setAttribute("apostas", apostas);
            request.setAttribute("compra", compra);
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        return "views/cartela/verificar_compra.jsp";
    }

    private String apagarCompra(javax.servlet.http.HttpServletRequest request) {

        try {
            int id = Integer.valueOf(request.getParameter("idcompra"));
            Compra compra = sc.get(id);
            System.out.println("Solicitação de exclusão de compra: ");
            if (!sc.verificarSeCompraEstaPaga(id)) {

                if (Objects.nonNull(compra)) {
                    guardarIdLocal = compra.getPessoa().getLocal().getIdLocal();
                    sc.removerCompras(id);
                    System.out.println("Compra removida...");
                    request.setAttribute("msg", " Cartela vinculada a " + compra.getPessoa().getNome().toLowerCase()
                            + " foi excluida com sucesso");
                } else {
                    request.setAttribute("msg", " Cartela já foi excluida");

                }

            } else {
                request.setAttribute("msg", " Cartela vinculada a " + compra.getPessoa().getNome().toLowerCase()
                        + " está paga não pode ser excluida");
                guardarIdLocal = compra.getPessoa().getLocal().getIdLocal();

            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return "controller?operacao=ConsultasController&consulta=compras&buscar=" + guardarIdLocal;

    }

    private String pegarElementosdoFormulario(HttpServletRequest request) {
        String msg = "";
        String valid = "";
        int idCompra = Integer.parseInt(request.getParameter("idcompra"));
        int idPessoa = Integer.parseInt(request.getParameter("idpessoa"));
        try {
            Milhar m1 = ms.getJogo(request.getParameter("milhar01"));
            Milhar m2 = ms.getJogo(request.getParameter("milhar02"));
            Milhar m3 = ms.getJogo(request.getParameter("milhar03"));
            Milhar m4 = ms.getJogo(request.getParameter("milhar04"));
            Milhar m5 = ms.getJogo(request.getParameter("milhar05"));
            double valor = Double.parseDouble(request.getParameter("valor"));
            List<Milhar> elementos = new ArrayList<Milhar>();
            elementos = Arrays.asList(m1,m2,m3,m4,m5);
            int qtd = 0;
            qtd = elementos.size() / 5;
            if (elementos.size() == 5 && !elementos.isEmpty()) {
                if (sc.inserirMilharParaPessoa(idCompra, idPessoa, elementos)) {
                    Compra compraModificada = sc.obterCompra(idCompra);
                    sc.modificarQtd(idCompra, qtd, (qtd * valor));
                    msg = "Numeros inseridos com sucesso!";
                    request.setAttribute("compraModificada", compraModificada);
                    elementos.clear();
                } else {
                    valid = "Existe numeros repitidos ou lista está vazia!";
                }

            } else {
                valid = "Pode existir milhar repitido na lista.";
            }
            request.setAttribute("msg", msg);
            request.setAttribute("valid", valid);
        } catch (Exception e) {
        
        }
        Compra retornaCompra = sc.obterCompra(idCompra);
        return "controller?operacao=ConsultasController&consulta=compras&buscar="
                + retornaCompra.getPessoa().getLocal().getIdLocal();
    }

    public String cadastrarCartela(HttpSession session, HttpServletRequest request, List<Milhar> elementos,
            HttpServletResponse response) {
        try {
            String info = "";
            String valid = "";
            if (elementos.isEmpty()) {
                request.setAttribute("valid", "Preencha o formulário com os milhar.");
            } else {
                if (elementos.size() % Integer.parseInt(request.getParameter("qtd_cartela")) == 0) {
                    Pessoa pessoa = criarPessoa(request, elementos);
                    session.setAttribute("endereco", pessoa.getLocal());
                    compra = sc.obterCompraPorClientePorMilharReferencia(pessoa.getReferencia());
                    if (Objects.isNull(compra)) {
                        compra = this.enviandoDadosDoCliente(compra, request, pessoa, elementos);
                        Compra minhaVenda = sc.save(compra, elementos);
                        request.setAttribute("vendaEnviadaCliente", minhaVenda);
                        info = "As informações da cartela contendo as apostas de " + compra.getPessoa().getNome()
                                + " foram cadastrada com sucesso! ";
                    } else {
                        valid = "As informações da aposta não forão enviadas.\n Por causa do milhar = " + compra.getNumero_cartela()
                                + " \nApague a cartela ou modifique o milhar que está como referência do cliente! "
                                + "\nCaso erro continue contate ao desenvolvedor do sistema.";
                        ps.delete(pessoa.getIdPessoa());
                    }
                } else {
                    valid = "A quantidade de milhar informada não corresponde ao talão. Corrija ";
                }
                criarSessaoDadosTalao(request, Integer.valueOf(request.getParameter("qtd_cartela")));
                request.setAttribute("msg", info);
                request.setAttribute("valid", valid);
            }
            elementos.clear();
            session.setAttribute("meuCarrinho", elementos);
            return "controller?operacao=CarrinhoController&carrinho=loja";
        } catch (Exception e) {
            request.setAttribute("valid",
                    "Pode ser erro no servidor.\n  Se não cadastrou!\n Tente novamente cadastrar: " + e);
            return "controller?operacao=CarrinhoController&carrinho=loja";
        }

    }

    protected void invalidSession() {
        session.invalidate();
    }

    public Pessoa criarPessoa(HttpServletRequest request, List<Milhar> numeros) {
        try {
            String nome = request.getParameter("nome");
            Integer id = Integer.valueOf(request.getParameter("idLocal"));
            Local local = sl.get(id);
            Pessoa pessoa = ps.referenciaCartela(numeros.get(0).getValue());
            Informacoes.SOP(pessoa);
            if (Objects.isNull(pessoa)) {
                pessoa = new Pessoa();
                pessoa.setNome(nome);
                pessoa.setContato(numeros.get(0).getValue());
                pessoa.setReferencia(numeros.get(0).getValue());
                pessoa.setLocal(local);
                pessoa = ps.save(pessoa);
                Informacoes.SOP(pessoa);
            } else {
                request.setAttribute("valid", "Esta pessoa já esta cadastrada");
            }
            return pessoa;
        } catch (Exception e) {
            return null;
        }

    }

    public double calcularValorCompra(double valor, int size, int qtdCartelas) {
        try {
            return valor * (size / qtdCartelas);
        } catch (Exception e) {
            return 0;
        }

    }

    public void criarSessaoDadosTalao(HttpServletRequest request, Integer qtd_cartela) {
        session.setAttribute("premio", request.getParameter("premio"));
        session.setAttribute("qtd_cartela", qtd_cartela);
        session.setAttribute("valor", request.getParameter("valor"));

    }

    public Compra enviandoDadosDoCliente(Compra venda, HttpServletRequest request, Pessoa pessoa, List sequencia_numeros) {

        try {
            venda = new Compra();
            int qtd_cartela = pegarQuantidade(request.getParameter("qtd_cartela"));
            venda.setPessoa(pessoa);
            Funcionario funcionarioLogado = fs
                    .getFuncionario((Integer) request.getSession().getAttribute("chave_acesso"));
            venda.setFuncionario(funcionarioLogado);
            venda.setPagou(false);
            venda.setDesconto(Double.parseDouble(request.getParameter("desconto")));
            venda.setValor(calcularValorCompra(DataSourceUtil.configDataDoubleValue(request.getParameter("valor")),
                    sequencia_numeros.size(), qtd_cartela));
            venda.setNumero_cartela(pessoa.getContato());
            venda.setQtdAlternativa(qtd_cartela);
            venda.setPremio(request.getParameter("premio"));
            venda.setValorBilhete(DataSourceUtil.configDataDoubleValue(request.getParameter("valor")));
            venda.setQtd_cartela(sequencia_numeros.size() / qtd_cartela);
            venda.setPagou(situacao(request.getParameter("situacao")));
            request.setAttribute("msg", "Você vendeu " + sequencia_numeros.size() / qtd_cartela + " bilhete para "
                    + pessoa.getNome() + " na data " + DataSourceUtil.formatarDataViewCalendar(Calendar.getInstance()));
            return venda;
        } catch (Exception e) {
            return venda;
        }

    }

    public boolean situacao(String pagou) {
        boolean pg = false;
        try {
            if (pagou.equalsIgnoreCase("sim")) {
                pg = true;
            }
            return pg;
        } catch (Exception e) {
            return pg;
        }
    }

    public Integer pegarQuantidade(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            System.out.println("Erro: " + e.getLocalizedMessage());
            return 0;
            // TODO: handle exception
        }
    }

    public String meuCarrinhoView(HttpServletRequest request) {
        request.setAttribute("locais", sl.getLocals());
        return "views/carrinho/carrinho.jsp";
    }

    public List<Milhar> agregarElemento(HttpServletRequest request) {
        List<Milhar> milhars = new ArrayList<>();
        milhars.clear();
        try {
            Milhar milhar01 = ms.getJogo(request.getParameter("milhar01"));
            Milhar milhar02 = ms.getJogo(request.getParameter("milhar02"));
            Milhar milhar03 = ms.getJogo(request.getParameter("milhar03"));
            Milhar milhar04 = ms.getJogo(request.getParameter("milhar04"));
            Milhar milhar05 = ms.getJogo(request.getParameter("milhar05"));
            milhars = Arrays.asList(milhar01, milhar02, milhar03, milhar04, milhar05);
            return milhars;
        } catch (Exception e) {
            return milhars;
        }

    }

    @SuppressWarnings("unchecked")
    public String agregarElementos(HttpSession session, HttpServletRequest request, List<Milhar> products) {
        List<Milhar> elementos = agregarElemento(request);
        try {
            products = (ArrayList<Milhar>) request.getSession().getAttribute("meuCarrinho");
            if (elementos.size() == 5) {
                products = carregandoCarrinho(products, elementos);
                session = request.getSession(true);
                session.setAttribute("meuCarrinho", products);
                  request.setAttribute("msg", " A sequência com " + products.size()
                        + " numeros está completa siga para o preenchimento do formulario. ");
            
            } else {
                request.setAttribute("valid", "Existe milhar indisponível na sequência!");
            }

        } catch (Exception e) {
            request.setAttribute("valid", "Existe milhar indisponível na sequência!");
        }

        return "controller?operacao=CarrinhoController&carrinho=loja";

    }

    public List<Milhar> dobroDeElemento(HttpServletRequest request) {

        Milhar m1 = ms.getJogo(request.getParameter("milhar01"));
        Milhar m2 = ms.getJogo(request.getParameter("milhar02"));
        Milhar m3 = ms.getJogo(request.getParameter("milhar03"));
        Milhar m4 = ms.getJogo(request.getParameter("milhar04"));
        Milhar m5 = ms.getJogo(request.getParameter("milhar05"));
        Milhar m6 = ms.getJogo(request.getParameter("milhar06"));
        Milhar m7 = ms.getJogo(request.getParameter("milhar07"));
        Milhar m8 = ms.getJogo(request.getParameter("milhar08"));
        Milhar m9 = ms.getJogo(request.getParameter("milhar09"));
        Milhar m10 = ms.getJogo(request.getParameter("milhar10"));
        List<Milhar> dobroElementos = new ArrayList<>();
        dobroElementos.clear();
        dobroElementos = Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10);
        return dobroElementos;
    }

    public String dobroDeElementos(HttpSession session, List<Milhar> products, HttpServletRequest request) {
        try {

            List<Milhar> elementos = dobroDeElemento(request);
            if (elementos.size() == 10) {
                products = carregandoCarrinho(products, elementos);
                session = request.getSession(true);
                session.setAttribute("meuCarrinho", products);
                request.setAttribute("msg", " A sequência com " + products.size()
                        + " numeros está completa siga para o preenchimento do formulario. ");
            } else {
                request.setAttribute("valid", "Existe milhar indisponível na sequência!");
            }
            return "controller?operacao=CarrinhoController&carrinho=loja";

        } catch (Exception e) {
            request.setAttribute("valid", "Existe milhar indisponível na sequência!");
            System.out.println(e.getLocalizedMessage());
            return "controller?operacao=CarrinhoController&carrinho=loja";
        }
    }

    public String descarrengandoCarrinho(HttpServletRequest request, List<Milhar> jogos) {
        String value = ms.getJogo(request.getParameter("idJogo")).getValue();
        jogos.remove(posicao(ms.getJogo(value), jogos));
        return "controller?operacao=CarrinhoController&carrinho=loja";
    }

    public String trocarMilhardoCarrinho(HttpSession session, HttpServletRequest request, List<Milhar> jogos) {
        try {
            Milhar milharOld = ms.getJogo(request.getParameter("milharold"));
            Milhar milharNovo = ms.getJogo(request.getParameter("nvmilhar"));
            jogos = (ArrayList<Milhar>) session.getAttribute("meuCarrinho");
            if (Objects.nonNull(milharOld) && Objects.nonNull(milharNovo)) {
                for (Milhar j : jogos) {
                    if (validarIgual(j.getValue(), milharOld.getValue())) {
                        j.setIdMilhar(milharNovo.getIdMilhar());
                        j.setValue(milharNovo.getValue());
                        break;
                    }
                   
                }             
            } else {
                request.setAttribute("valid", "Milhar não está disponível ");
            }

        } catch (Exception e) {
            request.setAttribute("valid", "Milhar não está disponível ");

        }
        for (Milhar jogo : jogos) {
            System.out.println("Nº:"+jogo.getValue());
        }
        return "controller?operacao=CarrinhoController&carrinho=loja";
    }

    public List<Milhar> carregandoCarrinho(List<Milhar> products, Milhar jogo) {
        if (Objects.isNull(products)) {
            products = new ArrayList<>();
        }

        if (seNãoExiste(jogo.getValue(), products) && !Objects.equals(jogo.getValue(), "")
                && jogo.getValue().length() == 4) {
            products.add(jogo);
        }

        return products;
    }

    public List<Milhar> carregandoCarrinho(List<Milhar> products, Collection<Milhar> carrinho) {

        if (Objects.isNull(products)) {
            products = new ArrayList<>();
            products.clear();
        }
        for (Milhar action : carrinho) {
            if (seNãoExiste(action.getValue(), products)) {
                products.add(action);
            }
        }

        return products;
    }

    private static boolean validarIgual(String value, String value2) {
        return Objects.equals(value, value2);
    }

    public int posicao(Milhar milhar, List<Milhar> jogos) {
        int pos = -1;
        for (int i = 0; i < jogos.size(); i++) {
            Milhar jogo = jogos.get(i);
            if (validarIgual(jogo.getValue(), milhar.getValue())) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    private boolean seNãoExiste(String value, List<Milhar> jogos) {
        boolean validate = false;
        for (Milhar jogo : jogos) {
            if (validarIgual(value, jogo.getValue())) {
                validate = true;
            }
        }
        if (validate) {
            System.out.println("Existe o numero");
        }
        return !validate;
    }

    private String lojaProdutosDisponivel(HttpServletRequest request) {
        try {
            request.setAttribute("enderecos", sl.getLocals());
            request.setAttribute("compras", cs.selecioneCartelasVendidasNoDia());
            System.out.println(sl.getLocals());
            System.out.println(cs.selecioneCartelasVendidasNoDia());
        } catch (Exception e) {
            System.err.println("Erro:" + e);

        }
        return "views/cartela/compras.jsp";

    }

}
