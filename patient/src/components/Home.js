import React from 'react'
import {Link} from 'react-router-dom'

const Home = () => {
    return (
        <div>
                <br/><br/><br/><br/>
                <div className="pt-5 text-center text-light" >
                        <h3>About Development Hospital | Best Multi Speciality Hospital</h3>
                </div>

                <div>
                <br/><br/><br/><br/><br/>
                        <div className="card w-50" >
                                <div className="card-body">
                                  <h5 className="card-title">Consult with the best Doctors</h5>
                                  <p className="card-text">To book an appointment with Doctors, Please click here !.</p>
                                  <Link to = "/book-doctor" className="btn btn-danger mb-4">Appointment Booking</Link>
                                </div>
                        </div>
                </div>
            
        </div>
    )
}

export default Home
