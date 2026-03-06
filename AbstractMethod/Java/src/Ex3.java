// PALETA DE CORES - HEADER
class UI {
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String PINK = "\u001B[95m";
    public static final String BLUE = "\u001B[94m";
    public static final String VIOLET = "\u001B[38;5;93m";
    public static final String WHITE = "\u001B[97m";

    public static void header(String titulo, String color) {
        int totalWidth = 34; 
        int padding = (totalWidth - titulo.length()) / 2;
        String leftPad = " ".repeat(Math.max(0, padding));
        String rightPad = " ".repeat(Math.max(0, totalWidth - titulo.length() - padding));

        System.out.println("\n" + color + BOLD + "+---------------------------------+");
        System.out.println(color + "|" + leftPad + titulo + rightPad + "|" + RESET);
        System.out.println(color + "+---------------------------------+" + RESET);
    }

    public static void divider(String color) {
        System.out.println(color + " ---------------------------------" + RESET);
    }
}

// PRODUTOS ABSTRATOS
abstract class Botao {
    public abstract String render();
}

abstract class Janela {
    public abstract String render();
}

// PRODUTOS CONCRETOS - WINDOWS
class BotaoWindows extends Botao {
    @Override
    public String render() {
        return "Botao estilo Windows";
    }
}

class JanelaWindows extends Janela {
    @Override
    public String render() {
        return "Janela estilo Windows";
    }
}

// PRODUTOS CONCRETOS - MAC
class BotaoMac extends Botao {
    @Override
    public String render() {
        return "Botao estilo MacOS";
    }
}

class JanelaMac extends Janela {
    @Override
    public String render() {
        return "Janela estilo MacOS";
    }
}

// PRODUTOS CONCRETOS - LINUX
class BotaoLinux extends Botao {
    @Override
    public String render() {
        return "Botao estilo Linux";
    }
}

class JanelaLinux extends Janela {
    @Override
    public String render() {
        return "Janela estilo Linux";
    }
}

// FÁBRICA ABSTRATA
abstract class FabricaGUI {
    public abstract Botao criarBotao();
    public abstract Janela criarJanela();
}

// FÁBRICAS CONCRETAS
class FabricaWindows extends FabricaGUI {
    @Override
    public Botao criarBotao() {
        return new BotaoWindows();
    }

    @Override
    public Janela criarJanela() {
        return new JanelaWindows();
    }
}

class FabricaMac extends FabricaGUI {
    @Override
    public Botao criarBotao() {
        return new BotaoMac();
    }

    @Override
    public Janela criarJanela() {
        return new JanelaMac();
    }
}

class FabricaLinux extends FabricaGUI {
    @Override
    public Botao criarBotao() {
        return new BotaoLinux();
    }

    @Override
    public Janela criarJanela() {
        return new JanelaLinux();
    }
}

// CLIENTE
public class Ex3 {
    public static void iniciarSistema(FabricaGUI fabrica, String color) {
        Botao botao = fabrica.criarBotao();
        Janela janela = fabrica.criarJanela();

        System.out.println(UI.WHITE + " -> " + botao.render() + UI.RESET);
        System.out.println(UI.WHITE + " -> " + janela.render() + UI.RESET);
        UI.divider(color);
    }

    public static void main(String[] args) {
        UI.header("SISTEMA WINDOWS", UI.PINK);
        iniciarSistema(new FabricaWindows(), UI.PINK);

        UI.header("SISTEMA MAC", UI.BLUE);
        iniciarSistema(new FabricaMac(), UI.BLUE);

        UI.header("SISTEMA LINUX", UI.VIOLET);
        iniciarSistema(new FabricaLinux(), UI.VIOLET);
    }
}