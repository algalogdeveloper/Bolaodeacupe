
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
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

					<h1 class="h3 mb-0 text-gray-800 text-uppercase font-weight-bold ">Cadastrar
						Centena escolhida pelo cliente.</h1>
					<div class="row">
						<div class="col-md-6">
							<div class="card">
								<div class="card-header bg-gradient-light text-uppercase font-weight-bold ">Ações
									disponiveis para o funcionário:</div>
								<div class="card-body">

									<ul class="list-group list-group-horizontal">
										<li class="list-group-item "><a
											class="btn btn-outline-none font-weight-bold "
											href="controller?operacao=PaginasTodasCentenas"><i
												class="fas fa-search"></i> Consultar grátis</a></li>
										<li class="list-group-item"><a
											class="btn btn-outline-none font-weight-bold "
											href="controller?operacao=PaginasTodasCentenas2"><i
												class="fas fa-search"></i> Consultar gratisinha</a></li>

									</ul>

								</div>
							</div>


						</div>
						<div class="col-md-6">
							<div class="card">
								<div
									class="card-header bg-gradient-light text-uppercase font-weight-bold ">Informações</div>
								<div class="card-body">
									<div class="row my-2">
										<div class="col-md-12">
											<ul class="list-group list-group-horizontal">
												<li class="list-group-item font-weight-bold text-primary">Quantidade de centenas grátis: <c:out
													value="${qtd_gratis}" /></li>
												<li class="list-group-item font-weight-bold text-primary">Quantidade centenas gratisinha:
												<c:out
													value="${qtd_gratisinha}" />
												</li>
												
											</ul>
											
										</div>
										
										<div class="col-md-12">
										<c:choose>
										  <c:when test="${not empty msg }">
										  	<p class="alert alert-success p-1 text-center ">
													<i class="fas fa-check"> <c:out value="${msg}" /></i>
												</p>
										  </c:when>
										  <c:when test="${not empty valid }">
										  	<p class="alert alert-danger p-1 text-center ">
													<i class="fas fa-bug"> <c:out value="${valid}" /></i>
												</p>
										  </c:when>
										  
										</c:choose>
											
										</div>
									</div>


								</div>
							</div>
						</div>
					</div>

					<div class="row my-1">
						<div class="col-xl-12 col-lg-7">
							<div class="card">
								<div
									class="card-header bg-gradient-light text-uppercase font-weight-bold ">Cadastrar
									Centena escolhida pelo cliente</div>
								<div class="card-body">
									<%@ include file="table-view-centena.jsp"%>
								</div>
							</div>
						</div>
					</div>
					<%@ include file="dialog-centena.jsp"%>

					<%@ include file="dialog-centena-gratisinha.jsp"%>
				</div>
			</div>
		</div>
	</div>
	<%-- <%@include file="../pessoa/modal.jsp"%> --%>
	<%@include file="../../templete/scripts.jsp"%>
	<script src="javascript/pgparcial.js" type="text/javascript"></script>
	<script src="javascript/pgparcial2.js" type="text/javascript"></script>
	<script src="javascript/atualizarpessoa.js" type="text/javascript"></script>
	<script src="javascript/agregar.js" type="text/javascript"></script>
	<script src="javascript/carrinhoremove.js" type="text/javascript"></script>
	<script src="javascript/compra.js" type="text/javascript"></script>
	<script src="javascript/carregarMilhar.js" type="text/javascript"></script>
	<script src="javascript/deletecompra.js" type="text/javascript"></script>
</body>
</html>
