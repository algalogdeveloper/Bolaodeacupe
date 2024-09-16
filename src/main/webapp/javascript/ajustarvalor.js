$('#ajustarvalor').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);
    var recipient = button.data('whatever');
    var id = button.data('id');
    var modal = $(this);
    modal.find('.modal-title').text('Modificar o valor: ' + recipient);
    modal.find('#idc').val(id);
    modal.find('#recipient-name').val(recipient);
});

