import {
  AUTHOR_IMAGE,
  AUTHOR_NAME,
  POST_MAX_FILE_SIZE,
  POST_MAX_TITLE_LENGTH,
} from "./constants/upload.js";
import { requestAddPost } from "./requests/posts.js";

const $postForm = document.querySelector(".post-form");
const $coverImage = document.querySelector(".cover-image");
const $coverImageUpload = document.querySelector("#cover-image-upload");
const $coverImageReUpload = document.querySelector("#cover-image-re-upload");
const $fileReUploadWrapper = document.querySelector(".file-re-upload-wrapper");
const $titleInput = document.querySelector(".title-input");
const $contentInput = document.querySelector(".content-input");
const $currentTitleLength = document.querySelector(".current-title-length");
const $publishButton = document.querySelector(".publish-button");
const $goBackButton = document.querySelector(".go-back");

const isValidFilesSize = (file) => {
  return file.size < POST_MAX_FILE_SIZE;
};

const uploadCoverImage = (event) => {
  const [file] = event.target.files;
  if (!isValidFilesSize(file)) {
    alert(`1MB 이상의 이미지 파일을 업로드할 수 없습니다.`);
    return;
  }

  const fileReader = new FileReader();
  fileReader.readAsDataURL(file);
  fileReader.onload = (event) => {
    $coverImage.src = event.target.result;
  };

  $coverImage.style.display = "block";
  $fileReUploadWrapper.style.display = "block";
};

const markTitleLength = (event) => {
  const { value } = event.target;

  if (value.length > POST_MAX_TITLE_LENGTH) {
    alert(`${POST_MAX_TITLE_LENGTH}글자 이상의 제목을 적을 수 없습니다.`);
    return;
  }

  $currentTitleLength.innerText = value.length;
};

const addPost = async (event) => {
  event.preventDefault();

  const post = {
    title: $titleInput.value,
    content: $contentInput.value,
    image: $coverImage.src,
    author: AUTHOR_NAME,
    authorImage: AUTHOR_IMAGE,
  };

  try {
    await requestAddPost(post);
  } catch (error) {
    alert("업로드에 실패하였습니다!");
  }
};

$coverImageUpload.addEventListener("change", uploadCoverImage);
$coverImageReUpload.addEventListener("change", uploadCoverImage);
$titleInput.addEventListener("input", markTitleLength);
$postForm.addEventListener("submit", addPost);
$publishButton.addEventListener("click", () =>
  $postForm.dispatchEvent(new Event("submit"))
);
$goBackButton.addEventListener("click", () => {
  window.history.back(1);
});
