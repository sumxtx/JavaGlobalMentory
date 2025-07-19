import java.util.Scanner;

public class CalculadoraApp
{
  public static void main(String[] args)
  {
    System.out.println("*** Application Calculadora ***");
    Scanner consola = new Scanner(System.in);

    System.out.print("Proporciona valor operando1: ");
    var operando1 = Integer.parseInt(consola.nextLine());

    System.out.print("Proporciona valor operando2: ");    
    var operando2 = Integer.parseInt(consola.nextLine());

    var resultado = operando1 + operando2;

    System.out.println("Resultado: " + resultado);
  }
}
