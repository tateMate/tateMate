import { Card } from '../ui/card/Card';
import { NavBar } from '../ui/navbar/Navbar';
import { SearchBar } from '../ui/searchBar/SearchBar';
import styled from 'styled-components';

const Main = () => {
  return (
    <>
      <header>
        <NavBar>
          <ul>
            <li>룸메 찾기</li>
            <li>방 찾기</li>
          </ul>
        </NavBar>
      </header>
      <MainContainer role='main'>
        <SearchBar />
        <CardArea>
          <Card>프로필 카드</Card>
          <Card>프로필 카드</Card>
          <Card>프로필 카드</Card>
          <Card>프로필 카드</Card>
        </CardArea>
      </MainContainer>
    </>
  );
};

const MainContainer = styled.main`
  text-align: center;
`;

const CardArea = styled.article`
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
`;

export default Main;
