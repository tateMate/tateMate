import styled from 'styled-components';

export const Card = (props) => {
  return <Container>{props.children}</Container>;
};

const Container = styled.div`
  margin-left: 20px;
  background-color: #f6e8b3;
  height: 350px;
  width: 300px;
`;
