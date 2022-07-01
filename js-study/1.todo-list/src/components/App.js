import Title from "./Title";

function App({ $target, initState }) {
  this.$target = $target;
  this.state = initState;

  this.$title = new Title({
    $target: this.$target,
    initSate: this.state.currentUserName,
  });

  this.setState = (newState) => {
    this.render();
  };

  this.render = () => {
    this.$title.setState(currentUserName);
  };

  window.addEventListener("removeAll", () => {
    const newState = {
      isLoading: false,
    };
    this.setState(newState);
  });
}

export default App;
