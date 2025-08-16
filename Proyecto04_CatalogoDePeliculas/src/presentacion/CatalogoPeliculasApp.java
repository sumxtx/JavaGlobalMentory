package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServiciosPeliculasArchivo;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CatalogoPeliculasApp {

  public static void main(String[] args) {
    var salir = false;
    var consola = new Scanner(System.in);
//    IServicioPeliculas serviciosPeliculas = new ServiciosPeliculasLista();
    IServicioPeliculas serviciosPeliculas = new ServiciosPeliculasArchivo();
    while(!salir) {
      try {
        mostrarMenu();
        salir = ejecutarOpciones(consola, serviciosPeliculas);
      } catch (Exception e) {
        System.out.println("Ocurrio un error" + e.getMessage());
      }
      System.out.println();
    }
  }

  private static void mostrarMenu(){
    System.out.println("""
            *** Catalogo de Peliculas ***
            1. Agregar Pelicula
            2. Listar Pelicula
            3. Buscar Pelicula
            4. Salir
            """);
  }

  private static boolean ejecutarOpciones(Scanner consola, IServicioPeliculas servicioPeliculas){
    var opcion = Integer.parseInt(consola.nextLine());
    var salir = false;
    switch (opcion){
      case 1 -> {
        System.out.println("Introudce el nombre de la Pelicula");
        var nombrePelicula = consola.nextLine();
        servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
      }
      case 2 ->{
        servicioPeliculas.listarPeliculas();
      }
      case 3 ->{
        System.out.println("Introduce la Pelicula a buscar: ");
        var buscar = consola.nextLine();
        servicioPeliculas.buscarPelicula(new Pelicula(buscar));
      }
      case 4 ->{
        System.out.println("Hasta Pronto!");
        salir = true;
      }
      default -> System.out.println("Opcion no reconocida");
    }
    return salir;
  }
}
