// 웹 문서의 요소를 가져오는 작업
const title = document.querySelector("#title");
const user = document.querySelectorAll(".user")[0];

const userImg = document.querySelector("#profile img");

title.onclick = function () {
  title.innerHTML = "프로필";
  title.style.backgroundColor = "black";
  title.style.color = "white";
  title.style.border = "2px solid blue";
};

user.onclick = function () {
  user.innerHTML = `이름 : <b>민들레</b>`;
};

userImg.onclick = function () {
  userImg.src = `../images/pf2.png`;
};
