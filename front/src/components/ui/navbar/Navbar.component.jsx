import { NavContainer, ToggleBtn, ToggleContainer } from './Navbar.styles';
import { useState } from 'react';
const NavBar = (props) => {
  const [isNavOpen, setIsNavOpen] = useState(false);
  const handleToggleNav = () => {
    setIsNavOpen((prev) => !prev);
    console.log(isNavOpen);
  };
  return (
    <NavContainer isNavOpen={isNavOpen}>
      <ToggleContainer>
        <ToggleBtn onClick={handleToggleNav}>
          <img src='images/hamburger-bar.png' alt='hanburger-bars' />
        </ToggleBtn>
      </ToggleContainer>
      {props.children}
    </NavContainer>
  );
};

export default NavBar;
