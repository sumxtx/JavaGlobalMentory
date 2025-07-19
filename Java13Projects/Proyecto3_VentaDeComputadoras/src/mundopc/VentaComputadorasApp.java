package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.modelo.Monitor;
import mundopc.servicio.Orden;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class VentaComputadorasApp {
  public static void main(String[] args) {

    Raton ratonLenovo = new Raton("bluetooth", "Lenovo");
    System.out.println(ratonLenovo);
    Teclado tecladoLenovo = new Teclado("bluetooth", "Lenovo");
    System.out.println(tecladoLenovo);
    Monitor monitorLenovo = new Monitor("Lenovo", 27);
    Computadora computadoraLenovo =
      new Computadora("Computadora Lenovo", monitorLenovo, tecladoLenovo, ratonLenovo);
    System.out.println(computadoraLenovo);

    Raton ratonRazer = new Raton("cable", "Razer");
    Teclado tecladoRazer = new Teclado("cable", "Razer");
    Monitor monitorSamsung = new Monitor("Samsung", 32);
    Computadora computadoraAus = new Computadora("Computadora Aus", monitorSamsung, tecladoRazer, ratonRazer);

    Orden orden1 = new Orden();
    orden1.agregarComputadora(computadoraLenovo);
    orden1.agregarComputadora(computadoraAus);
    orden1.mostrarOrden();
  }
}
