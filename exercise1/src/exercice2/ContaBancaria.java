package exercice2;

public class ContaBancaria {
    private String numeroDaConta;
    private String nomeDoTitular;
    private double saldo;

    public void depositar(double valorDeposito){
        this.saldo += valorDeposito;
        System.out.printf("Depósito efetuado\nSaldo: %.2f", this.saldo);
    }

    public void sacar(double valorParaSaque){
        if(valorParaSaque <= this.saldo){
            this.saldo -= valorParaSaque;
            System.out.printf("Saque efetuado\nSaldo: %.2f", this.saldo);
        }else{
            System.out.println("Saldo indisponível");
        }
    }
}
