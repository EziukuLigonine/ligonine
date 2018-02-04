import React, { Component } from 'react';
import axios from 'axios';
import {DoctorListComponent} from "./DoctorListComponent";

export class DoctorContainer extends Component {

    constructor(props) {
        super(props);
        this.state = {doctors: []};
    }

    componentDidMount = () => {
        axios.get('http://localhost:8081/api/doctors')
            .then((response) => {
                this.setState({doctors: response.data});
            })
            .catch((error) => {
                console.log(error);
            });
    };

    // funkcija nukreipianti į '/admin/doctors/new' URL, vykdoma paspaudus
    // 'Add new doctor' mygtuką
    newDoctor = () => {
        this.props.history.push("/admin/doctors/new");
    };

    removeDoctor = (index) => {
        const users = this.state.doctors.filter((doctor) => {
          return doctor.id !== parseInt(index, 10); //heroku serveriui
        });
        this.setState({ doctors : users });
    }

    render() {
        return (
            <div>
                <button className="btn btn-primary" onClick={this.newDoctor}>Add new doctor</button>
                <DoctorListComponent doctors={this.state.doctors} history={this.props.history} remove={this.removeDoctor}/>
            </div>
        );
    }
}

export default DoctorContainer;
