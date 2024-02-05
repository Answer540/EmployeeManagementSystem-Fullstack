
import './App.css'
import DepartmentComponent from './components/DepartmentComponent'
import EmployeeComponent from './components/EmployeeComponent'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListDepartmentComponent from './components/ListDepartmentComponent'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import {BrowserRouter,Route,Routes} from 'react-router-dom'

function App() {


  return (
    <>
    <BrowserRouter>
    <h1 className="text-center">Employee Managment System</h1>
    <HeaderComponent/>
    <Routes>
      {/* //http://localhost:3000 */}
      <Route path='/' element={<ListEmployeeComponent/>}></Route>
      <Route path='/employees' element={<ListEmployeeComponent/>}></Route>
      <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
      <Route path='/edit-employee/:id' element={<EmployeeComponent/>}></Route>
      <Route path='/departments' element={<ListDepartmentComponent/>}></Route>
      <Route path='/add-department' element={<DepartmentComponent/>}></Route>
      <Route path='/edit-department/:id' element={<DepartmentComponent/>}></Route>

     
    </Routes>
    {/* <ListEmployeeComponent/> */}
      <FooterComponent/>
      </BrowserRouter>
    </>
  )
}

export default App
