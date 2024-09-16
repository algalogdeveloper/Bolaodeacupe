<table
	class="table table-striped table-hover font-weight-bold text-center text-uppercase"
	style="border-collapse: collapse;" id="dataTable">
	<thead>
		<tr style="border-bottom: outset; border-width: 1pt;">
			<th scope="col">Posi��o</th>
			<th scope="col">Pessoa</th>
			<th scope="col">Endere�o</th>
			<th scope="col">Milhar</th>
			<th scope="col">Pagou</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty compras}">
			<c:forEach var="c" items="${compras}">
				<tr>
					<th scope="row"><c:out value="${c.posicao}� pr�mio" /></th>
					<td><c:out value="${c.pessoa}" /></td>
					<td><c:out value="${c.endereco}" /></td>
					<td><c:out value="${c.milhar}" /></td>
					<td><c:choose>
							<c:when test="${c.pagou eq 'Sim' }">
								<strong class="p-2 aler alert-success">Sim</strong>
							</c:when>
							<c:otherwise>
								<strong class="p-1 aler alert-danger">N�o</strong>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>