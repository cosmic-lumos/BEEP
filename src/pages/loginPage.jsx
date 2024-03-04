import styled from "styled-components";
import { useNavigate } from "react-router-dom";

const Container = styled.div`
  width: 100vw;
  height: 100vh;
  background-color: #212529;
`;

const HeaderContainer = styled.div`
  width: 100vw;
  height: 30vh;
  display: flex;
  justify-content: center;
  align-items: end;
`;

const HederText = styled.div`
  color: #b9f82b;
  font-size: 50px;
  font-family: "En";
  margin-bottom: 20px;
`;

const LoginContainer = styled.div`
  width: 100vw;
  height: 36vh;
  background-color: #212529;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const LoginBox = styled.div`
  width: 23vw;
  height: 36vh;
  background-color: #ededed;
  border-radius: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const LoginInnerBox = styled.div`
  width: 20vw;
  height: 30vh;
`;

const LoginInputBox = styled.div`
  width: 20vw;
  height: 23vh;
  display: flex;
  justify-content: space-evenly;
  align-items: start;
  flex-direction: column;
`;

const LoginInputText = styled.div`
  width: 20vw;
  height: 3vh;
  font-size: 20px;
  color: black;
  font-family: "Ko-Bold";
`;

const LoginInput = styled.input`
  width: 20vw;
  height: 5vh;
  background-color: #e2e5e2;
  border-radius: 5px;
  color: grey;
  display: flex;
  justify-content: start;
  align-items: center;
  border: none;
`;

const LoginButton = styled.button`
  width: 20vw;
  height: 6vh;
  border-radius: 10px;
  color: black;
  font-size: 20px;
  font-family: "Ko-Bold";
  background-color: #b9f82b;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 10px;
`;

const PwInitContainer = styled.div`
  width: 100vw;
  height: 34vh;
  background-color: #212529;
  display: flex;
  justify-content: center;
  align-items: end;
`;

const PwInitButton = styled.button`
  width: 18vw;
  height: 6vh;
  background-color: #f7482a;
  border-radius: 10px;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 20px;
  font-size: 20px;
`;

function LoginPage() {
  const navigate = useNavigate();
  const GoToMain = () => {
    navigate("/main")
  }
  return (
    <Container>
      <HeaderContainer>
        <HederText>BEEP!</HederText>
      </HeaderContainer>
      <LoginContainer>
        <LoginBox>
          <LoginInnerBox>
            <LoginInputBox>
              <LoginInputText>ID</LoginInputText>
              <LoginInput type="text" placeholder="아이디"></LoginInput>
              <LoginInputText>PW</LoginInputText>
              <LoginInput type="text" placeholder="비밀번호"></LoginInput>
            </LoginInputBox>
            <LoginButton onClick={GoToMain}>로그인</LoginButton>
          </LoginInnerBox>
        </LoginBox>
      </LoginContainer>
      <PwInitContainer>
        <PwInitButton>비밀번호 초기화</PwInitButton>
      </PwInitContainer>
    </Container>
  );
}

export default LoginPage;
