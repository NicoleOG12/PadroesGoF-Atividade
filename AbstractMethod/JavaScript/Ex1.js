// PALETA DE CORES
const ui = {
    reset: "\x1b[0m",
    bold: "\x1b[1m",
    pink: "\x1b[35m",  
    purple: "\x1b[95m",  
    white: "\x1b[97m"      
};

function header(titulo) {
    console.log("\n" + ui.pink + ui.bold + "╭──────────────────────────────────╮");
    console.log(`│  ${titulo.padEnd(30)} │`);
    console.log("╰──────────────────────────────────╯" + ui.reset);
}

// PRODUTOS ABSTRATOS
class VeiculoIndividual {
    iniciarRota() {
        throw new Error("iniciarRota() deve ser implementado");
    }
}

class VeiculoColetivo {
    iniciarRota() {
        throw new Error("iniciarRota() deve ser implementado");
    }
}

// PRODUTO CONCRETO - TERRESTRE
class Carro extends VeiculoIndividual {
    iniciarRota() {
        return "🚗 Carro iniciando trajeto urbano";
    }
}

class Onibus extends VeiculoColetivo {
    iniciarRota() {
        return "🚌 Ônibus transportando passageiros";
    }
}

// PRODUTO CONCRETO - AÉREO
class Helicoptero extends VeiculoIndividual {
    iniciarRota() {
        return "🚁 Helicóptero decolando";
    }
}

class Aviao extends VeiculoColetivo {
    iniciarRota() {
        return "✈️ Avião iniciando voo comercial";
    }
}

// FÁBRICA ABSTRATA
class FabricaTransporte {
    criarVeiculoIndividual() {
        throw new Error("criarVeiculoIndividual() deve ser implementado");
    }

    criarVeiculoColetivo() {
        throw new Error("criarVeiculoColetivo() deve ser implementado");
    }
}

// FÁBRICAS CONCRETAS
class FabricaTerrestre extends FabricaTransporte {
    criarVeiculoIndividual() {
        return new Carro();
    }

    criarVeiculoColetivo() {
        return new Onibus();
    }
}

class FabricaAerea extends FabricaTransporte {
    criarVeiculoIndividual() {
        return new Helicoptero();
    }

    criarVeiculoColetivo() {
        return new Aviao();
    }
}

// CLIENTE
function iniciarTransporte(fabrica) {
    const individual = fabrica.criarVeiculoIndividual();
    const coletivo = fabrica.criarVeiculoColetivo();

    console.log(ui.white + "   ➜ " + individual.iniciarRota() + ui.reset);
    console.log(ui.white + "   ➜ " + coletivo.iniciarRota() + ui.reset);
    console.log(ui.purple + "   ────────────────────────────────" + ui.reset);
}

// USO
header("🌸 TRANSPORTE TERRESTRE");
iniciarTransporte(new FabricaTerrestre());

header("🌸 TRANSPORTE AÉREO");
iniciarTransporte(new FabricaAerea());