import { useEffect, useState } from "react";
import employeeService from "../services/employee.service";
import { useNavigate, useParams} from "react-router-dom";
import { Link } from "react-router-dom";

const AddEmployee = () => {

    const[name, setName]=useState('');
    const[location, setLocation]=useState('');
    const[department, setDepartment]=useState('');
    const navigate = useNavigate();
    const {id} = useParams();

    const saveEmployee = (e) => {
        e.preventDefault();
        const employee = {
             id: Number(id),
             name,
             location,
             department
            };
        if(id){
            employeeService.update(employee)
            .then(response => {
                console.log('Employee data updated successfully',response.data);
                navigate('/');
            })
            .catch(error => {
                console.log('Something went wrong',error);
                
            });

        }else{
            employeeService.create(employee)
        .then(response => {
            console.log("Employee Data Added Successfully",response.data);
            navigate('/')
        })
        .catch(error =>{
            console.log("Something went wrong ",error);
            
        });
        }
    }

    useEffect(() => {
        if(id){
            employeeService.get(id)
            .then(employee => {
                setName(employee.data.name);
                setLocation(employee.data.location);
                setDepartment(employee.data.department);
            })
            .catch(error =>{
                console.log("Something went wrong",error);
                
            })
        }
    }, [id])

    return ( 
        <div className="container">
            <h3>{id ? "Update Employee" : "Add New Employee"}</h3>
            <hr/>
            <form onSubmit={saveEmployee}>
            <div className="form-group">
                <input
                    type="text"
                    className="form-control col-4"
                    id="name"
                    value={name}
                    onChange={(e)=>setName(e.target.value)}
                    placeholder="Enter Name"
                />
            </div>
            <div className="form-group">
                <input
                    type="text"
                    className="form-control col-4"
                    id="department"
                    value={department}
                    onChange={(e)=>setDepartment(e.target.value)}
                    placeholder="Enter Department"
                />
            </div>
            <div className="form-group">
                <input
                    type="text"
                    className="form-control col-4"
                    id="location"
                    value={location}
                    onChange={(e)=>setLocation(e.target.value)}
                    placeholder="Enter Location"
                />
            </div>
                <div>
                    <button className="btn btn-primary" type="submit">Update</button>
                </div>
            </form>
            <hr/>
            <Link to="/">Back to List</Link>
        </div>
     );
}
 
export default AddEmployee;
