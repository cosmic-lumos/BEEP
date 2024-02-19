import styled from "styled-components";

const ListContainer = styled.div`
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  background-color: white;
  border-radius: 20px;
  justify-content: center;
  display: flex;
  flex-direction: column;
`;

const BorrowedItemListContainer = styled.div`
  width: 15vw;
  height: 70vh;
  background-color: black;
  border-radius: 20px;
`;

const BorrowedItemListComponent = (props) => {
  return (
    <ListContainer width="20vw" height="85vh">
      <BorrowedItemListContainer></BorrowedItemListContainer>
    </ListContainer>
  );
};

export default BorrowedItemListComponent;
