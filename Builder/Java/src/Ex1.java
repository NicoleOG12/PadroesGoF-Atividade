
public class Ex1 {

    // PALETA DE CORES
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String PINK = "\u001B[35m";
    public static final String PURPLE = "\u001B[38;5;54m";
    public static final String WHITE = "\u001B[97m";

    // Classe base de Pessoa
    static class Pessoa {
        private String nome;
        private String cargo;
        private String matricula;
        private String horaEntrada;
        private String horaSaida;

        public Pessoa(String nome, String cargo, String matricula, String horaEntrada, String horaSaida) {
            this.nome = nome;
            this.cargo = cargo;
            this.matricula = matricula;
            this.horaEntrada = horaEntrada;
            this.horaSaida = horaSaida;
        }

        public void mostrarDetalhes() {
            System.out.println(
                PURPLE + "| " + WHITE + String.format("%-12s", nome) +
                PURPLE + " | " + WHITE + String.format("%-14s", cargo) +
                PURPLE + " | " + WHITE + String.format("%-12s", matricula) +
                PURPLE + " | " + WHITE + String.format("%-10s", horaEntrada) +
                PURPLE + " | " + WHITE + String.format("%-10s", horaSaida) +
                PURPLE + " |" + RESET
            );
        }
    }

    // Builder base
    static class PessoaBuilder {
        protected String nome = "";
        protected String cargo = "";
        protected String matricula = "";
        protected String horaEntrada = "";
        protected String horaSaida = "";

        public PessoaBuilder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public PessoaBuilder setMatricula(String matricula) {
            this.matricula = matricula;
            return this;
        }

        public PessoaBuilder setHoraEntrada(String hora) {
            this.horaEntrada = hora;
            return this;
        }

        public PessoaBuilder setHoraSaida(String hora) {
            this.horaSaida = hora;
            return this;
        }

        public Pessoa construir() {
            return new Pessoa(nome, cargo, matricula, horaEntrada, horaSaida);
        }
    }

    // Builders específicos
    static class AlunoBuilder extends PessoaBuilder {
        public AlunoBuilder() {
            this.cargo = "Aluno";
        }
    }

    static class ProfessorBuilder extends PessoaBuilder {
        public ProfessorBuilder() {
            this.cargo = "Professor";
        }
    }

    static class AdministradorBuilder extends PessoaBuilder {
        public AdministradorBuilder() {
            this.cargo = "Administrador";
        }
    }

    static class VisitanteBuilder extends PessoaBuilder {
        public VisitanteBuilder() {
            this.cargo = "Visitante";
        }
    }

    // Uso
    public static void main(String[] args) {

        System.out.println(PURPLE + BOLD + "\n=========================== SISTEMA DE PESSOAS ===========================" + RESET);
        System.out.println(PURPLE + "+--------------+----------------+--------------+------------+------------+" + RESET);
        System.out.println(PURPLE + "| " + PINK + String.format("%-12s", "Nome") +
                           PURPLE + " | " + PINK + String.format("%-14s", "Cargo") +
                           PURPLE + " | " + PINK + String.format("%-12s", "Matricula") +
                           PURPLE + " | " + PINK + String.format("%-10s", "Entrada") +
                           PURPLE + " | " + PINK + String.format("%-10s", "Saida") +
                           PURPLE + " |" + RESET);
        System.out.println(PURPLE + "+--------------+----------------+--------------+------------+------------+" + RESET);

        // Criando pessoas
        Pessoa aluno = new AlunoBuilder()
                        .setNome("Carlos")
                        .setMatricula("1234")
                        .setHoraEntrada("08:00")
                        .setHoraSaida("12:00")
                        .construir();

        Pessoa professor = new ProfessorBuilder()
                           .setNome("Ana")
                           .setMatricula("5678")
                           .setHoraEntrada("09:00")
                           .setHoraSaida("17:00")
                           .construir();

        Pessoa administrador = new AdministradorBuilder()
                               .setNome("Joao")
                               .setMatricula("4321")
                               .setHoraEntrada("07:00")
                               .setHoraSaida("15:00")
                               .construir();

        Pessoa visitante = new VisitanteBuilder()
                           .setNome("Maria")
                           .setMatricula("-")
                           .setHoraEntrada("10:00")
                           .setHoraSaida("12:00")
                           .construir();

        aluno.mostrarDetalhes();
        professor.mostrarDetalhes();
        administrador.mostrarDetalhes();
        visitante.mostrarDetalhes();

        System.out.println(PURPLE + "+--------------+----------------+--------------+------------+------------+" + RESET);
    }
}