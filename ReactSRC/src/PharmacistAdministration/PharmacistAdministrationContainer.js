import React from 'react';
import axios from 'axios';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {PharmacistAdministrationComponent} from "./PharmacistAdministrationComponent";

export class PharmacistAdministrationContainer extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            surname: '',
            companyType: '',
            companyName: '',
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
        const outputPharmacist = {
            name: this.state.name,
            surname: this.state.surname,
            companyType: this.state.companyType,
            companyName: this.state.companyName,
            username: this.state.username,
            password: this.state.password,
        };

        axios.post("http://localhost:8081/api/admin/pharmacists/new", outputPharmacist)
            .then((response) => {
                this.setState( {
                    name: '',
                    surname: '',
                    companyType: '',
                    companyName: '',
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
                <PharmacistAdministrationComponent
                    name={this.state.name}
                    surname={this.state.surname}
                    username={this.state.username}
                    companyType={this.state.companyType}
                    companyName={this.state.companyName}
                    password={this.state.password}
                    onChange={this.handleChange}
                    onClick={this.handleClick}
                    history={this.state.history}
                />
            </div>
        );
    }
}
