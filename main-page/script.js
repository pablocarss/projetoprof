// hamburguer funcional

const hamburger = document.getElementById("hamburger");
const menuLateral = document.getElementById("menu-lateral");
const overlay = document.createElement("div");
overlay.classList.add("overlay");
document.body.appendChild(overlay);

hamburger.addEventListener("click", () => {
  menuLateral.classList.toggle("active");
  overlay.classList.toggle("active");
});

overlay.addEventListener("click", () => {
  menuLateral.classList.remove("active");
  overlay.classList.remove("active");
});

// botões do main 

// curso
document.getElementById("btnCursos").addEventListener("click", () => {
  window.location.href = "../secondary-pages/main-curso/index.html";
});

// aulas
document.getElementById("btnAulas").addEventListener("click", () => {
  window.location.href = "../secondary-pages/main-aulas/index.html";
});

// notas
document.getElementById("btnNotas").addEventListener("click", () => {
  window.location.href = "../secondary-pages/main-notas/index.html";
});