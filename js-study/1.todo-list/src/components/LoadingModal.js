function LoadingModal({ initState }) {
  this.$modal = document.createElement("div");
  this.$modal.className = "loading-modal";
  document.body.prepend(this.$modal);

  this.state = initState;
  this.setState = (newState) => {
    this.state = newState;
    this.render();
  };

  this.render = () => {
    if (this.state) {
      this.$modal.textContent = "loading...⏱";
      this.$modal.classList.add("show");
    } else {
      this.$modal.textContent = "";
      this.$modal.classList.remove("show");
    }
  };
}

export default LoadingModal;
