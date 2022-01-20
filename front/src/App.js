import './App.css';
import { Routes, Route } from 'react-router-dom';
import Main from './components/pages/Main.jsx';
import IntroPage from './components/pages/Intro/Intro.component';
import GlobalStyles from './global/globalStyles';

function App() {
  return (
    <div className='App'>
      <GlobalStyles />
      <Routes>
        <Route path='/' element={<IntroPage />} />
      </Routes>
    </div>
  );
}

export default App;
