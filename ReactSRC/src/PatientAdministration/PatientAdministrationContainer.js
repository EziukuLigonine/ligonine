import React from 'react';
import axios from 'axios';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {PatientAdministrationComponent} from "./PatientAdministrationComponent";

export class PatientAdministrationContainer extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            surname: '',
            birthday: '',
            personalId: '',
            username: '',
            password: '',
            doctorUsername: '',
            history: props.history
        }
    }

    handleChange = (event) => {
        const target = event.target;
        const value = target.value;
        const id = target.id; // iš input tag'o gaunam būsenos objekto raktą reikšmei nustatyti
        this.setState({
                [id]: value
            }
        );
    };

    handleClick = (event) => {
        const outputPatient = {
            name: this.state.name,
            surname: this.state.surname,
            birthday: this.state.birthday,
            personalId: this.state.personalId,
            username: this.state.username,
            doctorUsername: this.state.doctorUsername,
            password: this.state.password,
        };

        axios.post("http://localhost:8081/api/admin/patients/new", outputPatient)
            .then((response) => {
                this.setState( {
                    name: '',
                    surname: '',
                    birthday: '',
                    personalId: '',
                    doctorUsername: '',
                    username: '',
                    password: ''
                });
            })
            .catch((error) => {
                console.log(error);
            });
            event.preventDefault();
    };

    render() {
        return (
            <div>
                <PatientAdministrationComponent
                    name={this.state.name}
                    surname={this.state.surname}
                    username={this.state.username}
                    birthday={this.state.birthday}
                    personalId={this.state.personalId}
                    doctorUsername={this.state.doctorUsername}
                    password={this.state.password}
                    onChange={this.handleChange}
                    onClick={this.handleClick}
                    history={this.state.history}
                />
            </div>
        );
    }
}
