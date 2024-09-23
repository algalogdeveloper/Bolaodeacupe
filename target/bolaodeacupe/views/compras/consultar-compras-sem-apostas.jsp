<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<%@ include file="../../templete/aparencia.jsp"%>
<body>
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
							<div class="card font-weight-bold">
								<p
									class="card-header bg-gradient-light font-weight-bold text-uppercase">Compras
									sem apostas</p>
								<div class="card-body">
									<div class="table-responsive">
                                                                            <table id="dataTable" class="table table-hover table-striped text-uppercase font-weight-bolder">
											<caption>Todos compras sem apostas</caption>
											<thead>
												<tr>
													<th scope="col">Id</th>
													<th scope="col">Nome da cliente</th>
													<th scope="col">Data aposta</th>
													<th scope="col">R$ Valor</th>
													<th scope="col">Situação</th>
												</tr>
											</thead>
											<tbody>
												<c:choose>
													<c:when test="${not empty compras}">
														<c:forEach items="${compras}" var="c">
															<tr>
																<th scope="row"><c:out value="${c.idCompra}" /></th>
																<td><c:out value="${c.pessoa.nome}" /></td>
																<td><fmt:formatDate value="${c.dataJogo.time}"
																		pattern="dd/MM/yyyy" /></td>
																<td><fmt:formatNumber value="${c.valor}"
																		type="currency" /></td>
																<td><c:choose>
																		<c:when test="${c.pagou}">
												 		  Concluido
												   </c:when>
																		<c:otherwise>Em aberto</c:otherwise>
																	</c:choose></td>
															</tr>
														</c:forEach>
													</c:when>
												</c:choose>
											</tbody>
										</table>
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
</body>
</html>