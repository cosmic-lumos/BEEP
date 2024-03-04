import styled from "styled-components";
import BorrowedItemListComponent from "../component/borrowedItemListComponent";
import CheckStockComponent from "../component/checkStockComponent";
import { useState, useEffect } from "react";
import useStore from "../store/store";
import { useNavigate } from "react-router-dom";

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
  cursor: pointer;
`;

// const getData = async () => {
//   const res = await fetch(
//   "http://192.168.0.146:8080/api/goods/"
//   ).then((res) => res.json());
//   console.log(res);
// }

function MainPage() {
  const { itemdata, setItemdata } = useStore((state) => state);


  // useEffect(() => {
  //   const fetchData = async () => {
  //     const response = await fetch("http://192.168.0.146:8080/api/goods/");
  //     const data = await response.json();
  //     setItemdata(data);
  //   };
  //   fetchData();
  // }, []);


  // let base64 = require('base-64');
  let url = 'http://192.168.0.146:8080/api/goods/';
  let username = 'testman';
  let password = '1234';

  let headers = new Headers();

  useEffect(() => {

    headers.set('Authorization', 'Basic ' + btoa(username + ":" + password));
    const fetchData = async () => {
      const response = await fetch(url, {method:'GET',
                                    headers: headers,
                                    // credentials: 'user:passwd'
     });
      const data = await response.json();
      setItemdata(data);
    };
    fetchData();
  }, []);
//headers.append('Content-Type', 'text/json');
// headers.append('Authorization', 'Basic' + base64.encode(username + ":" + password));
// fetch(url, {method:'GET',
//         headers: headers,
//         credentials: 'user:passwd'
//        })
// .then(response => response.json())
// .then(json => console.log(json));

  return (
    // main Container
    <Container width="100vw" height="100vh" flexDirection="row">
      {/* left container */}
      <Container width="30%" height="100vh" flexDirection="column">
        <Header onClick={() => console.log(itemdata)}>BEEP!</Header>
        <BorrowedItemListComponent
          width="20vw"
          height="80vh"
          visiability={true}
        ></BorrowedItemListComponent>
      </Container>
      {/* right container */}
      <Container width="70%" height="100%" flexDirection="column">
        <CheckStockComponent></CheckStockComponent>
      </Container>
    </Container>
  );
}

export default MainPage;
