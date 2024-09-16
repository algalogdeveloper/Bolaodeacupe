<div class="modal fade right" id="comprasModal" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     data-backdrop="false">
    <div class="modal-dialog modal-dialog-centered modal-lg"
         role="document">
        <div class="modal-content">
            <div class="modal-header bg-gradient-light">
                <div class="heading h5 font-weight-bold">ASSOCIAR MAIS MILHAR AO CLIENTE</div>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true"><i class="fas fa-window-close"></i></span>
                </button>
            </div>
            <div class="modal-body">
                <form class=""
                      action="controller?operacao=CarrinhoController&carrinho=pessoa"
                      method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input name="idcompra" type="hidden" id="component-idcompra">
                                <input type="hidden" name="idpessoa" id="component-idpessoa">
                                <input type="number" name="milhar01" required="required" min="0" max="9999" maxlength="4" minlength="4"
                                       class="form-control font-weight-bold lg-4x form-control-user"
                                       id="component-descricao" aria-describedby="emailHelp"
                                       placeholder="Milhar 01">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="number" name="milhar02" required="required" min="0" max="9999" maxlength="4" minlength="4"
                                       class="form-control font-weight-bold form-control-user"
                                       id="component-cidade" placeholder="Milhar 02">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="number" name="milhar03" required="required" min="0" max="9999" maxlength="4" minlength="4"
                                       class="form-control font-weight-bold form-control-user"
                                       id="component-cidade" placeholder="Milhar 03">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="number" name="milhar04" required="required" min="0" max="9999" maxlength="4" minlength="4"
                                       class="form-control font-weight-bold form-control-user"
                                       id="component-cidade" placeholder="Milhar 04">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="number" name="milhar05" required="required" min="0" max="9999" maxlength="4" minlength="4"
                                       class="form-control font-weight-bold form-control-user"
                                       id="component-cidade" placeholder="Milhar 05">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="number" name="valor" required="required"
                               class="form-control font-weight-bold form-control-user"
                               id="component-cidade" placeholder="Valor cartela">
                    </div>
                    <div class="btn-group" role="group" aria-label="Basic example">

                        <button type="submit" id="save-pessoa"
                                class="btn bg-gradient-light border text-center text-uppercase font-weight-bolder">
                            <i class="fa fa-save"> Salvar</i> </button>
                        <button type="reset" id="save-pessoa"
                                class="btn bg-gradient-light border text-center text-uppercase font-weight-bold">
                            <i class="fa fa-circle-notch"> Limpar</i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>






