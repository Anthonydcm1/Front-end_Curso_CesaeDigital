package pessoa;

import java.util.ArrayList;
import turma.UnidadeCurricular;

public class Professor extends Pessoa {
    private static int contadorProfessores = 0;
    private int numeroProfessor;
    private String especialidade;
    private double salario;
    private ArrayList<UnidadeCurricular> unidadesCurriculares;

    public Professor(String nome, String email, String telefone, int idade, String especialidade, double salario) {
        super(nome, email, telefone, idade);
        this.numeroProfessor = ++contadorProfessores;
        this.especialidade = especialidade;
        this.salario = salario;
        this.unidadesCurriculares = new ArrayList<>();
    }

    public void adicionarUC(UnidadeCurricular uc) {
        if (unidadesCurriculares.size() >= 5) {
            System.out.println("\nErro: Professor já leciona o máximo de 5 UCs.");
            return;
        }
        unidadesCurriculares.add(uc);
    }

    public void removerUC(UnidadeCurricular uc) {
        unidadesCurriculares.remove(uc);
    }

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
