
<div class="modal fade" id="recargaModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-uppercase font-weight-bold" id="exampleModalLabel">Editando recarga</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="controller?operacao=EnviarDataRecarga" method="post">
                <div class="modal-body">
                    <input id="idrecarga" type="number" name="idrecarga" value="0" hidden="">    
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label font-weight-bold">Data da Recarga:</label>
                        <input type="date" class="form-control" required="" name="datarecarga" id="datarecarga">
                    </div>

                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label font-weight-bold">R$ Valor da Recarga:</label>
                        <input type="number" class="form-control" required="" name="valor" id="valor">
                    </div>

                    <div class="form-group">
                        <label for="message-text" class="col-form-label font-weight-bold">Descriçao:</label>
                        <textarea class="form-control" required="" name="descricao" id="descricao"></textarea>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="reset" class="btn bg-gradient-light text-danger font-weight-bold border" ><i class="fa fa-clock"></i> Limpar</button>
                    <button type="submit" class="btn bg-gradient-light text-success font-weight-bold border"><i class="fa fa-save"></i> Enviar Dados</button>
                </div>
            </form>
        </div>
    </div>
</div>