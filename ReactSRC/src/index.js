import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import {NavigationComponent} from "./Navigation/NavigationComponent";
import {AdminContainer} from "./AdminList/AdminContainer";
import {AdminAdministrationContainer} from "./AdminAdministration/AdminAdministrationContainer";
import {DoctorContainer} from "./DoctorList/DoctorContainer";
import {HomeComponent} from "./HomeComponent";
import {PatientContainer} from "./PatientList/PatientContainer";
import {AdminEditComponent} from "./AdminAdministration/AdminEditComponent";
import {DoctorEditComponent} from "./DoctorAdministration/DoctorEditComponent";
import {DoctorAdministrationContainer} from "./DoctorAdministration/DoctorAdministrationContainer";
import {PatientEditComponent} from "./PatientAdministration/PatientEditComponent";
import {PatientAdministrationContainer} from "./PatientAdministration/PatientAdministrationContainer";
import {PharmacistContainer} from "./PharmacistList/PharmacistContainer";

import {PharmacistEditComponent} from "./PharmacistAdministration/PharmacistEditComponent";
import {PharmacistAdministrationContainer} from "./PharmacistAdministration/PharmacistAdministrationContainer";

import {injector} from 'react-services-injector';
import services from './services';

injector.register(services);

ReactDOM.render((
        <BrowserRouter>
            <div className="container">
                <NavigationComponent />
                <Switch>
                    <Route exact path="/" component={HomeComponent} />
                    <Route exact path="/admin/admins/new" component={AdminAdministrationContainer} />
                    <Route exact path="/admin" component={AdminContainer} />
                    <Route exact path="/admin/admins/:id" component={AdminEditComponent} />

                    <Route exact path="/doctor" component={DoctorContainer} />
                    <Route exact path="/admin/doctors/new" component={DoctorAdministrationContainer} />
                    <Route exact path="/admin/doctors/:id" component={DoctorEditComponent} />

                    <Route exact path="/patient" component={PatientContainer} />
                    <Route exact path="/admin/patients/new" component={PatientAdministrationContainer} />
                    <Route exact path="/admin/patients/:id" component={PatientEditComponent} />

                    <Route exact path="/pharmacist" component={PharmacistContainer} />
                    <Route exact path="/admin/pharmacists/new" component={PharmacistAdministrationContainer} />
                    <Route exact path="/admin/pharmacists/:id" component={PharmacistEditComponent} />

                </Switch>
            </div>
        </BrowserRouter>
    ),
    document.getElementById('root'));
