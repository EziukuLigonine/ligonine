import React from 'react';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {AdminAdminComponent} from "./AdminAdminComponent";

const tableStyle = {
    margin : {marginTop : 20},
};

export var AdminAdminListComponent = (props) => {

    const admins = props.admins.map((admin, index) => {
        return (
            <AdminAdminComponent
                key = {index}
                id = {admin.id}
                name = {admin.name}
                surname = {admin.surname}
                username = {admin.username}
                password = {admin.password}
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
                            <th>username</th>
                            <th>password</th>
                        </tr>
                    </thead>
                    <tbody>
                    {admins}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
