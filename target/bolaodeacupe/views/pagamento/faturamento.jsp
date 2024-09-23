<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>

    <body id="page-top">
        <%@ include file="../../templete/menu.jsp"%>
        <div id="wrapper bg-gradient-light">
            <%@ include file="../../templete/menu2.jsp"%>
            <div id="content-wrapper " class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">
                        <div class="card-group text-center text-uppercase font-weight-bold">
                            <div class="card">
                                <div class="card-header border-bottom-light bg-gradient-light">
                                    TOTAL DE CARTELAS COBRADAS
                                </div>
                                <div class="card-body">

                                    <p class="card-text">
                                    <fieldset class="text-center">
                                        <legend>Análise:</legend>
                                        <c:forEach var="f" items="${faturamento}">
                                            <p class="card-title  text-success">
                                                Clientes :
                                                <c:out value="${f.qtdPessoas} " />
                                            </p>
                                            <p class="card-text  text-success">
                                                Valor arrecadado:
                                                <f:formatNumber value="${f.valor}" type="currency" />
                                            </p>
                                            <p class="card-text  text-success">
                                                Quantidade de Talão :
                                                <c:out value="${f.qtdCartelas} " />
                                            </p>
                                        </c:forEach>
                                    </fieldset>
                                    </p>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header border-bottom-light bg-gradient-light">
                                    TOTAL DE CARTELAS PARA COBRAR
                                </div>
                                <div class="card-body text-center">

                                    <fieldset class="text-center">
                                        <legend>Análise:</legend>
                                        <c:forEach var="f" items="${notfaturamento}">
                                            <p class="card-title  text-danger">
                                                Clientes :
                                                <c:out value="${f.qtdPessoas} " />
                                            </p>
                                            <p class="card-text text-danger">
                                                Valor para receber:
                                                <f:formatNumber value="${f.valor}" type="currency" />
                                            </p>
                                            <p class="card-text  text-danger">
                                                Quantidade de talão :
                                                <c:out value="${f.qtdCartelas} " />
                                            </p>
                                        </c:forEach>
                                    </fieldset>
                                </div>
                            </div>
                        </div>
                        <div class="row my-1 text-dark text-uppercase font-weight-bold">
                            <div class="col-md-12">

                                <div class="card mb-4 text-center">
                                    <div class="card-header border-bottom-light bg-gradient-light">ANALISE
                                        GERAL</div>
                                    <div class="card-body">
                                        <table class="table table-borderless table-hover ">
                                            <c:forEach var="f" items="${faturamentoGeral}">
                                                <tr>
                                                    <th class="row text-primary font-weight-bold">Clientes:</th>
                                                    <td><c:out value=" ${f.qtdPessoas}" /></td>

                                                </tr>
                                                <tr>
                                                    <td class="row  text-primary font-weight-bold">Valor
                                                        total para receber:</td>
                                                    <td><f:formatNumber value=" ${f.valor}" type="currency" />
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="row text-primary font-weight-bold">Quantidade
                                                        de Talão:</td>
                                                    <td><c:out value=" ${f.qtdCartelas}" /></td>

                                                </tr>
                                            </c:forEach>
                                        </table>
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
