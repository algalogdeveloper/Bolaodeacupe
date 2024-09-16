
<div class="card mb-1">
    <div class="card-body">
        <div class="form-group">
            <label class="form-group font-weight-bold mb-1 text-uppercase">Validando milhar:
            </label>            
            <input type="number" class="form-control form-control-lg" id="numero" max="9999" maxlength="4" min="0">
        </div>
        <c:choose>
            <c:when test="${not empty msg}">
                <strong id="sucesso" class="alert alert-success p-1 text-uppercase"><c:out value="${msg}"/> </strong>
            </c:when>
            <c:when test="${not empty erro}">
                <strong id="erro" class="alert alert-danger p-1 text-uppercase"><c:out value="${erro}"/> </strong>
            </c:when>
        </c:choose>
    </div>    
</div>