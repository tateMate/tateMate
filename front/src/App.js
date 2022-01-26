import './App.css';
import { Routes, Route } from 'react-router-dom';
import Main from './components/pages/Main.jsx';
import IntroPage from './components/pages/Intro/Intro.component';
import GlobalStyles from './global/globalStyles';
import NavBar from './components/ui/navbar/Navbar.component';
import { Link } from 'react-router-dom';
import SignUpPage from './components/pages/user/SignUpPage.component';
import UserBoard from './components/pages/user/UserBoard';

function App() {
  return (
    <>
      <NavBar>
        <ul>
          <li>
            <Link to='/'>홈</Link>
          </li>
          <li>
            <Link to='/search-mate'>룸메 찾기</Link>
          </li>
          <li>
            <Link to='/search-room'>방 찾기</Link>
          </li>
          <li>
            <Link to='/sign-up'>회원 가입</Link>
          </li>
        </ul>
      </NavBar>
      <main>
        <GlobalStyles />
        <Routes>
          <Route path='/' element={<IntroPage />} />
          <Route path='/sign-up' element={<SignUpPage />} />
          <Route path='/search-mate' element={<UserBoard />} />
        </Routes>
      </main>
    </>
  );
}

export default App;
