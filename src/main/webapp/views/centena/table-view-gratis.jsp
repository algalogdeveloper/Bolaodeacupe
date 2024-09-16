
<div class="row text-uppercase">
    <%
        int j = 1;
    %>
    <c:if test="${not empty gratis}">
        <c:forEach var="c" items="${gratis}">
            <div class="col-md-auto">
                <div class="card  text-center">
                    <div class="card-header bg-gradient-light text-uppercase font-weight-bolder">Descrição</div>
                    <div class="card-body">
                        <div class="card border-left-primary rounded font-weight-bolder">
                            <div class="card-body bg-gradient-light">
                                <p class="card-title font-weight-bold text-dark">Posição: <%=j++%> <c:out value="º prêmio" /></p>
                                <p class="card-subtitle text-dark">Cliente: <c:out value="${c.compra.pessoa.nome}" /></p>
                                <p class="card-subtitle text-dark">Local: <c:out value="${c.compra.pessoa.local.descricao}" /></p>
                                <p class="text-dark h5 text-uppercase">Centena: <c:out value="${c.numero}" /></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>	
</div>


