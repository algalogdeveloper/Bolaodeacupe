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
                                <p class="card-header bg-gradient-light font-weight-bold text-uppercase">Apostas
                                    sem clientes</p>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-hover table-striped text-uppercase" id="dataTable">
                                            <caption>
                                                
                                                <c:choose>
                                                    <c:when test="${not empty message}">
                                                        <div class="alert alert-primary"><c:out value="${message}" /></div>
                                                    </c:when>
                                               
                                                    <c:otherwise>
                                                        Lista de clientes sem apostas.
                                                    </c:otherwise>
                                                </c:choose>
                                            </caption>
                                            <thead>
                                                <tr>
                                                    <th scope="col-1">Id</th>
                                                    <th scope="col">Nome do cliente</th>
                                                    <th scope="col">Data registro</th>
                                                    <th scope="col">Endereço do cliente</th>
                                                    <th scope="col-1">Açao</th>
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
                                                                <td><a href="controller?operacao=RemoverCliente&remover=<c:out value="${c.pessoa.idPessoa}"/>" class="btn bg-gradient-light border" onclick="return confirm('Deseja excluir: <c:out value="${c.pessoa.nome}" />')" ><i class="fas fa-trash"> Remover</i></a></td>
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