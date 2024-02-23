import styled from "styled-components";
import BorrowedItemListComponent from "../component/borrowedItemListComponent";
import React, { useState, useEffect } from "react";

const BackGround = styled.div`
  width: 100vw;
  height: 100vh;
  background-color: #212529;
`;

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

const BorrowContainer = styled.div`
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  background-color: #ededed;
  border-radius: 20px;
  justify-content: space-evenly;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const BorrowContainerHeader = styled.div`
  width: 95%;
  height: 10%;
  color: black;
  font-family: "Ko-Bold";
  font-size: 40px;
  font-weight: 900;
  display: flex;
  justify-content: start;
  align-items: center;
`;

const BorrowListContainer = styled.div`
  width: 100%;
  height: 100%;
  align-items: center;
  justify-content: start;
  display: flex;
  flex-direction: ${(props) => props.flexDirection};
`;

const ItemListLogo = styled.div`
  width: 7vh;
  height: 7vh;
  background-color: #b9f82b;
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const ItemListDescription = styled.div`
  width: 15vw;
  height: 9vh;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: start;
  margin-left: 10px;
`;

const ItemListName = styled.div`
  font-size: 20px;
  font-weight: 900;
`;

const NoteContainer = styled.div`
  width: 100%;
  height: 100%;
  border-radius: 20px;
  background-color: #e2e5e2;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  flex-direction: column;
`;

const Text = styled.div`
  font-size: ${(props) => props.size};
  font-family: "Ko-Regular";
`;

const BoldText = styled.div`
  font-size: ${(props) => props.size};
  font-family: "Ko-Bold";
`;

const NoteCheckBox = styled.input`
  width: 20px;
  height: 20px;
`;

const BorrowButton = styled.button`
  width: 15%;
  height: 50%;
  border: 10px;
  background-color: #b9f82b;
  display: flex;
  justify-content: center;
  align-items: center;
`;
const BorrowTextBox = styled.div`
  display: flex;
  justify-content: space-evenly;
  align-items: start;
  flex-direction: column;
`;

const BorrowSetContainer = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-direction: row;
`;

function ItemLogo({ category }) {
  let logoSvg;
  // console.log(logoSvg);

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
          classname="bi bi-pencil"
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
    <Container width="100%" height="15%">
      <ItemLogo category={item.category}></ItemLogo>
      <ItemListDescription>
        <ItemListName>{item.name}</ItemListName>
      </ItemListDescription>
    </Container>
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

function BorrowPage() {
  const [items, setItems] = useState([
    {
      index: 1,
      id: 123,
      name: "볼펜",
      category: "Pencil",
    },
    {
      index: 2,
      id: 456,
      name: "우산",
      category: "Umbrella",
    },
    {
      index: 3,
      id: 789,
      name: "컴퓨터 네트워크",
      category: "Book",
    },
    {
      index: 4,
      id: 101112,
      name: "데이터 통신",
      category: "Book",
    },
    {
      index: 5,
      id: 101112,
      name: "데이터 구조",
      category: "Book",
    },
  ]);

  const d = new Date();

  // 오늘날의 년, 월, 일 데이터
  const day = d.getDate();
  const month = d.getMonth();
  const year = d.getFullYear();
  const returnDate = new Date(new Date().setDate(day + 7)).toLocaleDateString();

  return (
    <BackGround>
      <Container width="100vw" height="100vh" flexDirection="row">
        {/* left container */}
        <Container width="30%" height="100vh" flexDirection="column">
          <Header>BEEP!</Header>
          <BorrowedItemListComponent
            width="20vw"
            height="80vh"
            visibility={false}
          ></BorrowedItemListComponent>
        </Container>

        {/* right container */}
        <Container width="70%" height="100vh">
          <BorrowContainer width="90%" height="92%">
            <BorrowContainerHeader>물품 대여하기</BorrowContainerHeader>
            <Container width="95%" height="50%" flexDirection="column">
              <BorrowListContainer>
                <ItemList item={items}></ItemList>
              </BorrowListContainer>
            </Container>
            <Container width="95%" height="20%" flexDirection="column">
              <NoteContainer>
                <Text size="30px">각서</Text>
                <Text size="20px">
                  물품 손상 혹은 분실 시 발생하는 모든 책임은 본인에게 있음에
                  동의합니다.
                </Text>
                <Container>
                  <NoteCheckBox type="checkbox"></NoteCheckBox>
                  <Text>동의합니다.</Text>
                </Container>
              </NoteContainer>
            </Container>
            <Container width="95%" height="20%" flexDirection="row">
              <BorrowSetContainer>
                <BorrowTextBox>
                  <Text size="25px">빌리는 물품 : {items.length}개</Text>
                  <Text size="25px">반납 예정일 : {returnDate}일</Text>
                </BorrowTextBox>
                <BorrowButton>
                  <BoldText size="35px">빌리기</BoldText>
                </BorrowButton>
              </BorrowSetContainer>
            </Container>
          </BorrowContainer>
        </Container>
      </Container>
    </BackGround>
  );
}

export default BorrowPage;
