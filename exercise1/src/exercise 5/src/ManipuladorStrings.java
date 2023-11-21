public class ManipuladorStrings {
    
    public ManipuladorStrings(){
    }

    public String inverter(String stringOriginal){
        String stringModificada = "";
        for(int i = stringOriginal.length() - 1; i >= 0; i--){
            stringModificada += stringOriginal.charAt(i);
        }
        return stringModificada;
    }

    public int contarVogais(String stringOriginal){
        int stringResultado =0;
        for(int i = 0; i < stringOriginal.length(); i++){
            if(stringOriginal.charAt(i) == 'a' || stringOriginal.charAt(i) == 'e' || stringOriginal.charAt(i) == 'i'
            || stringOriginal.charAt(i) == 'o' || stringOriginal.charAt(i) == 'u'){
                stringResultado++;
            }
        }
        return stringResultado;
    }
}
