package questao3;

public class conta {
    private float dinheiro;
    private int limite;
    
    public boolean deposita(float valor){
        this.dinheiro = valor;
        return true;          
    }
    
    public float getSaldo(){
        return dinheiro;
    }
     
    public void setLimite(int limite){
        this.limite = limite;
    }
    
    public boolean sacar(float valor){
        
        if(this.dinheiro < valor){
            return false;
        }
        
        this.dinheiro -= valor;
        return true;
    }
}
