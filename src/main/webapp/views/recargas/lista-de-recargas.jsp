

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">

        <title>Área do Administrador</title>
    </head>
    <body>



        <div class="container">
            <a href="controller?operacao=areaadmin" class="btm btn-link">Acessa Admin</a>
            <div class="card">
                <div class="card-header">
                    Listar as datas das recargas
                </div>
                <div class="card-body">
                    <h5 class="card-title">Catalogo</h5>
                    <c:if test="${not empty recargas}">
                    <table class="table table-striped border">
                        <thead>
                            <tr>
                                <th scope="col">Codigo</th>
                                <th scope="col">Descrição</th>
                                <th scope="col">Data de Lançamento</th>
                                <th scope="col">R$ Valor</th>
                                <th scope="col">Ações</th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            <c:forEach var="r" items="${recargas}">
                                <tr>
                                    <th scope="row"><c:out value="${r.idRecarga}"/></th>
                                    <td><c:out value="${r.descricao}"/></td>
                                    <td>
                                        <fmt:parseDate value="${r.dataRecarga}" pattern="yyyy-MM-dd" var="parsedDateTime" type="both" />
                                        <fmt:formatDate pattern="dd-MM-yyyy" value="${parsedDateTime}" />
                                    </td>
                                    <td> <fmt:formatNumber value="${r.valor}" type="currency"/></td>
                                    <td>
                                        <div class="btn-group" role="group" aria-label="Basic example">
                                            <button type="button" class="btn btn-primary fw-bold" data-bs-toggle="modal" 
                                                    data-bs-target="#exampleModal" 
                                                    data-bs-idrecarga="<c:out value="${r.idRecarga}"/>"
                                                    data-bs-descricao="<c:out value="${r.descricao}"/>"
                                                    data-bs-datarecarga="<c:out value="${r.dataRecarga}"/>">Editar</button>
                                            <button type="button" class="btn btn-danger fw-bold">Remover</button>

                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    </c:if>
                </div>
            </div>
        </div>

        <%@include file="modal-edit-recarga.jsp" %>
        <script>
            var exampleModal = document.getElementById('exampleModal')
            exampleModal.addEventListener('show.bs.modal', function (event) {
                var button = event.relatedTarget
                var id = button.getAttribute('data-bs-idrecarga');
                var datarecarga = button.getAttribute('data-bs-datarecarga');
                var descricao = button.getAttribute('data-bs-descricao');
                var modalTitle = exampleModal.querySelector('.modal-title')
                var modalBodyInput = exampleModal.querySelector('#data-recarga')
                var modalBodyArea = exampleModal.querySelector('#message-text')
                var modalBodyId = exampleModal.querySelector('#idrecarga');
                modalTitle.textContent = 'Editando data da recarga: ' + datarecarga;
                modalBodyInput.value = datarecarga;
                modalBodyArea.value = descricao;
                modalBodyId.value = id;
            })

        </script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    </body>

</html>
