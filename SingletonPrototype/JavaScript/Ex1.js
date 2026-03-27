// Paleta de cores
const cores = {
    reset: "\x1b[0m",
    pink: "\x1b[35m",   
    green: "\x1b[32m", 
    purple: "\x1b[38;5;93m",   
    black: "\x1b[1m" 
};

//Classe Aluno (PROTOTYPE)
class Aluno{
    constructor(id, nome, idade, curso, unidade, periodo){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.unidade = unidade;
        this.periodo = periodo;
    }

    clone(){
        return new Aluno(
            this.id,
            this.nome,
            this.idade,
            this.curso,
            this.unidade,
            this.periodo
        );
    }
}

//Classe GerenciadorAlunos (SINGLETON)
class GerenciadorAlunos{
    constructor(){
        if(GerenciadorAlunos.instance == null){
            GerenciadorAlunos.instance = this;
            this.alunos = {};
        }
        return GerenciadorAlunos.instance;
    }

    addAluno(aluno){
        this.alunos[aluno.id] = aluno;
        console.log(`${cores.green}✔ Aluno ${aluno.nome} adicionado com sucesso!${cores.reset}`);
    }

    listarAlunos(){
        const lista = Object.values(this.alunos);

        console.log(`${cores.pink}${cores.black}\n📚 LISTA DE ALUNOS${cores.reset}`);
        console.table(lista);
    } 
}


//Cliente
const g1 = new GerenciadorAlunos();
const g2 = new GerenciadorAlunos();

console.log(`${cores.pink}${cores.black}🔍 TESTE SINGLETON${cores.reset}`);


//Aluno Protótipo
const alunoPrototipo = new Aluno(
    0,
    "ALUNO PADRAO",
    0,
    "Desenvolviimento de Software",
    "Fatec Diadema",
    "Matutino"
);


//Clones
const aluno1 = alunoPrototipo.clone();
aluno1.id = 1;
aluno1.nome = "João";
aluno1.idade = 20;

const aluno2 = alunoPrototipo.clone();
aluno2.id = 2;
aluno2.nome = "Maria";
aluno2.idade = 22;

g1.addAluno(aluno1);
g2.addAluno(aluno2);

g1.listarAlunos();

console.log(`${cores.purple}${cores.black}\n📌 ALUNO PROTÓTIPO ORIGINAL${cores.reset}`);
console.table([alunoPrototipo]);