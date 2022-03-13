import { requestGetPosts } from "./requests/posts.js";

const $postingContainer = document.querySelector(".posting-container");

const getPostTemplate = (post) => {
  return `
    <a href="/detail.html?id=${post.id}">
    <div class="posting-wrapper">
      <div class="posting-image-container">
        <img
          src="${post.image}"
          alt="게시글 이미지"
        />
      </div>
      <h2 class="">${post.title}</h2>
      <div class="profile-wrapper">
        <div class="profile-image-container">
          <img
            class="profile-image"
            src="${post.authorImage}"
            alt="profile-image"
          />
        </div>
        <span class="profile-nickname">${post.author}</span>
      </div>
    </div>
  `;
};

const getPostsTemplate = (posts) => {
  return posts.map((post) => getPostTemplate(post)).join("");
};

requestGetPosts().then((posts) => {
  $postingContainer.innerHTML = getPostsTemplate(posts);
});
