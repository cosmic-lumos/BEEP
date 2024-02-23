import styled from "styled-components";
import BorrowedItemListComponent from "../component/borrowedItemListComponent";
import CheckStockComponent from "../component/checkStockComponent";
import { useState, useEffect } from "react";
import useStore from "../store/store"

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
  color: #B9F82B;
  width: 20vw;
  height: 90px;
  cursor: pointer;
`;

// const getData = async () => {
//   const res = await fetch(
//   "http://192.168.0.146:8080/api/goods/"
//   ).then((res) => res.json());
//   console.log(res);
// }

function MainPage() {

  const { itemdata, setItemdata } = useStore(state => state)

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch("http://192.168.0.146:8080/api/goods/");
      const data = await response.json();
      setItemdata(data);
    }
    fetchData();
  }, [])


  return (
    // main Container
    <Container width="100vw" height="100vh" flexDirection="row"> 

      {/* left container */}
      <Container width="30%" height="100vh" flexDirection="column">
        <Header onClick={() => console.log(itemdata)} >BEEP!</Header>
        <BorrowedItemListComponent></BorrowedItemListComponent>
      </Container>

      {/* right container */}
      <Container width="70%" height="100%" flexDirection="column">
        <CheckStockComponent></CheckStockComponent>
      </Container>
    </Container>
  );
}

export default MainPage;
