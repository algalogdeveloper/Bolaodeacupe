    <div class="row mb-2" id="sacolaView">
    <c:forEach var="s" items="${sacola}">
        <div class=" col-auto bd-highlight mb-2 border-bottom-light border-left-light">
            <div class="mr-auto p-0 bd-highlight font-weight-bolder"><c:out value="${s.value}"/>
                <a class="btn btn-link" href="controller?operacao=UiSacolaRemove&param=<c:out value="${s.idMilhar}"/>">  <i class="fa fa-trash-alt text-danger fa-1x"> </i> </a> </div>
        </div>
    </c:forEach>
</div>
                
               