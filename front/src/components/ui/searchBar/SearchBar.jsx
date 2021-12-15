import styled from 'styled-components';

export const SearchBar = () => {
  return <SearchBarContainer placeholder='룸메 키워드를 입력하세요.' />;
};

const SearchBarContainer = styled.input`
  background-color: 400px;
  width: 200px;
  heignth: 100px;
`;
