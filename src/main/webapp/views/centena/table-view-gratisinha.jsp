<% int i =1;%>

<div class="row text-uppercase">
	<c:if test="${not empty gratisinha}">
		<c:forEach var="c" items="${gratisinha}">
			<div class="col-md-auto mb-1">
				<div class="card text-center" >
				<div class="card-header bg-gradient-light text-uppercase font-weight-bold">Descrição</div>
					<div class="card-body">
                                            <div class="card border-left-primary bg-gradient-light font-weight-bolder">
						<h5 class="card-title font-weight-bold text-dark">Posição: <%=i++%> <c:out value="º prêmio" /></h5>
						<h6 class="card-subtitle mb-2  text-dark font-weight-bolder">Cliente: <c:out value="${c.compra.pessoa.nome}" /></h6>
                                                <h6 class="card-subtitle mb-2  text-dark font-weight-bolder">Local: <c:out value="${c.compra.pessoa.local.descricao}" /></h6>
						<p class="text-dark text-uppercase text-primary">Centena: <c:out value="${c.numero}" /></p>
                                            </div>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>
	
</div>
