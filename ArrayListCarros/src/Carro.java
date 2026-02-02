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

    
    
}