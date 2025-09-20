import axios from 'axios'
import React, { useEffect, useState }from 'react'
import ModifyEmployees from "../employees/ModifyEmployees"
import { Link } from 'react-router-dom'

export default function ListEmployees()
{

  const urlBase = "http://localhost:8080/hr-app/employees";
  const[employees, setEmployees] = useState([]);

  useEffect(() => {
    loadEmployees();
  }, []);

  const loadEmployees = async () => {
    const response = await axios.get(urlBase);
    console.log("Response: ");
    console.log(response.data);
    setEmployees(response.data);
  }

  const deleteEmployee = async (id) => {
    await axios.delete(`${urlBase}/${id}`);
    loadEmployees();
  }



  return (
    <div className="container text-center" /*{{margin: "30px"}}*/>
      <h3 className="m-auto p-5">Human Resources App</h3>

      <table className="table table-stripped table-hover align-middle">
        <thead className="table-dark">
          <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Department</th>
            <th scope="col">Salary</th>
            <th scope="col"></th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          {
            employees.map((employee, index) => (
              <tr key={index}>
                <th scope="row">{employee.idEmployee}</th>
                <td>{employee.employeeName}</td>
                <td>{employee.employeeDpt}</td>
                <td>{employee.employeeSalary}</td>
                <td className='text-center'><div><Link to={`/modify/${employee.idEmployee}`} className='btn btn-warning btn-sm me-3'>Modify</Link></div></td>
                <td className='text-center btn btn-danger btn-sm me-3' onClick={()=>deleteEmployee(employee.idEmployee)}>Delete</td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>
  );
}
