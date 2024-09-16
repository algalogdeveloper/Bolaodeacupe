<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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

                <nav
                    class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                    <%@ include file="../../templete/filtro.jsp"%>
                </nav>
                <div class="container-fluid">


                    <div class="row my-2">

                        <div class="col-md-12 my-1">

                            <div class="card">
                                <div
                                    class="card-header bg-gradient-light font-weight-bolder text-uppercase">Descrição de apostas com quantidade de milhar abaixo do talão</div>
                                <div class="card-body">
                                    <c:choose>
                                        <c:when test="${not empty comprasAbaixo}">

                                            <table class="table table-striped table-hover font-weight-bolder border" id="dataTable">
                                                <thead>
                                                    <tr class="bg-gradient-light text-uppercase">
                                                        <th scope="col">ID</th>
                                                        <th scope="col">Cliente</th>
                                                        <th scope="col">Qtd. talão</th>
                                                        <th scope="col">Qtd. inserida</th>
                                                        <th scope="col">Valor</th>
                                                        <th scope="col">Endereço</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="c" items="${comprasAbaixo}">
                                                        <tr>
                                                            <th scope="row"><c:out value="${c.idCompra}" /></th>
                                                            <td><c:out value="${c.pessoa.nome}" /></td>
                                                            <td><c:out value="${c.qtd_cartela}" /></td>
                                                            <td><c:out value="${c.qtdAlternativa}" /></td>
                                                            <td><fmt:formatNumber value="${c.valor}" type="currency" /></td>
                                                            <td><c:out value="${c.premio}" /></td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="alert alert-info text-center text-uppercase font-weight-bolder">Apostas não encontradas</div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12 mb-2">
                            <div class="card">
                                <div class="card-header bg-gradient-light font-weight-bolder text-uppercase">Descrição de apostas com quantidade de milhar abaixo do talão</div>
                                <div class="card-body">
                                    <c:choose>
                                        <c:when test="${not empty comprasAcima}">
                                            <table class="table table-striped font-weight-bolder table-hover text-uppercase" id="dataTable">
                                                <thead>
                                                    <tr class="bg-gradient-light">
                                                        <th scope="col">ID</th>
                                                        <th scope="col">Cliente</th>
                                                        <th scope="col">Endereço</th>
                                                        <th scope="col">Qtd. talão</th>
                                                        <th scope="col">Qtd. inserida</th>
                                                        <th scope="col">Valor</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="c" items="${comprasAcima}">
                                                        <tr>
                                                            <th scope="row"><c:out value="${c.idCompra}" /></th>
                                                            <td><c:out value="${c.pessoa.nome}" /></td>
                                                            <td><c:out value="${c.premio}" /></td>
                                                            <td><c:out value="${c.qtd_cartela}" /></td>
                                                            <td><c:out value="${c.qtdAlternativa}" /></td>
                                                            <td><fmt:formatNumber value="${c.valor}" type="currency" /></td>


                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="alert alert-info text-center text-uppercase font-weight-bolder">Apostas não encontradas</div>
                                        </c:otherwise>
                                    </c:choose>

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