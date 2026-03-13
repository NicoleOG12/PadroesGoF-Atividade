// PALETA DE CORES
const ui = {
    reset: "\x1b[0m",
    bold: "\x1b[1m",
    pink: "\x1b[35m",         
    purple: "\x1b[38;5;54m",  
    white: "\x1b[97m"
};

// Classe base de Pessoa
class Pessoa {
    constructor(nome, cargo, matricula, horaEntrada, horaSaida) {
        this.nome = nome;
        this.cargo = cargo;
        this.matricula = matricula;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    mostrarDetalhes() {
        console.log(
            ui.purple + "│ " +
            ui.white + this.nome.padEnd(12) +
            ui.purple + " │ " +
            ui.white + this.cargo.padEnd(14) +
            ui.purple + " │ " +
            ui.white + this.matricula.toString().padEnd(10) +
            ui.purple + " │ " +
            ui.white + this.horaEntrada.padEnd(8) +
            ui.purple + " │ " +
            ui.white + this.horaSaida.padEnd(8) +
            ui.purple + " │" +
            ui.reset
        );
    }
}

// Builder base
class PessoaBuilder {
    constructor() {
        this.nome = "";
        this.cargo = "";
        this.matricula = "";
        this.horaEntrada = "";
        this.horaSaida = "";
    }

    setNome(nome) {
        this.nome = nome;
        return this;
    }

    setMatricula(matricula) {
        this.matricula = matricula;
        return this;
    }

    setHoraEntrada(hora) {
        this.horaEntrada = hora;
        return this;
    }

    setHoraSaida(hora) {
        this.horaSaida = hora;
        return this;
    }

    construir() {
        return new Pessoa(
            this.nome,
            this.cargo,
            this.matricula,
            this.horaEntrada,
            this.horaSaida
        );
    }
}

// Builders específicos
class AlunoBuilder extends PessoaBuilder { 
    constructor() { 
        super(); 
        this.cargo = "Aluno"; 
    } 
}

class ProfessorBuilder extends PessoaBuilder { 
    constructor() {
        super(); 
        this.cargo = "Professor"; 
    } 
}

class AdministradorBuilder extends PessoaBuilder { 
    constructor() { 
        super(); 
        this.cargo = "Administrador"; 
    } 
}
class VisitanteBuilder extends PessoaBuilder { 
    constructor() { 
        super(); 
        this.cargo = "Visitante"; 
    } 
}

// Criando pessoas
console.log(ui.purple + ui.bold + "\n════════════════════════ SISTEMA DE PESSOAS ════════════════════════" + ui.reset);

console.log(ui.purple + "┌──────────────┬────────────────┬────────────┬──────────┬──────────┐" + ui.reset);
console.log(
    ui.purple + "│ " +
    ui.pink + "Nome".padEnd(12) +
    ui.purple + " │ " +
    ui.pink + "Cargo".padEnd(14) +
    ui.purple + " │ " +
    ui.pink + "Matrícula".padEnd(10) +
    ui.purple + " │ " +
    ui.pink + "Entrada".padEnd(8) +
    ui.purple + " │ " +
    ui.pink + "Saída".padEnd(8) +
    ui.purple + " │" +
    ui.reset
);
console.log(ui.purple + "├──────────────┼────────────────┼────────────┼──────────┼──────────┤" + ui.reset);

const aluno = new AlunoBuilder()
    .setNome("Carlos")
    .setMatricula(1234)
    .setHoraEntrada("08:00")
    .setHoraSaida("12:00")
    .construir();

const professor = new ProfessorBuilder()
    .setNome("Ana")
    .setMatricula(5678)
    .setHoraEntrada("09:00")
    .setHoraSaida("17:00")
    .construir();

const administrador = new AdministradorBuilder()
    .setNome("João")
    .setMatricula(4321)
    .setHoraEntrada("07:00")
    .setHoraSaida("15:00")
    .construir();

const visitante = new VisitanteBuilder()
    .setNome("Maria")
    .setMatricula("-")
    .setHoraEntrada("10:00")
    .setHoraSaida("12:00")
    .construir();

aluno.mostrarDetalhes();
professor.mostrarDetalhes();
administrador.mostrarDetalhes();
visitante.mostrarDetalhes();

console.log(ui.purple + "└──────────────┴────────────────┴────────────┴──────────┴──────────┘" + ui.reset);