public class Ex1 {

    // PALETA DE CORES
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String PINK = "\u001B[35m";
    public static final String PURPLE = "\u001B[38;5;54m";
    public static final String WHITE = "\u001B[97m";

    // Classe Base de Pessoa
    static class Pessoa {
        private String nome;
        private String cargo;
        private String permissao;

        public Pessoa(String nome, String cargo, String permissao) {
            this.nome = nome;
            this.cargo = cargo;
            this.permissao = permissao;
        }

        public void mostrarDetalhes() {
            System.out.println(
                PINK + "| " + WHITE + String.format("%-10s", nome) +
                PINK + " | " + WHITE + String.format("%-14s", cargo) +
                PINK + " | " + WHITE + String.format("%-10s", permissao) +
                PINK + " |" + RESET
            );
        }
    }

    // Subclasses de Pessoa
    static class Aluno extends Pessoa {
        public Aluno(String nome) { 
            super(nome, "Aluno", "Nivel 0"); 
        }
    }

    static class Administrador extends Pessoa {
        public Administrador(String nome) { 
            super(nome, "Administrador", "Nivel 1"); 
        }
    }

    static class Professor extends Pessoa {
        public Professor(String nome) { 
            super(nome, "Professor", "Nivel 2"); 
        }
    }

    static class Visitante extends Pessoa {
        public Visitante(String nome) { 
            super(nome, "Visitante", "Nivel 3"); 
        }
    }

    // Criação Abstrata de Pessoa
    static abstract class CriacaoDePessoas {
        public abstract Pessoa criarPessoa(String nome);
    }

    // Criações concretas
    static class CriacaoDeAlunos extends CriacaoDePessoas {
        public Pessoa criarPessoa(String nome) { 
            return new Aluno(nome); 
        }
    }

    static class CriacaoDeAdministradores extends CriacaoDePessoas {
        public Pessoa criarPessoa(String nome) { 
            return new Administrador(nome); 
        }
    }

    static class CriacaoDeProfessores extends CriacaoDePessoas {
        public Pessoa criarPessoa(String nome) { 
            return new Professor(nome); 
        }
    }

    static class CriacaoDeVisitantes extends CriacaoDePessoas {
        public Pessoa criarPessoa(String nome) { 
            return new Visitante(nome); 
        }
    }

    // Uso
    public static void main(String[] args) {

        System.out.println(PINK + BOLD + "\n============ SISTEMA DE PESSOAS ============" + RESET);
        System.out.println(PINK + "+------------+----------------+------------+" + RESET);
        System.out.println(PINK + "| " + PURPLE + String.format("%-10s", "Nome") +
                           PINK + " | " + PURPLE + String.format("%-14s", "Cargo") +
                           PINK + " | " + PURPLE + String.format("%-10s", "Permissao") +
                           PINK + " |" + RESET);
        System.out.println(PINK + "+------------+----------------+------------+" + RESET);

        CriacaoDePessoas criacaoAlunos = new CriacaoDeAlunos();
        CriacaoDePessoas criacaoAdministradores = new CriacaoDeAdministradores();
        CriacaoDePessoas criacaoProfessores = new CriacaoDeProfessores();
        CriacaoDePessoas criacaoVisitantes = new CriacaoDeVisitantes();

        Pessoa p1 = criacaoAlunos.criarPessoa("Carlos");
        Pessoa p2 = criacaoProfessores.criarPessoa("Ana");
        Pessoa p3 = criacaoAdministradores.criarPessoa("Joao");
        Pessoa p4 = criacaoVisitantes.criarPessoa("Maria");

        p1.mostrarDetalhes();
        p2.mostrarDetalhes();
        p3.mostrarDetalhes();
        p4.mostrarDetalhes();

        System.out.println(PINK + "+------------+----------------+------------+" + RESET);
    }
}