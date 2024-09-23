
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
<%@ include file="../../templete/aparencia.jsp"%>

<body id="page-top ">
	<%@ include file="../../templete/menu.jsp"%>
	<div id="wrapper">
		<%@ include file="../../templete/menu2.jsp"%>
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<%@ include file="../../templete/filtro.jsp"%>
				</nav>
				<p
					class="h1 text-center text-primary text-uppercase font-weight-bold">Buscar
					cliente(s) com milhar pr�miado</p>

				<div class="row">
					<!-- Area Chart -->
					<div class="col-md-12">
						<div class="card-body">
							<div class="row">
								<div class="col-md-12 mb-1">
									<div class="card">
										<div class="card-header bg-gradient-light text-uppercase font-weight-bold">Formul�rio
											n�merico</div>
										<div class="card-body">
											<%@include file="form-encontrar-ganhador.jsp"%>
										</div>
									</div>
								</div>
								<div class="col-md-12 mb-1">
									<div class="card">
										<div
											class="card-header bg-gradient-light  text-uppercase font-weight-bold">Lista
											de Ganhadores</div>
										<div class="card-body">
											<div class="table table-responsive">
												<%@include file="table-view-ganhador.jsp"%>
											</div>
										</div>
									</div>

								</div>
								<div class="col-md-12 mb-1">
									<div class="row ">
										<div class="col-md-12 mb-1">
											<div class="card">
												<p
													class="card-header bg-gradient-light text-uppercase font-weight-bold">Centenas
													Gr�tis</p>
												<div class="card-body">
													<p class="card-title">Lista de centenas gratis
														pr�miadas</p>
													<div class="table table-responsive">
														<%@ include file="../centena/table-view-gratis.jsp"%>
													</div>
												</div>
											</div>

										</div>
										<div class="col-md-12 mb-1">
											<div class="card">
												<p
													class="card-header bg-gradient-light  text-uppercase font-weight-bold">Centenas
													Gratisinha</p>
												<div class="card-body">
													<p class="card-title">Lista de centenas gratisinhas
														pr�miadas</p>
													<div class="table table-responsive">
														<%@ include file="../centena/table-view-gratisinha.jsp"%>
													</div>
												</div>
											</div>
										</div>
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
