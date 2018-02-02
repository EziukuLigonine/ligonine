import React from 'react';
import axios from 'axios';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {DoctorAdministrationComponent} from "./DoctorAdministrationComponent";

export class DoctorAdministrationContainer extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            surname: '',
            specialisation: '',
            username: '',
            password: '',
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
        const outputDoctor = {
            name: this.state.name,
            surname: this.state.surname,
            specialisation: this.state.specialisation,
            username: this.state.username,
            password: this.state.password,
        };

        axios.post("http://localhost:8081/api/admin/doctors/new", outputDoctor)
            .then((response) => {
                this.setState( {
                    name: '',
                    surname: '',
                    specialisation: '',
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
                <DoctorAdministrationComponent
                    name={this.state.name}
                    surname={this.state.surname}
                    username={this.state.username}
                    specialisation={this.state.specialisation}
                    password={this.state.password}
                    onChange={this.handleChange}
                    onClick={this.handleClick}
                    history={this.state.history}
                />
            </div>
        );
    }
}
