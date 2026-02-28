// PALETA DE CORES - HEADER
class UI {
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String DARK_BLUE = "\u001B[34m";
    public static final String WHITE = "\u001B[97m";

    public static void header(String titulo) {
        int totalWidth = 34;
        int padding = (totalWidth - titulo.length()) / 2;
        String leftPad = " ".repeat(Math.max(0, padding));
        String rightPad = " ".repeat(Math.max(0, totalWidth - titulo.length() - padding));

        System.out.println("\n" + DARK_BLUE + BOLD + "+---------------------------------+");
        System.out.println(DARK_BLUE + "|" + leftPad + titulo + rightPad + "|" + RESET);
        System.out.println(DARK_BLUE + "+---------------------------------+" + RESET);
    }

    public static void divider() {
        System.out.println(DARK_BLUE + " ---------------------------------" + RESET);
    }
}

// PRODUTOS ABSTRATOS
abstract class RoboMontador {
    public abstract String operar();
}

abstract class RoboInspetor {
    public abstract String operar();
}

// PRODUTO CONCRETO - LINHA AUTOMOTIVA
class MontadorAutomotivo extends RoboMontador {
    @Override
    public String operar() {
        return "Montador de carros operando na linha Automotiva";
    }
}

class InspetorAutomotivo extends RoboInspetor {
    @Override
    public String operar() {
        return "Inspetor de peças automotivas verificando qualidade";
    }
}

// PRODUTO CONCRETO - LINHA ELETRÔNICOS
class MontadorEletronico extends RoboMontador {
    @Override
    public String operar() {
        return "Montador de circuitos operando na linha Eletrônicos";
    }
}

class InspetorEletronico extends RoboInspetor {
    @Override
    public String operar() {
        return "Inspetor de chips verificando qualidade";
    }
}

// FÁBRICA ABSTRATA
abstract class FabricaRobo {
    public abstract RoboMontador criarMontador();
    public abstract RoboInspetor criarInspetor();
}

// FÁBRICAS CONCRETAS
class FabricaAutomotiva extends FabricaRobo {
    @Override
    public RoboMontador criarMontador() {
        return new MontadorAutomotivo();
    }

    @Override
    public RoboInspetor criarInspetor() {
        return new InspetorAutomotivo();
    }
}

class FabricaEletronicos extends FabricaRobo {
    @Override
    public RoboMontador criarMontador() {
        return new MontadorEletronico();
    }

    @Override
    public RoboInspetor criarInspetor() {
        return new InspetorEletronico();
    }
}

// CLIENTE
public class Ex4 {
    public static void operarLinha(FabricaRobo fabrica) {
        RoboMontador montador = fabrica.criarMontador();
        RoboInspetor inspetor = fabrica.criarInspetor();

        System.out.println(UI.WHITE + " -> " + montador.operar() + UI.RESET);
        System.out.println(UI.WHITE + " -> " + inspetor.operar() + UI.RESET);
        UI.divider();
    }

    public static void main(String[] args) {
        UI.header("LINHA AUTOMOTIVA");
        operarLinha(new FabricaAutomotiva());

        UI.header("LINHA ELETRONICOS");
        operarLinha(new FabricaEletronicos());
    }
}