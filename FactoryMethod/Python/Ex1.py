# PALETA DE CORES
ui = {
    "reset": "\033[0m",
    "bold": "\033[1m",
    "pink": "\033[35m",
    "purple": "\033[38;5;54m",
    "white": "\033[97m"
}

# Classe Base de Pessoa
class Pessoa:
    def __init__(self, nome, cargo, permissao):
        self.nome = nome
        self.cargo = cargo
        self.permissao = permissao

    def mostrar_detalhes(self):
        print(
            f"{ui['pink']}│ {ui['white']}{self.nome.ljust(10)}"
            f"{ui['pink']} │ {ui['white']}{self.cargo.ljust(14)}"
            f"{ui['pink']} │ {ui['white']}{self.permissao.ljust(10)}"
            f"{ui['pink']} │{ui['reset']}"
        )

# Subclasses de Pessoa
class Aluno(Pessoa):
    def __init__(self, nome):
        super().__init__(nome, "Aluno", "Nível 0")

class Administrador(Pessoa):
    def __init__(self, nome):
        super().__init__(nome, "Administrador", "Nível 1")

class Professor(Pessoa):
    def __init__(self, nome):
        super().__init__(nome, "Professor", "Nível 2")

class Visitante(Pessoa):
    def __init__(self, nome):
        super().__init__(nome, "Visitante", "Nível 3")

# Criação Abstrata de Pessoa
class CriacaoDePessoas:
    def criar_pessoa(self, nome):
        raise NotImplementedError("criar_pessoa() deve ser implementado")

# Criações concretas
class CriacaoDeAlunos(CriacaoDePessoas):
    def criar_pessoa(self, nome):
        return Aluno(nome)

class CriacaoDeAdministradores(CriacaoDePessoas):
    def criar_pessoa(self, nome):
        return Administrador(nome)

class CriacaoDeProfessores(CriacaoDePessoas):
    def criar_pessoa(self, nome):
        return Professor(nome)

class CriacaoDeVisitantes(CriacaoDePessoas):
    def criar_pessoa(self, nome):
        return Visitante(nome)

# Uso
print(ui['pink'] + ui['bold'] + "\n════════════ SISTEMA DE PESSOAS ════════════" + ui['reset'])
print(ui['pink'] + "┌────────────┬────────────────┬────────────┐" + ui['reset'])
print(
    ui['pink'] + "│ " +
    ui['purple'] + "Nome".ljust(10) +
    ui['pink'] + " │ " +
    ui['purple'] + "Cargo".ljust(14) +
    ui['pink'] + " │ " +
    ui['purple'] + "Permissão".ljust(10) +
    ui['pink'] + " │" +
    ui['reset']
)
print(ui['pink'] + "├────────────┼────────────────┼────────────┤" + ui['reset'])

criacao_alunos = CriacaoDeAlunos()
criacao_administradores = CriacaoDeAdministradores()
criacao_professores = CriacaoDeProfessores()
criacao_visitantes = CriacaoDeVisitantes()

p1 = criacao_alunos.criar_pessoa("Carlos")
p2 = criacao_professores.criar_pessoa("Ana")
p3 = criacao_administradores.criar_pessoa("João")
p4 = criacao_visitantes.criar_pessoa("Maria")

p1.mostrar_detalhes()
p2.mostrar_detalhes()
p3.mostrar_detalhes()
p4.mostrar_detalhes()

print(ui['pink'] + "└────────────┴────────────────┴────────────┘" + ui['reset'])