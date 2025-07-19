package mundopc.servicio;

import java.util.List;
import java.util.ArrayList;
import mundopc.modelo.Computadora;

public class Orden {
  private final int idOrden;
  private final List<Computadora> computadoras;
  private static int contadorOrdenes;

  public Orden()
  {
    computadoras = new ArrayList<>();
    this.idOrden = ++contadorOrdenes;
  }

  public void agregarComputadora(Computadora computadora)
  {
    computadoras.add(computadora);
  }

  public void mostrarOrden()
  {
    System.out.println("Orden #:" + idOrden);
    System.out.println("Total computadoras: " + computadoras.size());
    computadoras.forEach(System.out::println);
  }
}
