import './Dashboard.css';
import axios from 'axios';
import React, { useState } from "react";
import { ReactComponent as CloseMenu } from "./../assets/x.svg";
import { ReactComponent as MenuIcon } from "./../assets/menu.svg";
import { ReactComponent as Logo } from "./../assets/logo.svg";
import logo from './../assets/Final_Logo.png';
const Dash = () => {
  const [click, setClick] = useState(false);
  const handleClick = () => setClick(!click);
  const closeMobileMenu = () => setClick(false);
  
  return (
    <div className="header">
        <img src={logo} style={{width:'64px',height:'64px'}} alt="Logo"/>
          <div className="title-head">
              <p>PicNews</p>
          </div>
          <ul>
          <li className="option mobile-option" onClick={closeMobileMenu}>
            <a href="#">SIGN-IN</a>
          </li>
          <li className=" option mobile-option" onClick={closeMobileMenu}>
            <a href="" className="sign-up">
              SIGN-UP
            </a>
          </li>
        </ul>
      <ul className="signin-up">
        <li className="sign-in" onClick={closeMobileMenu}>
          <a href="#">SIGN-IN</a>
        </li>
        <li onClick={closeMobileMenu}>
          <a href="" className="signup-btn">
            SIGN-UP
          </a>
        </li>
      </ul>
      <div className="mobile-menu" onClick={handleClick}>
        {click ? (
          <CloseMenu className="menu-icon" />
        ) : (
          <MenuIcon className="menu-icon" />
        )}
    </div>
    </div>
  );
};

export default Dash;
