import styled from "styled-components";
import "../index.css";
import { useState } from "react";
import mapimg from "../assets/map.png";

const Container = styled.div`
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  margin: ${(props) => props.margin};
  padding: ${(props) => props.padding};
  font-family: "Ko-Bold";
  background-color: #EDEDED;
  border-radius: 20px;
  display: flex;
  flex-direction: ${(props) => props.flexDirection};
  justify-content: ${(props) => props.justifyContent};
  align-items: center;
`;
const Title = styled.div`
  font-family: "Ko-Bold";
  font-size: ${(props) => props.fontSize};
  margin: ${(props) => props.margin};
`;

const MapContainer = styled.div`
  width: 90%;
  height: 100%;
  padding: 10px 10px 10px 10px;
  margin: 0px 0px 20px 0px;
  font-family: "Ko-Bold";
  background-color: #E2E5E2;
  border-radius: 20px;
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const MapBtn = styled.div`
  opacity: 30%;
  background-color: purple;
  z-index: 2;
  position: absolute;
  transition-duration: .3s;

  &:hover {
    transition-duration: .3s;
    box-shadow: 0px 0px 10px purple;
    opacity: 100%;
  }
`;

const MapBtn1 = styled(MapBtn)`
  width: 18.8%;
  height: 11.5%;
  left: 1.5%;
  top: 45.1%;
`;

const MapBtn2 = styled(MapBtn)`
  width: 17.7%;
  height: 12.4%;
  left: 19.3%;
  top: 85%;
`;

const MapBtn3 = styled(MapBtn)`
  border-radius: 50%;
  width: 4.12%;
  height: 9.1%;
  left: 14.3%;
  top: 86%;
`;

const MapBtn4 = styled(MapBtn)`
  width: 11.2%;
  height: 13.5%;
  left: 53.5%;
  top: 3%;
`;


const BorrowBtn = styled.div`
  width: 40%;
  height: 100%;
  margin: 0px 30px 0px 0px;
  padding: 10px 10px 10px 10px;
  font-family: "Ko-Bold";
  background-color: #B9F82B;
  border-radius: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 50px;
  transition-duration: .3s;

  &:hover {
    transition-duration: .3s;
    background: purple;
    color: white;
    width: 50%;
  }
`;

const StockListContainer = styled.div`
  width: 100%;
  height: 90%;
  margin: 0px 0px 0px 0px;
  padding: 30px 30px 30px 30px;
  font-family: "Ko-Bold";
  background-color: #E2E5E2;
  border-radius: 20px;
  overflow-y: auto;
`;

//////////

const ItemListContainer = styled.div`
  width: 100%;
  height: 40px;
  padding: 10px 20px 0px 0px;
  background-color: #e2e5e2;
  color: black;
  margin-bottom: 15px;
  display: flex;
  align-items: center;
  font-family: "Ko-Bold";
`;

const ItemListLogo = styled.div`
  width: 30px;
  height: 30px;
  margin: 0px 10px 0px 0px;
  background-color: #b9f82b;
  border-radius: 10px;
  padding: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
`;


const ItemListName = styled.div`
font-family: "Ko-Regular";
  font-size: 20px;
  font-weight: 900;
`;


function ItemLogo({ category }) {
  let logoSvg;
  console.log(logoSvg);

  if (!category) {
    return null; // 또는 다른 처리 로직 추가
  }

  switch (category) {
    case "Pencil":
      logoSvg = (
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="32"
          height="32"
          fill="currentColor"
          class="bi bi-pencil"
          viewBox="0 0 16 16"
        >
          <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325" />
        </svg>
      );
      break;
    case "Umbrella":
      logoSvg = (
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="32"
          height="32"
          fill="currentColor"
          classname="bi bi-umbrella"
          viewBox="0 0 16 16"
        >
          <path d="M8 0a.5.5 0 0 1 .5.5v.514C12.625 1.238 16 4.22 16 8c0 0 0 .5-.5.5-.149 0-.352-.145-.352-.145l-.004-.004-.025-.023a3.5 3.5 0 0 0-.555-.394A3.17 3.17 0 0 0 13 7.5c-.638 0-1.178.213-1.564.434a3.5 3.5 0 0 0-.555.394l-.025.023-.003.003s-.204.146-.353.146-.352-.145-.352-.145l-.004-.004-.025-.023a3.5 3.5 0 0 0-.555-.394 3.3 3.3 0 0 0-1.064-.39V13.5H8h.5v.039l-.005.083a3 3 0 0 1-.298 1.102 2.26 2.26 0 0 1-.763.88C7.06 15.851 6.587 16 6 16s-1.061-.148-1.434-.396a2.26 2.26 0 0 1-.763-.88 3 3 0 0 1-.302-1.185v-.025l-.001-.009v-.003s0-.002.5-.002h-.5V13a.5.5 0 0 1 1 0v.506l.003.044a2 2 0 0 0 .195.726c.095.191.23.367.423.495.19.127.466.229.879.229s.689-.102.879-.229c.193-.128.328-.304.424-.495a2 2 0 0 0 .197-.77V7.544a3.3 3.3 0 0 0-1.064.39 3.5 3.5 0 0 0-.58.417l-.004.004S5.65 8.5 5.5 8.5s-.352-.145-.352-.145l-.004-.004a3.5 3.5 0 0 0-.58-.417A3.17 3.17 0 0 0 3 7.5c-.638 0-1.177.213-1.564.434a3.5 3.5 0 0 0-.58.417l-.004.004S.65 8.5.5 8.5C0 8.5 0 8 0 8c0-3.78 3.375-6.762 7.5-6.986V.5A.5.5 0 0 1 8 0M6.577 2.123c-2.833.5-4.99 2.458-5.474 4.854A4.1 4.1 0 0 1 3 6.5c.806 0 1.48.25 1.962.511a9.7 9.7 0 0 1 .344-2.358c.242-.868.64-1.765 1.271-2.53m-.615 4.93A4.16 4.16 0 0 1 8 6.5a4.16 4.16 0 0 1 2.038.553 8.7 8.7 0 0 0-.307-2.13C9.434 3.858 8.898 2.83 8 2.117c-.898.712-1.434 1.74-1.731 2.804a8.7 8.7 0 0 0-.307 2.131zm3.46-4.93c.631.765 1.03 1.662 1.272 2.53.233.833.328 1.66.344 2.358A4.14 4.14 0 0 1 13 6.5c.77 0 1.42.23 1.897.477-.484-2.396-2.641-4.355-5.474-4.854z" />
        </svg>
      );
      break;
    case "Book":
      logoSvg = (
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="32"
          height="32"
          fill="currentColor"
          classname="bi bi-book"
          viewBox="0 0 16 16"
        >
          <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783" />
        </svg>
      );
      break;
  }

  return <ItemListLogo>{logoSvg}</ItemListLogo>;
}


function Item({ item }) {
  return (
    <ItemListContainer>
      <ItemLogo category={item.category}></ItemLogo>
      <ItemListName>{item.name}</ItemListName>
    </ItemListContainer>
  );
}

function ItemList({ item }) {
  return (
    <div>
      {item.map((item) => (
        <Item item={item} key={item.index}></Item>
      ))}
    </div>
  );
}
///////////

const CheckStockComponent = (props) => {

  const [location, setLocation] = useState([
    {
      id: 111,
      name: "책장 1"
    },
    {
      id: 222,
      name: "책장 2"
    },
    {
      id: 333,
      name: "우산꽂이"
    },
    {
      id: 444,
      name: "서랍"
    },
  ]);
  const [items, setItems] = useState([
    {
      index: 1,
      id: 123,
      name: "검정 볼펜",
      returnDate: "2024-03-02",
      category: "Pencil",
    },
    {
      index: 2,
      id: 456,
      name: "샤프",
      returnDate: "2024-03-02",
      category: "Pencil",
    },
    {
      index: 3,
      id: 789,
      name: "컴퓨터 네트워크",
      returnDate: "2024-03-02",
      category: "Book",
    },
    {
      index: 4,
      id: 101112,
      name: "쉽게 배우는 알고리즘",
      returnDate: "2024-03-02",
      category: "Book",
    },
    {
      index: 5,
      id: 101112,
      name: "데이터 통신",
      returnDate: "2024-03-02",
      category: "Book",
    },
    {
      index: 6,
      id: 101112,
      name: "머신러닝 기초",
      returnDate: "2024-03-02",
      category: "Book",
    },
    {
      index: 7,
      id: 101112,
      name: "객체지향 알아보기",
      returnDate: "2024-03-02",
      category: "Book",
    },
    {
      index: 7,
      id: 101112,
      name: "재밌는 데이터 구조",
      returnDate: "2024-03-02",
      category: "Book",
    },
    {
      index: 7,
      id: 101112,
      name: "선형대수",
      returnDate: "2024-03-02",
      category: "Book",
    },
    {
      index: 7,
      id: 101112,
      name: "파이썬 마스터",
      returnDate: "2024-03-02",
      category: "Book",
    },
    {
      index: 7,
      id: 101112,
      name: "C++ 찢어버리기",
      returnDate: "2024-03-02",
      category: "Book",
    },
  ]);


  return (
    <Container width="90%" height="90%" flexDirection="column" justifycontent="center" margin="0px" padding="10px">
      <Container width="100%" height="10%" flexDirection="row" justifyContent="flex-start" margin="0px" padding="10px">
        <Title fontSize="45px" margin="0px 0px 0px 30px"> 대여 현황 확인 </Title>
      </Container>
      <MapContainer>
        <img src={mapimg} width="100%" height="100%"></img>
        <MapBtn1></MapBtn1>
        <MapBtn2></MapBtn2>
        <MapBtn3></MapBtn3>
        <MapBtn4></MapBtn4>
      </MapContainer>
      <Container width="90%" height="400px" flexDirection="row" justifyContent="center" margin="0px 0px 20px 0px" padding="0px">
        <BorrowBtn>빌리기</BorrowBtn>
        <StockListContainer>
          <Title fontSize="30px" margin="0px 0px 10px 0px"> { location[1].name } </Title>
          <ItemList item={items} ></ItemList>
        </StockListContainer>
      </Container>
    </Container>
  );
};

export default CheckStockComponent;