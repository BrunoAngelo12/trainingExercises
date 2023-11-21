public class ManipuladorStrings {
    
    public ManipuladorStrings(){
    }

    public String inverter(String stringOriginal){
        String stringModificada = "";
        for(int i = stringOriginal.length(); i >= 0; i--){
            stringModificada += stringOriginal.charAt(i);
        }
        return stringModificada;
    }
}
