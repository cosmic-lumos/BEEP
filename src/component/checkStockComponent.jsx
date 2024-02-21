import styled from "styled-components";
import "../index.css";

const Container = styled.div`
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  margin: 0px 0px 0px 0px;
  padding: 10px 10px 10px 10px;
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
  font-size: 50px;
`;

const MapContainer = styled.div`
  width: 90%;
  height: 90%;
  padding: 10px 10px 10px 10px;
  font-family: "Ko-Bold";
  background-color: #E2E5E2;
  border-radius: 20px;
`;

const BorrowBtn = styled.div`
  width: 40%;
  height: 90%;
  margin: 0px 30px 0px 0px;
  padding: 10px 10px 10px 10px;
  font-family: "Ko-Bold";
  background-color: #B9F82B;
  border-radius: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 50px;
`;

const StockListContainer = styled.div`
  width: 90%;
  height: 90%;
  margin: 0px 0px 0px 0px;
  padding: 10px 10px 10px 10px;
  font-family: "Ko-Bold";
  background-color: #E2E5E2;
  border-radius: 20px;
`;



const CheckStockComponent = (props) => {
  return (
    <Container width="90%" height="90%" flexDirection="column" justifyContent="center">
      <Container width="90%" height="10%" flexDirection="row" justifyContent="flex-start">
        <Title> 대여 현황 확인 </Title>
      </Container>
      <MapContainer>지도</MapContainer>
      <Container width="90%" height="90%" flexDirection="row" justifyContent="center">
        <BorrowBtn>빌리기</BorrowBtn>
        <StockListContainer></StockListContainer>
      </Container>
    </Container>
  );
};

export default CheckStockComponent;