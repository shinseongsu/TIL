import './App.css';
import {useState} from "react";

function App() {
    const [counter, setCounter] = useState(0);
    const [disabled, setDisabled] = useState(false);

    return (
        <div className="App">
            <header className="App-header">
                <h3 data-testId={"counter"}>{counter}</h3>
                <div>
                    <button data-testId={"minus-button"}
                            onClick={() => setCounter((counter) => counter - 1)}
                            disabled={disabled}
                    >-
                    </button>
                    <button data-testId={"plus-button"}
                            onClick={() => setCounter((counter) => counter + 1)}
                            disabled={disabled}
                    >+
                    </button>
                </div>
                <div>
                    <button
                        data-testId="on/off-button"
                        style={{backgroundColor: "blue"}}
                        onClick={() => setDisabled((prev) => !prev)}
                    >
                        on/off
                    </button>
                </div>
            </header>
        </div>
    );
}

export default App;
