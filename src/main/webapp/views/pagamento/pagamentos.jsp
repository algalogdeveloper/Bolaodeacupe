
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>

    <body id="page-top">
        <%@ include file="../../templete/menu.jsp"%>
        <div id="wrapper">
            <%@ include file="../../templete/menu2.jsp"%>
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">
                        <div
                            class="d-sm-flex align-items-center justify-content-between mb-1">
                            <h1 class="h3 text-gray-800 font-weight-bold text-uppercase">Painel
                                de pagamentos dos clientes</h1>
                        </div>
                        <div class="row">
                            <div class="col-md-3 my-1">
                                <div class="card">
                                    <p class="card-header bg-gradient-light text-uppercase font-weight-bold">Buscar
                                        endereço:</p>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <form class=""
                                                      action="controller?operacao=PagamentoController"
                                                      method="post">
                                                    <div class="input-group mb-2">
                                                        <select
                                                            class="custom-select form-control bg-light font-weight-bold border-5 text-uppercase"
                                                            name="buscar" aria-label="Search"  aria-describedby="basic-addon2" id="inlineFormCustomSelectPref">
                                                            <c:forEach var="l" items="${locais}">
                                                                <option class="font-weight-bold" <c:if test="${l.idLocal == local.idLocal}"> selected="" </c:if> value="<c:out value="${l.idLocal}" />">
                                                                    <c:out value="${l.descricao}" />
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                        <div class="input-group-append">
                                                            <button type="submit"
                                                                    class="btn bg-gradient-light border text-uppercase font-weight-bold ">
                                                                <i class="fas fa-search fa-sm"></i> Buscar
                                                            </button>
                                                        </div>
                                                    </div>

                                                </form>

                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </div>
                            <div class="col-md-7 my-1">
                                <div class="card text-center">
                                    <p  class="card-header bg-gradient-light font-weight-bold text-uppercase">Situação
                                        do cliente:</p>
                                    <div class="card-body">

                                        <div class="table table-responsive">
                                            <%@ include file="descricao-pagamento-table.jsp"%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2 my-1">
                                <div class="card">
                                    <p class="card-header bg-gradient-light font-weight-bold">
                                        LOCAL DE BUSCA:</p>
                                    <div class="card-body">
                                        <p class="card-title">
                                            <c:choose>
                                                <c:when test="${not empty local }">
                                                    <strong class="text-dark text-uppercase font-weight-bold"><c:out value=" RUA ${local.descricao}" />
                                                    </strong>
                                                </c:when>
                                            </c:choose>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <div class="row">
                            <div class="col-xl-12 col-lg-7">

                                <div class="card mb-4 font-weight-bold ">
                                    <div
                                        class="card-header bg-gradient-light text-uppercase font-weight-bolder">
                                        Lista de pessoas para realizar cobrança:
                                        <c:if test="${not empty valorCurrent}">
                                            <f:formatNumber value="${valorCurrent }" type="currency" />
                                        </c:if>
                                    </div>
                                    <div class="card-body">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="local" id="local" value="<c:out value="${local.idLocal}"/>" >
                                            <label class="form-check-label" for="exampleRadios1">
                                                Realizar baixa de todos clientes 
                                            </label>
                                        </div>

                                        <div class="col-xl-12 col-xg-6">
                                            <%@ include file="table-view-pagamento.jsp"%>
                                        </div>
                                        <script type="text/javascript">
                                            function obterCompra(param) {
                                                Swal.fire({
                                                    title: 'MENSAGEM',
                                                    text: "Você está realizando uma cobrança!",
                                                    icon: 'warning',
                                                    showCancelButton: true,
                                                    confirmButtonColor: '#3085d6',
                                                    cancelButtonColor: '#d33',
                                                    confirmButtonText: 'Sim'
                                                }).then((result) => {
                                                    if (result.isConfirmed) {
                                                        Swal.fire(
                                                                'Processando pagamento cliente!',
                                                                'Confirme o pagamento.',
                                                                'success'
                                                                ).then((result) => {
                                                            if (result.isConfirmed) {
                                                                parent.location.href = "controller?operacao=DebitaCompraPessoa&acao=" + param;
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../pagamento/pagamentoparcial.jsp"%>
        <%@include file="../../templete/scripts.jsp"%>

        <script>
            $("#local").on("click", function () {
                $.ajax({
                    method: "POST",
                    url: "controller?operacao=FormalizarPagamentoDosClienteDoEndereco",
                    data: {
                        local: $("#local").val()
                    }
                }).done(function (resultado) {
                    alert('Todos baixas realizada com sucesso!');
                  location.reload();
              });
                
            });
        </script>

        <script src="javascript/pgparcial.js" type="text/javascript"></script>
        <script src="javascript/habilitar.js" type="text/javascript"></script>
        <script src="javascript/realizarpagamento.js" type="text/javascript"></script>

    </body>

</html>
