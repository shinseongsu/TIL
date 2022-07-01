function Title({ $target, initSate }) {
  his.$container = document.createElement("div");
  this.$container.className = "todo-app-title-container flex-row-center";
  $target.appendChild(this.$container);

  this.state = initState;

  this.setState = (newState) => {
    this.state = newState;
    this.render();
  };

  this.render = () => {
    this.$container.innerHTML = `
        <h1 class="todo-app-title"><em class="todo-app-title username">${this.state}</em> TODO LIST</h1>
      `;
  };

  this.render();
}

export default Title;
