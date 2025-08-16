package dominio;

import java.util.Objects;

public class Pelicula {
  private String nombre;

  public Pelicula()
  {

  }

  public Pelicula(String nombre)
  {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /*
  @Override
  public String toString() {
    return "Pelicula{" +
            "nombre='" + nombre + '\'' +
            '}';
  }
  */
  @Override
  public String toString(){
    return this.nombre;
  }
  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    Pelicula pelicula = (Pelicula) o;
    return Objects.equals(nombre, pelicula.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(nombre);
  }
}
