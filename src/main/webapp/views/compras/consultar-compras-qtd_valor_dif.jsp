<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<%@ include file="../../templete/aparencia.jsp"%>
<body>
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

                        <div class="col-md-12">
                            <div class="card font-weight-bold">
                                <p class="card-header bg-gradient-light font-weight-bold text-uppercase">Aposta com valores diferente da quantidade de talao </p>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-hover table-striped text-uppercase" id="dataTable">
                                            <caption class="text-warning">

                                                <c:choose>
                                                    <c:when test="${not empty message}">
                                                        <div class="alert alert-primary"><c:out value="${message}" /></div>
                                                    </c:when>                                               
                                                    <c:otherwise>
                                                        Valor Promoçoes, descontos e debitados: <fmt:formatNumber value="${valorperdido}" type="currency" />
                                                        .   </c:otherwise>
                                                </c:choose>
                                            </caption>
                                            <thead>
                                                <tr>
                                                    <th scope="col-1">Id</th>
                                                    <th scope="col">Nome do cliente</th>
                                                    <th scope="col">Data registro</th>
                                                    <th scope="col">Endereço do cliente</th>
                                                    <th scope="col">R$ Valor</th>
                                                    <th scope="col">Qtd</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:choose>
                                                    <c:when test="${not empty compras }">
                                                        <c:forEach var="c" items="${compras}">
                                                            <tr>
                                                                <th scope="row"><c:out value="${c.pessoa.idPessoa}" /></th>
                                                                <td><c:out value="${c.pessoa.nome}" /></td>
                                                                <td><fmt:formatDate value="${c.pessoa.dataRegistro.time}"/></td>
                                                                <td><c:out value="${c.pessoa.local.descricao}" /></td>
                                                                <td><fmt:formatNumber value="${c.valor}" type="currency" /> </td>
                                                                <td><c:out value="${c.qtd_cartela}" /></td>
                                                            </tr>
                                                        </c:forEach>
                                                    </c:when>
                                                </c:choose>
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
    <%@include file="../../templete/scripts.jsp"%>

</body>
</html>