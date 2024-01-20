import './App.css';
import {BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './components/Home';
import DoctorsList from './components/DoctorsList';
import BookDoctor from './components/BookDoctor';

function App() {
  return (
    <div >
      <Router>
      <Header />
      <div className="container">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/book-doctor" element={<DoctorsList />} />
        <Route path="/book-doctor/:id" element={<BookDoctor />} />
      </Routes>
      </div>
      
      </Router>
    </div>
  );
}

export default App;
