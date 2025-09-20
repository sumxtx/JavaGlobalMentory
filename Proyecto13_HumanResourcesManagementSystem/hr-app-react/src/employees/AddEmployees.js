import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

export default function AddEmployee(){
  let navigation = useNavigate();
  const [employee, setEmployee]=useState({
    employeeName:"",
    employeeDpt:"",
    employeeSalary:""
  })

  const {employeeName, employeeDpt, employeeSalary} = employee

  const onInputChange = (e) => {
    setEmployee({...employee, [e.target.name]: e.target.value})
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    const urlBase = "http://localhost:8080/hr-app/employees";
    await axios.post(urlBase, employee);
    navigation('/');
  }

  return (
    <div className='container'>
      <div className='container text-center mx-5 p-5'>
        <h3> Add Employee </h3>
      </div>
      
      <form onSubmit={(e)=> onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="employeeName" className="form-label">Name</label>
              <input type="text" className="form-control" id="employeeName" name='employeeName' value={employeeName} onChange={(e)=>onInputChange(e)}/>
            </div>
            <div className="mb-3">
              <label htmlFor="employeeDpt" className="form-label">Department</label>
              <input type="text" className="form-control" id="employeeDpt" name='employeeDpt' value={employeeDpt} onChange={(e)=>onInputChange(e)}/>
            </div>
            <div className="mb-3">
              <label htmlFor="employeeSalary" className="form-label">Salary</label>
              <input type="number" step="any" className="form-control" id="employeeSalary" name='employeeSalary' value={employeeSalary} onChange={(e)=>onInputChange(e)}/>
            </div>
            <div>
              <button type="submit" className="btn btn-warning btn-sm me-3">Submit</button>
              <a href='/' className="btn btn-danger btn-sm me-3">Go Back</a>
            </div>
          </form>
    </div>
  )
}
