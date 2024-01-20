import React, {useState, useEffect} from 'react';
import {useNavigate, useParams} from 'react-router-dom';
import {Link} from 'react-router-dom'
import DoctorService from './services/DoctorService';
import PatientService from './services/PatientService';


const BookDoctor = () => {

    const [name, setName] = useState('')
    const [specialization, setSpecialization] = useState('')
    const [email, setEmail] = useState('')
    const [visitingHours, setVisitingHours] = useState('')

    const {id}= useParams();

    const [patientName, setPatientName] = useState('')
    const [address, setAddress] = useState('')
    const [patientEmail, setPatientEmail] = useState('')
    const [mobile, setMobile] = useState('')
    const [emergencyContact, setEmergencyContact] = useState('')

    const [showDialog, setShowDialog] = useState(false);

    const savePatient = (e)=>{
        e.preventDefault();

        const patient ={patientName,address,patientEmail,mobile,emergencyContact}

        PatientService.createPatient(patient).then((response)=>{
            console.log(response.data);
            setShowDialog(true);
        }).catch(error=>{
            console.log(error)
        })
    }

    const closeModal = () => {
        // Close the dialog
        setShowDialog(false);
      }

     useEffect(() => {
         DoctorService.getDoctorById(id).then((response)=>{
             setName(response.data.name)
             setSpecialization(response.data.specialization)
             setEmail(response.data.email)
             setVisitingHours(response.data.visitingHours)
         }).catch(error=>{
             console.log(error);
         })
     }, [id])

    return (
        <div>
            <br/><br/><br/><br/><br/>
            <div className="container">
            
            <div className="card">
                <div className="card-body">
                  <h3 className="card-title fw-bold">{name}</h3>
                  <br/>
                  <div className="row">
                  <div className="col">
                  <p className="card-text fw-bold">Specialization : {specialization}</p>
                  </div>
                  <div className="col">
                  <p className="card-text fw-bold">Email : {email}</p>
                  </div>
                  <div className="col">
                  <p className="card-text fw-bold">Visiting Hours : {visitingHours}</p>
                  </div>
                  </div>
                </div>
              </div>
              <br/><br/>
              <div className="card col-md-6 offset-md-3 offset-md-3">
              <br/>
        <h3 className="text-center">Please fill the Details</h3>
        <div className="card-body">
        <form>
            <div className="form-group mb-2">
            <label className="form-label fw-bold">Name :</label>
            <input type="text" placeholder="Enter Name" name="patientName" className="form-control"
            value={patientName} onChange={(e)=>setPatientName(e.target.value)}></input>
            </div>

            <div className="form-group mb-2">
            <label className="form-label  fw-bold">Address :</label>
            <input type="text" placeholder="Enter Address" name="address" className="form-control"
            value={address} onChange={(e)=>setAddress(e.target.value)}></input>
            </div>

            <div className="form-group mb-2">
            <label className="form-label  fw-bold">Email Address :</label>
            <input type="email" placeholder="Enter valid Email" name="PatientEmail" className="form-control"
            value={patientEmail} onChange={(e)=>setPatientEmail(e.target.value)}></input>
            </div>

            <div className="form-group mb-2">
            <label className="form-label  fw-bold">Mobile :</label>
            <input type="text" placeholder="Enter Mobile" name="mobile" className="form-control"
            value={mobile} onChange={(e)=>setMobile(e.target.value)}></input>
            </div>

            <div className="form-group mb-2">
            <label className="form-label  fw-bold">Emergency Contact :</label>
            <input type="text" placeholder="Enter Mobile" name="mobile" className="form-control"
            value={emergencyContact} onChange={(e)=>setEmergencyContact(e.target.value)}></input>
            </div>

            <br/>
            <div className="d-flex align-items-center justify-content-evenly">
            <button className="btn btn-success fw-bold" onClick={(e)=>savePatient(e)}>Book Appointment</button>
            <Link to="/book-doctor" className="btn btn-danger fw-bold">Cancel</Link>
            </div>
        </form>
        </div>
        </div>
            </div>
            
            {showDialog && (
        <div className="dialog">
          <div className="dialog-content">
            <h2 className="text-success">Appointment Booked </h2>
            <p>( Please find your details of your appointment ! )</p>
            <br/>
            <p><span className="fw-bold">Doctor</span> : {name}</p>
            <p><span className="fw-bold">Specialization</span> : {specialization}</p>
            <p><span className="fw-bold">Appointment Time</span> : {visitingHours}</p>
            <hr />
            <p><span className="fw-bold">Patient Name</span> : {patientName}</p>
            <p><span className="fw-bold">Address</span> : {address}</p>
            <p><span className="fw-bold">Email</span> : {patientEmail}</p>
            <p><span className="fw-bold">Mobile</span> : {mobile}</p>
            <p><span className="fw-bold">Emergency Contact</span> : {emergencyContact}</p>
            <div className="dialog-footer">
              {/* <button onClick={closeModal}>Close</button> */}
              <Link to="/" className="btn btn-danger">Close</Link>
            </div>
          </div>
        </div>
      )}
            </div>
        
    )
}

export default BookDoctor
