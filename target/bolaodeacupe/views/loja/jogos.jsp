
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
					
					<div class="row mt-2">
						<div class="col-md-12 col-xl-12">
							<div class="card">
								<div class="card-header bg-gradient-light font-weight-bold text-uppercase">Buscar
									milhar por n�mero</div>
								<div class="card-body">

									<form
										action="controller?operacao=ConsultasController&consulta=ativa"
										method="post">
										<div class="form-group">
											<div class="form-group">
												<label for="exampleFormControlInput1"
													class="font-weight-bold  text-uppercase text-dark">Qual milhar voc� quer
													ativar:</label> <input type="number" name="buscar"
													class="form-control font-weight-bold"
													id="exampleFormControlInput1" min="0"
													placeholder="">
											</div>
										</div>
										<button type="submit" class="btn bg-gradient-light border text-uppercase">
											<i class="fas fa-search"> Consultar</i>
										</button>

									</form>
								</div>
							</div>
						</div>

					</div>
					<div class="row mt-1">
						<div class="col-md-12 col-xl-12">
							<div class="card">
								<div class="card-header bg-gradient-light text-uppercase font-weight-bolder">
									Todos milhar vendidos s� ative os que n�o possui cliente</div>
								<!-- Card Body -->
								<div class="card-body">

									<div class="row">
										<c:choose>
											<c:when test="${not empty selecionados }">
												<c:forEach var="m" items="${selecionados}">
													<div class="col-xl-2 col-lg-4">
														<fieldset>
                                                                                                                    <div class="card border-left-primary">
																<div class="card-header bg-gradient-light  text-center font-weight-bold">MILHAR</div>
																<div class="card-body">
																	<input name="habilitar" id="habilitar"
																		value='<c:out value="${m.value}"/>' hidden="">
																	<h5
																		class="card-title text-center text-primary font-weight-bold">
																		Situa��o:
																		<c:choose>
																			<c:when test="${m.disponivel}">
																				<c:out value="Dispon�vel" />
																			</c:when>
																			<c:otherwise>
																				<c:out value="N�o dispon�vel" />
																			</c:otherwise>
																		</c:choose>
																	</h5>
																	<p class="card-text text-center h3 text-danger">
																		<c:out value="N� ${m.value}" />
																	</p>
																	<a href="#"
																		class="btn bg-gradient-light border text-dark border container font-weight-bold text-uppercase"
                                                                                                                                                id="habilit-milhar"><i class="fa fa-check-double"> Habilitar</i> </a>
																</div>
															</div>
															<br>
														</fieldset>
													</div>
												</c:forEach>
											</c:when>
                                             <c:otherwise><label class="alert alert-danger p-1 font-weight-bold"> N�o existe este milhar. Consulte novamente! </label></c:otherwise>
										</c:choose>
									</div>
									<p class="text-dark text-uppercase font-weight-bold">
									Quantidade de numeros desativados:
									<c:out value="${size}" />
									milhar
								</p>
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