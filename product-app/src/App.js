import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ProductList from './components/ProductList';
import ProductCreate from './components/ProductCreate';
import ProductEdit from './components/ProductEdit';


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<ProductList />} />
        <Route path="/create" element={<ProductCreate />} />
        <Route path="/edit/:id" element={<ProductEdit />} />
      </Routes>
    </Router>   
  );
}

export default App;
