
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>

    <body id="page-top ">
        <%@ include file="../../templete/menu.jsp"%>
        <div id="container-fluid">
            <%@ include file="../../templete/menu2.jsp"%>
            <div id="content-wrapper" class="d-flex flex-column">
                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <p class="h1 text-center text-primary text-uppercase font-weight-bold">Buscar
                        cliente(s) com milhar prêmiados
                    </p>
                    <script type="text/javascript">
                        function add() {
                            var milhar = document.getElementById("milhar").value;
                            if (milhar.length === 4) {
                                carregar(milhar);
                                document.getElementById("milhar").focus();
                            }
                            milhar.focus();
                        }
                        function carregar(milhar) {
                            var url = "controller?operacao=CarregarMilharPremiado&milhar="
                                    + milhar;
                            location.href = url;
                        }
                    </script>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <%@ include file="card-numerico.jsp"%>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="card-body">
                                <div class="table table-responsive border">
                                    <div class="row">
                                        <%@ include file="card-primado.jsp"%>
                                    </div>
                                        <c:if test="${not empty apostas}">
                                    <a href="controller?operacao=LimparApostaPremiada"
                                       class="btn btn-danger font-weight-bold text-danger bg-gradient-light border-primary text-uppercase">
                                        Limpar aposta</a>
                                        </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row container-fluid">
                        <div class="col-md-12 my-1">
                            <div class="card">
                                <p
                                    class="card-header bg-gradient-light text-uppercase font-weight-bold">Centenas
                                    Grátis</p>
                                <div class="card-body">
                                    <div class="table table-responsive">
                                        <%@ include file="../centena/table-view-gratis.jsp"%>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12 my-1">
                            <div class="card">
                                <p
                                    class="card-header bg-gradient-light text-uppercase font-weight-bold">Centenas
                                    Gratisinha</p>
                                <div class="card-body">
                                    <div class="table table-responsive">
                                        <%@ include file="../centena/table-view-gratisinha.jsp"%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/habilitar.js" type="text/javascript"></script>
    </body>

</html>
