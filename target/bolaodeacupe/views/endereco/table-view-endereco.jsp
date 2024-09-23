<table
	class="table table-hover table-striped text-uppercase font-weight-bold"
	id="dataTable">
	<caption>Lista de Endere�os</caption>
	<thead>

		<tr>
			<th>#ID</th>
			<th>Descri��o</th>
			<th>Cidade</th>
			<th class="text-center">A��es</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="e" items="${enderecos}">
			<tr>
				<td><c:out value="${e.idLocal}" /></td>
				<td><c:out value="${e.descricao}" /></td>
				<td><c:out value="${e.cidade}" /></td>
				<td class="text-center">
					<div class="btn-group" role="group" aria-label="Basic example">

						<a href="#" data-toggle="modal" data-target="#localModal"
							data-whateverid="<c:out value="${e.idLocal}"/>"
							data-whateveredescricao="<c:out value="${e.descricao}" />"
							data-whateverecidade="<c:out value="${e.cidade}"/>"
							class="btn bg-gradient-primary text-white"> <i class="fas fa-pencil-alt"></i>
						</a> <a onclick="return confirm('Deseja excluir informa��o?')"
							href="controller?operacao=LocalController&locais=excluir&codlocal=<c:out value="${e.idLocal}"/>"
							class="btn bg-gradient-danger text-white"><i class="fas fa-trash-alt"></i> </a>
					</div>
				</td>
			</tr>
		</c:forEach>

	</tbody>
</table>