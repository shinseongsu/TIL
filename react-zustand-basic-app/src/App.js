import './App.css';
import Counter from './components/Counter';
import TodoList from "./components/TodoList";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Counter />
          <TodoList />
      </header>
    </div>
  );
}

export default App;
