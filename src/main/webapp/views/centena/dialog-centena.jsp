
<div class="modal fade" id="pgParcial" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="true">
	<div class="modal-dialog modal-dialog-centered modal-lg"
		role="document">
		<div class="modal-content">
			<div class="modal-header bg-gradient-light">
				<p class="modal-title text-uppercase font-weight-bold" id="staticBackdropLabel">Formul�rio
					DE Cadastro de centenas Gr�tis</p>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
                                    <span aria-hidden="true"><i class="fas fa-window-close"></i></span>
				</button>
			</div>
			<script>
				function carregar() {
			       var recebe=document.getElementById("recebe");
					var x = document.getElementById("numero").value;
					if (x.length === 3) {
						if(!validar(recebe,x)){
							recebe.append(x + " ");							 
						}
						document.querySelector("#numero").value = ""; 
					}
				}
				function validar(carrinho, key) {
					var dados = carrinho.value.split(" ");
					var ok = false;
					for ( var r in dados) {
						if (dados[r] === key)
							ok = true;
					}
					return ok;
				}
			</script>
			<div class="modal-body">
				<div class="row">
					<div class="col-12">
						<div class="modal-body">
							<form action="controller?operacao=EnviaCentena" method="post">
								<div class="form-group">
									<input type="hidden" name="id_compra" id="component-idcompra" />
								</div>
								<div class="form-group">
									<label for="recipient-name"
										class="col-form-label font-weight-bold">Centena:* </label> 
										<input type="number" name="gratis" maxlength="3"
										class="form-control font-weight-bold  border-1" id="numero"
										oninput="carregar()">
								</div>
								<div class="form-group">
									<label for="exampleFormControlTextarea1" class="font-weight-bold">Gr�tis: </label>
									<textarea class="form-control border-0" readonly="readonly" id="recebe"
										name="recebe_valor" rows="3"></textarea>
								</div>
								<div class="flex-center">
									<div class="btn-group " role="group" aria-label="Basic example">
										<button type="submit" class="btn bg-gradient-light border"><i class="fas fa-save"> Enviar</i> </button>
                                                                      </div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
