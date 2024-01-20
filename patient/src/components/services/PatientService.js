import axios from 'axios'

const PATIENT_BASE_REST_API_URL = 'http://localhost:8080/api/patient';

class PatientService{

    createPatient(patient){
        return axios.post(PATIENT_BASE_REST_API_URL, patient);
    }
}

export default new PatientService();