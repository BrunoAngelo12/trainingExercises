package exercice2;

import java.util.LinkedHashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        ContaBancaria conta0 = new ContaBancaria("0001-A", "Bruno Angelo Souza Santos", 100.00);
        Set<ContaBancaria> setContas = new LinkedHashSet<>();
        setContas.add(conta0);
        ContaBancaria conta1 = new ContaBancaria("0002-A", "Sandy Shelda", 1150.00);
        setContas.add(conta1);
        setContas = conta0.transferir(setContas, conta0, conta1, 50.00);
        conta0.mostrarSaldo();

    }
}
