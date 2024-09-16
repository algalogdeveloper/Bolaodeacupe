<div class="card border-primary">
	<div class="card-header bg-primary text-white text-uppercase">Compras com quantidade acima</div>
	<div class="card-body">
		
		<table class="table table-borderless text-center text-uppercase" style="border-collapse: collapse;">
			<caption>
				Total de apostas:
				<c:out value="${qtdacima}" />
			</caption>
			<thead>
				<tr style="border-bottom: solid 1pt; border-color: blue;">
					<th scope="col">#</th>
					<th scope="col">Cliente</th>
					<th scope="col">Qtd. talão</th>
					<th scope="col">Qtd. inserida</th>
					<th scope="col">Valor</th>
					<th scope="col">Endereço</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty compras5}">
						<c:forEach items="${compras5}" var="c">
							<tr>
								<th scope="row"><c:out value="${c.idCompra}" /></th>
								<td><c:out value="${c.pessoa.nome}" /></td>
								<td><c:out value="${c.qtd_cartela}" /></td>
								<td><c:out value="${c.qtdAlternativa}" /></td>
								<td><c:out value="${c.valor}" /></td>
								<td><c:out value="${c.premio}" /></td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>