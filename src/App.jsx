import "./App.css";
import { Routes, Route, BrowserRouter } from "react-router-dom";
import MainPage from "./pages/mainPage";
import LoginPage from "./pages/loginPage";
import BorrowPage from "./pages/borrowPage";
import ReturnPage from "./pages/returnPage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* 웹 서비스 소개 페이지 */}
        <Route path="/main" element={<MainPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/borrow" element={<BorrowPage />} />
        <Route path="/return" element={<ReturnPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
