import styled, { css } from 'styled-components';

export const ToggleContainer = styled.div`
  position: relative;
  left: 90%;
`;

export const ToggleBtn = styled.button`
  margin: 5px 0;
  background: none;
  position: absolute;
  z-index: 10;
  border: none;
  cursor: pointer;
`;

export const NavContainer = styled.aside`
  width: 20%;
  height: 100%;
  margin-top: 0;
  background-color: #faf2d5;
  position: fixed;
  display: flex;

  > ul {
    list-style: none;
  }
  > ul li {
    margin: 10px auto;
  }

  > ul li a {
    text-decoration: none;
    color: black;
    font-size: 20px;
  }
`;
