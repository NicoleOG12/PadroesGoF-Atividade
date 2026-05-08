import java.util.Scanner;

class Pizza {
    String tamanho;
    String borda;
    String sabor;

    public Pizza(String tamanho, String borda, String sabor) {
        this.tamanho = tamanho;
        this.borda = borda;
        this.sabor = sabor;
    }

    public void mostrarPizza() {
        System.out.println("\n==============================================");
        System.out.println("            PIZZA MONTADA");
        System.out.println("==============================================");

        System.out.println("Tamanho: " + tamanho);
        System.out.println("Borda:   " + borda);
        System.out.println("Sabor:   " + sabor);

        System.out.println("==============================================\n");
    }
}

class SistemaAntigoPizza {

    public void enviarPedido(String tamanho, String borda, String sabor) {

        System.out.println("\n----------------------------------------------");
        System.out.println("PEDIDO ENVIADO PARA O SISTEMA ANTIGO");
        System.out.println("----------------------------------------------");

        System.out.println("Dados convertidos:");
        System.out.println(tamanho + " | " + borda + " | " + sabor);

        System.out.println("----------------------------------------------\n");
    }
}

class PizzaAdapter {
    private SistemaAntigoPizza sistemaAntigo;

    public PizzaAdapter(SistemaAntigoPizza sistemaAntigo) {
        this.sistemaAntigo = sistemaAntigo;
    }

    public void criarPizza(Pizza pizza) {
        sistemaAntigo.enviarPedido(
                pizza.tamanho,
                pizza.borda,
                pizza.sabor
        );
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void linha() {
        System.out.println("==============================================");
    }

    public static void erro() {
        System.out.println("\nOpcao invalida! Tente novamente.\n");
    }

    public static void escolherTamanho() {

        linha();
        System.out.println("\nESCOLHA O TAMANHO DA PIZZA\n");
        System.out.println("[1] Brotinho");
        System.out.println("[2] Tradicional");
        System.out.println("[3] Grande");

        System.out.print("\nDigite sua opcao: ");
        String op = sc.nextLine();

        String tamanho = "";

        switch (op) {
            case "1":
                tamanho = "Brotinho";
                break;
            case "2":
                tamanho = "Tradicional";
                break;
            case "3":
                tamanho = "Grande";
                break;
            default:
                erro();
                escolherTamanho();
                return;
        }

        escolherBorda(tamanho);
    }

    public static void escolherBorda(String tamanho) {

        linha();
        System.out.println("\nESCOLHA A BORDA\n");
        System.out.println("[1] Tradicional");
        System.out.println("[2] Catupiry");
        System.out.println("[3] Sem borda");

        System.out.print("\nDigite sua opcao: ");
        String op = sc.nextLine();

        String borda = "";

        switch (op) {
            case "1":
                borda = "Tradicional";
                break;
            case "2":
                borda = "Catupiry";
                break;
            case "3":
                borda = "Sem borda";
                break;
            default:
                erro();
                escolherBorda(tamanho);
                return;
        }

        escolherSabor(tamanho, borda);
    }

    public static void escolherSabor(String tamanho, String borda) {

        linha();
        System.out.println("\nESCOLHA O SABOR\n");
        System.out.println("[1] Calabresa");
        System.out.println("[2] Frango");
        System.out.println("[3] Portuguesa");

        System.out.print("\nDigite sua opcao: ");
        String op = sc.nextLine();

        String sabor = "";

        switch (op) {
            case "1":
                sabor = "Calabresa";
                break;
            case "2":
                sabor = "Frango";
                break;
            case "3":
                sabor = "Portuguesa";
                break;
            default:
                erro();
                escolherSabor(tamanho, borda);
                return;
        }

        Pizza pizza = new Pizza(tamanho, borda, sabor);
        pizza.mostrarPizza();

        SistemaAntigoPizza sistemaAntigo = new SistemaAntigoPizza();
        PizzaAdapter adapter = new PizzaAdapter(sistemaAntigo);

        adapter.criarPizza(pizza);

        sc.close();
    }

    public static void main(String[] args) {

        System.out.println("\n==============================================");
        System.out.println("          SISTEMA DE PIZZARIA");
        System.out.println("==============================================");

        escolherTamanho();
    }
}