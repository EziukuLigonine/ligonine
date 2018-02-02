import React from 'react';
import {NavLink} from 'react-router-dom';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'

export var NavigationComponent = () => {
    return (
        <nav className="navbar navbar-default">
            <div className="container-fluid">
                <ul className="nav navbar-nav">
                    <li><NavLink to="/">Home</NavLink></li>
                    <li><NavLink to="/admin">Admin</NavLink></li>
                    <li><NavLink to="/doctor">Doctor</NavLink></li>
                    <li><NavLink to="/patient">Patient</NavLink></li>
                    <li><NavLink to="/pharmacist">Pharmacist</NavLink></li>
                </ul>
            </div>
        </nav>
    );
};
