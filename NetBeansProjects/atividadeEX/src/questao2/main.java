package questao2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    
    public static void main(String [] args){
        boolean exception = false;
        do{
           try {
              Scanner teclado = new Scanner(System.in);

              System.out.println("Eu sei dividir");
              System.out.println("Informe o primeiro valor: ");
              int x = teclado.nextInt();
              System.out.println("Informe o segundo valor: ");
              int y = teclado.nextInt();
        
              double r = (x / y);
              System.out.println("O resultado da soma: "+r);
              exception = false;
            } catch(InputMismatchException ex){
              System.err.println("Somente números");
              exception = true;
            } catch(ArithmeticException ex){
              System.err.println("Você tentou dividir por zero");
              exception = true;
            }
        } while(exception);
    }
}
