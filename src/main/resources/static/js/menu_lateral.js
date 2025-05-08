function criarMenu() {
    const aside = document.createElement("aside");
    aside.className = "side-menu";

    aside.innerHTML = `
        <h2>Menu</h2>
        <ul>
            <li>
                <a href="/tela/cadastro_funcionario">👥 Cadastro de Funcionários</a>
                <ul>
                    <li><a href="/tela/pesquisa_funcionario">🔎 Pesquisa de Funcionário</a></li>
                </ul>
            </li>
            <li><a href="/tela/cadastro_turno">🕒 Cadastro de Turnos</a></li>
            <li><a href="/tela/cadastro_justificativa">📝 Cadastro de Justificativas</a></li>
            <li><a href="/tela/cadastro_ponto">📌 Cadastro de Pontos</a></li>
            <li><a href="#">🔍 Consultas</a></li>
            <li><a href="#">📄 Gerar Relatório</a></li>
            <li><a href="/logout">🚪 Logout</a></li>
        </ul>
    `;

    const menuLateralDiv = document.getElementById("menu-lateral");

    if (menuLateralDiv) {
        menuLateralDiv.appendChild(aside);
    } else {
        console.error("Elemento <div id='menu-lateral'> não encontrado.");
    }
}

document.addEventListener("DOMContentLoaded", criarMenu);
