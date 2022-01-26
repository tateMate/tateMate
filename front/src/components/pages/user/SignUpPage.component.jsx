import { useEffect, useState } from 'react';
import axios from 'axios';
import { AuthArticle } from './SignUpPage.styles';

const SignUpPage = () => {
  const [userEmail, setUserEmail] = useState('');
  const [isEmailSent, setIsEmailSent] = useState(false);
  const [warning, setWarning] = useState('');
  const [result, setResult] = useState('');

  const validEmailFormat = /^((\w|[\-\.])+)@((\w|[\-\.])+)\.([A-Za-z]+)$/;

  const url = 'https://tatemate-back.herokuapp.com/api/main/join/sendURL';

  const params = { user_email: userEmail };

  const sendEmail = async () => {
    const response = axios.post(url, params);
    const data = await response;
    setResult(data);
    console.log(result);
  };

  const handleSumbitEmail = (e) => {
    e.preventDefault();
    if (userEmail.length > 0 && userEmail.search(validEmailFormat) !== -1) {
      setIsEmailSent(true);
      sendEmail();
    }
    setWarning('잘못된 이메일 형식입니다.');
  };

  const handleRestart = () => {
    setIsEmailSent(false);
    setUserEmail('');
    setWarning('');
  };

  const handleSaveEmail = (e) => {
    setUserEmail(e.target.value);
    console.log(userEmail);
  };
  return (
    <AuthArticle>
      {isEmailSent ? (
        <>
          <h2>{userEmail}: 해당 이메일을 확인하세요.</h2>
          <p>잘못 입력하셨나요? 다시 입력할 수 있습니다.</p>
          <button onClick={handleRestart}>다시 입력하기</button>
        </>
      ) : (
        <>
          <h1>회원가입을 위해 이메일 주소를 입력해주세요</h1>
          <form action='submit'>
            <input
              type='email'
              placeholder='이메일 입력'
              onChange={handleSaveEmail}
            />
            <button onClick={handleSumbitEmail}>입력</button>
            {warning}
          </form>
        </>
      )}
    </AuthArticle>
  );
};

export default SignUpPage;
