
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="ft" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>
    <body id="page-top">
        <%@ include file="../../templete/menu.jsp"%>

        <div id="wrapper bg-gradient-light">
            <%@ include file="../../templete/menu2.jsp"%>
            <div id="content-wrapper" class="d-flex flex-column text-uppercase">
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                <div id="justify-content-center">
                    
                    <br>
                    <h4 class=" text-dark text-center text-uppercase font-weight-bold  text-primary">
                        PLATAFORMA BOLÃO DE ACUPE - GESTÃO DE RIFAS <c:choose>
                        <c:when test="${not empty msg}">
                                <span class="alert alert-danger text-center p-1 mr-3 text-center">
                                    <i class="fas fa-exclamation-circle fa-1x"> <c:out
                                            value="${msg}" /></i>
                                </span>
                                                   </c:when>
                    </c:choose>
                    </h4>

                           

                    <%@include file="acaocadastros.jsp" %>
                    <%@include file="acaoconsultas.jsp" %>
                    <%@include file="acaopagamentos.jsp" %>
                    <%@include file="acaorelatorios.jsp" %>
                </div>

            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/deletelocal.js" type="text/javascript"></script>
        <script src="javascript/atualizarlocal.js"></script>

    </body>

</html>
