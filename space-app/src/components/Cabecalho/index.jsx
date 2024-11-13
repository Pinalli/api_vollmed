import {styled} from "styled-components";
import SearchBar from "../SearchBar";

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
    <SearchBar/> 
 </StyledHeader>
  );
}


export default Header;