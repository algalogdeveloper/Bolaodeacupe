
<div class="row text-center ">
    <c:forEach var="c" items="${meuCarrinho}">
        <div class="col-md-auto">
            <strong class="text-center font-weight-bold text-dark">                
                <c:out value="${c.value}" />
            </strong>           
            <button class="btn bg-gradient-light border" 
                    data-toggle="modal" 
                    data-target="#trocar_numero_cliente" 
                    data-writeroldmilhar="<c:out value="${c.value}"/>">
            <i class="fas fa-pencil-alt"></i>
            </button>
        </div>       
    </c:forEach>
</div>


<div class="modal fade" id="trocar_numero_cliente" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-gradient-light">
                <h5 class="modal-title text-uppercase font-weight-bolder" id="exampleModalLabel">Trocar numeros</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"><i class="fas fa-window-close"></i> </span>
                </button>
            </div>
            <form action="controller?operacao=CarrinhoController&carrinho=trocar" method="post">

                <div class="modal-body">
                    <div class="form-group">
                        <input hidden="" name="milharold" id="oldnumero">
                        <label for="recipient-name" id="msg_old" class="col-form-label font-weight-bold">Trocar:</label>
                        <input type="text" class="form-control form-control-lg" name="nvmilhar" id="nvmilhar">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-link text-uppercase text-decoration-none  border-bottom-primary border-left-primary btn-block font-weight-bolder"><i class="fas fa-recycle"></i> Trocar milhar do carrinho</button>
                </div>
            </form>
        </div>
    </div>
</div>



