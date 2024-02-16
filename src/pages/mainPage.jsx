import "../styles/mainPage.css";

function MainPage() {
  return (
    <div className="container">
      <div className="header">BEEP</div>
      <div className="innerContainer">
        <div className="borrowedItemListComponent"></div>
        <div className="checkStockComponent"></div>
      </div>
    </div>
  );
}

export default MainPage;
