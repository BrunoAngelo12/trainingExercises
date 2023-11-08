package exercice2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ContaBancaria {
    private String numeroDaConta;
    private String nomeDoTitular;
    private double saldo;
    private List<String> extrato;
    private double limiteChequeEspecial;

    public ContaBancaria(String numeroDaConta, String nomeDoTitular, double saldo){
        this.numeroDaConta = numeroDaConta;
        this.nomeDoTitular = nomeDoTitular;
        this.saldo = saldo;
        extrato = new ArrayList<String>();
    }

    DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    public void depositar(double valorDeposito){
        this.saldo += valorDeposito;
        LocalDateTime horarioDeposito = LocalDateTime.now();
        String horarioDepositoString = horarioDeposito.format(formatoDataHora);
        System.out.println("Depósito realizado com sucesso!");
        String depositoExtrato = String.format("Depósito efetuado no valor de %.2f às %s.\n", valorDeposito, horarioDepositoString);
        extrato.add(depositoExtrato);
    }

    public void sacar(double valorParaSaque){
        if (this.saldo - valorParaSaque < 0){
            double limite = valorParaSaque - this.saldo;
            double saldoFinal = this.limiteChequeEspecial - limite;
            this.saldo = -limite;
            LocalDateTime horarioSaque = LocalDateTime.now();
            String horarioSaqueString = horarioSaque.format(formatoDataHora);
            System.out.println("Saque realizado com sucesso através do cheque especial às " + horarioSaqueString + "Consulte seu saldo");
            String saqueChequeEspecial = String.format("Saque efetuado no valor de %.2f através do cheque especial\n", valorParaSaque);
            extrato.add(saqueChequeEspecial);
        }else if(valorParaSaque <= this.saldo){
            this.saldo -= valorParaSaque;
            LocalDateTime horarioSaque = LocalDateTime.now();
            String horarioSaqueString = horarioSaque.format(formatoDataHora);
            System.out.println("Saque realizado com sucesso!");
            String saqueExtrato = String.format("Saque efetuado no valor de %.2f\n", valorParaSaque);
            extrato.add(saqueExtrato);
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
                                LocalDateTime horarioTransferencia = LocalDateTime.now();
                                String horarioTransferenciaString = horarioTransferencia.format(formatoDataHora);
                                String transferenciaExtrato = String.format("Transferência no valor de: %.2f realizado para conta: %s às %s\n", valorTransferido, c2.getNumeroDaConta(), horarioTransferenciaString);
                                extrato.add(transferenciaExtrato);
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

    public void mostrarSaldo(){
        System.out.printf("Conta: %s\nSaldo disponível: %.2f\n", this.numeroDaConta, this.saldo);
    }

    public void imprimirExtrato(){
        System.out.printf("Extrato bancário de %s\n", nomeDoTitular);
        for(String x : extrato){
            System.out.println(x);
        }
    }

    public void definirLimiteChequeEspecial(double limiteChequeEspecial){
        if(limiteChequeEspecial > 0){
            this.limiteChequeEspecial = limiteChequeEspecial;
        }else{
            System.out.println("Limite de cheque especial não pode ser negativo");
        }
    }
}
