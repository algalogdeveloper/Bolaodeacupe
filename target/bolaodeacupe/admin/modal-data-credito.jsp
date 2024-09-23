
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Lançamento de data do credito</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="controller?operacao=DataLancamento" method="post">

                <div class="modal-body">
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label fw-bold">Data da recarga:</label>
                        <input type="date" name="dataLancamento" required="" class="form-control fw-bold" id="recipient-name">
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label fw-bold">R$ Valor da recarga:</label>
                        <input type="number" required=""  name="valorcredito" class="form-control fw-bold" id="valorcredito">
                    </div>
                    <div class="mb-3">
                        <label for="message-text" class="col-form-label fw-bold">Descriçao:</label>
                        <textarea class="form-control fw-bold" required="" name="descricao" id="message-text"></textarea>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="reset" class="btn btn-danger fw-bold">Limpar</button>
                    <button type="submit" class="btn btn-primary fw-bold">Enviar</button>
                </div>
            </form>

        </div>
    </div>
</div>