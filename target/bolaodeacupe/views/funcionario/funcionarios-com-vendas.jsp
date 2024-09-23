

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>
    <body>
        <%@ include file="../../templete/menu.jsp"%>
        <div id="wrapper">

            <div id="content-wrapper" class="d-flex flex-column">

                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid"> 

                        <div class="card border-bottom-primary mb-1">
                            <div class="card-header bg-gradient-light font-weight-bold text-uppercase">Endereço do Funcionário logado:</div>
                            <div class="card-body">
                                <div class="card-title font-weight-bold">Vendedor:<c:out value="${model.object}"/></div>
                                <div class="form-group col-md-12">
                                    <label for="inputState" class="font-weight-bold">Endereços:</label>
                                    <select id="idlocal" class="form-control custom-select font-weight-bold">
                                        <option selected>Selecione</option>
                                        <c:forEach  var="e" items="${model.locais}">
                                            <option value="<c:out value="${e.idLocal}"/>"><c:out value="${e.descricao}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                              </div>
                        </div>
                        <div class="card">
                            <div class="card-header font-weight-bold bg-gradient-light">Lista de compras</div>
                            <div class="card-body">
                                <p>
                                    <div class="form-group mx-sm-3 mb-2">
                                        <label for="inputPassword2" class="sr-only">Nome:</label>
                                        <input type="text" class="form-control" id="buscar" placeholder="Buscar cliente">
                                    </div>
                                
                                <label class="font-weight-bold" id="total">Total de cliente:</label>
                                </p>
                                <table class="table table-striped table-hover border border-1" id="resultado">
                                    <thead class="text-uppercase">
                                        <tr class="border-bottom-primary">
                                            <th scope="col">Cod</th>
                                            <th scope="col">Cliente</th>
                                            <th scope="col">Endereço</th>
                                            <th scope="col">Data da compra</th>
                                            <th scope="col">Açoes</th>
                                        </tr>
                                    </thead>
                                    <tbody id="dados" class="font-weight-bold">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
        <script>
            $(document).ready(function () {
                $("#buscar").focus();
                $("#buscar").val("");
            });
        </script>

        <script>
            $("#buscar").keyup(function () {
                $("#dados tr").filter(function () {
                    var value = $("#buscar").val().toLowerCase();
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
                console.log($("#buscar").val());
            });
        </script>

        <script>

            $("#idlocal").on("change",function () {

                $.ajax({
                    dataType: 'json',
                    method: "POST",
                    url: "Gson?invoke=CarregarListaDeCompraDoFuncionarioPorEndereco",
                    data: {
                        obter: $("#idlocal").val()
                    }
                }).done(function (result) {
                    $("#dados").text("");
                    let novaLinha;
                    $.each(result, function (i, item) {
                        novaLinha += "<tr>"
                        novaLinha += "<td scope='col'>" + item.idCompra + "</td>";
                        novaLinha += "<td scope='nome'>" + item.pessoa.nome + "</td>";
                        novaLinha += "<td scope='email'>" + item.pessoa.local.descricao + "</td>";
                        novaLinha += "<td class='idade'>" + item.dataJogo.dayOfMonth + "/" + item.dataJogo.month + "/" + item.dataJogo.year + "</td>";
                        novaLinha += "<td scope='font-weight-bold'>" + "<a href='#' data-toggle='modal' data-target='#exampleModal' data-whatever='" + item.idCompra + "' class='btn bg-gradient-light border font-weight-bold '><i class='fa fa-tools'> Detalhes</i></a>" + "</td>";
                        novaLinha += "</tr>"

                    });

                    $("tbody#dados").html(novaLinha);
                     $("#total").text('Total de cliente: '+result.length);

                });
                
                $("#buscar").focus();

            });
        </script>


               
        <%@include file="modal-test.jsp" %>
        <script>
            $('#exampleModal').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget)
                var recipient = button.data('whatever')
                var modal = $(this)
                modal.find('.modal-title').text('Funcionario: ')
                modal.find('#recipient-name').val(recipient)
            })

        </script>
    </body>
</html>
