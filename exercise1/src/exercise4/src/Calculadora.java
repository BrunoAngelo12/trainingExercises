public class Calculadora{
    protected double a;
    protected double b;

    public Calculadora(){
    }

    public double somar(double a, double b){
        double soma = a + b;
        return soma;
    }

    public double subtrair (double a, double b){
        double subtracao = a - b;
        return subtracao;
    }

    public double multiplicar (double a, double b){
        double produto = a * b;
        return produto;
    }

    public double dividir (double a, double b){
        try{//aqui tenta o código, caso funcione ok
            double resultado = a / b;
            return resultado;
        }catch(ArithmeticException e){//aqui caso de algum erro
            System.err.println("O denominador não pode ser zero !");//.err adequado
            return Double.NaN;//NotANumber para mostrar que o resultado é indefinido
        }    
    }

    public double potenciar(double a, double b){
        double resultado = Math.pow(a, b);
        return resultado;
    }

}