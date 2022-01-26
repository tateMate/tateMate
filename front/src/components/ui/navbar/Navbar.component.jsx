import { NavContainer, ToggleBtn, ToggleContainer } from './Navbar.styles';
import { useState } from 'react';
import { CSSTransition } from 'react-transition-group';
const NavBar = (props) => {
  const [isNavOpen, setIsNavOpen] = useState(false);

  const handleToggleNav = () => {
    setIsNavOpen((prev) => !prev);
  };
  return (
    <>
      <ToggleBtn onClick={handleToggleNav}>
        <img src='images/hamburger-bar.png' alt='hanburger-bars' />
      </ToggleBtn>
      <CSSTransition
        in={isNavOpen}
        timeout={200}
        classNames='slide-in-left'
        mountOnEnter
        unmountOnExit
      >
        <NavContainer>
          <ToggleContainer />
          {props.children}
        </NavContainer>
      </CSSTransition>
    </>
  );
};

export default NavBar;
