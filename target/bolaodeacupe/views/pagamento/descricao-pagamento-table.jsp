<table
	class="table table-striped table-hover border text-center text-uppercase text-center"
	style="border-collapse: collapse;">
	<thead>
            <tr class="text-dark border-bottom-secondary">
                <th class="col-1">Chave#</th>
			<th>Descrição</th>
			<th>R$ Valor</th>
			<th>Situação</th>
		</tr>
	</thead>
	<c:if test="${not empty meuPagamento }">
		<tbody>
                    <tr class="text-success font-weight-bolder">
                        <td class="col-1"><c:out value="${meuPagamento. numero_cartela}" /></td>
				<td class=""><c:out value="${meuPagamento.pessoa.nome}" /> - <c:out
						value="${meuPagamento.pessoa.local.descricao}" /></td>
				<td><f:formatNumber value="${meuPagamento.valor}"
						type="currency" /></td>
				<td><c:if test="${meuPagamento.pagou}">
						<c:out value="Pagamento efetivado" />
					</c:if> <c:if test="${not meuPagamento.pagou}">
						<strong style="color: red;"><c:out value="Em aberto" /></strong>
					</c:if></td>
			</tr>
		</tbody>
	</c:if>
</table>