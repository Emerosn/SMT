package questao3;

public class main {
    public static void main(String[] args){
       conta c = new conta();
       c.setLimite(1000);
       c.deposita(1000);
       
       try {
           if(!c.sacar(2000)){
               throw new errosEX("VALOR EXEDE O SEU SALDO");
           } 
       } catch(errosEX e){
           System.err.println(e.getMessage()+"\n\n Seu Saldo Atual: "+c.getSaldo());
       } 
    }
}
