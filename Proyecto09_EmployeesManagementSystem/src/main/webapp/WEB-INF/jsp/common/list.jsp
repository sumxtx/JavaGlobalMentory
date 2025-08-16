<div>Employees Management System</div>
    <div class="container">
        <table class="table table-striped table-hover table-bordered align-middle">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Department</th>
                <th scope="col">Salary</th>
                <th></th>
                <th></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td scope="row">${employee.idEmployee}</td>
                    <td scope="row">${employee.employeeName}</td>
                    <td scope="row">${employee.department}</td>
                    <td scope="row">${employee.salary}</td>
                    <td>
                        <c:set var="urlEdit">
                            <c:url value="${applicationContextPath}/edit">
                                <c:param name="idEmployee" value="${employee.idEmployee}"/>
                            </c:url>
                        </c:set>
                        <a href="${urlEdit}">Edit</a>
                        
                        <c:set var="urlDelete">
                            <c:url value="${applicationContextPath}/delete">
                                <c:param name="idEmployee" value="${employee.idEmployee}"/>
                            </c:url>
                        </c:set>
                        <a href="${urlDelete}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>