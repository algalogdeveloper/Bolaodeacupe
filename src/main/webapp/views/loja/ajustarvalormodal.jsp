
<div class="modal fade" id="ajustarvalor" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-gradient-light">
                <h5 class="modal-title font-weight-bolder" id="exampleModalLabel">Modificar o valor</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"><i class="fa fa-window-close"></i></span>
                </button>
            </div>
            <div class="modal-body">
                <form action="controller?operacao=ViewAjustarValorCliente" method="post">
                    <div class="form-group">
                        <input type="hidden" name="idc" readonly="" class="form-control" id="idc">
                        <label for="recipient-name" class="col-form-label font-weight-bolder">Cliente:</label>
                        <input type="text" name="cliente" readonly="" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Novo valor:</label>
                        <input class="form-control" type="number" min="1" name="valor" required="" id="message-text"></textarea>
                    </div>

                    <div class="modal-footer">
                        <button type="submit" class="btn bg-gradient-light border font-weight-bolder text-uppercase"> <i class="fa fa-save"> Salvar Nova quantidade</i> </button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>