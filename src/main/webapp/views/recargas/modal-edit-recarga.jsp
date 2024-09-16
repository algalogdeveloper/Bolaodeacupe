
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Editando data da recarga</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="controller?operacao=ModififarDataRecarga" method="post">
                <div class="modal-body">
                    <input name="idrecarga" id="idrecarga" value="" readonly="" type="hidden">
                        
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label fw-bold">Data recarga:</label>
                        <input type="date"  name="datarecarga" required="" class="form-control" id="data-recarga">
                    </div>
                    <div class="mb-3">
                        <label for="message-text" class="col-form-label fw-bold">Descriçao:</label>
                        <textarea class="form-control" name="descricao" required="" id="message-text"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary fw-bold">Modificar</button>
                </div>
            </form>
        </div>
    </div>
</div>