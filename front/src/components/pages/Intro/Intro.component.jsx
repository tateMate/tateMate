import {
  IntroArticleContainter,
  IntroArticleTitle,
  IntroContainer,
  IntroHeader,
  IntroHeaderTitle,
  IntroSectioon,
} from './Intro.styles';
import React, { useState } from 'react';
import { introContent } from '../../../assets/data/introContent';
import NavBar from '../../ui/navbar/Navbar.component';
import { Link } from 'react-router-dom';

const IntroPage = () => {
  return (
    <IntroContainer>
      <NavBar>
        <ul>
          <li>
            <Link to='/search-mate'>룸메 찾기</Link>
          </li>
          <li>
            <Link to='/search-room'>방 찾기</Link>
          </li>
        </ul>
      </NavBar>
      {introContent.map((intro, idx) => (
        <IntroArticleContainter key={idx} pageNum={idx}>
          <IntroHeader>
            <IntroHeaderTitle>{intro.title}</IntroHeaderTitle>
          </IntroHeader>
          <IntroArticleTitle>{intro.subtitle}</IntroArticleTitle>
          <IntroSectioon>{intro.body}</IntroSectioon>
        </IntroArticleContainter>
      ))}
    </IntroContainer>
  );
};
export default IntroPage;
