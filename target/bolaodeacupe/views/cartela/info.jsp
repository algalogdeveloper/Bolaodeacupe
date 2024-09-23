<div class="card-deck">
    <div class="card">
        <div class="card-header bg-gradient-light text-uppercase font-weight-bold">Último
            cadastro realizado pelo funcionário:</div>
        <div class="card-body">

            <c:if test="${not empty vendaEnviadaCliente}">
                <div class="table table-responsive">
                    <table class="table table-striped border table-hover font-weight-bold text-uppercase">
                        <thead>
                            <tr>
                                <th>Chave</th>
                                <th>Descrição</th>
                                <th>Qtd</th>
                                <th>Valor</th>
                                <th>Números</th>
                                <th>Situação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="text-success">
                                <td><c:out value="${vendaEnviadaCliente. numero_cartela}" /></td>
                        <td class="text-uppercase"><c:out
                            value="${vendaEnviadaCliente.pessoa.nome}" /> <c:out
                            value="${vendaEnviadaCliente.pessoa.local.descricao}" />
                        </td>
                        <td><c:out value="${vendaEnviadaCliente.qtd_cartela}" /> </td>

                        <td><fmt:formatNumber value="${vendaEnviadaCliente.valor}"
                                              type="currency" /></td>

                        <c:choose>
                            <c:when test="${not empty vendaEnviadaCliente.apostas}">
                                <td> 
                                <c:forEach var="v" items="${vendaEnviadaCliente.apostas}">
                                    <c:out value="${v.milhar.value }" />
                                </c:forEach>
                                </td>
                            </c:when>
                        </c:choose>
                        <td>
                        <c:if test="${not vendaEnviadaCliente.pagou}">
                            <strong class="text-danger"> <c:out
                                    value="Em aberto" /></strong>
                        </c:if>

                        <c:if test="${vendaEnviadaCliente.pagou}">
                            <strong class="text-success"> <c:out
                                    value="Concluido" /></strong>
                        </c:if>

                        </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </c:if>

            <footer class="blockquote-footer text-info">
                Obs: <cite title="Source Title ">Observe se as informações
                    estão corretas!</cite>
            </footer>

        </div>
    </div>

    <div class="card">
        <div
            class="card-header bg-gradient-light text-uppercase font-weight-bold">Últimas
            Informações:</div>
        <div class="card-body">
            <table class="table table-striped border table-hover">
                <thead>
                <th>Preencha a sequência desejada de acordo com quantidade de bilhete do talão do cliente.
                </th>
                </thead>
                <tbody>
                    <tr>
                        <td>
                <c:if test="${not empty msg }">
                    <p
                        class="card-text text-center alert alert-success text-uppercase font-weight-bold">
                        <i class="fas fa-check"> <c:out value="${msg}" /></i>
                    </p>
                </c:if>
                <p class="card-text">
                <c:if test="${not empty valid}">
                    <p class="alert alert-danger font-weight-bold text-center">
                        <i class="fas fa-bug"> <c:out value="${valid}" /></i>
                    </p>
                </c:if>
                </p>
                </td>
                </tr>
                </tbody>
            </table>



        </div>
    </div>
</div>