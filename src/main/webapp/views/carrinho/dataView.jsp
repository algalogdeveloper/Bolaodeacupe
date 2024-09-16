<div class="row">
    <div class="col-md-12">
        <div class="table table-responsive">
            <table class="table table-striped table border">
                <thead class="text-uppercase">
                <th class="col-auto">Nº</th>
                <th class="col-auto">Cliente</th>
                <th class="col-auto">R$ Valor</th>
                <th class="col-auto">R$ Valor Desconto</th>
                <th class="col-auto">Qtd</th>
                <th class="col-auto">Situação</th>
                </thead>
                <tbody>
                    <tr class="font-weight-bold">
                        <td><c:out value="${compra.numero_cartela}"/></td>
                <td><c:out value="${compra.pessoa.nome}"/></td>
                <td><formatador:formatNumber value="${compra.valor}" type="currency"/> </td>
                <td><formatador:formatNumber value="${compra.desconto}" type="currency"/> </td>
                <td><c:out value="${compra.qtd_cartela}"/></td>
                <td>
                <c:choose>
                    <c:when test="${compra.pagou}">
                        <strong class="alert alert-success p-1"><c:out value="Concluido"/></strong>   
                    </c:when>
                    <c:otherwise>
                        <strong class="alert alert-danger p-1"><c:out value="Em Aberto"/></strong> 
                    </c:otherwise>
                </c:choose>
                </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
