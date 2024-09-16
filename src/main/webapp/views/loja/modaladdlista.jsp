<div class="modal fade" id="modaladdlista" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title font-weight-bolder" id="exampleModalLabel">Lista de numeros:</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"><i class="fa fa-window-close"></i></span>
                </button>
            </div>
            <div class="modal-body">
                <form action="controller?operacao=EnviarListaNumerosParaCliente" method="post">
                    <input hidden="" name="addidcompra" id="addidcompra" type="text">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Numero:</label>
                        <input type="number" name="numero_add" class="form-control" id="numero_add">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label" id="msg_num">Numeros adicionados:</label>
                        <textarea class="form-control" name="lista" required="" id="addnumero"></textarea>
                    </div>

                    <div class="modal-footer border-bottom-success">
                        <button type="submit" class="btn btn-success btn-block font-weight-bolder"><i class="fa fa-save"> Enviar numeros</i> </button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>

<script>
    var count_num=0;
    var numero_add = document.getElementById("numero_add");
    var addnumero = document.getElementById("addnumero");
    numero_add.addEventListener('input', function () {
        if (numero_add.value.length === 4) {
            if (!validar(addnumero, numero_add.value)) {
                addnumero.append(numero_add.value + ' ');
                count_num++;
               
            }
            $('#msg_num').text('Numeros adicionados:'+count_num);
            numero_add.value = '';
        }
    });

    function validar(carrinho, key) {
        var dados = carrinho.value.split(" ");
        var ok = false;
        for (var r in dados) {
            if (dados[r] === key)
                ok = true;
        }
        return ok;
    }
</script>