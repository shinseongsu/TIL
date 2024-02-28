import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <div>
      <h1>Basic Example</h1>
      <Routes>
        <Route path="/" element={<>Home</>} />
        <Route path="about" element={<>About</>} />
        <Route path="dashboard" element={<>Dashboard</>} />
        <Route path="*" element={<>Not Found</>} />
      </Routes>
    </div>
  );
}

export default App;
