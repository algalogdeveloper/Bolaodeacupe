

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib  prefix="formatador" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>
    <body>
        <%@ include file="../../templete/menu.jsp"%>
        <div id="content ">
            <nav
                class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                <%@ include file="../../templete/filtro.jsp"%>
            </nav>
            <div class="container-fluid">
                <c:if test="${carregado > 0}">
                    <div class="card mb-1">
                        <div class="card-header bg-gradient-light font-weight-bolder">Loja do cliente</div>
                        <div class="card-body">
                            <h5 class="card-title font-weight-bold text-uppercase">Loja do cliente: <c:if test="${not empty carregado}"> <c:out value="${carregado} milhar(s)"/> </c:if></h5>
                            <%@include file="cart.jsp" %>
                        </div>
                        <div class="card-footer">
                            <a href="controller?operacao=UIClearSacola" class="btn mb-2 btn-link border-bottom-danger text-danger font-weight-bold"><i class="fa fa-shopping-bag"> Limpar minha sacola </i></a>
                        </div>
                    </div>

                </c:if>
                
                <%@include file="message.jsp" %>
                <c:choose>
                    <c:when test="${not empty compra}">
                        <%@include file="dataView.jsp" %>
                    </c:when>
                </c:choose>
                <script>
                    var numero = document.getElementById("numero");
                    numero.addEventListener('input', function () {
                        if (numero.value.length === 4) {
                            window.location.href = 'controller?operacao=UICarrinho&mc=' + numero.value;
                        }
                    });
                    numero.focus();
                </script>
                
                <%@include file="forms.jsp" %>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>

    </body>
</html>
