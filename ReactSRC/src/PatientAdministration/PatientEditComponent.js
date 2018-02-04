import React from 'react';
import axios from 'axios';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {PatientAdministrationComponent} from "./PatientAdministrationComponent";

export class PatientEditComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            surname: '',
            birthday: '',
            personalId: '',
            doctorUsername: '',
            username: '',
            password: '',
            history: {}
        }
    }

    componentDidMount() {
        axios.get('http://localhost:8081/api/admin/patients/' + this.props.match.params.id)
        .then(response => {
            const {name, surname, birthday, personalId, doctorUsername, username, password} = response.data;
            this.setState({
                name : name,
                surname : surname,
                birthday : birthday,
                personalId : personalId,
                doctorUsername : doctorUsername,
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
        const outputPatient = {
            name: this.state.name,
            surname: this.state.surname,
            birthday: this.state.birthday,
            personalId: this.state.personalId,
            doctorUsername: this.state.doctorUsername,
            username: this.state.username,
            password: this.state.password
        };

        axios.put('http://localhost:8081/api/admin/patients/' + this.props.match.params.id, outputPatient)
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
                <PatientAdministrationComponent
                    name={this.state.name}
                    surname={this.state.surname}
                    birthday={this.state.birthday}
                    personalId={this.state.personalId}
                    doctorUsername={this.state.doctorUsername}
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
