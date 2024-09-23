
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="ft" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>
    <body id="page-top">
        <%@ include file="../../templete/menu.jsp"%>
        <div id="wrapper">
            <%@ include file="../../templete/menu2.jsp"%>
            <div id="content-wrapper" class="d-flex flex-column">
                <div id="content">
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">
                        <div
                            class="d-sm-flex align-items-center justify-content-between mb-2">
                            <div class="text-dark h4 font-weight-bold">PAINEL DE ACOMPANHAMENTO DAS COMPRAS</div>
                            <a class="btn bg-gradient-light text-primary border text-uppercase"
                               href="controller?operacao=UISacola"><i
                                    class="fas fa-address-card fa-2x"> Criar cartela</i> </a>
                        </div>

                        <div class="row text-uppercase">
                            <div class="col-md-3 my-1">
                                <div class="card text-center">
                                    <div
                                        class="card-header bg-gradient-light  font-weight-bold">Clientes pelo seu endereço:</div>
                                    <div class="card-body">
                                        <%@ include file="form-filtro.jsp"%>
                                    </div>
                                </div>

                            </div>
                            <div class="col-md-6 my-1">
                                <div class="card">
                                    <div
                                        class="card-header bg-gradient-light  font-weight-bold">Dados inseridos da aposta:
                                    </div>
                                    <div class="card-body">
                                        <c:choose>
                                            <c:when test="${not empty compraModificada }">
                                                <div class="table table-responsive">
                                                    <table class="table table-striped border table-hover"
                                                           style="border-collapse: collapse;">
                                                        <thead>
                                                            <tr>
                                                                <th style="border-bottom: solid 1pt;"
                                                                    class="text-uppercase text-primary">Cliente: <c:out
                                                                        value="${compraModificada.pessoa.nome}" />
                                                                </th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td colspan="font-weight-bold"><c:forEach var="c"
                                                                           items="${compraModificada.apostas}">
                                                                        <c:out value="${c.milhar.value}" />
                                                                    </c:forEach></td>
                                                            </tr>

                                                        </tbody>
                                                    </table>
                                                </div>
                                            </c:when>
                                        </c:choose>
                                        <p class="text-center">
                                            <c:choose>
                                                <c:when test="${not empty msg }">
                                                    <strong class="alert alert-success p-1 text-center">
                                                        <i class="fas fa-check"> <c:out value="${msg}" />
                                                        </i>
                                                    </strong>
                                                </c:when>

                                                <c:when test="${not empty valid }">
                                                    <strong class="alert alert-danger p-1 text-center">
                                                        <i class="fas fa-bug"> <c:out value="${valid}" /></i>
                                                    </strong>
                                                </c:when>
                                                <c:otherwise>
                                                    <strong class="alert alert-info p-1 text-center"> <i
                                                            class="fas fa-info"> <c:out
                                                                value="Aguardando informação" /></i>
                                                    </strong>
                                                </c:otherwise>
                                            </c:choose>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 my-1">
                                <div class="card text-center">
                                    <div
                                        class="card-header bg-gradient-light font-weight-bold">
                                        Endereço consultado :</div>
                                    <div class="card-body">
                                        <p class="text-uppercase text-dark h5 font-weight-bold">

                                            <c:out value="${local_filt.descricao}" />
                                        </p>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xl-12 col-lg-7">
                                <div class="card">
                                    <div
                                        class="card-header bg-gradient-light font-weight-bold">PAINEL
                                        DE ACOMPANHAMENTO DAS COMPRAS</div>
                                    <div class="card-body text-uppercase font-weight-bold">
                                        <%@ include file="table-view-loja.jsp"%>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%@ include file="../cartela/compraspessoa.jsp"%>
                </div>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
        <script>
            $('#modaladdlista').on('show.bs.modal', function (event) {
                var botao = $(event.relatedTarget);
                var data_idcompra = botao.data('addlistanumeros');
                var viewdata = $(this);
                viewdata.find('#addidcompra').val(data_idcompra);
            });
        </script>
        <script src="javascript/deletecompra.js" type="text/javascript"></script>
        <script src="javascript/carregarMilhar.js" type="text/javascript"></script>
        <script src="javascript/compra.js" type="text/javascript"></script>
        <script src="javascript/ajustarqtd.js"></script>
        <script src="javascript/ajustarvalor.js"></script>
        
    </body>

</html>
