# PALETA DE CORES
ui = {
    "reset": "\033[0m",
    "bold": "\033[1m",
    "pink": "\033[35m",
    "purple": "\033[38;5;54m",
    "white": "\033[97m"
}

# Classe base de Pessoa
class Pessoa:
    def __init__(self, nome, cargo, matricula, hora_entrada, hora_saida):
        self.nome = nome
        self.cargo = cargo
        self.matricula = matricula
        self.hora_entrada = hora_entrada
        self.hora_saida = hora_saida

    def mostrar_detalhes(self):
        print(
            f"{ui['purple']}│ "
            f"{ui['white']}{self.nome.ljust(12)}"
            f"{ui['purple']} │ "
            f"{ui['white']}{self.cargo.ljust(14)}"
            f"{ui['purple']} │ "
            f"{ui['white']}{str(self.matricula).ljust(10)}"
            f"{ui['purple']} │ "
            f"{ui['white']}{self.hora_entrada.ljust(8)}"
            f"{ui['purple']} │ "
            f"{ui['white']}{self.hora_saida.ljust(8)}"
            f"{ui['purple']} │"
            f"{ui['reset']}"
        )

# Builder base
class PessoaBuilder:
    def __init__(self):
        self.nome = ""
        self.cargo = ""
        self.matricula = ""
        self.hora_entrada = ""
        self.hora_saida = ""

    def set_nome(self, nome):
        self.nome = nome
        return self

    def set_matricula(self, matricula):
        self.matricula = matricula
        return self

    def set_hora_entrada(self, hora):
        self.hora_entrada = hora
        return self

    def set_hora_saida(self, hora):
        self.hora_saida = hora
        return self

    def construir(self):
        return Pessoa(
            self.nome,
            self.cargo,
            self.matricula,
            self.hora_entrada,
            self.hora_saida
        )

# Builders específicos
class AlunoBuilder(PessoaBuilder):
    def __init__(self):
        super().__init__()
        self.cargo = "Aluno"

class ProfessorBuilder(PessoaBuilder):
    def __init__(self):
        super().__init__()
        self.cargo = "Professor"

class AdministradorBuilder(PessoaBuilder):
    def __init__(self):
        super().__init__()
        self.cargo = "Administrador"

class VisitanteBuilder(PessoaBuilder):
    def __init__(self):
        super().__init__()
        self.cargo = "Visitante"

# Uso
aluno = (AlunoBuilder()
         .set_nome("Carlos")
         .set_matricula(1234)
         .set_hora_entrada("08:00")
         .set_hora_saida("12:00")
         .construir())

professor = (ProfessorBuilder()
             .set_nome("Ana")
             .set_matricula(5678)
             .set_hora_entrada("09:00")
             .set_hora_saida("17:00")
             .construir())

administrador = (AdministradorBuilder()
                 .set_nome("João")
                 .set_matricula(4321)
                 .set_hora_entrada("07:00")
                 .set_hora_saida("15:00")
                 .construir())

visitante = (VisitanteBuilder()
             .set_nome("Maria")
             .set_matricula("-")
             .set_hora_entrada("10:00")
             .set_hora_saida("12:00")
             .construir())

print(f"{ui['purple']}{ui['bold']}\n════════════════════════ SISTEMA DE PESSOAS ════════════════════════{ui['reset']}")
print(f"{ui['purple']}┌──────────────┬────────────────┬────────────┬──────────┬──────────┐{ui['reset']}")
print(f"{ui['purple']}│ "
      f"{ui['pink']}{'Nome'.ljust(12)}"
      f"{ui['purple']} │ "
      f"{ui['pink']}{'Cargo'.ljust(14)}"
      f"{ui['purple']} │ "
      f"{ui['pink']}{'Matrícula'.ljust(10)}"
      f"{ui['purple']} │ "
      f"{ui['pink']}{'Entrada'.ljust(8)}"
      f"{ui['purple']} │ "
      f"{ui['pink']}{'Saída'.ljust(8)}"
      f"{ui['purple']} │{ui['reset']}")
print(f"{ui['purple']}├──────────────┼────────────────┼────────────┼──────────┼──────────┤{ui['reset']}")

aluno.mostrar_detalhes()
professor.mostrar_detalhes()
administrador.mostrar_detalhes()
visitante.mostrar_detalhes()

print(f"{ui['purple']}└──────────────┴────────────────┴────────────┴──────────┴──────────┘{ui['reset']}")