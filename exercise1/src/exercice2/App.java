package exercice2;

public class App {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("0001-A", "Bruno Angelo Souza Santos", 100.00);
        System.out.println(conta.toString());
        conta.depositar(50.50);
        conta.sacar(5000.0);
    }
}
