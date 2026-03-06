// PALETA DE CORES - HEADER
class UI {
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String PINK = "\u001B[35m";
    public static final String WHITE = "\u001B[97m";

    public static void header(String titulo) {
        int totalWidth = 33; 
        int padding = (totalWidth - titulo.length()) / 2;
        String leftPad = " ".repeat(Math.max(0, padding));
        String rightPad = " ".repeat(Math.max(0, totalWidth - titulo.length() - padding));
        
        System.out.println("\n" + PINK + BOLD + "+---------------------------------+");
        System.out.println(PINK + "|" + leftPad + titulo + rightPad + "|" + RESET);
        System.out.println(PINK + "+---------------------------------+" + RESET);
    }
}

// PRODUTOS ABSTRATOS
abstract class VeiculoIndividual {
    public abstract String iniciarRota();
}

abstract class VeiculoColetivo {
    public abstract String iniciarRota();
}

// PRODUTOS CONCRETOS - TERRESTRE
class Carro extends VeiculoIndividual {
    @Override
    public String iniciarRota() {
        return "Carro iniciando trajeto urbano";
    }
}

class Onibus extends VeiculoColetivo {
    @Override
    public String iniciarRota() {
        return "Onibus transportando passageiros";
    }
}

// PRODUTOS CONCRETOS - AEREO
class Helicoptero extends VeiculoIndividual {
    @Override
    public String iniciarRota() {
        return "Helicoptero decolando";
    }
}

class Aviao extends VeiculoColetivo {
    @Override
    public String iniciarRota() {
        return "Aviao iniciando voo comercial";
    }
}

// FABRICA ABSTRATA
abstract class FabricaTransporte {
    public abstract VeiculoIndividual criarVeiculoIndividual();
    public abstract VeiculoColetivo criarVeiculoColetivo();
}

// FABRICAS CONCRETAS
class FabricaTerrestre extends FabricaTransporte {
    @Override
    public VeiculoIndividual criarVeiculoIndividual() {
        return new Carro();
    }

    @Override
    public VeiculoColetivo criarVeiculoColetivo() {
        return new Onibus();
    }
}

class FabricaAerea extends FabricaTransporte {
    @Override
    public VeiculoIndividual criarVeiculoIndividual() {
        return new Helicoptero();
    }

    @Override
    public VeiculoColetivo criarVeiculoColetivo() {
        return new Aviao();
    }
}

// CLIENTE
public class Ex1 {
    public static void iniciarTransporte(FabricaTransporte fabrica) {
        VeiculoIndividual individual = fabrica.criarVeiculoIndividual();
        VeiculoColetivo coletivo = fabrica.criarVeiculoColetivo();

        System.out.println(UI.WHITE + " -> " + individual.iniciarRota() + UI.RESET);
        System.out.println(UI.WHITE + " -> " + coletivo.iniciarRota() + UI.RESET);
        System.out.println(UI.PINK + " ---------------------------------" + UI.RESET);
    }

    public static void main(String[] args) {
        UI.header("TRANSPORTE TERRESTRE");
        iniciarTransporte(new FabricaTerrestre());

        UI.header("TRANSPORTE AEREO");
        iniciarTransporte(new FabricaAerea());
    }
}