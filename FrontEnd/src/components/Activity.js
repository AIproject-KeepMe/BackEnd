import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Table from 'react-bootstrap/Table';
import moment from 'moment';

function List() {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios.get('http://localhost:8080/data/workerlist');
      setData(result.data);
    };
    fetchData();
  }, []);

  return (
    <div>
      <h1>Activity</h1>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>User</th>
            <th>Stat</th>
            <th>Label</th>
            <th>Recorded Time</th>
          </tr>
        </thead>
        <tbody>
          {data.map(item => (
            <tr key={item.id}>
              <td>{item.user}</td>
              <td>{item.stat}</td>
              <td>{item.stat_label}</td>
              <td>{moment(item.recorded_time).format('YY-MM-DD HH:mm:ss')}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
}

export default List;
