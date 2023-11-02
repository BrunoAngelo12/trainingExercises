package exercice1;
public class App {
    public static void main(String[] args) throws Exception {
        Carro carro1 = new Carro("Volkswagen", "Tiguan", 2023, "Azul Marinho");
        System.out.println(carro1.toString());
        System.out.println();
        carro1.ligar();
    }
}
