package pessoa;

// Classe abstrata que representa uma pessoa genérica no sistema
public abstract class Pessoa {
    private String nome; // Nome da pessoa
    private String email; // Email de contacto
    private String telefone; // Número de telefone
    private int idade; // Idade em anos

    // Construtor base para inicializar os dados de uma pessoa
    public Pessoa(String nome, String email, String telefone, int idade) {
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
        setIdade(idade);
    }

    // Método abstrato que obriga as subclasses a implementar a exibição de detalhes
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
