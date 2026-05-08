const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const ui = {
    reset: "\x1b[0m",
    bold: "\x1b[1m",
    pink: "\x1b[38;5;213m",
    purple: "\x1b[38;5;99m",
    white: "\x1b[97m",
    green: "\x1b[38;5;84m",
    yellow: "\x1b[38;5;228m",
    red: "\x1b[38;5;203m",
    cyan: "\x1b[38;5;117m"
};

class Pizza {
    constructor(tamanho, borda, sabor) {
        this.tamanho = tamanho;
        this.borda = borda;
        this.sabor = sabor;
    }

    mostrarPizza() {

        console.log(
            ui.purple +
            "\n╔════════════════════════════════════════════════════╗" +
            ui.reset
        );

        console.log(
            ui.purple +
            "║               🍕 PIZZA MONTADA 🍕                ║" +
            ui.reset
        );

        console.log(
            ui.purple +
            "╠══════════════╦════════════════╦════════════════════╣" +
            ui.reset
        );

        console.log(
            ui.purple + "║ " +
            ui.yellow + "Tamanho".padEnd(12) +
            ui.purple + " ║ " +
            ui.yellow + "Borda".padEnd(14) +
            ui.purple + " ║ " +
            ui.yellow + "Sabor".padEnd(18) +
            ui.purple + " ║" +
            ui.reset
        );

        console.log(
            ui.purple +
            "╠══════════════╬════════════════╬════════════════════╣" +
            ui.reset
        );

        console.log(
            ui.purple + "║ " +
            ui.white + this.tamanho.padEnd(12) +
            ui.purple + " ║ " +
            ui.white + this.borda.padEnd(14) +
            ui.purple + " ║ " +
            ui.white + this.sabor.padEnd(18) +
            ui.purple + " ║" +
            ui.reset
        );

        console.log(
            ui.purple +
            "╚══════════════╩════════════════╩════════════════════╝" +
            ui.reset
        );
    }
}

class SistemaAntigoPizza {

    enviarPedido(tamanho, borda, sabor) {

        console.log(
            ui.green +
            "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" +
            ui.reset
        );

        console.log(
            ui.green +
            ui.bold +
            "✅ PEDIDO ENVIADO PARA O SISTEMA ANTIGO" +
            ui.reset
        );

        console.log(
            ui.white +
            "\n📦 Dados convertidos:" +
            ui.reset
        );

        console.log(
            ui.cyan +
            "➜ " + tamanho +
            " | " + borda +
            " | " + sabor +
            ui.reset
        );

        console.log(
            ui.green +
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
            ui.reset
        );
    }
}

class PizzaAdapter {

    constructor(sistemaAntigo) {
        this.sistemaAntigo = sistemaAntigo;
    }

    criarPizza(pizza) {
        this.sistemaAntigo.enviarPedido(
            pizza.tamanho,
            pizza.borda,
            pizza.sabor
        );
    }
}

function linha() {

    console.log(
        ui.purple +
        "══════════════════════════════════════════════════════" +
        ui.reset
    );
}

function erro() {

    console.log(
        ui.red +
        "\n❌ Opção inválida! Escolha uma opção do menu.\n" +
        ui.reset
    );
}

function escolherTamanho() {

    console.log(
        ui.pink +
        ui.bold +
        "\n🍕 ESCOLHA O TAMANHO DA PIZZA\n" +
        ui.reset
    );

    console.log(ui.white + "[1]" + ui.reset + " Brotinho");
    console.log(ui.white + "[2]" + ui.reset + " Tradicional");
    console.log(ui.white + "[3]" + ui.reset + " Grande");

    rl.question(
        ui.cyan + "\n➜ Digite sua opção: " + ui.reset,
        (opTamanho) => {

            let tamanho = "";

            if (opTamanho === "1") {
                tamanho = "Brotinho";
            }

            else if (opTamanho === "2") {
                tamanho = "Tradicional";
            }

            else if (opTamanho === "3") {
                tamanho = "Grande";
            }

            else {
                erro();
                return escolherTamanho();
            }

            escolherBorda(tamanho);
        }
    );
}

function escolherBorda(tamanho) {

    linha();

    console.log(
        ui.pink +
        ui.bold +
        "\n🧀 ESCOLHA A BORDA\n" +
        ui.reset
    );

    console.log(ui.white + "[1]" + ui.reset + " Tradicional");
    console.log(ui.white + "[2]" + ui.reset + " Catupiry");
    console.log(ui.white + "[3]" + ui.reset + " Sem borda");

    rl.question(
        ui.cyan + "\n➜ Digite sua opção: " + ui.reset,
        (opBorda) => {

            let borda = "";

            if (opBorda === "1") {
                borda = "Tradicional";
            }

            else if (opBorda === "2") {
                borda = "Catupiry";
            }

            else if (opBorda === "3") {
                borda = "Sem borda";
            }

            else {
                erro();
                return escolherBorda(tamanho);
            }

            escolherSabor(tamanho, borda);
        }
    );
}

function escolherSabor(tamanho, borda) {

    linha();

    console.log(
        ui.pink +
        ui.bold +
        "\n🍕 ESCOLHA O SABOR\n" +
        ui.reset
    );

    console.log(ui.white + "[1]" + ui.reset + " Calabresa");
    console.log(ui.white + "[2]" + ui.reset + " Frango");
    console.log(ui.white + "[3]" + ui.reset + " Portuguesa");

    rl.question(
        ui.cyan + "\n➜ Digite sua opção: " + ui.reset,
        (opSabor) => {

            let sabor = "";

            if (opSabor === "1") {
                sabor = "Calabresa";
            }

            else if (opSabor === "2") {
                sabor = "Frango";
            }

            else if (opSabor === "3") {
                sabor = "Portuguesa";
            }

            else {
                erro();
                return escolherSabor(tamanho, borda);
            }

            const pizza = new Pizza(
                tamanho,
                borda,
                sabor
            );

            pizza.mostrarPizza();

            const sistemaAntigo = new SistemaAntigoPizza();

            const adapter = new PizzaAdapter(
                sistemaAntigo
            );

            adapter.criarPizza(pizza);

            rl.close();
        }
    );
}

console.clear();

console.log(
    ui.purple +
    ui.bold +
    "\n══════════════════════════════════════════════════════" +
    "\n              🍕 PIZZARIA ADAPTER 🍕                   " +
    "\n══════════════════════════════════════════════════════" +
    ui.reset
);

escolherTamanho();