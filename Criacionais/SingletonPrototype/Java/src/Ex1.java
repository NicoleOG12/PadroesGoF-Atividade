import java.util.*;

// Paleta de cores
class Cores {
    public static final String RESET = "\u001B[0m";
    public static final String PINK = "\u001B[35m";
    public static final String GREEN = "\u001B[32m";
    public static final String PURPLE = "\u001B[38;5;93m";
    public static final String BOLD = "\u001B[1m";
    public static final String WHITE = "\u001B[97m";
}

// Classe Aluno (PROTOTYPE)
class Aluno implements Cloneable {
    int id;
    String nome;
    int idade;
    String curso;
    String unidade;
    String periodo;

    public Aluno(int id, String nome, int idade, String curso, String unidade, String periodo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.unidade = unidade;
        this.periodo = periodo;
    }

    public Aluno clone() {
        return new Aluno(id, nome, idade, curso, unidade, periodo);
    }
}

// Classe GerenciadorAlunos (SINGLETON)
class GerenciadorAlunos {
    private static GerenciadorAlunos instance;
    private Map<Integer, Aluno> alunos;

    private GerenciadorAlunos() {
        alunos = new HashMap<>();
    }

    public static GerenciadorAlunos getInstance() {
        if (instance == null) {
            instance = new GerenciadorAlunos();
        }
        return instance;
    }

    public void addAluno(Aluno aluno) {
        alunos.put(aluno.id, aluno);
        System.out.println(Cores.GREEN + "Aluno " + aluno.nome + " adicionado com sucesso!" + Cores.RESET);
    }

    public void listarAlunos() {
        System.out.println(Cores.PINK + Cores.BOLD + "\nLISTA DE ALUNOS" + Cores.RESET);

        System.out.println(Cores.PINK + "+-----+------------+-------+--------------------------------+-----------------+------------+" + Cores.RESET);

        System.out.printf(Cores.PINK + Cores.BOLD + "| %-3s | %-10s | %-5s | %-30s | %-15s | %-10s |\n" + Cores.RESET,
                "ID", "NOME", "IDADE", "CURSO", "UNIDADE", "PERIODO");

        System.out.println(Cores.PINK + "+-----+------------+-------+--------------------------------+-----------------+------------+" + Cores.RESET);

        for (Aluno a : alunos.values()) {
            System.out.printf(Cores.WHITE + "| %-3d | %-10s | %-5d | %-30s | %-15s | %-10s |\n" + Cores.RESET,
                    a.id, a.nome, a.idade, a.curso, a.unidade, a.periodo);
        }

        System.out.println(Cores.PINK + "+-----+------------+-------+--------------------------------+-----------------+------------+" + Cores.RESET);
    }
}

// Classe principal
public class Ex1 {
    public static void main(String[] args) {

        GerenciadorAlunos g1 = GerenciadorAlunos.getInstance();
        GerenciadorAlunos g2 = GerenciadorAlunos.getInstance();

        System.out.println(Cores.PINK + Cores.BOLD + "TESTE SINGLETON" + Cores.RESET);

        // Aluno Protótipo
        Aluno alunoPrototipo = new Aluno(
                0,
                "ALUNO PADRAO",
                0,
                "Desenvolvimento de Software",
                "Fatec Diadema",
                "Matutino"
        );

        // Clones
        Aluno aluno1 = alunoPrototipo.clone();
        aluno1.id = 1;
        aluno1.nome = "Joao";
        aluno1.idade = 20;

        Aluno aluno2 = alunoPrototipo.clone();
        aluno2.id = 2;
        aluno2.nome = "Maria";
        aluno2.idade = 22;

        g1.addAluno(aluno1);
        g2.addAluno(aluno2);

        g1.listarAlunos();

        // Protótipo original
        System.out.println(Cores.PURPLE + Cores.BOLD + "\nALUNO PROTOTIPO ORIGINAL" + Cores.RESET);

        System.out.println(Cores.PURPLE + "+-----+-----------------+-------+--------------------------------+-----------------+------------+" + Cores.RESET);

        System.out.printf(Cores.PURPLE + "| %-3s | %-15s | %-5s | %-30s | %-15s | %-10s |\n" + Cores.RESET,
                "ID", "NOME", "IDADE", "CURSO", "UNIDADE", "PERIODO");

        System.out.println(Cores.PURPLE + "+-----+-----------------+-------+--------------------------------+-----------------+------------+" + Cores.RESET);

        System.out.printf(Cores.WHITE + "| %-3d | %-15s | %-5d | %-30s | %-15s | %-10s |\n" + Cores.RESET,
                alunoPrototipo.id,
                alunoPrototipo.nome,
                alunoPrototipo.idade,
                alunoPrototipo.curso,
                alunoPrototipo.unidade,
                alunoPrototipo.periodo);

        System.out.println(Cores.PURPLE + "+-----+-----------------+-------+--------------------------------+-----------------+------------+" + Cores.RESET);
    }
}