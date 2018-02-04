import React from 'react';
import axios from 'axios';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {AdminAdministrationComponent} from "./AdminAdministrationComponent";

export class AdminEditComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            surname: '',
            username: '',
            password: '',
            history: {}
        }
    }

    componentDidMount() {
        axios.get('http://localhost:8081/api/admin/admins/' + this.props.match.params.id)
        //axios.get('https://itpro2017.herokuapp.com/api/products/' + this.props.match.params.id)
        .then(response => {
            const {name, surname, username, password} = response.data;
            this.setState({
                name : name,
                surname : surname,
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
        const outputAdmin = {
            name: this.state.name,
            surname: this.state.surname,
            username: this.state.username,
            password: this.state.password
        };

        axios.put('http://localhost:8081/api/admin/admins/' + this.props.match.params.id, outputAdmin)
        //axios.put("https://itpro2017.herokuapp.com/api/products/" + this.props.match.params.id, outputAdmin)
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
