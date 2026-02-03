import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        //Criar um ArrayList de Carros - garagem
        ArrayList<Carro> garagem = new ArrayList<>();

        // Opçao 2: Adicionar varios carros de uma vez
        // garagem.addAll(List.of(
        //     new Carro( "Ferrari", "La Ferrari", 400),
        //     new Carro( "Lamborgini", "Aventador", 350),
        //     new Carro( "McLaren", "Senna", 340)
        // ));

        System.out.println("--------- GESTAO DE GARAGEM DE CARROS ---------");
        

        //Adicionar carros à garagem
        System.out.println("\n1. A adicionar carros à garagem...\n");
        garagem.add(new Carro("Toyota", "Corolla", 180));
        System.out.println("Carro adicionado: "+ garagem.get(0));
        imprimirGaragem(garagem);
        System.out.println();

        garagem.add(new Carro("Honda", "Civic", 220));
        System.out.println("Carro adicionado: "+ garagem.get(1));
        imprimirGaragem(garagem);
        System.out.println();

        garagem.add(new Carro("Ford", "Mustang", 250));
        System.out.println("Carro adicionado: "+ garagem.get(2));
        imprimirGaragem(garagem);
        System.out.println();
   

        // //Imprimir a garagem
        // System.out.println("\n--- Garagem Atualizada ---");
        // imprimirGaragem(garagem);

        // //Remover um carro
        // System.out.println("\nRemovendo o carro da posição 1...");
        // garagem.remove(1);

        // //Imprimir a garagem novamente
        // System.out.println("\n--- Garagem Atualizada ---");
        // imprimirGaragem(garagem);

        // //Acessar um carro específico
        // System.out.println("\nAcessando o carro da posição 0...");
        // Carro carro = garagem.get(0);
        // System.out.println("Carro acessado: " + carro);

        // //Modificar um carro
        // System.out.println("\nModificando o carro da posição 0...");
        // carro.acelerar(50);
        // carro.travar(20);

        // //Imprimir a garagem novamente
        // System.out.println("\n--- Garagem Atualizada ---");
        // imprimirGaragem(garagem);

        // //Verificar tamanho da garagem
        // System.out.println("\nTamanho da garagem: " + garagem.size());

        // //Limpar a garagem
        // System.out.println("\nLimpando a garagem...");
        // garagem.clear();

        // //Imprimir a garagem novamente
        // System.out.println("\n--- Garagem Atualizada ---");
        // imprimirGaragem(garagem);

    }

    /**
     * Metedos auxiliar que imprime todos os carros da garagem
     * @param garagem ArrayList de carros
     */
    public static void imprimirGaragem(ArrayList<Carro> garagem){
        if (garagem.isEmpty()){
            System.out.println("   [GARAGEM VAZIA]");
            return;
        }

        // Ciclo for-each para percorrer a garagem
        for (Carro carro : garagem) {
            System.out.println(carro);
        }
    }
}
