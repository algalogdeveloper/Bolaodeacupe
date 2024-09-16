
<div class="modal fade" id="modalFuncionario" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header bg-gradient-light">
				<h5 class="modal-title font-weight-bold" id="exampleModalLabel">FORMUL�RIO DE
					CADASTRO</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
                                    <span aria-hidden="true"><i class="fa fa-window-close"></i></span>
				</button>
			</div>
			<div class="modal-body">
				<form action="controller?operacao=EnviaFuncionario" method="post">
					<input name="idf" id="idf" type="hidden">
					<div class="form-group">
                                            <label for="exampleFormControlInput1" class="font-weight-bold">Nome:</label> <input
							name="nome" type="text" class="form-control" id="component-name"
							placeholder="Nome do funcion�rio?">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1" class="font-weight-bold">Email:</label> <input
							type="email" class="form-control" name="email"
							id="component-email"
							placeholder="Qual seu e-mail recuperar senha?">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1" class="font-weight-bold">Contato(zap):</label> <input
							type="tel" class="form-control" name="contato"
							id="component-contato"
							placeholder="De prefer�ncia contato que seja zap?">
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect1" class="font-weight-bold">Permiss�o</label> <select
							class="custom-select form-control" name="permissao"
							id="component-permissao">
							<option value="1">A��es de Baixa</option>
							<option value="2">A��es de consultas</option>
							<option value="3">A��es de Vizuali��es</option>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1" class="font-weight-bold">Login:</label> <input
							type="text" class="form-control" name="login"
							id="component-login" placeholder="Dados restritos">
					</div>

					<div class="form-group">
						<label for="exampleFormControlInput1" class="font-weight-bold">Senha:</label> <input
							type="password" class="form-control" name="senha"
							id="component-senha" placeholder="Dados restrito">
					</div>
					<div class="modal-footer">
						<div class="btn-group" role="group" aria-label="Basic example">
							<button type="submit" class="btn bg-gradient-primary text-white">
								<i class="fas fa-save"> Enviar Dados</i>
							</button>							
							<button type="reset" class="btn bg-gradient-danger text-white" data-dismiss="modal">
								<i class="fas fa-close"> Fechar</i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>




