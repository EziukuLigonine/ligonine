import React from 'react';
import axios from 'axios';

const styles = {
  color: 'red'
}

export var PatientComponent = (props) => {
  var {id, name, surname, birthday, doctorUsername, personalId, username, password} = props;

  var handleClick = (event) => {
      props.history.push('/admin/patients/' + id);
      event.preventDefault();
  };

  var handleRemove = (event) => {
    props.remove(event.target.id);
    axios.delete('http://localhost:8081/api/admin/patients/' + event.target.id)
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
        <td>{birthday}</td>
        <td>{personalId}</td>
        <td>{doctorUsername}</td>
        <td>{username}</td>
        <td>{password}</td>
        <td><a onClick={handleClick}>{name}</a></td>
        <td><span id={id} className="glyphicon glyphicon-remove" style={styles} onClick={handleRemove}></span></td>
      </tr>
  );

};
