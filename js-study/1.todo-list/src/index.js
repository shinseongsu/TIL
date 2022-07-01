import App from "./components/App.js";

new App({
  $target: document.querySelector("#app"),
  initState: {
    isLoading: false,
    currentUserName: "test",
  },
});
