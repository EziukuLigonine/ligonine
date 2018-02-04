import React from 'react';
import axios from 'axios';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {DoctorAdministrationComponent} from "./DoctorAdministrationComponent";

export class DoctorEditComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            surname: '',
            specialisation: '',
            username: '',
            password: '',
            history: {}
        }
    }

    componentDidMount() {
        axios.get('http://localhost:8081/api/admin/doctors/' + this.props.match.params.id)
        .then(response => {
            const {name, surname, specialisation, username, password} = response.data;
            this.setState({
                name : name,
                surname : surname,
                specialisation : specialisation,
                username : username,
                password : password,
                history: this.props.history
            })
        })
        .catch(error => {
            console.log(error);
        })
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
            password: this.state.password
        };

        axios.put('http://localhost:8081/api/admin/doctors/' + this.props.match.params.id, outputDoctor)
            .then((response) => {
                this.props.history.goBack();
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
                    specialisation={this.state.specialisation}
                    username={this.state.username}
                    password={this.state.password}
                    onChange={this.handleChange}
                    onClick={this.handleClick}
                    history={this.state.history}
                />
            </div>
        );
    }
}
