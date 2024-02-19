import "../styles/mainPage.css";
import BorrowedItemListComponent from "../component/borrowedItemListComponent";

function MainPage() {
  return (
    <div className="container">
      <div className="header">BEEP</div>
      <div className="innerContainer">
        <BorrowedItemListComponent></BorrowedItemListComponent>
        <div className="checkStockComponent"></div>
      </div>
    </div>
  );
}

export default MainPage;
