import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonas
{
  public static void main(String[] args)
  {
    Scanner consola = new Scanner(System.in);
    List<Persona> personas = new ArrayList<>();

    var salir = false;
    while(!salir)
    {
      mostrarMenu();
      try
      {
        salir = ejecutarOperacion(consola, personas);
      }
      catch(Exception e)
      {
        System.out.println("Ocurrio un error: " + e.getMessage());
      }
    }
  }
  
  private static void mostrarMenu()
  {
    System.out.println("""
        *** Listado Personas app ***
        1. Agregar
        2. Listar
        3. Salir
        """);
    System.out.print("Enter Option: ");
  }

  private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas)
  {
    var opcion = Integer.parseInt(consola.nextLine());
    var salir = false;
    switch(opcion)
    {
      case 1 -> // Agregar Persona
      {
        System.out.println("Proporciona el nombre: ");
        var nombre = consola.nextLine();
        System.out.println("Proporciona el telefono: ");
        var tel = consola.nextLine();
        System.out.println("Proporciona el email: ");
        var email = consola.nextLine();
        var persona = new Persona(nombre, tel, email);
        personas.add(persona);
      }
      case 2 -> // Listar las Personas
      {
        System.out.println("Listado de Personas: ");

        //lambda
        //personas.forEach((persona) -> System.out.println(persona));

        //metodo de referencia
        personas.forEach(System.out::println);
      }
      case 3 ->
      {
        System.out.println("Hasta pronto ...");
        salir = true;
      }
      default -> System.out.println("Opcion Erronea");
    } //switch
    return salir;
  } //method

}
