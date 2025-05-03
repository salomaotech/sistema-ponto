function criarMenu() {

    const nav = document.createElement("nav");
    nav.className = "nav-bar";

    nav.innerHTML = `
        <div class="logo">
            <h1>logo</h1>
        </div>

        <div class="nav-list">
            <ul>
                <!-- Cadastro -->
                <li class="nav-item"><a href="/tela/cadastro_funcionario" class="nav-link">Cadastro de Funcionários</a></li>
                <li class="nav-item"><a href="/tela/cadastro_turno" class="nav-link">Cadastro de Turnos</a></li>
                <li class="nav-item"><a href="/tela/cadastro_justificativa" class="nav-link">Cadastro de Justificativas</a></li>
                <li class="nav-item"><a href="/tela/cadastro_ponto" class="nav-link">Cadastro de Pontos</a></li>

                <!-- Consultas -->
                <li class="nav-item"><a href="#" class="nav-link">Consultas</a></li>

                <!-- Relatórios -->
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
