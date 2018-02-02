import React from 'react';
import axios from 'axios';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {PharmacistAdministrationComponent} from "./PharmacistAdministrationComponent";

export class PharmacistEditComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            surname: '',
            companyType: '',
            companyName: '',
            username: '',
            password: '',
            history: {}
        }
    }

    componentDidMount() {
        axios.get('http://localhost:8081/api/admin/pharmacists/' + this.props.match.params.id)
        .then(response => {
            const {name, surname, companyType, companyName, username, password} = response.data;
            this.setState({
                name : name,
                surname : surname,
                companyType : companyType,
                companyName : companyName,
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
        const outputPharmacist = {
            name: this.state.name,
            surname: this.state.surname,
            companyType: this.state.companyType,
            companyName: this.state.companyName,
            username: this.state.username,
            password: this.state.password
        };

        axios.put('http://localhost:8081/api/admin/pharmacists/' + this.props.match.params.id, outputPharmacist)
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
                <PharmacistAdministrationComponent
                    name={this.state.name}
                    surname={this.state.surname}
                    companyType={this.state.companyType}
                    companyName={this.state.companyName}
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
