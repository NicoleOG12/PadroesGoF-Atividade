// PALETA DE CORES
const ui = {
    reset: "\x1b[0m",
    bold: "\x1b[1m",
    pink: "\x1b[95m",     
    blue: "\x1b[94m",     
    purple: "\x1b[38;5;54m",   
    white: "\x1b[97m"
};

function header(titulo, color) {
    console.log("\n" + color + ui.bold + "╔══════════════════════════════════╗");
    console.log(color + `║  ${titulo.padEnd(30)} ║`);
    console.log("╚══════════════════════════════════╝" + ui.reset);
}

function divider(color) {
    console.log(color + "   ────────────────────────────────" + ui.reset);
}

// PRODUTOS ABSTRATOS
class Botao {
    render() { throw new Error("render() deve ser implementado"); }
}

class Janela {
    render() { throw new Error("render() deve ser implementado"); }
}

// PRODUTO CONCRETO -  WINDOWS
class BotaoWindows extends Botao {
    render() { return "🟪 Botão estilo Windows"; }
}

class JanelaWindows extends Janela {
    render() { return "🪟 Janela estilo Windows"; }
}

// PRODUTO CONCRETO -  MAC
class BotaoMac extends Botao {
    render() { return "⬜ Botão estilo MacOS"; }
}

class JanelaMac extends Janela {
    render() { return "🖥️ Janela estilo MacOS"; }
}

// PRODUTO CONCRETO - LINUX
class BotaoLinux extends Botao {
    render() { return "🟩 Botão estilo Linux"; }
}

class JanelaLinux extends Janela {
    render() { return "🖥️ Janela estilo Linux"; }
}

// FÁBRICA ABSTRATA
class FabricaGUI {
    criarBotao() { throw new Error("criarBotao() deve ser implementado"); }
    criarJanela() { throw new Error("criarJanela() deve ser implementado"); }
}

// FÁBRICAS CONCRETAS
class FabricaWindows extends FabricaGUI {
    criarBotao() { return new BotaoWindows(); }
    criarJanela() { return new JanelaWindows(); }
}

class FabricaMac extends FabricaGUI {
    criarBotao() { return new BotaoMac(); }
    criarJanela() { return new JanelaMac(); }
}

class FabricaLinux extends FabricaGUI {
    criarBotao() { return new BotaoLinux(); }
    criarJanela() { return new JanelaLinux(); }
}

// CLIENTE
function iniciarSistema(fabrica, color) {
    const botao = fabrica.criarBotao();
    const janela = fabrica.criarJanela();

    console.log(ui.white + "   ➤ " + botao.render() + ui.reset);
    console.log(ui.white + "   ➤ " + janela.render() + ui.reset);
    divider(color);
}

// USO
header("💻 SISTEMA WINDOWS", ui.pink);
iniciarSistema(new FabricaWindows(), ui.pink);

header("🍎 SISTEMA MAC", ui.blue);
iniciarSistema(new FabricaMac(), ui.blue);

header("🐧 SISTEMA LINUX", ui.purple);
iniciarSistema(new FabricaLinux(), ui.purple);