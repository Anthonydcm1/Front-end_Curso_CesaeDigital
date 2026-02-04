package turma;

import java.util.ArrayList;
import pessoa.Aluno;
import curso.Curso;

public class Turma {
    private String nome;
    private int capacidadeMaxima;
    private ArrayList<Aluno> alunos;
    private ArrayList<UnidadeCurricular> unidadesCurriculares;
    private Curso curso;

    public Turma(String nome, int capacidadeMaxima, Curso curso) {
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.curso = curso;
        this.alunos = new ArrayList<>();
        this.unidadesCurriculares = new ArrayList<>();
    }

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

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public void listarAlunos() {
        System.out.println("\nAlunos da turma " + nome + ":");
        for (Aluno a : alunos) {
            System.out.println("- " + a.getNome());
        }
    }

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
