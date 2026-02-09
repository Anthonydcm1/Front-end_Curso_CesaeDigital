package turma;

import java.util.ArrayList;
import pessoa.Aluno;
import curso.Curso;

// Classe que representa uma turma de um curso
public class Turma {
    private String nome; // Nome/identificador da turma (ex: "SD-2025-A")
    private int capacidadeMaxima; // Número máximo de alunos permitidos
    private ArrayList<Aluno> alunos; // Lista de alunos inscritos nesta turma
    private ArrayList<UnidadeCurricular> unidadesCurriculares; // Disciplinas associadas a esta turma
    private Curso curso; // Curso ao qual a turma pertence

    // Construtor para criar uma nova turma
    public Turma(String nome, int capacidadeMaxima, Curso curso) {
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.curso = curso;
        this.alunos = new ArrayList<>();
        this.unidadesCurriculares = new ArrayList<>();
    }

    // Regista um aluno na turma se houver vaga e se não estiver já inscrito
    public boolean inscreverAluno(Aluno aluno) {
        if (alunos.size() >= capacidadeMaxima) {
            System.out.println("\nErro: Turma cheia.");
            return false;
        }
        if (alunos.contains(aluno)) {
            System.out.println("\nErro: Aluno já inscrito nesta turma.");
            return false;
        }
        alunos.add(aluno);
        return true;
    }

    // Remove um aluno da turma
    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    // Lista os nomes de todos os alunos inscritos nesta turma
    public void listarAlunos() {
        System.out.println("\nAlunos da turma " + nome + ":");
        for (Aluno a : alunos) {
            System.out.println("- " + a.getNome());
        }
    }

    // Adiciona uma Unidade Curricular à turma
    public void adicionarUC(UnidadeCurricular uc) {
        if (!unidadesCurriculares.contains(uc)) {
            unidadesCurriculares.add(uc);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public ArrayList<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadesCurriculares;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Turma: " + nome + " (Cap: " + alunos.size() + "/" + capacidadeMaxima + ")";
    }
}
