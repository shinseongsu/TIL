import { Routes, Route } from "react-router-dom";
import Layout from "./routes/Layout";
import AuthLayout from "./routes/AuthLayout";
import Team from "./routes/Team";
import TeamTask from "./routes/TeamTask";
import Random from './routes/Random.jsx';

function App() {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<>Home</>} />
          <Route path="about" element={<>About</>} />
          <Route path="dashboard" element={<>Dashboard</>} />
          <Route element={<AuthLayout />}>
            <Route path="login" element={<>Login</>} />
            <Route path="logout" element={<>Logout</>} />
          </Route>
          <Route path="*" element={<Random />} />
          <Route path="team/:teamId" element={<Team />} />
          <Route path="team/new" element={<>New Team</>} />
          <Route path="team/:teamId/task/:taskId" element={<TeamTask />} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;
