# PALETA DE CORES
class UI:
    reset = "\033[0m"
    bold = "\033[1m"
    deepPurple = "\033[38;5;54m"
    violet = "\033[38;5;93m"
    white = "\033[97m"

ui = UI()

def header(titulo):
    print("\n" + ui.deepPurple + ui.bold + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓")
    print(f"┃  {titulo.ljust(30)} ┃")
    print("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + ui.reset)

def divider():
    print(ui.violet + " ────────────────────────────────" + ui.reset)

# PRODUTOS ABSTRATOS
class CartaoCredito:
    def pagar(self, valor):
        raise NotImplementedError("pagar() deve ser implementado")

class Boleto:
    def pagar(self, valor):
        raise NotImplementedError("pagar() deve ser implementado")

# PRODUTO CONCRETO - BANCO A
class CartaoBancoA(CartaoCredito):
    def pagar(self, valor):
        return f"💳 Banco A processou R$ {valor:.2f} no Cartão"

class BoletoBancoA(Boleto):
    def pagar(self, valor):
        return f"🧾 Banco A emitiu boleto de R$ {valor:.2f}"

# PRODUTO CONCRETO - BANCO B
class CartaoBancoB(CartaoCredito):
    def pagar(self, valor):
        return f"💳 Banco B autorizou R$ {valor:.2f} no Cartão"

class BoletoBancoB(Boleto):
    def pagar(self, valor):
        return f"🧾 Banco B gerou boleto de R$ {valor:.2f}"

# FÁBRICA ABSTRATA
class FabricaBanco:
    def criar_cartao(self):
        raise NotImplementedError("criar_cartao() deve ser implementado")

    def criar_boleto(self):
        raise NotImplementedError("criar_boleto() deve ser implementado")

# FÁBRICAS CONCRETAS
class FabricaBancoA(FabricaBanco):
    def criar_cartao(self):
        return CartaoBancoA()

    def criar_boleto(self):
        return BoletoBancoA()

class FabricaBancoB(FabricaBanco):
    def criar_cartao(self):
        return CartaoBancoB()

    def criar_boleto(self):
        return BoletoBancoB()

# CLIENTE
def finalizar_compra(fabrica, valor):
    cartao = fabrica.criar_cartao()
    boleto = fabrica.criar_boleto()

    print(ui.white + "   ➤ " + cartao.pagar(valor) + ui.reset)
    print(ui.white + "   ➤ " + boleto.pagar(valor) + ui.reset)
    divider()

# USO
header("🛒 LOJA ONLINE | BANCO A")
finalizar_compra(FabricaBancoA(), 420.75)

header("🛒 LOJA ONLINE | BANCO B")
finalizar_compra(FabricaBancoB(), 189.30)