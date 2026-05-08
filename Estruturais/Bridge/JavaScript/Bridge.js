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

class Borda {
    tipoBorda() {}
}

class BordaTradicional extends Borda {

    tipoBorda() {
        return "Tradicional";
    }
}

class BordaCatupiry extends Borda {

    tipoBorda() {
        return "Catupiry";
    }
}

class SemBorda extends Borda {

    tipoBorda() {
        return "Sem borda";
    }
}

class Pizza {

    constructor(borda, sabor) {
        this.borda = borda;
        this.sabor = sabor;
    }

    getTamanho() {}

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
            ui.white + this.getTamanho().padEnd(12) +
            ui.purple + " ║ " +
            ui.white + this.borda.tipoBorda().padEnd(14) +
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

class PizzaBrotinho extends Pizza {

    getTamanho() {
        return "Brotinho";
    }
}

class PizzaTradicional extends Pizza {

    getTamanho() {
        return "Tradicional";
    }
}

class PizzaGrande extends Pizza {

    getTamanho() {
        return "Grande";
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

            let tipoPizza = null;

            if (opTamanho === "1") {
                tipoPizza = PizzaBrotinho;
            }

            else if (opTamanho === "2") {
                tipoPizza = PizzaTradicional;
            }

            else if (opTamanho === "3") {
                tipoPizza = PizzaGrande;
            }

            else {
                erro();
                return escolherTamanho();
            }

            escolherBorda(tipoPizza);
        }
    );
}

function escolherBorda(tipoPizza) {

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

            let borda = null;

            if (opBorda === "1") {
                borda = new BordaTradicional();
            }

            else if (opBorda === "2") {
                borda = new BordaCatupiry();
            }

            else if (opBorda === "3") {
                borda = new SemBorda();
            }

            else {
                erro();
                return escolherBorda(tipoPizza);
            }

            escolherSabor(tipoPizza, borda);
        }
    );
}

function escolherSabor(tipoPizza, borda) {

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
                return escolherSabor(tipoPizza, borda);
            }

            const pizza = new tipoPizza(
                borda,
                sabor
            );

            pizza.mostrarPizza();

            console.log(
                ui.green +
                "\n✅ Pizza montada utilizando o padrão Bridge!\n" +
                ui.reset
            );

            rl.close();
        }
    );
}

console.clear();

console.log(
    ui.purple +
    ui.bold +
    "\n══════════════════════════════════════════════════════" +
    "\n              🍕 PIZZARIA BRIDGE 🍕                  " +
    "\n══════════════════════════════════════════════════════" +
    ui.reset
);

escolherTamanho();