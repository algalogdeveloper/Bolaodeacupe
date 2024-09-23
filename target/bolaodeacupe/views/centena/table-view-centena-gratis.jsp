<table class="table table-striped table-hover text-center text-uppercase"
       id="dataTable">
    <thead class="bg-gradient-light">
        <tr>
            <th scope="col">#Id</th>
            <th scope="col">Pessoa</th>
            <th scope="col">Endereco</th>
            <th scope="col">Centena</th>
            <th scope="col">A��es</th>

        </tr>
    </thead>
    <tbody>
    <c:if test="${not empty gratis}">
        <c:forEach var="c" items="${gratis}">
            <tr>
                <th scope="row"><c:out value="${c.idCentena}" /></th>
            <td><c:out value="${c.compra.pessoa.nome}" /></td>
            <td><c:out value="${c.compra.pessoa.local.descricao}" /></td>
            <td><c:out value="${c.numero}" /></td>
            <th class="text-center">
                <div class="btn-group" role="group" aria-label="Basic example">

                    <a href="#" class="btn bg-gradient-light border"
                       data-toggle="modal" 
                       data-target="#edit_form_centena"
                       data-whatevereid="<c:out value="${c.idCentena}"/>"
                       data-whatevercentena="<c:out value="${c.numero}"/>">
                       <i class="fas fa-pencil-alt"></i></a> 					
                    <a href="controller?operacao=DeleteCentena&id=<c:out value="${c.idCentena}"/>" onclick="return confirm('Delete centena agora')" class="btn bg-gradient-light border"><i class="fas fa-trash-alt"></i></a>
                </div>
            </th>
            </tr>
        </c:forEach>
    </c:if>

</tbody>
</table>
<%@ include file="dialog-form-edit.jsp" %>