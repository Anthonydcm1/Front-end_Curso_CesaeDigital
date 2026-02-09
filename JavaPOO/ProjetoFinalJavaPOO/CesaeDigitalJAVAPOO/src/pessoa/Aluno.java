package pessoa;

import java.util.ArrayList;
import turma.Turma;

// Classe que representa um aluno, herdando de Pessoa
public class Aluno extends Pessoa {
    private static int contadorAlunos = 0; // Contador global para gerar números de aluno únicos
    private int numeroAluno; // Número mecanográfico do aluno
    private Turma turma; // Turma à qual o aluno pertence
    private ArrayList<Double> notas; // Lista de notas obtidas pelo aluno
    private EstadoAluno estado; // Estado atual do aluno (Ativo, Suspenso, etc.)

    // Construtor com turma
    // Construtor para criar um aluno já associado a uma turma
    public Aluno(String nome, String email, String telefone, int idade, Turma turma) {
        super(nome, email, telefone, idade);
        this.numeroAluno = ++contadorAlunos;
        this.turma = turma;
        this.notas = new ArrayList<>();
        this.estado = EstadoAluno.ATIVO;
    }

    // Construtor sem turma (para matricular depois)
    // Construtor para criar um aluno sem turma inicial
    public Aluno(String nome, String email, String telefone, int idade) {
        super(nome, email, telefone, idade);
        this.numeroAluno = ++contadorAlunos;
        this.notas = new ArrayList<>();
        this.estado = EstadoAluno.ATIVO;
    }

    // Calcula a média aritmética de todas as notas do aluno
    public double calcularMedia() {
        if (notas.isEmpty())
            return 0;
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

    // Adiciona uma nova nota (0 a 20) à lista do aluno
    public void adicionarNota(double nota) {
        if (nota < 0 || nota > 20) {
            System.out.println("\nErro: Nota deve ser entre 0 e 20.");
            return;
        }
        notas.add(nota);
    }

    public int getNumeroAluno() {
        return numeroAluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public EstadoAluno getEstado() {
        return estado;
    }

    public void setEstado(EstadoAluno estado) {
        this.estado = estado;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("\nAluno: " + toString());
        System.out.println("Turma: " + (turma != null ? turma.getNome() : "Sem turma"));
        System.out.println("Média: " + String.format("%.2f", calcularMedia()));
        System.out.println("Estado: " + estado);
    }

    @Override
    public String toString() {
        return super.toString() + " [Nº Aluno: " + numeroAluno + "]";
    }
}
