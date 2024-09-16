<div class="table table-responsive font-weight-bold">
	<table class="table table-striped border table-hover text-uppercase"
		id="dataTable">
		<caption>
			<strong class="text-primary font-weight-bold"> Lista de
				cobran�a: <c:out value="${local.descricao}" />
			</strong>
		</caption>
		<thead>
			<tr style="">
				<td>Realizar cobran�a</td>
				<td>A��es</td>
			</tr>
		</thead>

		<c:forEach var="c" items="${compras}">
			<tr style="border-bottom-style: solid;">
				<td><c:out value="${c.numero_cartela}" /> - <c:out
						value="${c.pessoa.nome}" /> - <f:formatNumber value="${c.valor}"
						type="currency" /></td>
				<td>
					<div class="btn-group" role="group" aria-label="Basic example">
                                            <a class="btn bg-gradient-light border"
							<%--  href="controller?operacao=DebitaCompraPessoa&acao=<c:out value="${c.idCompra}"/>"   --%>
						href="#"
							onclick="obterCompra(<c:out value="${c.idCompra}"/>)"> <i
							class="fas fa-donate fa-1x"> Efetivar Pagamento</i>
						</a> <a class="btn bg-gradient-light border" href="#" title="Pagamento parcial"
							data-toggle="modal" data-target="#pgParcial"
							data-whatevereidcompra="<c:out value="${c.idCompra}"/>"
							data-whatevereidpessoa="<c:out value="${c.pessoa.idPessoa}"/>"
							data-whateverepessoa="<c:out value="${c.pessoa.nome}"/>"><i
							class="fas fa-funnel-dollar fa-1x"> Debitar valor</i></a>
					</div>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty compras}">
			<tr>
				<td colspan="5">N�o existe compras</td>
			</tr>
		</c:if>

	</table>
</div>

