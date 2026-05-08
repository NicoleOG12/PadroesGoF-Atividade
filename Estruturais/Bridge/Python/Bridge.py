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


class Borda:
    def tipo_borda(self):
        pass


class BordaTradicional(Borda):
    def tipo_borda(self):
        return "Tradicional"


class BordaCatupiry(Borda):
    def tipo_borda(self):
        return "Catupiry"


class SemBorda(Borda):
    def tipo_borda(self):
        return "Sem borda"


class Pizza:
    def __init__(self, borda, sabor):
        self.borda = borda
        self.sabor = sabor

    def get_tamanho(self):
        pass

    def mostrar_pizza(self):

        print(UI.PURPLE + "\n╔════════════════════════════════════════════════════╗" + UI.RESET)
        print(UI.PURPLE + "║               🍕 PIZZA MONTADA 🍕                ║" + UI.RESET)
        print(UI.PURPLE + "╠══════════════╦════════════════╦════════════════════╣" + UI.RESET)

        print(
            UI.PURPLE + "║ " +
            UI.YELLOW + "Tamanho".ljust(12) +
            UI.PURPLE + " ║ " +
            UI.YELLOW + "Borda".ljust(14) +
            UI.PURPLE + " ║ " +
            UI.YELLOW + "Sabor".ljust(18) +
            UI.RESET
        )

        print(UI.PURPLE + "╠══════════════╬════════════════╬════════════════════╣" + UI.RESET)

        print(
            UI.PURPLE + "║ " +
            UI.WHITE + self.get_tamanho().ljust(12) +
            UI.PURPLE + " ║ " +
            UI.WHITE + self.borda.tipo_borda().ljust(14) +
            UI.PURPLE + " ║ " +
            UI.WHITE + self.sabor.ljust(18) +
            UI.RESET
        )

        print(UI.PURPLE + "╚══════════════╩════════════════╩════════════════════╝" + UI.RESET)


class PizzaBrotinho(Pizza):
    def get_tamanho(self):
        return "Brotinho"


class PizzaTradicional(Pizza):
    def get_tamanho(self):
        return "Tradicional"


class PizzaGrande(Pizza):
    def get_tamanho(self):
        return "Grande"


def linha():
    print(UI.PURPLE + "══════════════════════════════════════════════════════" + UI.RESET)


def erro():
    print(UI.RED + "\n❌ Opção inválida! Escolha uma opção do menu.\n" + UI.RESET)


def escolher_tamanho():

    print(UI.PINK + UI.BOLD + "\n🍕 ESCOLHA O TAMANHO DA PIZZA\n" + UI.RESET)
    print(UI.WHITE + "[1]" + UI.RESET + " Brotinho")
    print(UI.WHITE + "[2]" + UI.RESET + " Tradicional")
    print(UI.WHITE + "[3]" + UI.RESET + " Grande")

    op = input(UI.CYAN + "\n➜ Digite sua opção: " + UI.RESET)

    if op == "1":
        return PizzaBrotinho
    elif op == "2":
        return PizzaTradicional
    elif op == "3":
        return PizzaGrande
    else:
        erro()
        return escolher_tamanho()


def escolher_borda():

    linha()

    print(UI.PINK + UI.BOLD + "\n🧀 ESCOLHA A BORDA\n" + UI.RESET)
    print(UI.WHITE + "[1]" + UI.RESET + " Tradicional")
    print(UI.WHITE + "[2]" + UI.RESET + " Catupiry")
    print(UI.WHITE + "[3]" + UI.RESET + " Sem borda")

    op = input(UI.CYAN + "\n➜ Digite sua opção: " + UI.RESET)

    if op == "1":
        return BordaTradicional()
    elif op == "2":
        return BordaCatupiry()
    elif op == "3":
        return SemBorda()
    else:
        erro()
        return escolher_borda()


def escolher_sabor(tipo_pizza, borda):

    linha()

    print(UI.PINK + UI.BOLD + "\n🍕 ESCOLHA O SABOR\n" + UI.RESET)
    print(UI.WHITE + "[1]" + UI.RESET + " Calabresa")
    print(UI.WHITE + "[2]" + UI.RESET + " Frango")
    print(UI.WHITE + "[3]" + UI.RESET + " Portuguesa")

    op = input(UI.CYAN + "\n➜ Digite sua opção: " + UI.RESET)

    if op == "1":
        sabor = "Calabresa"
    elif op == "2":
        sabor = "Frango"
    elif op == "3":
        sabor = "Portuguesa"
    else:
        erro()
        return escolher_sabor(tipo_pizza, borda)

    pizza = tipo_pizza(borda, sabor)
    pizza.mostrar_pizza()

    print(UI.GREEN + "\n✅ Pizza montada utilizando o padrão Bridge!\n" + UI.RESET)


print(UI.PURPLE + UI.BOLD +
      "\n══════════════════════════════════════════════════════" +
      "\n              🍕 PIZZARIA BRIDGE 🍕                  " +
      "\n══════════════════════════════════════════════════════" +
      UI.RESET)

tipo_pizza = escolher_tamanho()
borda = escolher_borda()
escolher_sabor(tipo_pizza, borda)