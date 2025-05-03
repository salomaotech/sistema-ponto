function criarMenu() {

    const nav = document.createElement("nav");
    nav.className = "nav-bar";

    nav.innerHTML = `
        <div class="logo">
            <h1>logo</h1>
        </div>

        <div class="nav-list">
            <ul>
                <li class="nav-item"><a href="#" class="nav-link">Cadastro</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Consultas</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Gerar Relatório</a></li>
            </ul>
        </div>
    `;

    const header = document.querySelector("header");

    if (header) {

        header.appendChild(nav);

    } else {

        console.error("Elemento <header> não encontrado.");

    }

}

document.addEventListener("DOMContentLoaded", criarMenu);
