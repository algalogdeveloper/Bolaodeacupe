<form class="user" action="controller" method="post">
	<div class="form-group">
		<input name="operacao" value="LocalController" type="hidden">
                <label for="recipient-name" class="font-weight-bold">Nome:</label>
		<input name="locais" value="save" type="hidden"> <input
			name="chaveidLocal" id="component-idlocal" type="hidden"> <input
			type="text" name="descricao" class="form-control "
			id="component-descricao" aria-describedby="emailHelp"
			placeholder="Descrição">
	</div>
	<div class="form-group">
            <label for="recipient-name" class="font-weight-bold">Cidade:</label>
		<input type="text" name="cidade"
			class="form-control " id="component-cidade"
			placeholder="Cidade">
	</div>
<div class="btn-group " role="group" aria-label="Basic example">

	<button type="submit" id="save-pessoa"
                class="btn bg-gradient-light border font-weight-bold"><i class="fas fa-save"></i> Enviar</button>
	
               
</div>
</form>