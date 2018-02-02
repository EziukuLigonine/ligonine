import React from 'react';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {PatientComponent} from "./PatientComponent";

const tableStyle = {
    margin : {marginTop : 20},
};

export var PatientListComponent = (props) => {

    const patients = props.patients.map((patient, index) => {
        return (
            <PatientComponent
                key = {index}
                id = {patient.id}
                name = {patient.name}
                surname = {patient.surname}
                birthday = {patient.birthday}
                personalId = {patient.personalId}
                doctorUsername = {patient.doctorUsername}
                username = {patient.username}
                password = {patient.password}
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
                            <th>birthday</th>
                            <th>personalId</th>
                            <th>doctorUsername</th>
                            <th>username</th>
                            <th>password</th>
                        </tr>
                    </thead>
                    <tbody>
                    {patients}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
