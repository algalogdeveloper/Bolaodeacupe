<table class="table table-striped table-hover text-center text-uppercase" id="dataTable">
    <thead class="font-weight-bold">
        <tr >
            <th scope="col">#</th>
            <th scope="col">Nome</th>
            <th scope="col">Contato</th>
            <th scope="col">E-mail</th>
            <th scope="col">Login</th>
            <th scope="col">Permiss�o</th>
            <th scope="col">A��es</th>
        </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${not empty funcionarios}">
            <c:forEach var="f" items="${funcionarios}">
                <tr>
                    <th scope="row"><c:out value="${f.idFuncionario }" /></th>
                <td><c:out value="${f.nome }" /></td>
                <td><c:out value="${f.contato }" /></td>
                <c:choose>
                    <c:when test="${not empty f.email}">
                        <td><c:out value="${f.email }" /></td>
                    </c:when>
                    <c:otherwise>
                        <td>N�o existe e-mail</td>
                    </c:otherwise>
                </c:choose>

                <td><c:out value="${f.login }" /></td>
                <td><c:choose>
                    <c:when test="${ f.permissao == 1}">
                        A��es de Baixas
                    </c:when>
                    <c:when test="${ f.permissao == 2}">
                        A��es de Consultas
                    </c:when>
                    <c:when test="${ f.permissao == 3}">
                        A��es de Acomponhamentos
                    </c:when>
                    <c:when test="${ f.permissao == 4}">
                        Administrador Sistema
                    </c:when>

                    <c:otherwise>Cargo n�o existe</c:otherwise>
                </c:choose></td>
                <td>
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <a href="#" class="btn btn-primary" 
                           data-toggle="modal" data-target="#modalFuncionario"
                           data-whateverid="<c:out value="${f.idFuncionario}"/>"
                        data-whatevernome="<c:out value="${f.nome}"/>"
                        data-whatevercontato="<c:out value="${f.contato}"/>"
                        data-whateverpermissao="<c:out value="${f.permissao}"/>"
                        data-whateverlogin="<c:out value="${f.login}"/>"
                        data-whateveremail="<c:out value="${f.email}"/>"
                        > <i
                            class="fas fa-edit"></i>
                    </a> <a href="#" class="btn btn-danger"> <i
                        class="fas fa-trash-alt"></i>
                </a>

            </div>
        </td>
        </tr>
    </c:forEach>

</c:when>
<c:otherwise>
    <tr>
        <th scope="row" colspan="4">N�o existe registros</th>
    </tr>
</c:otherwise>
</c:choose>
</tbody>
</table>