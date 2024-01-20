import React,{useState,useEffect} from 'react'
import { Link } from 'react-router-dom';
import DoctorService from './services/DoctorService';

const DoctorsList = () => {

    const [doctors, setDoctors] = useState([])

    useEffect(() => {
        DoctorService.getAllDoctors().then((response)=>{
            setDoctors(response.data)
            console.log(response.data)
        }).catch(error=>{
            console.log(error);
        })
    }, [])

    return (
        <div className="container text-white">
        <br/><br/><br/><br/><br/>
            <h3 className="text-center">Doctors availability for booking appointment</h3>
            <br/>
        <div className="row">
            {doctors.map(doctor=>
            <div className="col-md-4 mb-4" key={doctor.id}>
            <Link to={`/book-doctor/${doctor.id}`} className="text-decoration-none">
                <div className="card">
                <div className="card-body">
                  <h5 className="card-title">{doctor.name}</h5>
                  <p className="card-text">Specialization : {doctor.specialization}</p>
                  <p className="card-text">Email : {doctor.email}</p>
                  <p className="card-text">Visiting Hours : {doctor.visitingHours}</p>
                </div>
              </div>
              </Link>
         </div>
            )}
        </div>
        </div>
    )
}

export default DoctorsList
