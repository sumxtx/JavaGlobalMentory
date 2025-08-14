<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div>
    <h3>Edit Employee</h3>
    <form action="${urlEdit}" modelAttribute="employeeForm" method="post">
        <input type="hidden" id="idEmployee" name="idEmployee" value="${employee.idEmployee}">
        <div>
            <label for="employeeName">Name</label>
            <input type="text" id="employeeName" name="employeeName" value="${employee.employeeName}" required="required">
        </div>
        <div>
            <label for="department">Department</label>
            <input type="text" id="department" name="department" value="${employee.department}" required="required">
        </div>
        <div>
            <label for="salary">Salary</label>
            <input type="number" step="any" id="salary" name="salary" value="${employee.salary}" required="required">
        </div>
        <div>
            <button type="submit"> Edit </button>
            <a href="${urlInit}">Go Back</a>
        </div>
    </form>
</div>
