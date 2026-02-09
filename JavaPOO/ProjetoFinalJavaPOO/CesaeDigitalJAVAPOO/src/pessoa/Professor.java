package pessoa;

import java.util.ArrayList;
import turma.UnidadeCurricular;

// Classe que representa um professor, herdando de Pessoa
public class Professor extends Pessoa {
    private static int contadorProfessores = 0; // Contador para números de professor únicos
    private int numeroProfessor; // Número identificador do professor
    private String especialidade; // Área de especialidade do professor
    private double salario; // Salário base
    private ArrayList<UnidadeCurricular> unidadesCurriculares; // Disciplinas que leciona

    // Construtor para criar um novo professor
    public Professor(String nome, String email, String telefone, int idade, String especialidade, double salario) {
        super(nome, email, telefone, idade);
        this.numeroProfessor = ++contadorProfessores;
        this.especialidade = especialidade;
        this.salario = salario;
        this.unidadesCurriculares = new ArrayList<>();
    }

    // Atribui uma nova UC ao professor (máximo 5)
    public void adicionarUC(UnidadeCurricular uc) {
        if (unidadesCurriculares.size() >= 5) {
            System.out.println("\nErro: Professor já leciona o máximo de 5 UCs.");
            return;
        }
        unidadesCurriculares.add(uc);
    }

    // Remove uma UC da lista de disciplinas do professor
    public void removerUC(UnidadeCurricular uc) {
        unidadesCurriculares.remove(uc);
    }

    // Lista todas as disciplinas lecionadas por este professor
    public void listarUCs() {
        System.out.println("\nUCs lecionadas por " + getNome() + ":");
        for (UnidadeCurricular uc : unidadesCurriculares) {
            System.out.println("- " + uc.getNome());
        }
    }

    public int getNumeroProfessor() {
        return numeroProfessor;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public ArrayList<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadesCurriculares;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("\nProfessor: " + toString());
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Salário: " + salario);
        listarUCs();
    }

    @Override
    public String toString() {
        return super.toString() + " [Nº Prof: " + numeroProfessor + "]";
    }
}
