package curso;

import java.util.ArrayList;
import turma.Turma;
import turma.UnidadeCurricular;

public class Curso {
    private String nome;
    private TipoCurso tipo;
    private int duracaoMeses;
    private ArrayList<Turma> turmas;
    private ArrayList<UnidadeCurricular> unidadesCurriculares;

    public Curso(String nome, TipoCurso tipo, int duracaoMeses) {
        this.nome = nome;
        this.tipo = tipo;
        this.duracaoMeses = duracaoMeses;
        this.turmas = new ArrayList<>();
        this.unidadesCurriculares = new ArrayList<>();
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public void adicionarUC(UnidadeCurricular uc) {
        if (!unidadesCurriculares.contains(uc)) {
            unidadesCurriculares.add(uc);
        }
    }

    public void listarTurmas() {
        System.out.println("\nTurmas do curso " + nome + ":");
        for (Turma t : turmas) {
            System.out.println("- " + t.getNome());
        }
    }

    public void mostrarDetalhes() {
        System.out.println("\nCurso: " + nome + " (" + tipo + ")");
        System.out.println("Duração: " + duracaoMeses + " meses");
        System.out.println("Total de Turmas: " + turmas.size());
        System.out.println("Total de UCs: " + unidadesCurriculares.size());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCurso getTipo() {
        return tipo;
    }

    public void setTipo(TipoCurso tipo) {
        this.tipo = tipo;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(int duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public ArrayList<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadesCurriculares;
    }

    @Override
    public String toString() {
        return nome + " [" + tipo + "]";
    }
}
