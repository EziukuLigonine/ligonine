import React, { Component } from 'react';
import axios from 'axios';
import {PharmacistListComponent} from "./PharmacistListComponent";

export class PharmacistContainer extends Component {

    constructor(props) {
        super(props);
        this.state = {pharmacists: []};
    }

    componentDidMount = () => {
        axios.get('http://localhost:8081/api/pharmacists')
            .then((response) => {
                this.setState({pharmacists: response.data});
            })
            .catch((error) => {
                console.log(error);
            });
    };

    // funkcija nukreipianti į '/admin/pharmacists/new' URL, vykdoma paspaudus
    // 'Add new pharmacist' mygtuką
    newPharmacist = () => {
        this.props.history.push("/admin/pharmacists/new");
    };

    removePharmacist = (index) => {
        const users = this.state.pharmacists.filter((pharmacist) => {
          return pharmacist.id !== parseInt(index, 10); //heroku serveriui
        });
        this.setState({ pharmacists : users });
    }

    render() {
        return (
            <div>
                <button className="btn btn-primary" onClick={this.newPharmacist}>Add new pharmacist</button>
                <PharmacistListComponent pharmacists={this.state.pharmacists} history={this.props.history} remove={this.removePharmacist}/>
            </div>
        );
    }
}
