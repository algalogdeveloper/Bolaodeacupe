

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>
    <body id="page-top">

        <%@ include file="../../templete/menu.jsp"%>
        <div id="wrapper">
            <div id="content-wrapper" class="d-flex flex-column">
                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">
                        <h1>Clientes com centenas gratis ou gratisinha</h1>
                        <div class="table table-responsive">
                            <table class="table bg-gradient-light table-hover border font-weight-bolder" id="dataTable">
                                <thead>
                                    <tr >
                                        <th>Nº Canhoto</th>
                                        <th>Cliente</th>
                                        <th>Endereco</th>
                                        <th>Aposta</th>
                                        <th>Centenas:[Gratis]</th>
                                        <th>Centenas:[Gratisinha]</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-light">
                                    <c:forEach var="c" items="${model.compras}">
                                        <tr>
                                            <td><c:out value="${c.numero_cartela}"/></td>
                                            <td><c:out value="${c.pessoa.nome}"/></td>
                                            <td><c:out value="${c.pessoa.local.descricao}"/></td>
                                            <td><c:out value="${c.apostas}"/></td>
                                            <td><c:out value="${c.todasCentenasGratis}"/></td>
                                            <td><c:out value="${c.todasCentenasGratisinha}"/></td>
                                        </tr>

                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
    </body>
</html>
