package turma;

import pessoa.Professor;

// Classe que representa uma disciplina ou módulo (UC)
public class UnidadeCurricular {
    private String nome; // Nome da disciplina
    private String codigo; // Código identificador (ex: "JAVA-01")
    private int cargaHoraria; // Total de horas da disciplina
    private Professor professor; // Professor responsável por lecionar a UC

    // Construtor para criar uma nova Unidade Curricular
    public UnidadeCurricular(String nome, String codigo, int cargaHoraria, Professor professor) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "UC: " + nome + " (" + codigo + ") - " + cargaHoraria + "h - Prof: "
                + (professor != null ? professor.getNome() : "N/A");
    }
}
