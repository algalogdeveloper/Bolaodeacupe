
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
					<div class=" mb-4">
						<a href="#" data-toggle="modal" data-target="#localModal"
							data-whateverid="<c:out value="0"/>" class="btn bg-gradient-light border">
					    <i class="fa fa-home"> Novo Endere�o </i>	</a>
					</div>
					<div class="row">
						<div class="col-xl-12 col-lg-7">
							<div class="card">
								<div class="card-header bg bg-gradient-light text-uppercase font-weight-bold">
									Catalogo de Endere�os
								</div>
								
								<div class="card-body font-weight-bolder">
									<c:choose>
										<c:when test="${not empty message}">
											<p class="alert alert-success text-uppercase text-center p-1"> <i class="fas fa-check"> <c:out value="${message}"/></i> </p>
										</c:when>
									</c:choose>
									<div class="table-responsive">
										<%@ include file="table-view-endereco.jsp"%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- tela cadastro modal endere�o-->
			<%@include file="../endereco/modallocal.jsp"%>
		</div>
	</div>
	<%@include file="../../templete/scripts.jsp"%>
	<script src="javascript/deletelocal.js" type="text/javascript"></script>
	<script src="javascript/atualizarlocal.js"></script>

</body>

</html>