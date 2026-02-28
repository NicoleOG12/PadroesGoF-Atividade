// PALETA DE CORES
const ui = {
    reset: "\x1b[0m",
    bold: "\x1b[1m",
    deepPurple: "\x1b[38;5;54m",  
    violet: "\x1b[38;5;93m",      
    white: "\x1b[97m"
};

function header(titulo) {
    console.log("\n" + ui.deepPurple + ui.bold + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
    console.log(`┃  ${titulo.padEnd(30)} ┃`);
    console.log("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + ui.reset);
}

function divider() {
    console.log(ui.violet + "   ────────────────────────────────" + ui.reset);
}

// PRODUTOS ABSTRATOS
class CartaoCredito {
    pagar(valor) {
        throw new Error("pagar() deve ser implementado");
    }
}

class Boleto {
    pagar(valor) {
        throw new Error("pagar() deve ser implementado");
    }
}

// PRODUTO CONCRETO - BANCO A
class CartaoBancoA extends CartaoCredito {
    pagar(valor) {
        return `💳 Banco A processou R$ ${valor.toFixed(2)} no Cartão`;
    }
}

class BoletoBancoA extends Boleto {
    pagar(valor) {
        return `🧾 Banco A emitiu boleto de R$ ${valor.toFixed(2)}`;
    }
}

// PRODUTO CONCRETO - BANCO B
class CartaoBancoB extends CartaoCredito {
    pagar(valor) {
        return `💳 Banco B autorizou R$ ${valor.toFixed(2)} no Cartão`;
    }
}

class BoletoBancoB extends Boleto {
    pagar(valor) {
        return `🧾 Banco B gerou boleto de R$ ${valor.toFixed(2)}`;
    }
}

// FÁBRICA ABSTRATA
class FabricaBanco {
    criarCartao() {
        throw new Error("criarCartao() deve ser implementado");
    }

    criarBoleto() {
        throw new Error("criarBoleto() deve ser implementado");
    }
}

// FÁBRICAS CONCRETAS
class FabricaBancoA extends FabricaBanco {
    criarCartao() {
        return new CartaoBancoA();
    }

    criarBoleto() {
        return new BoletoBancoA();
    }
}

class FabricaBancoB extends FabricaBanco {
    criarCartao() {
        return new CartaoBancoB();
    }

    criarBoleto() {
        return new BoletoBancoB();
    }
}

// CLIENTE
function finalizarCompra(fabrica, valor) {
    const cartao = fabrica.criarCartao();
    const boleto = fabrica.criarBoleto();

    console.log(ui.white + "   ➤ " + cartao.pagar(valor) + ui.reset);
    console.log(ui.white + "   ➤ " + boleto.pagar(valor) + ui.reset);
    divider();
}

// USO
header("🛒 LOJA ONLINE | BANCO A");
finalizarCompra(new FabricaBancoA(), 420.75);

header("🛒 LOJA ONLINE | BANCO B");
finalizarCompra(new FabricaBancoB(), 189.30);