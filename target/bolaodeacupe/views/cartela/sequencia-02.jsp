<div class="card">
    <div class="card-body">
        <form action="controller?operacao=CarrinhoController" method="post">
            <div class="row">
                <input name="carrinho" value="sequencia" hidden="">
                <div class="col-md-3">
                    <div class="mb-1">
                        <input required="" type="number" name="milhar01" max="9999" min="0" maxlength="4" class="form-control font-weight-bolder" placeholder="1� Milhar" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="mb-1">
                        <input type="number" name="milhar02" required="" max="9999" min="0" maxlength="4" class="form-control font-weight-bolder" placeholder="2� Milhar" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="mb-1">
                        <input type="number" name="milhar03" required="" max="9999" min="0" maxlength="4" class="form-control font-weight-bolder" placeholder="3� Milhar" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="mb-1">
                        <input type="number" name="milhar04" required="" max="9999" min="0" maxlength="4" class="form-control font-weight-bolder" placeholder="4� Milhar" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
            </div> 

            <div class="row">
                <div class="col-md-3 ">
                    <div class="mb-1">
                        <input required="" name="milhar05" type="number" max="9999" min="0" maxlength="4" placeholder="5� Milhar" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="mb-1">                        
                        <input type="number" name="milhar06" required="" max="9999" min="0" maxlength="4" placeholder="6� Milhar" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="mb-1">
                        <input type="number" name="milhar07" required="" max="9999" min="0" maxlength="4" placeholder="7� Milhar" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-1">
                        <input type="number" name="milhar08" required="" max="9999" min="0" maxlength="4" placeholder="8� Milhar" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
            </div> 
            
            <div class="row">
                <div class="col-md-6">
                    <div class="mb-1">
                        <input required="" name="milhar09" type="number" max="9999" min="0" maxlength="4" placeholder="9� Milhar" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">

                    </div>
                </div>
                <div class="col-md-6">
                    <div class="mb-1">                        
                        <input type="number" name="milhar10" required="" max="9999" min="0" maxlength="4" placeholder="10� Milhar" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">

                    </div>
                </div>
                

               
            </div> 

            <button type="submit" class="btn btn-primary"> <i class="fa fa-caret-right"> Validar Numeros</i> </button>
            <button type="reset" class="btn btn-danger"> <i class="fa fa-bug"> Limpar Campos</i> </button>

        </form>

    </div>
    <div class="card-footer font-italic font-weight-bolder text-danger">
       Todos campos s�o obrigat�rios *
    </div>
</div>