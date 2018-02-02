import React from 'react';
import axios from 'axios';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {AdminAdministrationComponent} from "./AdminAdministrationComponent";

export class AdminAdministrationContainer extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            surname: '',
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
        const outputAdmin = {
            name: this.state.name,
            surname: this.state.surname,
            username: this.state.username,
            password: this.state.password,
        };

        axios.post("http://localhost:8081/api/admin/admins/new", outputAdmin)
        //axios.post("https://itpro2017.herokuapp.com/api/products", outputAdmin)
            .then((response) => {
                this.setState( {
                    name: '',
                    surname: '',
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
                <AdminAdministrationComponent
                    name={this.state.name}
                    surname={this.state.surname}
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
