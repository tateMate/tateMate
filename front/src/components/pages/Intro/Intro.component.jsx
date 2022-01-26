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
