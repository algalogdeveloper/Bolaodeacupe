
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>
    <body id="page-top">
        <%@ include file="../../templete/menu.jsp"%>
        <div id="wrapper">
            <%@ include file="../../templete/menu2.jsp"%>
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">
                        <div
                            class="d-sm-flex align-items-center justify-content-between mb-2">
                            <h1 class="h3 mb-0  font-weight-bold text-primary">VIZUALIZAR
                                PAGAMENTOS DO DIA</h1>
                        </div>
                        <div class="row py-1">
                            <div class="col-xl-12 col-lg-7">
                                <div class="card font-weight-bold">
                                    <!-- Card Header - Dropdown -->
                                    <div class="card-header bg-gradient-light text-uppercase">A��es</div>
                                    <div class="card-body">
                                        <div class="btn-group" role="group" aria-label="Basic example">

                                            <a class="btn bg-gradient-light border font-weight-bold"
                                               href="controller?operacao=CarrinhoController&carrinho=loja">
                                                <i class="fas fa-address-book"> NOVO TAL�O</i>
                                            </a> <a class="btn bg-gradient-light border font-weight-bold"
                                                    href="controller?operacao=CriandoPDFPagamentoDataAtual">
                                                <i class="fas fa-file-pdf"> EXIBIR PDF PAGAMENTOS</i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xl-12 col-lg-7">
                                <div class="card font-weight-bold">
                                    <!-- Card Header - Dropdown -->
                                    <div class="card-header bg-gradient-light text-uppercase">Pagamentos
                                        efetivado hoje</div>
                                    <div class="card-body">
                                        <div class="row">
                                            <strong class="mr-1 alert alert-warning">Obs: Por
                                                motivo de seguran�a o desenvolvedor do sistema vai criar uma
                                                copi� do arquivo tamb�m por causa de eventuais problemas.</strong>
                                            <div class="col-xl-12 col-lg-4">
                                                <div class="table-responsive">
                                                    <table
                                                        class="table table-hover table-borderless font-weight-bold text-uppercase"
                                                        id="dataTable">
                                                        <thead>
                                                            <tr class="text-uppercase bg-gradient-light">
                                                                <td class="col-1">Id</td>
                                                                <td>Pessoa</td>
                                                                <td>Situa��o</td>
                                                                <td>N�meros dos clientes</td>
                                                            </tr>
                                                        </thead>

                                                       
                                                        <tbody>
                                                            <c:forEach var="c" items="${compras}">
                                                                <tr style="border-bottom-style: solid;">
                                                                    <td><c:out value="N� ${c.idCompra}" /></td>
                                                                    <td><c:out value="N� talao ${c.numero_cartela}" /> - <c:out
                                                                            value="${c.pessoa.nome}" /> - <f:formatNumber
                                                                            value="${c.valor}" type="currency" /></td>

                                                                    <td><c:if test="${c.pagou}">
                                                                            <i class="fas fa-check alert alert-success"> <c:out
                                                                                    value="PAGAMENTO CONCLUIDO" />
                                                                            </i>
                                                                        </c:if></td>
                                                                    <td><c:forEach var="a" items="${c.apostas }">
                                                                            <strong class="text-primary"><c:out
                                                                                    value="${a.milhar.value}" /></strong>
                                                                        </c:forEach></td>
                                                                </tr>
                                                            </c:forEach>
                                                            <c:if test="${empty compras}">
                                                                <tr>
                                                                    <td colspan="5">N�o existe compras</td>
                                                                </tr>
                                                            </c:if>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>

                                        </div>

                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                    <%@ include file="modal-detalhes-pagamento.jsp"%>
                </div>

                <%@include file="../../templete/scripts.jsp"%>

                <script src="javascript/habilitar.js" type="text/javascript"></script>
                </body>

                </html>
