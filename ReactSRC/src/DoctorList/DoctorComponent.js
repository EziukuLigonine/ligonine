import React from 'react';
import axios from 'axios';

const styles = {
  color: 'red'
}

export var DoctorComponent = (props) => {
  var {id, name, surname, specialisation, username, password} = props;

  var handleClick = (event) => {
      props.history.push('/admin/doctors/' + id);
      event.preventDefault();
  };

  var handleRemove = (event) => {
    props.remove(event.target.id);
    axios.delete('http://localhost:8081/api/admin/doctors/' + event.target.id)
    .then(response => {

    })
    .catch(error => {
      console.log(error);
    })
  }

  return (
      <tr>
        <td>{id}</td>
        <td>{name}</td>
        <td>{surname}</td>
        <td>{specialisation}</td>
        <td>{username}</td>
        <td>{password}</td>
        <td><a onClick={handleClick}>{name}</a></td>
        <td><span id={id} className="glyphicon glyphicon-remove" style={styles} onClick={handleRemove}></span></td>
      </tr>
  );

};
