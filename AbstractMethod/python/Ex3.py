# PALETA DE CORES
class UI:
    reset = "\033[0m"
    bold = "\033[1m"
    pink = "\033[95m"
    blue = "\033[94m"
    purple = "\033[38;5;54m"
    white = "\033[97m"

ui = UI()

def header(titulo, color):
    print("\n" + color + ui.bold + "╔══════════════════════════════════╗")
    print(color + f"║  {titulo.ljust(30)} ║")
    print("╚══════════════════════════════════╝" + ui.reset)

def divider(color):
    print(color + " ────────────────────────────────" + ui.reset)

# PRODUTOS ABSTRATOS
class Botao:
    def render(self):
        raise NotImplementedError("render() deve ser implementado")

class Janela:
    def render(self):
        raise NotImplementedError("render() deve ser implementado")

# PRODUTO CONCRETO - WINDOWS
class BotaoWindows(Botao):
    def render(self):
        return "🟪 Botão estilo Windows"

class JanelaWindows(Janela):
    def render(self):
        return "🪟 Janela estilo Windows"

# PRODUTO CONCRETO - MAC
class BotaoMac(Botao):
    def render(self):
        return "⬜ Botão estilo MacOS"

class JanelaMac(Janela):
    def render(self):
        return "🖥️ Janela estilo MacOS"

# PRODUTO CONCRETO - LINUX
class BotaoLinux(Botao):
    def render(self):
        return "🟩 Botão estilo Linux"

class JanelaLinux(Janela):
    def render(self):
        return "🖥️ Janela estilo Linux"

# FÁBRICA ABSTRATA
class FabricaGUI:
    def criar_botao(self):
        raise NotImplementedError("criar_botao() deve ser implementado")

    def criar_janela(self):
        raise NotImplementedError("criar_janela() deve ser implementado")

# FÁBRICAS CONCRETAS
class FabricaWindows(FabricaGUI):
    def criar_botao(self):
        return BotaoWindows()

    def criar_janela(self):
        return JanelaWindows()

class FabricaMac(FabricaGUI):
    def criar_botao(self):
        return BotaoMac()

    def criar_janela(self):
        return JanelaMac()

class FabricaLinux(FabricaGUI):
    def criar_botao(self):
        return BotaoLinux()

    def criar_janela(self):
        return JanelaLinux()

# CLIENTE
def iniciar_sistema(fabrica, color):
    botao = fabrica.criar_botao()
    janela = fabrica.criar_janela()

    print(ui.white + "   ➤ " + botao.render() + ui.reset)
    print(ui.white + "   ➤ " + janela.render() + ui.reset)
    divider(color)

# USO
header("💻 SISTEMA WINDOWS", ui.pink)
iniciar_sistema(FabricaWindows(), ui.pink)

header("🍎 SISTEMA MAC", ui.blue)
iniciar_sistema(FabricaMac(), ui.blue)

header("🐧 SISTEMA LINUX", ui.purple)
iniciar_sistema(FabricaLinux(), ui.purple)