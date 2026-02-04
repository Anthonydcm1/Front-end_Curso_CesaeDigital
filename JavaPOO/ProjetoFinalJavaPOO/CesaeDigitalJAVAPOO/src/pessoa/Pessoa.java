package pessoa;

public abstract class Pessoa {
    private String nome;
    private String email;
    private String telefone;
    private int idade;

    public Pessoa(String nome, String email, String telefone, int idade) {
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
        setIdade(idade);
    }

    public abstract void mostrarDetalhes();

    @Override
    public String toString() {
        return nome + " (" + email + "), Tel: " + telefone + ", Idade: " + idade;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getIdade() {
        return idade;
    }

    // Getters e Setters com validação
    public void setNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("\nNome inválido");
        this.nome = nome;
    }

    public void setEmail(String email) {
        if (!email.contains("@"))
            throw new IllegalArgumentException("\nEmail inválido");
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setIdade(int idade) {
        if (idade < 0)
            throw new IllegalArgumentException("\nIdade inválida");
        this.idade = idade;
    }
}
