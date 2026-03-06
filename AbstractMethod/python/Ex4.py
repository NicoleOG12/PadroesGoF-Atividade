# PALETA DE CORES
class UI:
    reset = "\033[0m"
    bold = "\033[1m"
    darkBlue = "\033[34m"
    gray = "\033[37m"
    white = "\033[97m"

ui = UI()

def header(titulo):
    print("\n" + ui.darkBlue + ui.bold + "╔══════════════════════════════════╗")
    print(ui.darkBlue + f"║  {titulo.ljust(30)} ║")
    print("╚══════════════════════════════════╝" + ui.reset)

def divider():
    print(ui.darkBlue + " ────────────────────────────────" + ui.reset)

# PRODUTOS ABSTRATOS
class RoboMontador:
    def operar(self):
        raise NotImplementedError("operar() deve ser implementado")

class RoboInspetor:
    def operar(self):
        raise NotImplementedError("operar() deve ser implementado")

# PRODUTO CONCRETO - LINHA AUTOMOTIVA
class MontadorAutomotivo(RoboMontador):
    def operar(self):
        return "🤖 Montador de carros operando na linha Automotiva"

class InspetorAutomotivo(RoboInspetor):
    def operar(self):
        return "🔍 Inspetor de peças automotivas verificando qualidade"

# PRODUTO CONCRETO - LINHA ELETRÔNICOS
class MontadorEletronico(RoboMontador):
    def operar(self):
        return "🤖 Montador de circuitos operando na linha Eletrônicos"

class InspetorEletronico(RoboInspetor):
    def operar(self):
        return "🔍 Inspetor de chips verificando qualidade"

# FÁBRICA ABSTRATA
class FabricaRobo:
    def criar_montador(self):
        raise NotImplementedError("criar_montador() deve ser implementado")

    def criar_inspetor(self):
        raise NotImplementedError("criar_inspetor() deve ser implementado")

# FÁBRICAS CONCRETAS
class FabricaAutomotiva(FabricaRobo):
    def criar_montador(self):
        return MontadorAutomotivo()

    def criar_inspetor(self):
        return InspetorAutomotivo()

class FabricaEletronicos(FabricaRobo):
    def criar_montador(self):
        return MontadorEletronico()

    def criar_inspetor(self):
        return InspetorEletronico()

# CLIENTE
def operar_linha(fabrica):
    montador = fabrica.criar_montador()
    inspetor = fabrica.criar_inspetor()

    print(ui.white + "   ➤ " + montador.operar() + ui.reset)
    print(ui.white + "   ➤ " + inspetor.operar() + ui.reset)
    divider()

# USO
header("LINHA AUTOMOTIVA")
operar_linha(FabricaAutomotiva())

header("LINHA ELETRÔNICOS")
operar_linha(FabricaEletronicos())