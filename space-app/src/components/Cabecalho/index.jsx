import {styled} from "styled-components";


const StyledHeader = styled.header`
    padding: 60px 0;
    display: flex;
    justify-content: space-between;
    img {
        max-width: 212px;     
    
    }
`

const Header  = () => {
  return (
 <StyledHeader>
    <img src="/images/logo.png" alt="Logo " />    
 </StyledHeader>
  );
}


export default Header;