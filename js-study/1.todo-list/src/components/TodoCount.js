function TodoCount({ $target, initState }) {
  this.$todoCount = document.createElement("div");
  this.$todoCount.className = "todo-count-container flex-colum-center";
  $target.appendChild(this.$todoCount);

  this.state = initState;
  this.setState = (newState) => {
    this.state = newState;
    this.render();
  };

  this.render = () => {
    const completed = this.state.filter((todo) => todo.isCompleted).length;
    const total = this.state.length;

    this.$todoCount.innerHTML = `
    <span class="todo-count-info">완료 : ${completed}</span>
    <span class="todo-count-info">전체 : ${total}</span>
    `;
  };

  this.render();
}

export default TodoCount;
