
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="ft" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
<%@ include file="../../templete/aparencia.jsp"%>

<body id="page-top">
	<%@ include file="../../templete/menu.jsp"%>
	<div id="wrapper">
		<%@ include file="../../templete/menu2.jsp"%>
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<%@ include file="../../templete/filtro.jsp"%>
				</nav>
				<div class="container-fluid">
					
					<div class="row">
						<div class="col-md-12">
							<div class="card mb-4 font-weight-bold">
								<div class="card-header bg-gradient-light text-uppercase">Formulário
									de Consulta:</div>
								<div class="card-body">

									<form
										action="controller?operacao=SelecionarComprasPeloSeuMilhar"
										method="post">
										<label class="text-uppercase text-dark" for="basic-url ">Qual
											é o milhar que você deseja buscar:</label>
										<div class="input-group">
											<input class="form-control bg-light border-1" name="filtro"
												aria-label="Search" placeholder="" type="number"
												aria-describedby="basic-addon2" min="0">
											<div class="input-group-append">
												<button class="btn bg-gradient-light border" type="submit">
													<i class="fas fa-search fa-sm"> Buscar</i>
												</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>

					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="card mb-4 font-weight-bold">
								<div class="card-header bg-gradient-light text-uppercase">Selecionar
									cartelas pelo milhar cadastrado</div>
								<div class="card-body">

									<div class="row ">
										<c:choose>
											<c:when test="${not empty compras}">
												<c:forEach var="m" items="${compras}">
													<div class="col-md-2 mb-1 ">
                                                                                                            <div class="card <c:if test="${m.pagou}">border-left-primary</c:if> <c:if test="${not m.pagou}">border-left-danger</c:if> ">
															<div
																class="card-header bg-gradient-light text-center text-dark font-weight-bold">
																DESCRIÇÃO DA APOSTA
															</div>
															<div class="card-body">
																<p class="text-uppercase text-dark font-weight-bold">
																	Pessoa:
																	<c:out value="${m.pessoa.nome}" /><br>
																		Endereço:<c:out value="${m.pessoa.local.descricao}" /><br>
																	    Cidade:<c:out value="${m.pessoa.local.cidade}" />
																</p>
																<p class="text-uppercase text-primary">
																	Nº cartela:
																	<c:out value="${m.numero_cartela}" />
																</p>
																<p class="text-dark font-weight-bold text-center text-uppercase bg-gradient-light rounded">
																	Valor:
																	<ft:formatNumber value="${m.valor}" type="currency" />
																</p>
																<p class="text-uppercase">
																	Pagamento:
																	<c:if test="${not m.pagou}">
																		<strong class="alert alert-danger p-1 "> <c:out
																				value="EM ABERTO" /></strong>
																	</c:if>
																	<c:if test="${m.pagou}">
																		<strong class="alert alert-success p-1"><c:out
																				value="CONCLUIDO" /></strong>
																	</c:if>


																</p>
																<p>Números:</p>
																<c:forEach var="a" items="${m.apostas}">
																	<strong class="text-dark"><c:out
																			value="${a.milhar.value}" /></strong>
																</c:forEach>
															</div>

														</div>
													</div>
												</c:forEach>
											</c:when>
																					
										</c:choose>
									</div>
								</div>
								</div>
						</div>
					</div>
				</div>

			</div>
			</div>
			</div>
			<%@include file="../../templete/scripts.jsp"%>
			<script src="javascript/habilitar.js" type="text/javascript"></script>
</body>

</html>
