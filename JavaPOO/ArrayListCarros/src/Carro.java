public class Carro {
    // Atributos privados
    private String marca;
    private String modelo;
    private int velocidadeMaxima;
    private int velocidadeAtual;

    /**
     * Construtor da classe Carro
     * Inicializa o carro com marca, modelo e velocidade máxima
     * @param marca
     * @param modelo
     * @param velocidadeMaxima
     */

    public Carro(String marca, String modelo, int velocidadeMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidadeAtual = 0; // Inicia parado
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(int velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    // Metodos de funcionamento
    /**
     * Acelera o carro aumentando a velocidade atual
     * A velocidade atual não pode ultrapassar a velocidade máxima
     * 
     * @param incremento
     */

    public void acelerar(int incremento) {
        // Verifica se o incremento é positivo
        if (incremento <= 0) {
            System.out.println("O incremento deve ser positivo");
            return;
        }

        //Calcula a nova velocidade
        int novaVelocidade = this.velocidadeAtual + incremento;

        //Se ultrapassar a velocidade máxima, define a velocidade máxima
        if (novaVelocidade > this.velocidadeMaxima) {
            this.velocidadeAtual = this.velocidadeMaxima;
            System.out.println("Atingiu a velocidade máxima de: " + this.velocidadeMaxima + " km/h");
        } else {
            this.velocidadeAtual = novaVelocidade;
            System.out.println("Velocidade atual: " + this.velocidadeAtual + " km/h");
        }

    }

    


    
}