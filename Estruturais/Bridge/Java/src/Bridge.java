import java.util.Scanner;

class UI {
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String PINK = "\u001B[38;5;213m";
    public static final String PURPLE = "\u001B[38;5;99m";
    public static final String WHITE = "\u001B[97m";
    public static final String GREEN = "\u001B[38;5;84m";
    public static final String RED = "\u001B[38;5;203m";
    public static final String CYAN = "\u001B[38;5;117m";
    public static final String YELLOW = "\u001B[38;5;228m";
}

interface Borda {
    String tipoBorda();
}

class BordaTradicional implements Borda {
    public String tipoBorda() {
        return "Tradicional";
    }
}

class BordaCatupiry implements Borda {
    public String tipoBorda() {
        return "Catupiry";
    }
}

class SemBorda implements Borda {
    public String tipoBorda() {
        return "Sem borda";
    }
}

abstract class Pizza {
    protected Borda borda;
    protected String sabor;

    public Pizza(Borda borda, String sabor) {
        this.borda = borda;
        this.sabor = sabor;
    }

    public abstract String getTamanho();

    public void mostrarPizza() {
        System.out.println("\n==============================");
        System.out.println("        PIZZA MONTADA");
        System.out.println("==============================");
        System.out.println("Tamanho: " + getTamanho());
        System.out.println("Borda:   " + borda.tipoBorda());
        System.out.println("Sabor:   " + sabor);
        System.out.println("==============================\n");
    }
}

class PizzaBrotinho extends Pizza {
    public PizzaBrotinho(Borda borda, String sabor) {
        super(borda, sabor);
    }

    public String getTamanho() {
        return "Brotinho";
    }
}

class PizzaTradicional extends Pizza {
    public PizzaTradicional(Borda borda, String sabor) {
        super(borda, sabor);
    }

    public String getTamanho() {
        return "Tradicional";
    }
}

class PizzaGrande extends Pizza {
    public PizzaGrande(Borda borda, String sabor) {
        super(borda, sabor);
    }

    public String getTamanho() {
        return "Grande";
    }
}

public class PizzariaBridge {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("==============================");
        System.out.println("      PIZZARIA BRIDGE");
        System.out.println("==============================");

        Class<? extends Pizza> tipoPizza = escolherTamanho();
        Borda borda = escolherBorda();
        String sabor = escolherSabor();

        Pizza pizza = criarPizza(tipoPizza, borda, sabor);
        pizza.mostrarPizza();

        System.out.println("Pizza montada com sucesso");
    }

    static Class<? extends Pizza> escolherTamanho() {

        System.out.println("\nEscolha o tamanho");
        System.out.println("1 - Brotinho");
        System.out.println("2 - Tradicional");
        System.out.println("3 - Grande");

        String op = sc.nextLine();

        if (op.equals("1")) return PizzaBrotinho.class;
        if (op.equals("2")) return PizzaTradicional.class;
        if (op.equals("3")) return PizzaGrande.class;

        System.out.println("Opcao invalida");
        return escolherTamanho();
    }

    static Borda escolherBorda() {

        System.out.println("\nEscolha a borda");
        System.out.println("1 - Tradicional");
        System.out.println("2 - Catupiry");
        System.out.println("3 - Sem borda");

        String op = sc.nextLine();

        if (op.equals("1")) return new BordaTradicional();
        if (op.equals("2")) return new BordaCatupiry();
        if (op.equals("3")) return new SemBorda();

        System.out.println("Opcao invalida");
        return escolherBorda();
    }

    static String escolherSabor() {

        System.out.println("\nEscolha o sabor");
        System.out.println("1 - Calabresa");
        System.out.println("2 - Frango");
        System.out.println("3 - Portuguesa");

        String op = sc.nextLine();

        if (op.equals("1")) return "Calabresa";
        if (op.equals("2")) return "Frango";
        if (op.equals("3")) return "Portuguesa";

        System.out.println("Opcao invalida");
        return escolherSabor();
    }

    static Pizza criarPizza(Class<? extends Pizza> tipo, Borda borda, String sabor) {
        try {
            return tipo.getConstructor(Borda.class, String.class)
                    .newInstance(borda, sabor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}