<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<nav
    class="navbar navbar-expand-lg navbar-light bg-gradient-light border-bottom-dark font-weight-bold">
    <a class="navbar-brand" href="controller?operacao=IndexController"><img
            alt="" src="img/imgBda.jpeg" width="40"
            class="img-fluid rounded-circle"> Bolão de Acupe </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse text-uppercase"
         id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown active"><a
                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                    role="button" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false"><i class="fa fa-user-clock"></i> CADASTROS </a>
                <div class="dropdown-menu font-weight-bold"
                     aria-labelledby="navbarDropdown">
                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=PessoaController&pessoa=listar"> <i
                            class="fa fa-user"></i> Pessoas
                    </a> <a class="dropdown-item  font-weight-bold"
                            href="controller?operacao=CatalogoFuncionario"><i
                            class="fa fa-user-tag"></i> Funcionário</a> <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=LocalController&locais=listar"><i
                            class="fa fa-map-marker-alt"></i> Endereços</a> 
                    <!--                    <a  class="dropdown-item  font-weight-bold"
                                            href="controller?operacao=CarrinhoController&carrinho=loja"><i
                                                class="fa fa-gamepad"></i> Inserir Talão</a>-->
                    <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=UISacola"><i
                            class="fa fa-shopping-basket"></i> Novo Canhato</a>

                    <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=CentenasGratis"><i
                            class="fa fa-user-check"></i> Associar centena ao cliente</a>
                </div></li>
            <li class="nav-item dropdown active"><a
                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                    role="button" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false"> <i class="fa fa-search"></i> CONSULTAS </a>
                <div class="dropdown-menu font-weight-bold"
                     aria-labelledby="navbarDropdown">
                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=ConsultaRapidaComprasCliente"><i
                            class="fa fa-user-plus"></i> Consulta aposta do cliente por nome e milhar</a> <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=ConsultasController&consulta=compras"><i
                            class="fa fa-shopping-bag"></i> Compras por Endereço</a> <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=FiltrarComprasPorFuncionario"><i
                            class="fa fa-users-cog"></i> Filtar compras por Funcionário</a> 
                    
                    <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=BuscarComprasPorEnderecoFuncionarioLogado"><i
                            class="fa fa-users-cog"></i> Filtar compras por Funcionário logado</a>
                    
                    <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=SelecionarComprasPeloSeuMilhar"><i
                            class="fa fa-sort-numeric-down-alt"></i> Cartelas por milhar</a> <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=DirecionarPaginaExibirComprasRealizadas"><i
                            class="fa fa-users"></i> Apostas realizadas dos clientes</a> <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=PaginasTodasCentenas"> <i
                            class="fa fa-list-ul"></i> Consultar Centena Grátis
                    </a> <a class="dropdown-item  font-weight-bold"
                            href="controller?operacao=PaginasTodasCentenas2"> <i
                            class="fa fa-list-ol"></i> Consultar Centena Gratisinha
                    </a>

                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=BuscarCentenaGratisEnCompraCliente"> <i
                            class="fa fa-list-alt"></i> Consultar Clientes com Centena gratis/Gratisinha
                    </a>

                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=ListarCentenaGratisOrdenado"> <i
                            class="fa fa-list-alt"></i> Centena gratis ordenada
                    </a>

                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=ListarCentenaGratisinhaOrdenado"> <i
                            class="fa fa-list-alt"></i> Centena gratisinha ordenada
                    </a>

                    <a href="controller?operacao=CarregarPaginaReizinho"
                       title="Consultar Compras realizadas Cobradores"
                       class="dropdown-item  font-weight-bold"> <i
                            class="fa fa-people-carry"></i> Consultar Compras realizadas Cobradores
                    </a> 

                    <a href="controller?operacao=ComprasSemClientes"
                       title="Consultar Compras realizadas Cobradores"
                       class="dropdown-item  font-weight-bold"> <i
                            class="fa fa-male"></i> Consultar Clientes sem compras
                    </a> 

                    <a href="controller?operacao=ComprasSemApostas"
                       title="Consultar Compras realizadas Cobradores"
                       class="dropdown-item  font-weight-bold"> <i
                            class="fa fa-shopping-basket"></i> Consultar Compras sem apostas
                    </a> 

                    <a href="controller?operacao=EnviaPageQtdIrregulares"
                       title="Consultar Compras realizadas Cobradores"
                       class="dropdown-item  font-weight-bold"> <i
                            class="fa fa-square-root-alt"></i> Quantidade Irregulares
                    </a> 
                    <a href="controller?operacao=CarregarPageItemCliente"
                       title="Consultar Compras realizadas Cobradores"
                       class="dropdown-item  font-weight-bold"> <i
                            class="fa fa-street-view"></i> Milhar sem Cliente
                    </a> 

                    <a href="controller?operacao=ViewQtdDiferenteValorAposta"
                       title="Consultar Compras realizadas Cobradores"
                       class="dropdown-item  font-weight-bold"> <i
                            class="fa fa-search-dollar"></i> APOSTAS COM OS VALORES DIFERENTE DA QUANTIDADE NO TALAO
                    </a> 

                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=ConsultasController&consulta=ativa">
                        <i class="fa fa-toggle-on"></i> Ativar milhar
                    </a>
                </div></li>
            <li class="nav-item dropdown active"><a
                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                    role="button" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false"><i class="fa fa-dollar-sign"></i> PAGAMENTOS </a>
                <div class="dropdown-menu font-weight-bold"
                     aria-labelledby="navbarDropdown">
                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=PagamentoController"><i
                            class="fa fa-piggy-bank"></i> Realizar cobrança</a> <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=ConsultarPagamentosDoDia"><i
                            class="fa fa-calendar-plus"></i> Vizualizar pagamentos do dia</a> <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=Faturamento"><i
                            class="fa fa-donate"></i> Faturamento</a>
                </div></li>

            <li class="nav-item dropdown active"><a
                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                    role="button" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false"><i class="fa fa-clipboard-list"></i> RELATÓRIOS </a>
                <div class="dropdown-menu font-weight-bold"
                     aria-labelledby="navbarDropdown">

                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=FormFiltroEnderecoParaGerarPdfCompra"><i
                            class="fa fa-file-pdf"></i> Criar PDF com lista em aberto de
                        apostas </a> <a class="dropdown-item  font-weight-bold"
                                    href="controller?operacao=ConsultarCompraQtdValor"><i
                            class="fa fa-sort-amount-up-alt"></i> Consultar apostas por qtd e valor </a> <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=VerificarGanhador"><i
                            class="fa fa-medal"></i> Buscar clientes com milhar prêmiados</a>
                    <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=LimparApostaPremiada"><i
                            class="fa fa-trophy"></i> Buscar cliente com milhar prêmiado</a>
                </div></li>


            <li class="nav-item dropdown active"><a
                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                    role="button" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false"> <i class="fas fa-user-circle"></i> Usuário: <c:out value="${usuario}" />
                </a>
                <div class="dropdown-menu font-weight-bold"
                     aria-labelledby="navbarDropdown">
                    <c:if test="${permissao eq 4}">
                        <a class="dropdown-item  font-weight-bold"  href="controller?operacao=PainelAdministrador">
                            <i class="fa fa-user-secret"> Nome: <c:out value="${usuario}" /></i>  
                        </a> 
                    </c:if>
                    <a class="dropdown-item  font-weight-bold"
                       href="#"> <i
                            class="fa fa-calendar"> Acesso: <fmt:formatDate value="${dataAcesso}" pattern="dd/MM/yyyy" /></i> 

                    </a> <a class="dropdown-item  font-weight-bold"
                            href="controller?operacao=IndexController">
                        <i class="fa fa-power-off" aria-hidden="true"> Sair</i>
                    </a>
                </div></li>


        </ul>

    </div>
</nav>