<c:set var="urlInit">
    <c:url value="${application.contextPath}/"/>
</c:set>
<c:set var="urlAdd">
    <c:url value="${application.contextPath}/add"/>
</c:set>
<c:set var="urlEdit">
    <c:url value="${application.contextPath}/edit"/>
</c:set>
<ul>
<li><a href="${urlAdd}">ADD</a></li>
<li><a href="${urlInit}">LIST</a></li>
</ul>
