

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <%@include file="templete/aparencia.jsp" %>
    <body>
        <br>
        <div id="content-wrapper" class="d-flex flex-column text-uppercase">
           
            <div class="container">
                <div class="card">
                    <div class="card-header bg-gradient-light font-weight-bolder">Mensagem</div>
                    <div class="card-body">
                        <div class="card-title font-weight-bold">Notificação:</div>
                        <p class="alert alert-danger p-1 font-weight-bolder"><c:out value="${notificar}"/></p>
                    </div>
                </div>
            </div>
        </div>
        <h1 style="color: red;"></h1>
        <%@include file="../../templete/scripts.jsp"%>
    </body>
</html>
