<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
                <nav
                    class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                    <%@ include file="../../templete/filtro.jsp"%>
                </nav>
                <div class="container-fluid">
                    <div class="row my-2">
                        <div class="col-md-12 my-1">
                            <div class="card">
                                <div
                                    class="card-header font-weight-bold bg-gradient-light  h6 text-uppercase">Todos milhar sem clientes</div>
                                <div class="card-body">
                                    <%
                                    int qtdpage = (int) request.getAttribute("qtdpage");
                                    int pagina = (int) request.getAttribute("page");
                                    int qtddata = (int) request.getAttribute("qtddata");
                                    int limite = (int) request.getAttribute("limite");
                                    int cor=0;
                                    %>
                                    <p class="font-weight-bolder">
                                        Total pagina:<%=qtdpage%>
                                        Registros:
                                        <%=qtddata%>
                                        limite:<%=limite%>
                                    </p>
                                    <nav aria-label="...">

                                        <ul class="pagination pagination-sm m-1 font-weight-bolder">
                                            
                                            <li class="page-item m-1"><a class="page-link bg-gradient-light rounded-circle"
                                                                         href="controller?operacao=CarregarPageItemCliente&data=<c:out value="${anterior}"/>"
                                                                         aria-label="Previous"> <span aria-hidden="true"><i class="fa fa-arrow-left"></i></span>
                                                </a>
                                            </li>
                                                                         <%
                                                 for (int i = 1; i <= qtdpage; i++) {
                                                        if (pagina == i) {
                                                %>
                                            <li class="page-item active m-1" aria-current="page"><span
                                                    class="page-link rounded-circle"> <%=i%>
                                                </span></li>
                                                <%
                                                } else if (i <= limite) {
                                                %>
                                            <li class="page-item m-1 "><a class="page-link rounded-circle "
                                                                          href="controller?operacao=CarregarPageItemCliente&data=<%=i%>"><%=i%></a></li>
                                                <%
                                                }
                                                %>

                                            <%}%>
                                            <li class="page-item m-1"><a class="page-link bg-gradient-light rounded-circle"
                                                                         href="controller?operacao=CarregarPageItemCliente&data=<c:out value="${proxima}"/>"
                                                                         aria-label="Next"> <span aria-hidden="true"><i class="fa fa-arrow-right"></i></span>
                                                </a></li>
                                        </ul>
                                    </nav>

                                    
                                    <div class="row">
                                        <c:choose>
                                            <c:when test="${not empty apostas}">
                                                <c:forEach var="a" items="${apostas}">
                                                    
                                                    <div class="col-md-1 bg-light mb-1 border-left-primary border-bottom-primary text-center">
                                                        <strong class="card-subtitle text-uppercase text-primary border-bottom-primary">Disponível</strong>
                                                        <p class="card-text h5 font-weight-bolder text-primary text-dark"><c:out value="${a.milhar.value }" /></p>
                                                    </div>
                                                   
                                                </c:forEach>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                    <p class="font-weight-bolder">
                                        Total pagina:<%=qtdpage%>
                                        Registros:
                                        <%=qtddata%>
                                        limite:<%=limite%>
                                    </p>
                                    <nav aria-label="...">

                                        <ul class="pagination pagination-sm m-1 font-weight-bolder">
                                            <li class="page-item m-1"><a class="page-link bg-gradient-light rounded-circle"
                                                                         href="controller?operacao=CarregarPageItemCliente&data=<c:out value="${anterior}"/>"
                                                                         aria-label="Previous"> <span aria-hidden="true"><i class="fa fa-arrow-left"></i></span>
                                                </a> <%
                                                 for (int i = 1; i <= qtdpage; i++) {
                                                        if (pagina == i) {
                                                %>
                                            <li class="page-item active m-1" aria-current="page"><span
                                                    class="page-link rounded-circle"> <%=i%>
                                                </span></li>
                                                <%
                                                } else if (i <= limite) {
                                                %>
                                            <li class="page-item m-1 "><a class="page-link rounded-circle "
                                                                          href="controller?operacao=CarregarPageItemCliente&data=<%=i%>"><%=i%></a></li>
                                                <%
                                                }
                                                %>

                                            <%}%>
                                            <li class="page-item m-1"><a class="page-link bg-gradient-light rounded-circle"
                                                                         href="controller?operacao=CarregarPageItemCliente&data=<c:out value="${proxima}"/>"
                                                                         aria-label="Next"> <span aria-hidden="true"><i class="fa fa-arrow-right"></i></span>
                                                </a></li>
                                        </ul>
                                    </nav>


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