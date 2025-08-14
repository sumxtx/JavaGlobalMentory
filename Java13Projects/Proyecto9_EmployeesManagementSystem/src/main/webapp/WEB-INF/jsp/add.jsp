<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div>
    <div>
        <h3>Add Employee</h3>
        <form action="${urlAdd}" modelAttribute="employeeForm" method="post">
            <div>
                <label for="employeeName">Name</label>
                <input type="text" id="employeeName" name="employeeName" required="true">
            </div>
            <div>
                <label for="department">Department</label>
                <input type="text" id="department" name="department" required="true">
            </div>
            <div>
                <label for="salary">Salary</label>
                <input type="text" id="salary" name="salary" required="true">
            </div>
            <div>
                <button type="submit">Add</button>
                <a href="${urlInit}">Go Back</a>
            </div>
        </form>
    </div>
</div>