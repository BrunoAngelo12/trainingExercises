public class App {
    public static void main(String[] args) throws Exception {
        Calculadora calc = new Calculadora();
        double soma = calc.somar(2, 2);
        System.out.println(soma);
        double subtracao = calc.subtrair(2, 2);
        System.out.println(subtracao);
        double multiplicar = calc.multiplicar(4, 2);
        System.out.println(multiplicar);
        double divisao1 = calc.dividir(2, 2);
        System.out.println(divisao1);
        double divisao2 = calc.dividir(2, 0);
        System.out.println(divisao2);
        double potenciar = calc.potenciar(3, 3);
        System.out.println(potenciar);
    }
}
