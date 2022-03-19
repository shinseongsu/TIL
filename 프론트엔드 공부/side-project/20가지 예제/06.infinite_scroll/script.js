(function () {
  "use strict";

  const get = function (target) {
    return document.querySelector(target);
  };

  let currentPage = 1;
  let total = 10;
  const limit = 10;
  const end = 100;

  const $posts = get(".posts");
  const $loader = get(".loader");

  const hideLoader = () => {
    $loader.classList.remove("show");
  };

  const showLoader = () => {
    $loader.classList.add("show");
  };

  const showPosts = (posts) => {
    posts.forEach((post) => {
      const $post = document.createElement("div");
      $post.classList.add("post");
      $post.innerHTML = `
            <div class="header">
              <div class="id">${post.id}.</div>
              <div class="title">${post.title}</div>
            </div>
            <div class="body">${post.body}</div>
        `;
      $posts.appendChild($post);
    });
  };

  const getPosts = async (page, limit) => {
    const API_URL = `https://jsonplaceholder.typicode.com/posts?_page=${page}&_limit=${limit}`;
    const response = await fetch(API_URL);
    if (!response.ok) {
      throw new Error("에러가 발생했습니다.");
    }
    return await response.json();
  };

  const loadPosts = async (page, limit) => {
    showLoader();
    try {
      const response = await getPosts(page, limit);
      showPosts(response);
    } catch (error) {
      console.error(error.message);
    } finally {
      hideLoader();
    }
  };

  const handleScroll = () => {
    const { scrollTop, scrollHeight, clientHeight } = document.documentElement;

    if (total === end) {
      window.removeEventListener("scroll", handleScroll);
      return;
    }

    if (scrollTop + clientHeight >= scrollHeight - 5) {
      currentPage++;
      total += 10;
      loadPosts(currentPage, limit);
      return;
    }
  };

  window.addEventListener("DOMContentLoaded", () => {
    loadPosts(currentPage, limit);
    window.addEventListener("scroll", handleScroll);
  });
})();
