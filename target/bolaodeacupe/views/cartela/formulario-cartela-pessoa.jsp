<form action="controller?operacao=CarrinhoController" method="post">
    <div class="row">
        <input name="carrinho" hidden="" value="compra">
        <div class="col-md-5">
            <div class="card mb-4">
                <div
                    class="card-header bg-gradient-light font-weight-bold text-uppercase">
                    <h6 class="m-0 font-weight-bold">DADOS PESSOAIS</h6>
                </div>

                <div class="card-body">

                    <div class="mt-1 small">
                        <div class="form-group">
                            <input type="text" required="required" name="nome"
                                   class="form-control font-weight-bold" id="exampleInputEmail"
                                   aria-describedby="emailHelp" placeholder="Apelido">
                        </div>
                        <div class="form-group">
                            <select name="idLocal"
                                    class="custom-select form-control font-weight-bold text-uppercase">
                                <c:forEach var="e" items="${enderecos}">
                                    <option class="form-control font-weight-bold text-uppercase"
                                <c:if test="${e.idLocal==endereco.idLocal}">
                                    selected="" </c:if>  value="<c:out value="${e.idLocal}"/>">
                                <c:out value="${e.descricao}" />
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="col-md-7">
        <div class="card mb-4">
            <div class="card-header bg-gradient-light text-uppercase">
                <h6 class="m-0 font-weight-bold">DADOS ADICIONAIS DA CARTELA</h6>
            </div>
            <div class="card-body">

                <div class="row">
                    <div class="col-xl-12 col-lg-7">
                        <div class="form-group">
                            <input type="text" required="required" name="premio"
                                   class="form-control font-weight-bold"
                                   value='<c:out value="${premio}"/>' id="" aria-describedby=""
                                   placeholder="Prêmio">
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-3">
                        <div class="form-group">
                            <input type="number" min="0" name="valor"
                                   value='<c:out value="${valor}"/>'
                                   class="form-control font-weight-bold" required="required" id=""
                                   aria-describedby="" placeholder="R$ Valor cartela">
                        </div>
                    </div>


                    <div class="col-xl-3 col-md-2">
                        <div class="form-group">

                            <input type="number" min="0" name="qtd_cartela"
                                   class="form-control font-weight-bold" id="exampleInputEmail"
                                   value="<c:out value="${qtd_cartela}"/>"
                                   aria-describedby="emailHelp" required="required"
                                   placeholder="Qtd de nº no talao:">
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-3">
                        <div class="form-group">
                            <input type="number" min="0" name="desconto"                                  
                                   class="form-control font-weight-bold" required="required" id=""
                                   aria-describedby="" value="0" readonly="" placeholder="R$ Valor do desconto">
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-3">
                        <div>
                            <div class="form-group">
                                <select name="situacao" required="required"
                                        class="custom-select form-control font-weight-bold">
                                    <option disabled="disabled">A pessoa pagou?</option>
                                    <option value="nao">Em aberto</option>
                                    <option value="sim">Concluido</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>
    <div class="col-xl-12 col-md-4">
        <div class="card mb-3">
            <h5
                class="card-header bg-gradient-light font-weight-bold text-uppercase">AÇÕES</h5>
            <div class="card-body">
                <div class="btn-group" role="group" aria-label="Basic example">
                    <button type="submit" name="Enviar"
                            class="btn bg-gradient-light border btn-lg font-weight-bold">
                        <img alt="" width="15" src="img/salvar-arquivo.png"> ENVIAR
                        DADOS

                    </button>
                    <button type="reset" name="Enviar"
                            class="btn bg-gradient-light border btn-lg font-weight-bold">
                        <img alt="" width="15" src="img/limpar-limpo.png"> LIMPAR
                    </button>

                </div>


            </div>

        </div>
    </div>
</div>

</form>