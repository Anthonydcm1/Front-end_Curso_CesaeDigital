package turma;

import pessoa.Professor;

public class UnidadeCurricular {
    private String nome;
    private String codigo;
    private int cargaHoraria;
    private Professor professor;

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
