<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="../templete/aparencia.jsp"%>
    <body id="page-top">
        <%@ include file="../templete/menu.jsp"%>

        <div id="wrapper bg-gradient-light">
            <%@ include file="../templete/menu2.jsp"%>
            <div id="content-wrapper" class="d-flex flex-column">
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                    <%@ include file="../templete/filtro.jsp"%>
                </nav>
                <div class="container-fluid">

                    <a href="controller?operacao=HabilitarVendas" class="btn bg-gradient-light font-weight-bold border" onclick="return confirm('Deseja resetar todas as apostas!')">Resetar Todas as Apostas</a>

                    <a href="controller?operacao=areaadmin" class="btn bg-gradient-light font-weight-bold border" >Antigo Painel</a>

                    <div id="justify-content-center m-1">
                        <div class="card">
                            <div class="card-header bg-gradient-light font-weight-bold">Gerenciar recargas da plataforma</div>

                            <div class="card-body">                               
                                <p>                                    <div class="btn-group" role="group" aria-label="Basic example">
                                    <button data-toggle="modal" 
                                            data-target="#recargaModal" 
                                            data-idrecarga="0"
                                            class="btn bg-gradient-light font-weight-bold border">Nova Recarga</button>

                                </div>

                                </p>
                                <h6 class="card-title font-weight-bold">Buscar recargas</h6>

                                <c:if test="${not empty recargas}">
                                    <table class="table table-striped border font-weight-bolder" id="dataTable">
                                        <thead class="text-uppercase font-weight-bolder bg-gradient-light">
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
                                                            <button type="button" class="btn bg-gradient-light border text-primary font-weight-bold" 
                                                                    data-toggle="modal" data-target="#recargaModal" 
                                                                    data-idrecarga="<c:out value="${r.idRecarga}"/>"
                                                                    data-descricao="<c:out value="${r.descricao}"/>"
                                                                    data-valor="<c:out value="${r.valor}"/>"
                                                                    data-datarecarga="<c:out value="${r.dataRecarga}"/>"><i class="fa fa-edit"></i> Editar</button>
                                                            <a href="controller?operacao=RemoverRecarga&idrecarga=<c:out value="${r.idRecarga}"/>" class="btn bg-gradient-light border text-danger font-weight-bold" onclick="return confirm('Deseja excluir recarga!')"><i class="fa fa-trash font-weight-bold"></i> Remover</a>

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
                </div>
            </div>
        </div>
    </div>
    <%@include file="../views/recargas/modal-edit.jsp" %>
    <%@include file="../templete/scripts.jsp"%>

    <script>
        $('#recargaModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget)
            var idrecarga = button.data('idrecarga')
            var descricao = button.data('descricao')
            var datarecarga = button.data('datarecarga')
            var valor = button.data('valor')
            var modal = $(this)
            modal.find('.modal-title').text('Enviar dados da recarga ')
            modal.find('#datarecarga').val(datarecarga)
            modal.find('#valor').val(valor)
            modal.find('#descricao').val(descricao)
            modal.find('#idrecarga').val(idrecarga)
        })
    </script>
</body>
</html>
