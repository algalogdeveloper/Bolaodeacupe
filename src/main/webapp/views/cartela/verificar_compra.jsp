
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>

    <body id="page-top">
        <%@ include file="../../templete/menu.jsp"%>

        <div id="wrapper">
            <%@ include file="../../templete/menu2.jsp"%>
            <div id="content-wrapper" class="d-flex flex-column">

                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">
                        <div class="row mb-1">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header bg-gradient-light font-weight-bold text-uppercase">A��es</div>
                                    <div class="card-body">
                                        <h1
                                            class="text-center font-weight-bold text-uppercase text-dark">Detalhes
                                            da compra</h1>
                                        <p class="text-center font-weight-bold h6 text-primary text-uppercase">
                                            <c:out value=" N� Tal�o: ${compra.numero_cartela}" />
                                        </p>
                                        <p class="text-center font-weight-bold h6 text-primary text-uppercase">
                                            <c:out value="Nome: ${compra.pessoa.nome}" />

                                        </p>
                                        <div class="row">
                                            <section class="col-md-12 text-center">
                                                <div class="btn-group" role="group" aria-label="Basic example">
                                                    <a class="btn bg-gradient-light border"
                                                       href="controller?operacao=UISacola"><i
                                                            class="fa fa-address-card"> Novo Canhoto</i></a> <a
                                                                class="btn bg-gradient-light border"
                                                        href="controller?operacao=ConsultasController&consulta=compras"><i
                                                            class="fa fa-shopping-bag"> Apostas</i></a> <a
                                                                class="btn bg-gradient-light border" data-toggle="modal"
                                                                data-target="#milharUnico" href=""><i class="fas fa-balance-scale"> Novo Milhar</i></a>								
                                                </div>
                                            </section>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header bg-gradient-light font-weight-bold ">PAINEL
                                        DE MILHAR COMPRADAS</div>
                                    <div class="card-body">
                                        <c:if test="${not empty info}">
                                            <p class="text-center alert alert-danger font-weight-bold text-uppercase">
                                                <c:out value="${info}" />
                                            </p>
                                        </c:if>
                                        <c:if test="${not empty message}">
                                            <p class="text-center alert alert-success font-weight-bold text-uppercase">
                                                <c:out value="${message}" />
                                            </p>
                                        </c:if>

                                        <div class="table-responsive">
                                            <%@ include file="table-view-detalhes-aposta.jsp"%>
                                        </div>

                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
        <%@ include file="../cartela/AdicionarUmMilhar.jsp"%>
        <%@ include file="../cartela/check.jsp"%>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/carregarMilhar.js" type="text/javascript"></script>
    </body>
</html>