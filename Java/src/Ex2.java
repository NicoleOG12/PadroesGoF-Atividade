// PALETA DE CORES - HEADER
class UI {
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String VIOLET = "\u001B[38;5;93m";
    public static final String WHITE = "\u001B[97m";

    public static void header(String titulo) {
        int totalWidth = 34; 
        int padding = (totalWidth - titulo.length()) / 2;
        String leftPad = " ".repeat(Math.max(0, padding));
        String rightPad = " ".repeat(Math.max(0, totalWidth - titulo.length() - padding));

        System.out.println("\n" + VIOLET + BOLD + "+---------------------------------+");
        System.out.println(VIOLET + "|" + leftPad + titulo + rightPad + "|" + RESET);
        System.out.println(VIOLET + "+---------------------------------+" + RESET);
    }
}

// PRODUTOS ABSTRATOS
abstract class CartaoCredito {
    public abstract String pagar(double valor);
}

abstract class Boleto {
    public abstract String pagar(double valor);
}

// PRODUTOS CONCRETOS - BANCO A
class CartaoBancoA extends CartaoCredito {
    @Override
    public String pagar(double valor) {
        return "Banco A processou R$ " + String.format("%.2f", valor) + " no Cartao";
    }
}

class BoletoBancoA extends Boleto {
    @Override
    public String pagar(double valor) {
        return "Banco A emitiu boleto de R$ " + String.format("%.2f", valor);
    }
}

// PRODUTOS CONCRETOS - BANCO B
class CartaoBancoB extends CartaoCredito {
    @Override
    public String pagar(double valor) {
        return "Banco B autorizou R$ " + String.format("%.2f", valor) + " no Cartao";
    }
}

class BoletoBancoB extends Boleto {
    @Override
    public String pagar(double valor) {
        return "Banco B gerou boleto de R$ " + String.format("%.2f", valor);
    }
}

// FABRICA ABSTRATA
abstract class FabricaBanco {
    public abstract CartaoCredito criarCartao();
    public abstract Boleto criarBoleto();
}

// FABRICAS CONCRETAS
class FabricaBancoA extends FabricaBanco {
    @Override
    public CartaoCredito criarCartao() {
        return new CartaoBancoA();
    }

    @Override
    public Boleto criarBoleto() {
        return new BoletoBancoA();
    }
}

class FabricaBancoB extends FabricaBanco {
    @Override
    public CartaoCredito criarCartao() {
        return new CartaoBancoB();
    }

    @Override
    public Boleto criarBoleto() {
        return new BoletoBancoB();
    }
}

// CLIENTE
public class Ex2 {
    public static void finalizarCompra(FabricaBanco fabrica, double valor) {
        CartaoCredito cartao = fabrica.criarCartao();
        Boleto boleto = fabrica.criarBoleto();

        System.out.println(UI.WHITE + " -> " + cartao.pagar(valor) + UI.RESET);
        System.out.println(UI.WHITE + " -> " + boleto.pagar(valor) + UI.RESET);
        System.out.println(UI.VIOLET + " ---------------------------------" + UI.RESET);
    }

    public static void main(String[] args) {
        UI.header("LOJA ONLINE | BANCO A");
        finalizarCompra(new FabricaBancoA(), 420.75);

        UI.header("LOJA ONLINE | BANCO B");
        finalizarCompra(new FabricaBancoB(), 189.30);
    }
}