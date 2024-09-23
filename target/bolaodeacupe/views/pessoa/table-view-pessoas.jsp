<table
	class="table table-hover table-striped text-uppercase font-weight-bold"
	id="dataTable">
	<caption class="text-primary">
		<c:out value="Quantidade de tal�es: ${qtdtalao}" />
	</caption>
	<thead>
		<tr class="text-primary">
			<th>Id</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Contato</th>
			<th>Refer�ncia</th>
			<th>Endere�o</th>
			<th>Data Registro</th>
			<th>A��ES</th>
		</tr>
	</thead>
	<tfoot>
		<tr>

			<th>Id</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Contato</th>
			<th>Referencia</th>
			<th>Endere�o</th>
			<th>Data Registro</th>
			<th>A��ES</th>
		</tr>
	</tfoot>
	<tbody>
		<c:if test="${not empty pessoas}">

			<c:forEach var="p" items="${pessoas}">
				<tr>
					<td><c:out value="${p.idPessoa}" /></td>
					<td><c:out value="${p.nome}" /></td>
					<td><c:choose>
							<c:when test="${not empty p.email}">
								<c:out value="${p.email}" />
							</c:when>
							<c:otherwise>
								<c:out value="Atualize as informa��es" />
							</c:otherwise>
						</c:choose></td>
					<td><c:out value="${p.contato}" /></td>
					<td><c:choose>
							<c:when test="${not empty p.referencia}">
								<c:out value="${p.referencia}" />
							</c:when>
							<c:otherwise>
								<c:out value="Atualize as informa��es" />
							</c:otherwise>
						</c:choose></td>
					<th><c:out value="${p.local.descricao}" /></th>
					<th><fmt:formatDate value="${p.dataRegistro.time}"
							pattern="dd/MM/yyyy" /></th>

					<td>
						<div class="btn-group" role="group" aria-label="Basic example">

							<a class="btn bg-gradient-primary text-white" href="#" data-toggle="modal"
								data-target="#modalDiscount"
								data-whateverid="<c:out value="${p.idPessoa}"/>"
								data-whatevernome="<c:out value="${p.nome}" />"
								data-whateveremail="<c:out value="${p.email}"/>"
								data-whateverecontato="<c:out value="${p.contato}"/>"
								data-whateverlocal="<c:out value="${p.local.idLocal}"/>"
								data-whateverreferencia="<c:out value="${p.referencia}"/>"><i
								class="fas fa-pencil-alt"></i></a> <a
								onclick="return confirm ('Deseja excluir a pessoa?')"
								class="btn bg-gradient-danger text-white"
								href="controller?operacao=PessoaController&pessoa=remove&codpessoa=<c:out value="${p.idPessoa}"/>"><i
								class="fas fa-trash-alt"></i></a>
						</div>


					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>