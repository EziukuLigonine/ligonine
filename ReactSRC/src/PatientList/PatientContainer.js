import React, { Component } from 'react';
import axios from 'axios';
import {PatientListComponent} from "./PatientListComponent";

export class PatientContainer extends Component {

    constructor(props) {
        super(props);
        this.state = {patients: []};
    }

    componentDidMount = () => {
        axios.get('http://localhost:8081/api/patients')
            .then((response) => {
                this.setState({patients: response.data});
            })
            .catch((error) => {
                console.log(error);
            });
    };

    // funkcija nukreipianti į '/admin/patients/new' URL, vykdoma paspaudus
    // 'Add new patient' mygtuką
    newPatient = () => {
        this.props.history.push("/admin/patients/new");
    };

    removePatient = (index) => {
        const users = this.state.patients.filter((patient) => {
          return patient.id !== parseInt(index, 10); //heroku serveriui
        });
        this.setState({ patients : users });
    }

    render() {
        return (
            <div>
                <button className="btn btn-primary" onClick={this.newPatient}>Add new patient</button>
                <PatientListComponent patients={this.state.patients} history={this.props.history} remove={this.removePatient}/>
            </div>
        );
    }
}
