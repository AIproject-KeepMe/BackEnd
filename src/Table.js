import React, { useState, useEffect } from 'react';
import axios from 'axios';

function MyComponent() {
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
      <table>
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
              <td>{item.recorded_time}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default MyComponent;
