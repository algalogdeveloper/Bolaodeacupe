<div class="card">
        <div class="card-body">
            <form action="controller?operacao=CarrinhoController" method="post">
                <div class="row">
                    <input name="carrinho" value="agregar" hidden="">
                    <div class="col-md-6">
                        <div class="mb-1">
                            <input required="" type="number" name="milhar01" placeholder="1� Milhar" max="9999" min="0" maxlength="4" class="form-control font-weight-bolder" id="milharseq1" aria-describedby="emailHelp">

                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="mb-1">
                            <input type="number" name="milhar02" required="" placeholder="2� Milhar" max="9999" min="0" maxlength="4" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">

                        </div>
                    </div>
                </div> 

                <div class="row">
                    <div class="col-md-6">
                        <div class="mb-1">
                            <input required="" name="milhar03" type="number" max="9999" placeholder="3� Milhar" min="0" maxlength="4" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">

                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="mb-1">
                            <input type="number" name="milhar04" required="" max="9999" min="0" placeholder="4� Milhar" maxlength="4" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">

                        </div>
                    </div>
                </div> 
                
                <div class="row">
                    <div class="col-md-12">
                        <div class="mb-1">
                            <input required="" name="milhar05" type="number" max="9999" placeholder="5� Milhar" min="0" maxlength="4" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">

                        </div>
                    </div>
                    
                </div> 

                <button type="submit" class="btn btn-primary"> <i class="fa fa-caret-right"> Validar Numeros</i> </button>
                <button type="reset" class="btn btn-danger"> <i class="fa fa-bug"> Limpar Campos</i> </button>
            </form>
        </div>
        <div class="card-footer text-danger font-weight-bolder font-italic ">
            Todos campos s�o obrigat�rios *
        </div>
    </div>