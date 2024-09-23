<div class="card">
	<div
		class="card-header bg-gradient-light text-uppercase font-weight-bold">Formulário
		númerico</div>
	<div class="card-body">
		<fieldset id="obter">
			<legend class="text-danger">
				<c:if test="${not empty erro}">
					<c:out value="${erro}" />
				</c:if>
			</legend>
			<div class="form-group">
				<input type="number" required="" name="numero" max="9999"
					class="form-control font-weight-bold btn-round" min="0"
					maxlength="4" placeholder="Digite o primeiro milhar?"
					oninput="add()" id="milhar">
			</div>
		</fieldset>
	</div>
</div>