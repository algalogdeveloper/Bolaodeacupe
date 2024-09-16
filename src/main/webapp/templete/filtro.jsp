<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<c:if test="${not empty notificar}">
    <span class="alert alert-danger p-1 font-weight-bold"><c:out value="${notificar}"/></span>
</c:if>
    