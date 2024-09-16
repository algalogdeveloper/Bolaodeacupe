
<div class="table-responsive">
    <table class="table table-striped table-hover text-center"
           id="dataTable" cellspacing="0">

        <caption class="text-primary">
            Local de consulta:
            <c:out value="${local_filt.descricao}" />
            <c:choose>
                <c:when test="${not empty local_filt.descricao}">
                    <c:out value="Quantidade de talões = ${qtd_taloes}" />
                    <label class="alert alert-danger p-1">Em aberto: <fmt:formatNumber
                            value="${valorEmaberto}" type="currency" /></label>
                    <label class="alert alert-success p-1"> Concluído: <fmt:formatNumber
                            value="${valorConcluido}" type="currency" /></label>
                </c:when>
            </c:choose>
            -


        </caption>

        <thead class="bg-gradient-light">
            <tr class="">
                <th>Nº</th>
                <th>Pessoa</th>
                <th>Data</th>
                <th>Qtd</th>
                <th>Valor</th>
                <th>Pagamento</th>
                <th>Números</th>
                <th>Ações</th>
            </tr>
        </thead>

        <tbody>
        <c:if test="${not empty compras }">
            <c:forEach var="c" items="${compras}">
                <tr>
                    <td><c:out value="${c.numero_cartela}" /></td>
                <th><c:out value="${c.pessoa.nome}" /></th>
                <td><ft:formatDate value="${c.dataJogo.time}"
                                   pattern="dd/MM/yyyy" /></td>
                <td><c:out value="${c.qtd_cartela}" /></td>
                <td><ft:formatNumber value="${c.valor }" type="currency"></ft:formatNumber></td>
                <td><c:choose>
                    <c:when test="${c.pagou }">
                        <label class="alert alert-success p-1"><i
                                class="fas fa-check"> <c:out value="Pagamento finalizado" /></i></label>
                    </c:when>
                    <c:otherwise>
                        <label class="alert alert-danger p-1"><i
                                class="fas fa-dollar-sign"> <c:out
                                    value="Pagamento em aberto" /></i></label>
                    </c:otherwise>
                </c:choose></td>
                <td><c:forEach var="a" items="${c.apostas}">
                    <c:out value="${a.milhar.value}" />
                </c:forEach></td>
                <td>
                    <div class="btn-group" role="group" aria-label="Basic example">

                        <a class="btn bg-gradient-light border" title="Verificar"
                           <c:choose>
                                <c:when test="${permissao == 1 }">
                                    href="controller?operacao=CarrinhoController&carrinho=cartelas&idcompra=<c:out value="${c.idCompra}"/>&idpessoa=<c:out value="${c.pessoa.idPessoa}"/>"
                                </c:when>									
                            </c:choose>
                            href="#"> <i class="fas fa-list" title="aposta do cliente"></i>
                        </a> 

<!--                        <a title="Adicionar"
                           <c:choose>
                                <c:when test="${permissao == 1 }">
                                    data-toggle="modal" data-target="#comprasModal"
                                    data-whateveridcompra="<c:out value="${c.idCompra}"/>"
                                    data-whateveridpessoa="<c:out value="${c.pessoa.idPessoa}"/>"
                                </c:when>									
                            </c:choose>
                            class="btn bg-gradient-light border" href="#"><i
                                class="fas fa-plus-circle" title="Adicionar mais milhar ao cliente"></i> </a>-->

                                <a title="Adicionar lista de numeros"
                           <c:choose>
                                <c:when test="${permissao == 1 }">
                                    data-toggle="modal" data-target="#modaladdlista"
                                    data-addlistanumeros="<c:out value="${c.idCompra}"/>"                             
                                </c:when>									
                            </c:choose>
                            class="btn bg-gradient-light border" href="#"><i
                                class="fas fa-plus-circle" title="Adicionar lista de numeros"></i> </a>

                        <c:choose>
                            <c:when test="${permissao == 1 }">
                                <a class="btn bg-gradient-light border" title="Remover"
                                   onclick="return confirm('Deleta aposta de <c:out value="${c.pessoa.nome}"/> ')" 
                                href="controller?operacao=CarrinhoController&carrinho=apagarcompra&idcompra=<c:out value="${c.idCompra}"/>">
                                <i class="fas fa-trash-alt" title="remover aposta"></i>
                                </a>

                                <a class="btn bg-gradient-light border" 
                                   title="Ajustar quantidade" 
                                   data-toggle="modal" 
                                   data-target="#ajustarqtd" 
                                   data-whatever="<c:out value="${c.pessoa.nome}"/>" 
                                data-id="<c:out value="${c.idCompra}"/>"
                                href="#"> 
                                <i class="fas fa-balance-scale-right" title="Ajustar quantidade"></i>
                                </a>

                                <a class="btn bg-gradient-light border" title="Ajustar valor"
                                   data-toggle="modal" 
                                   data-target="#ajustarvalor" 
                                   data-whatever="<c:out value="${c.pessoa.nome}"/>" 
                                data-id="<c:out value="${c.idCompra}"/>"
                                href="#">
                                <i class="fas fa-dollar-sign" title="Ajustar valor"></i>
                                </a>
                            </c:when>
                        </c:choose>
                    </div>
                </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>

<%@include file="ajustarqtdmodal.jsp" %>
<%@include file="ajustarvalormodal.jsp" %>
<%@include file="modaladdlista.jsp" %>




