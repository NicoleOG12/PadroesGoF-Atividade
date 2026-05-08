class UI:
    RESET = "\033[0m"
    BOLD = "\033[1m"
    PINK = "\033[38;5;213m"
    PURPLE = "\033[38;5;99m"
    WHITE = "\033[97m"
    GREEN = "\033[38;5;84m"
    YELLOW = "\033[38;5;228m"
    RED = "\033[38;5;203m"
    CYAN = "\033[38;5;117m"


class Pizza:

    def __init__(self, tamanho, borda, sabor):
        self.tamanho = tamanho
        self.borda = borda
        self.sabor = sabor

    def mostrar_pizza(self):

        print(
            UI.PURPLE +
            "\n╔════════════════════════════════════════════════════╗" +
            UI.RESET
        )

        print(
            UI.PURPLE +
            "║               🍕 PIZZA MONTADA 🍕                ║" +
            UI.RESET
        )

        print(
            UI.PURPLE +
            "╠══════════════╦════════════════╦════════════════════╣" +
            UI.RESET
        )

        print(
            UI.PURPLE + "║ " +
            UI.YELLOW + "Tamanho".ljust(12) +
            UI.PURPLE + " ║ " +
            UI.YELLOW + "Borda".ljust(14) +
            UI.PURPLE + " ║ " +
            UI.YELLOW + "Sabor".ljust(18) +
            UI.PURPLE + " ║" +
            UI.RESET
        )

        print(
            UI.PURPLE +
            "╠══════════════╬════════════════╬════════════════════╣" +
            UI.RESET
        )

        print(
            UI.PURPLE + "║ " +
            UI.WHITE + self.tamanho.ljust(12) +
            UI.PURPLE + " ║ " +
            UI.WHITE + self.borda.ljust(14) +
            UI.PURPLE + " ║ " +
            UI.WHITE + self.sabor.ljust(18) +
            UI.PURPLE + " ║" +
            UI.RESET
        )

        print(
            UI.PURPLE +
            "╚══════════════╩════════════════╩════════════════════╝" +
            UI.RESET
        )


class SistemaAntigoPizza:

    def enviar_pedido(self, tamanho, borda, sabor):

        print(
            UI.GREEN +
            "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" +
            UI.RESET
        )

        print(
            UI.GREEN +
            UI.BOLD +
            "✅ PEDIDO ENVIADO PARA O SISTEMA ANTIGO" +
            UI.RESET
        )

        print(
            UI.WHITE +
            "\n📦 Dados convertidos:" +
            UI.RESET
        )

        print(
            UI.CYAN +
            f"➜ {tamanho} | {borda} | {sabor}" +
            UI.RESET
        )

        print(
            UI.GREEN +
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
            UI.RESET
        )


class PizzaAdapter:

    def __init__(self, sistema_antigo):
        self.sistema_antigo = sistema_antigo

    def criar_pizza(self, pizza):

        self.sistema_antigo.enviar_pedido(
            pizza.tamanho,
            pizza.borda,
            pizza.sabor
        )


def linha():

    print(
        UI.PURPLE +
        "══════════════════════════════════════════════════════" +
        UI.RESET
    )


def erro():

    print(
        UI.RED +
        "\n❌ Opção inválida! Escolha uma opção do menu.\n" +
        UI.RESET
    )


def escolher_tamanho():

    while True:

        print(
            UI.PINK +
            UI.BOLD +
            "\n🍕 ESCOLHA O TAMANHO DA PIZZA\n" +
            UI.RESET
        )

        print(UI.WHITE + "[1]" + UI.RESET + " Brotinho")
        print(UI.WHITE + "[2]" + UI.RESET + " Tradicional")
        print(UI.WHITE + "[3]" + UI.RESET + " Grande")

        opcao = input(
            UI.CYAN + "\n➜ Digite sua opção: " + UI.RESET
        )

        if opcao == "1":
            return "Brotinho"

        elif opcao == "2":
            return "Tradicional"

        elif opcao == "3":
            return "Grande"

        else:
            erro()


def escolher_borda():

    while True:

        linha()

        print(
            UI.PINK +
            UI.BOLD +
            "\n🧀 ESCOLHA A BORDA\n" +
            UI.RESET
        )

        print(UI.WHITE + "[1]" + UI.RESET + " Tradicional")
        print(UI.WHITE + "[2]" + UI.RESET + " Catupiry")
        print(UI.WHITE + "[3]" + UI.RESET + " Sem borda")

        opcao = input(
            UI.CYAN + "\n➜ Digite sua opção: " + UI.RESET
        )

        if opcao == "1":
            return "Tradicional"

        elif opcao == "2":
            return "Catupiry"

        elif opcao == "3":
            return "Sem borda"

        else:
            erro()


def escolher_sabor():

    while True:

        linha()

        print(
            UI.PINK +
            UI.BOLD +
            "\n🍕 ESCOLHA O SABOR\n" +
            UI.RESET
        )

        print(UI.WHITE + "[1]" + UI.RESET + " Calabresa")
        print(UI.WHITE + "[2]" + UI.RESET + " Frango")
        print(UI.WHITE + "[3]" + UI.RESET + " Portuguesa")

        opcao = input(
            UI.CYAN + "\n➜ Digite sua opção: " + UI.RESET
        )

        if opcao == "1":
            return "Calabresa"

        elif opcao == "2":
            return "Frango"

        elif opcao == "3":
            return "Portuguesa"

        else:
            erro()


print(
    UI.PURPLE +
    UI.BOLD +
    "\n══════════════════════════════════════════════════════" +
    "\n              🍕 PIZZARIA ADAPTER 🍕               " +
    "\n══════════════════════════════════════════════════════" +
    UI.RESET
)

tamanho = escolher_tamanho()
borda = escolher_borda()
sabor = escolher_sabor()

pizza = Pizza(
    tamanho,
    borda,
    sabor
)

pizza.mostrar_pizza()

sistema_antigo = SistemaAntigoPizza()

adapter = PizzaAdapter(
    sistema_antigo
)

adapter.criar_pizza(pizza)