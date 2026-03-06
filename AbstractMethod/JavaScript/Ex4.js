// PALETA DE CORES
const ui = {
    reset: "\x1b[0m",
    bold: "\x1b[1m",
    darkBlue: "\x1b[34m",
    white: "\x1b[97m"
};

function header(titulo) {
    console.log("\n" + ui.darkBlue + ui.bold + "╔══════════════════════════════════╗");
    console.log(ui.darkBlue + `║  ${titulo.padEnd(30)} ║`);
    console.log("╚══════════════════════════════════╝" + ui.reset);
}

function divider() {
    console.log(ui.darkBlue + " ────────────────────────────────" + ui.reset);
}

// PRODUTOS ABSTRATOS
class RoboMontador {
    operar() {
        throw new Error("operar() deve ser implementado");
    }
}

class RoboInspetor {
    operar() {
        throw new Error("operar() deve ser implementado");
    }
}

// PRODUTO CONCRETO - LINHA AUTOMOTIVA
class MontadorAutomotivo extends RoboMontador {
    operar() {
        return "🤖 Montador de carros operando na linha Automotiva";
    }
}

class InspetorAutomotivo extends RoboInspetor {
    operar() {
        return "🔍 Inspetor de peças automotivas verificando qualidade";
    }
}

// PRODUTO CONCRETO - LINHA ELETRÔNICOS
class MontadorEletronico extends RoboMontador {
    operar() {
        return "🤖 Montador de circuitos operando na linha Eletrônicos";
    }
}

class InspetorEletronico extends RoboInspetor {
    operar() {
        return "🔍 Inspetor de chips verificando qualidade";
    }
}

// FÁBRICA ABSTRATA
class FabricaRobo {
    criarMontador() {
        throw new Error("criarMontador() deve ser implementado");
    }
    criarInspetor() {
        throw new Error("criarInspetor() deve ser implementado");
    }
}

// FÁBRICAS CONCRETAS
class FabricaAutomotiva extends FabricaRobo {
    criarMontador() { return new MontadorAutomotivo(); }
    criarInspetor() { return new InspetorAutomotivo(); }
}

class FabricaEletronicos extends FabricaRobo {
    criarMontador() { return new MontadorEletronico(); }
    criarInspetor() { return new InspetorEletronico(); }
}

// CLIENTE
function operarLinha(fabrica) {
    const montador = fabrica.criarMontador();
    const inspetor = fabrica.criarInspetor();

    console.log(ui.white + "   ➤ " + montador.operar() + ui.reset);
    console.log(ui.white + "   ➤ " + inspetor.operar() + ui.reset);
    divider();
}

// USO
header("LINHA AUTOMOTIVA");
operarLinha(new FabricaAutomotiva());

header("LINHA ELETRÔNICOS");
operarLinha(new FabricaEletronicos());