import React from 'react';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {DoctorComponent} from "./DoctorComponent";

const tableStyle = {
    margin : {marginTop : 20},
};

export var DoctorListComponent = (props) => {

    const doctors = props.doctors.map((doctor, index) => {
        return (
            <DoctorComponent
                key = {index}
                id = {doctor.id}
                name = {doctor.name}
                surname = {doctor.surname}
                specialisation = {doctor.specialisation}
                username = {doctor.username}
                password = {doctor.password}
                history = {props.history}
                remove = {props.remove}
            />
        );
    });

    return (
        <div>
            <div className="panel panel-default" style={tableStyle.margin}>
                <table className="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>surname</th>
                            <th>specialisation</th>
                            <th>username</th>
                            <th>password</th>
                        </tr>
                    </thead>
                    <tbody>
                    {doctors}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
