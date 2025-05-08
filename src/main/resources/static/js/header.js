function criarHeader() {

    const nav = document.createElement("nav");
    nav.className = "nav-bar";

    nav.innerHTML = `
        <div class="logo">
            <h1>logo</h1>
        </div>
    `;

    const header = document.querySelector("header");

    if (header) {
        header.appendChild(nav);
    } else {
        console.error("Elemento <header> não encontrado.");
    }

}

document.addEventListener("DOMContentLoaded", criarHeader);
