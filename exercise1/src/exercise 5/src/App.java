public class App {
    public static void main(String[] args) throws Exception {
        ManipuladorStrings manipulador = new ManipuladorStrings();
        String saudacao = "ola";
        System.out.println(manipulador.inverter(saudacao));
        int vogais = manipulador.contarVogais(saudacao);
        System.out.println(vogais);

    }
}
