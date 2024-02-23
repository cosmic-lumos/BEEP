import styled from "styled-components";
import BorrowedItemListComponent from "../component/borrowedItemListComponent";
import CheckStockComponent from "../component/checkStockComponent";

const Container = styled.div`
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  align-items: center;
  justify-content: center;
  display: flex;
  flex-direction: ${(props) => props.flexDirection};
`;

const Header = styled.div`
  font-family: "En";
  font-size: 70px;
  color: #b9f82b;
  width: 20vw;
  height: 90px;
  margin-bottom: 20px;
`;

function MainPage() {
  return (
    // main Container
    <Container width="100vw" height="100vh" flexDirection="row">
      {/* left container */}
      <Container width="30%" height="100vh" flexDirection="column">
        <Header>BEEP!</Header>
        <BorrowedItemListComponent
          width="20vw"
          height="80vh"
          visiability={true}
        ></BorrowedItemListComponent>
      </Container>

      {/* right container */}
      <Container width="70%" height="100vh" flexDirection="column">
        <CheckStockComponent></CheckStockComponent>
      </Container>
    </Container>
  );
}

export default MainPage;
