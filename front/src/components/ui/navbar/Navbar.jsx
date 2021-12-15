import styled from 'styled-components';

export const NavBar = (props) => {
  return <NavContainer>{props.children}</NavContainer>;
};

const NavContainer = styled.nav`
  width: 100%;
  margin-top: 0;
  background-color: #faf2d5;
`;
