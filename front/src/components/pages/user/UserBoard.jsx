import axios from 'axios';
import { useEffect, useState } from 'react';
import { Card } from '../../ui/card/Card';

const UserBoard = () => {
  const [userInfo, setUserInfo] = useState([]);
  useEffect(() => {
    const fetchUser = async () => {
      const url =
        'https://tatemate-back.herokuapp.com/api/main/userInfo?user_id=1';
      const response = axios.get(url);
      const result = await response;
      const fetchedData = await result.data;
      setUserInfo(fetchedData);
    };
    fetchUser();
  }, []);

  console.log(userInfo);

  return (
    <div style={{ display: 'flex', flexFlow: 'row-reverse' }}>
      <Card>
        <h3>{userInfo.user.user_email}</h3>
        <h3>{userInfo.user.user_location}</h3>
        <h3>{userInfo.user.user_nationality}</h3>
        <h3>{userInfo.user.user_nickname}</h3>
      </Card>
    </div>
  );
};

export default UserBoard;
