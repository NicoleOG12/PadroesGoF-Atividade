// PALETA DE CORES
const ui = {
    reset: "\x1b[0m",
    bold: "\x1b[1m",
    pink: "\x1b[35m",
    purple: "\x1b[38;5;54m",  
    white: "\x1b[97m"
};


// Classe Base de Pessoa
class Pessoa {
    constructor(nome, cargo, permissao) {
        this.nome = nome;
        this.cargo = cargo;
        this.permissao = permissao;
    }

    mostrarDetalhes() {
        console.log(
            ui.pink + "│ " +
            ui.white + this.nome.padEnd(10) +
            ui.pink + " │ " +
            ui.white + this.cargo.padEnd(14) +
            ui.pink + " │ " +
            ui.white + this.permissao.padEnd(10) +
            ui.pink + " │" +
            ui.reset
        );
    }
}

// Subclasses de Pessoa
class Aluno extends Pessoa {
    constructor(nome) {
        super(nome, "Aluno", "Nível 0");
    }
}

class Administrador extends Pessoa {
    constructor(nome) {
        super(nome, "Administrador", "Nível 1");
    }
}

class Professor extends Pessoa {
    constructor(nome) {
        super(nome, "Professor", "Nível 2");
    }
}

class Visitante extends Pessoa {
    constructor(nome) {
        super(nome, "Visitante", "Nível 3");
    }
}

// Criação Abstrata de Pessoa
class CriacaoDePessoas {
    criarPessoa(nome) {
        throw new Error("criarPessoa() deve ser implementado");
    }
}

// Criação concreta de Alunos
class CriacaoDeAlunos extends CriacaoDePessoas {
    criarPessoa(nome) {
        return new Aluno(nome);
    }
}

// Criação concreta de Administradores
class CriacaoDeAdministradores extends CriacaoDePessoas {
    criarPessoa(nome) {
        return new Administrador(nome);
    }
}

// Criação concreta de Professores
class CriacaoDeProfessores extends CriacaoDePessoas {
    criarPessoa(nome) {
        return new Professor(nome);
    }
}

// Criação concreta de Visitantes
class CriacaoDeVisitantes extends CriacaoDePessoas {
    criarPessoa(nome) {
        return new Visitante(nome);
    }
}

// Uso
console.log(ui.pink + ui.bold + "\n════════════ SISTEMA DE PESSOAS ════════════" + ui.reset);

console.log(ui.pink + "┌────────────┬────────────────┬────────────┐" + ui.reset);
console.log(
    ui.pink + "│ " +
    ui.purple + "Nome".padEnd(10) +
    ui.pink + " │ " +
    ui.purple + "Cargo".padEnd(14) +
    ui.pink + " │ " +
    ui.purple + "Permissão".padEnd(10) +
    ui.pink + " │" +
    ui.reset
);
console.log(ui.pink + "├────────────┼────────────────┼────────────┤" + ui.reset);

const criacaoAlunos = new CriacaoDeAlunos();
const criacaoAdministradores = new CriacaoDeAdministradores();
const criacaoProfessores = new CriacaoDeProfessores();
const criacaoVisitantes = new CriacaoDeVisitantes();

const p1 = criacaoAlunos.criarPessoa("Carlos");
const p2 = criacaoProfessores.criarPessoa("Ana");
const p3 = criacaoAdministradores.criarPessoa("João");
const p4 = criacaoVisitantes.criarPessoa("Maria");

p1.mostrarDetalhes();
p2.mostrarDetalhes();
p3.mostrarDetalhes();
p4.mostrarDetalhes();

console.log(ui.pink + "└────────────┴────────────────┴────────────┘" + ui.reset);