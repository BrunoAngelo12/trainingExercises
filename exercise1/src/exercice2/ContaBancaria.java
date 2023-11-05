package exercice2;

import java.util.Set;

public class ContaBancaria {
    private String numeroDaConta;
    private String nomeDoTitular;
    private double saldo;

    public ContaBancaria(String numeroDaConta, String nomeDoTitular, double saldo){
        this.numeroDaConta = numeroDaConta;
        this.nomeDoTitular = nomeDoTitular;
        this.saldo = saldo;
    }
    
    public void depositar(double valorDeposito){
        this.saldo += valorDeposito;
        System.out.printf("Depósito efetuado\nSaldo: %.2f\n", this.saldo);
    }

    public void sacar(double valorParaSaque){
        if(valorParaSaque <= this.saldo){
            this.saldo -= valorParaSaque;
            System.out.printf("Saque efetuado\nSaldo: %.2f\n", this.saldo);
        }else{
            System.out.println("Saldo indisponível");
        }
    }

    @Override
    public String toString() {
        return "ContaBancaria [numeroDaConta=" + numeroDaConta + ", nomeDoTitular=" + nomeDoTitular + ", saldo=" + saldo
                + "]";
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public String getNomeDoTitular() {
        return nomeDoTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public Set<ContaBancaria> transferir(Set<ContaBancaria> setContas, ContaBancaria c1, ContaBancaria c2, double valorTransferido){
        if(valorTransferido < 0){
            System.out.println("O valor não pode ser negativo..");
        }else{
            for(ContaBancaria x : setContas){
                if(x.getNumeroDaConta().equals(c1.getNumeroDaConta())){//método .equals utilizado para comparação de conteúdo é o mais recomendável
                    if(x.getSaldo() >= valorTransferido){
                        x.sacar(valorTransferido);
                        for(ContaBancaria y : setContas){
                            if(y.getNumeroDaConta().equals(c2.getNumeroDaConta())){
                                y.depositar(valorTransferido);
                            }
                        }
                    }else{
                        System.out.println("Saldo insuficiente..");
                    }
                }
            }
        }        
        return setContas;
    }
}
