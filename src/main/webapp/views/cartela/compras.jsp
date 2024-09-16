    
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
                        <div class="row">
                            <div class="col-md-9">
                                <h4 class="text-primary font-weight-bold text-uppercase">Solicitação
                                    de envio das apostas dos clientes</h4>
                            </div>
                            <div class="col-md-3">
                                <a class="btn bg-gradient-light font-weight-bold text-uppercase border"
                                   href="controller?operacao=ImprimirPDFCadastradosHoje"><i
                                        class="fas fa-calendar-day"> Gerar pdf com apostas de hoje </i></a>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <c:choose>
                                    <c:when test="${not empty msg}">
                                        <%@ include file="info.jsp"%>
                                    </c:when>
                                    <c:when test="${not empty valid}">
                                        <%@ include file="info.jsp"%>
                                    </c:when>
                                </c:choose>

                                <div class="row my-1">
                                    <div class="col-md-4 ">
                                        <%@ include file="sequencia-01.jsp"%>
                                    </div>
                                    <div class="col-md-8">
                                        <%@ include file="sequencia-02.jsp"%>
                                    </div>
                                </div>
                                <c:choose>
                                    <c:when test="${not empty meuCarrinho}">
                                        <div class="row my-1">
                                            <div class="col-md-12">
                                                <div class="card">
                                                    <h5
                                                        class="card-header bg-gradient-light font-weight-bold text-uppercase">
                                                        Carrinho do cliente com <c:out value="${qtd_numero} numeros" /> </h5>
                                                    <div class="card-body">
                                                        <%@ include file="carrinho.jsp"%>
                                                    </div>
                                                    <div class="card-footer">
                                                        <a class="btn btn-danger font-weight-bold" href="controller?operacao=CarrinhoController&carrinho=Limpar"><i class="fas fa-broom"> Limpar Carrinho</i> </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>

                            </div>
                        </div>
                        <%@ include file="formulario-cartela-pessoa.jsp"%>
                    </div>

                </div>
            </div>
            <%@ include file="../cartela/compraspessoa.jsp"%>
        </div>
        <%@include file="../pessoa/modal.jsp"%>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/atualizarpessoa.js" type="text/javascript"></script>
        <script src="javascript/agregar.js" type="text/javascript"></script>
        <script src="javascript/carrinhoremove.js" type="text/javascript"></script>
        <script src="javascript/compra.js" type="text/javascript"></script>
        <script src="javascript/carregarMilhar.js" type="text/javascript"></script>
        <script src="javascript/deletecompra.js" type="text/javascript"></script>

        <script>
            $('#trocar_numero_cliente').on('show.bs.modal', function (event) {
                var pegar = $(event.relatedTarget);
                var oldm = pegar.data('writeroldmilhar');
                var view = $(this);
                view.find('#msg_old').text('Numero para troca: ' + oldm);
                view.find('#oldnumero').val(oldm);
                $("#nvmilhar").focus();

            });

        </script>

        <script>
            $(document).ready(function () {
                $('#milharseq1').focus();
            });
            
        </script>
    </body>
</html>

