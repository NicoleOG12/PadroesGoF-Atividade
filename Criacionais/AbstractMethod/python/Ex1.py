# PALETA DE CORES
class UI:
    reset = "\033[0m"
    bold = "\033[1m"
    pink = "\033[35m"
    purple = "\033[95m"
    white = "\033[97m"

ui = UI()

def header(titulo):
    print("\n" + ui.pink + ui.bold + "╭──────────────────────────────────╮")
    print(f"│  {titulo.ljust(30)} │")
    print("╰──────────────────────────────────╯" + ui.reset)

# PRODUTOS ABSTRATOS
class VeiculoIndividual:
    def iniciar_rota(self):
        raise NotImplementedError("iniciar_rota() deve ser implementado")

class VeiculoColetivo:
    def iniciar_rota(self):
        raise NotImplementedError("iniciar_rota() deve ser implementado")

# PRODUTO CONCRETO - TERRESTRE
class Carro(VeiculoIndividual):
    def iniciar_rota(self):
        return "🚗 Carro iniciando trajeto urbano"

class Onibus(VeiculoColetivo):
    def iniciar_rota(self):
        return "🚌 Ônibus transportando passageiros"

# PRODUTO CONCRETO - AÉREO
class Helicoptero(VeiculoIndividual):
    def iniciar_rota(self):
        return "🚁 Helicóptero decolando"

class Aviao(VeiculoColetivo):
    def iniciar_rota(self):
        return "✈️ Avião iniciando voo comercial"

# FÁBRICA ABSTRATA
class FabricaTransporte:
    def criar_veiculo_individual(self):
        raise NotImplementedError("criar_veiculo_individual() deve ser implementado")

    def criar_veiculo_coletivo(self):
        raise NotImplementedError("criar_veiculo_coletivo() deve ser implementado")

# FÁBRICAS CONCRETAS
class FabricaTerrestre(FabricaTransporte):
    def criar_veiculo_individual(self):
        return Carro()

    def criar_veiculo_coletivo(self):
        return Onibus()

class FabricaAerea(FabricaTransporte):
    def criar_veiculo_individual(self):
        return Helicoptero()

    def criar_veiculo_coletivo(self):
        return Aviao()

# CLIENTE
def iniciar_transporte(fabrica):
    individual = fabrica.criar_veiculo_individual()
    coletivo = fabrica.criar_veiculo_coletivo()

    print(ui.white + "   ➜ " + individual.iniciar_rota() + ui.reset)
    print(ui.white + "   ➜ " + coletivo.iniciar_rota() + ui.reset)
    print(ui.purple + " ────────────────────────────────" + ui.reset)

# USO
header("🌸 TRANSPORTE TERRESTRE")
iniciar_transporte(FabricaTerrestre())

header("🌸 TRANSPORTE AÉREO")
iniciar_transporte(FabricaAerea())