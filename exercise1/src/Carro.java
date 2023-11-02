public class Carro{
    protected String marca;
    protected String modelo;
    protected int ano;
    protected String cor;

    public Carro(String marca, String modelo, int ano, String cor){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Carro [marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", cor=" + cor + "]";
    }

}