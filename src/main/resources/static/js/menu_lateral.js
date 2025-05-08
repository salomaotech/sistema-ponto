function criarMenu() {
    const aside = document.createElement("aside");
    aside.className = "side-menu";

    aside.innerHTML = `
        <h2>Menu</h2>
        <ul>
            <li><a href="/tela/cadastro_funcionario">👥 Cadastro de Funcionários</a></li>
            <li><a href="/tela/cadastro_turno">🕒 Cadastro de Turnos</a></li>
            <li><a href="/tela/cadastro_justificativa">📝 Cadastro de Justificativas</a></li>
            <li><a href="/tela/cadastro_ponto">📌 Cadastro de Pontos</a></li>
            <li><a href="#">🔍 Consultas</a></li>
            <li><a href="#">📄 Gerar Relatório</a></li>
        </ul>
    `;

    const main = document.querySelector("main");

    if (main) {
        const container = main.querySelector(".container");
        if (container) {
            const wrapper = document.createElement("div");
            wrapper.style.display = "flex";
            wrapper.style.gap = "2rem";

            wrapper.appendChild(aside);
            wrapper.appendChild(container.cloneNode(true));
            container.replaceWith(wrapper);
        } else {
            console.error("Elemento .container não encontrado.");
        }
    } else {
        console.error("Elemento <main> não encontrado.");
    }
}

document.addEventListener("DOMContentLoaded", criarMenu);
