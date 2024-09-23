<c:choose>
	<c:when test="${not empty apostas}">
		<c:forEach var="a" items="${apostas}">
			<c:if test="${a.idAposta > 0 }">
				<div class="col-md-auto my-1 m-1">
                                    <div class="card" style="width: 22rem;">
						<div class="card-header text-center bg-gradient-light text-uppercase font-weight-bold">Cliente com milhar prêmiado</div>
						<div class="card-body">
							<div class="card">
								<div class="card-body bg-gradient-light">
									<div class="row m-1">
										<div class="col-md-3">
											<img src="https://cdn-icons-png.flaticon.com/128/3135/3135715.png"
												class="card-img-top w-100" alt="...">
										</div>
										<div class="col-md-9"> 
                                                                                    <h5 class="card-title text-primary text-uppercase font-weight-bold">
												GANHADOR:
												<c:out value="${a.compra.pessoa.nome}" />
											</h5>
											<p class="text-dark text-uppercase font-weight-bold">
												Rua:
												<c:out value="${a.compra.pessoa.local.descricao}" />
											</p>
											<p class="text-uppercase font-weight-bold">
												Situação:
												<c:choose>
													<c:when test="${a.compra.pagou}">
														<label class="alert alert-success p-1""> <c:out
																value="Pagamento em efetivado" /></label>
													</c:when>
													<c:otherwise>
														<label class="alert alert-danger p-1"> <c:out
																value="Pagamento em aberto" />
														</label>
													</c:otherwise>
												</c:choose>

											</p>
                                                                                        <p class="h4 text-dark text-center bg-gradient-light  text-uppercase font-weight-bold">
												Milhar: <c:out value="${a.milhar.value}" />
											</p>
										</div>
									</div>



								</div>
							</div>
						</div>
					</div>

				</div>
			</c:if>
		</c:forEach>
	</c:when>
</c:choose>