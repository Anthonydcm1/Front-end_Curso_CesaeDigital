package curso;

import java.util.ArrayList;
import turma.Turma;
import turma.UnidadeCurricular;

// Classe que representa um curso do Cesae
public class Curso {
    private String nome; // Nome do curso
    private TipoCurso tipo; // Tipo de curso (Formação, Pós-graduação, etc.)
    private int duracaoMeses; // Duração do curso em meses
    private ArrayList<Turma> turmas; // Lista de turmas associadas a este curso
    private ArrayList<UnidadeCurricular> unidadesCurriculares; // Disciplinas do curso

    // Construtor para criar um novo curso
    public Curso(String nome, TipoCurso tipo, int duracaoMeses) {
        this.nome = nome;
        this.tipo = tipo;
        this.duracaoMeses = duracaoMeses;
        this.turmas = new ArrayList<>();
        this.unidadesCurriculares = new ArrayList<>();
    }

    // Adiciona uma nova turma ao curso
    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    // Adiciona uma Unidade Curricular ao curso, se ainda não existir
    public void adicionarUC(UnidadeCurricular uc) {
        if (!unidadesCurriculares.contains(uc)) {
            unidadesCurriculares.add(uc);
        }
    }

    // Lista todas as turmas que pertencem a este curso
    public void listarTurmas() {
        System.out.println("\nTurmas do curso " + nome + ":");
        for (Turma t : turmas) {
            System.out.println("- " + t.getNome());
        }
    }

    // Mostra informações detalhadas sobre o curso
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
