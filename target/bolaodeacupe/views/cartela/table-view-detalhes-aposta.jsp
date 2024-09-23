<table id="dataTable"
       class="table table-borderless table-hover font-weight-bold text-center">
    <thead>
        <tr class="text-uppercase">
            <th>Milhar</th>
            <th>Disponível</th>
            <th>Alterar</th>

        </tr>
    </thead>
    <tbody>
    <c:forEach var="a" items="${apostas}">
        <tr>
            <td><c:out value="${a.milhar.value}" /></td>
        <td><c:choose>
            <c:when test="${not a.milhar.disponivel}">

                <strong class="alert alert-success p-1"><c:out
                        value="Comprado" /> <i class="fas fa-check"></i> </strong>
            </c:when>
        </c:choose></td>
        <td>
            <a href="" class="btn bg-gradient-light border" data-toggle="modal"
               data-target="#checkModal"
               data-whatevernumero="<c:out value="${a.milhar.value}"/>"
            data-whateveridaposta="<c:out value="${a.idAposta}"/>"
        data-whateveridcompra="<c:out value="${compra.idCompra}"/>"
        data-whatevermilharold="<c:out value="${a.milhar.value}"/>"
        data-whateveridpessoa="<c:out value="${compra.pessoa.idPessoa}"/>">

        <i class="fa fa-pencil-alt"> Editar</i>
    </a> <a
        href="controller?operacao=RemoverApostaClienenteASCascate&idaposta=<c:out value="${a.idAposta}"/>&idpessoa=<c:out value="${compra.pessoa.idPessoa}"/>&idcompra=<c:out value="${compra.idCompra}"/>"
class="btn bg-gradient-light border" onclick="return confirm ('Deseja excluir?')"> <i
    class="fas fa-trash"> Remover</i>
</a></td>
</tr>
</c:forEach>
</tbody>
</table>
