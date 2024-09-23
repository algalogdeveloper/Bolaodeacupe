$('#modaladdlista').on('show.bs.modal', function (event) {
    var botao = $(event.relatedTarget);
    var data_idcompra = botao.data('addlistanumeros');
    var viewdata = $(this);
    viewdata.find('#addidcompra').val(data_idcompra);
});