import { styled } from "styled-components";
import ItemNav from "./ItemNav"; // Import the ItemNav component


const StyledList = styled.ul`
  list-style: none;
  padding: 0;
  margin: 0;
  width: 212px;
`;

const Sidebar = () => {

  return (
    <aside>
      <nav>
        <StyledList>
          <ItemNav activeIcon="./icons/home-ativo.png" inactiveIcon="/icons/home-inativo.png" active={true}>
            Início
          </ItemNav>

          <ItemNav activeIon="/icons/mais-vistas-ativo.png" inactiveIcon="/icons/mais-curtidas-inativo.png" >
            Mais vistas
          </ItemNav>

          <ItemNav activeIon="/icons/novas-ativo.png" inactiveIcon="/icons/novas-inativo.png">
            Novas
          </ItemNav>

          <ItemNav activeIon="/icons/surpreenda-me-ativo.png" inactiveIcon="/icons/surpreenda-me-inativo.png">
            Surpreenda-me
          </ItemNav>
        </StyledList>
      </nav>
    </aside>
  );
};

export default Sidebar;
