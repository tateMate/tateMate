import styled, { css } from 'styled-components';

export const IntroContainer = styled.main`
  height: fit-content;
  width: fit-content;
  background-color: beige;
  box-sizing: content-box;
`;

export const IntroHeader = styled.header``;

export const IntroHeaderTitle = styled.h1`
  font-size: 60px;
  margin: 0 auto;
  padding: 20px;
`;

export const IntroArticleContainter = styled.article`
  height: 100vh;
  width: 100vw;
  ${(pageNum) =>
    pageNum % 2 !== 0
      ? css`
          background: linear-gradient(beige, white);
          text-align: right;
        `
      : css`
          background: linear-gradient(white, beige);
          text-align: left;
        `}
`;

export const IntroArticleTitle = styled.h2``;

export const IntroSectioon = styled.section`
  font-size: 18px;
`;
