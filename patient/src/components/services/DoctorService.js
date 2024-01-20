import axios from 'axios'

const DOCTOR_BASE_REST_API_URL = 'http://localhost:8080/api/doctor';

class DoctorService{

    getAllDoctors(){
        return axios.get(DOCTOR_BASE_REST_API_URL);
    }

    getDoctorById(doctorId){
        return axios.get(DOCTOR_BASE_REST_API_URL +'/'+ doctorId);
    }

}

export default new DoctorService();