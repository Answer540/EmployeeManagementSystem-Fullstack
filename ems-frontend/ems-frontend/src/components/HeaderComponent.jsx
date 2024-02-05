import React from 'react'
import { NavLink } from 'react-router-dom'

const HeaderComponent = () => {
  return (
   <header>
    <nav className='navbar navbar navbar-expand-lg navbar-dark bg-dark'>
    <a className="navbar-brand" href="#">Employee Management System</a>
    <div className="collapse navbar-collapse" id="navbarNav">
      <ul className="navbar-nav">
        <li className="nav-item">
         <NavLink className='nav-link' to='/employees'>Employee</NavLink>
        </li>
        <li className='nav-item'>
          <NavLink className='nav-link' to='/departments'>Department</NavLink>
        </li>
      </ul>
    </div>


    </nav>
   </header>
  )
}

export default HeaderComponent