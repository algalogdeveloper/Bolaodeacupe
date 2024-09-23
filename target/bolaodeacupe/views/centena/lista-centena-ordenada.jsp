
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
                        <div
                            class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800 text-uppercase">Todas centenas ordenada.</h1>
                        </div>

                        <div class="row mr-md-2">
                            <div class="col-xl-12 col-lg-7">
                                <div class="card shadow ">
                                    <div class="card-body">

                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="card border ">
                                                    <div class="card-header bg-gradient-light  text-uppercase font-weight-bold">Centenas
                                                        </div>
                                                    <div class="card-body">
                                                        <c:choose>
                                                            <c:when test="${not empty msg}">
                                                                <p class="alert alert-primary p-1 h3 text-center" role="alert">
                                                                    <c:out value="${msg}" />
                                                                </p>
                                                            </c:when>
                                                        </c:choose>
                                                        <div class="table table-responsive">
                                                            <table class="table table-bordered bg-gradient-light font-weight-bolder table-hover text-center text-uppercase"
                                                                   >
                                                                <thead class="border-bottom-light">
                                                                    <tr>
                                                                        <th scope="col-md-1">#Id</th>
                                                                        <th scope="col">Cliente</th>
                                                                        <th scope="col">Endereço</th>
                                                                        <th scope="col">Números do cliente</th>
                                                                        <th scope="col">Centena</th>

                                                                    </tr>
                                                                </thead>
                                                                <tbody class="bg-white">
                                                                    <c:if test="${not empty centenas}">
                                                                        <c:forEach var="c" items="${centenas}">
                                                                            <tr>
                                                                                <th scope="row"><c:out value="${c.idCentena}" /></th>
                                                                                <td><c:out value="${c.compra.pessoa.nome}" /></td>
                                                                                <td><c:out value="${c.compra.pessoa.local.descricao}" /></td>
                                                                                <td><c:out value="${c.compra.apostas}" /></td>    
                                                                                <td><c:out value="${c.numero}" /></td>                                                                                
                                                                            </tr>
                                                                        </c:forEach>
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
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/modificar-centena-gratis.js"
        type="text/javascript"></script>

        <script src="javascript/pgparcial.js" type="text/javascript"></script>
        <script src="javascript/atualizarpessoa.js" type="text/javascript"></script>
        <script src="javascript/agregar.js" type="text/javascript"></script>
        <script src="javascript/carrinhoremove.js" type="text/javascript"></script>
        <script src="javascript/compra.js" type="text/javascript"></script>
        <script src="javascript/carregarMilhar.js" type="text/javascript"></script>
        <script src="javascript/deletecompra.js" type="text/javascript"></script>
    </body>
</html>