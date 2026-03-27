# Paleta de cores
class Cores:
    reset = "\x1b[0m"
    pink = "\x1b[35m"   
    green = "\x1b[32m"  
    purple = "\x1b[38;5;93m"
    black = "\x1b[1m" 
    bold = "\033[1m"

# Classe Aluno (PROTOTYPE)
class Aluno:
    def __init__(self, id, nome, idade, curso, unidade, periodo):
        self.id = id
        self.nome = nome
        self.idade = idade
        self.curso = curso
        self.unidade = unidade
        self.periodo = periodo

    def clone(self):
        return Aluno(
            self.id,
            self.nome,
            self.idade,
            self.curso,
            self.unidade,
            self.periodo
        )


# Classe GerenciadorAlunos (SINGLETON)
class GerenciadorAlunos:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(GerenciadorAlunos, cls).__new__(cls)
            cls._instance.alunos = {}
        return cls._instance

    def add_aluno(self, aluno):
        self.alunos[aluno.id] = aluno
        print(f"{Cores.green}✔ Aluno {aluno.nome} adicionado com sucesso!{Cores.reset}")

    def listar_alunos(self):
        largura = 105

        print(f"{Cores.pink}{Cores.bold}\n📚 LISTA DE ALUNOS{Cores.reset}")

        print(f"{Cores.pink}+{'='*largura}+{Cores.reset}")

        print(f"{Cores.pink}{Cores.bold}| "
              f"{'ID':<5} | {'NOME':<15} | {'IDADE':<7} | {'CURSO':<30} | {'UNIDADE':<20} | {'PERÍODO':<10}"
              f" |{Cores.reset}")

        print(f"{Cores.pink}+{'-'*largura}+{Cores.reset}")

        for aluno in self.alunos.values():
            print(f"{Cores.black}| "
                  f"{aluno.id:<5} | {aluno.nome:<15} | {aluno.idade:<7} | "
                  f"{aluno.curso:<30} | {aluno.unidade:<20} | {aluno.periodo:<10}"
                  f" |{Cores.reset}")

        print(f"{Cores.pink}+{'='*largura}+{Cores.reset}")


# Cliente
g1 = GerenciadorAlunos()
g2 = GerenciadorAlunos()

print(f"{Cores.pink}{Cores.bold}🔍 TESTE SINGLETON{Cores.reset}")

# Aluno Protótipo
aluno_prototipo = Aluno(
    0,
    "ALUNO PADRAO",
    0,
    "Desenvolvimento de Software",
    "Fatec Diadema",
    "Matutino"
)

# Clones
aluno1 = aluno_prototipo.clone()
aluno1.id = 1
aluno1.nome = "João"
aluno1.idade = 20

aluno2 = aluno_prototipo.clone()
aluno2.id = 2
aluno2.nome = "Maria"
aluno2.idade = 22

g1.add_aluno(aluno1)
g2.add_aluno(aluno2)

g1.listar_alunos()


largura = 105

print(f"{Cores.purple}{Cores.bold}\n📌 ALUNO PROTÓTIPO ORIGINAL{Cores.reset}")

print(f"{Cores.purple}+{'='*largura}+{Cores.reset}")

print(f"{Cores.purple}| "
      f"{'ID':<5} | {'NOME':<15} | {'IDADE':<7} | {'CURSO':<30} | {'UNIDADE':<20} | {'PERÍODO':<10}"
      f" |{Cores.reset}")

print(f"{Cores.purple}+{'-'*largura}+{Cores.reset}")

print(f"{Cores.black}| "
      f"{aluno_prototipo.id:<5} | {aluno_prototipo.nome:<15} | {aluno_prototipo.idade:<7} | "
      f"{aluno_prototipo.curso:<30} | {aluno_prototipo.unidade:<20} | {aluno_prototipo.periodo:<10}"
      f" |{Cores.reset}")

print(f"{Cores.purple}+{'='*largura}+{Cores.reset}")