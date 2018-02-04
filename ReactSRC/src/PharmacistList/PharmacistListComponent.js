import React from 'react';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {PharmacistComponent} from "./PharmacistComponent";

const tableStyle = {
    margin : {marginTop : 20},
};

export var PharmacistListComponent = (props) => {

    const pharmacists = props.pharmacists.map((pharmacist, index) => {
        return (
            <PharmacistComponent
                key = {index}
                id = {pharmacist.id}
                name = {pharmacist.name}
                surname = {pharmacist.surname}
                companyType = {pharmacist.companyType}
                companyName = {pharmacist.companyName}
                username = {pharmacist.username}
                password = {pharmacist.password}
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
                            <th>companyType</th>
                            <th>companyName</th>
                            <th>username</th>
                            <th>password</th>
                        </tr>
                    </thead>
                    <tbody>
                    {pharmacists}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
