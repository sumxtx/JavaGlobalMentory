package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServiciosPeliculasLista implements IServicioPeliculas{

    private final List<Pelicula> peliculas;

    public ServiciosPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas");
        //peliculas.forEach(System.out::println);
        peliculas.forEach(pelicula -> System.out.println(pelicula.getNombre()));

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula.getNombre());
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // Regresa el indice de la pelicula encontrada en lista
        var indice = peliculas.indexOf(pelicula);
        if(!(indice == -1)) {
            System.out.println("Pelicula encontrada en el indice :" + indice);
        }
        else{
            System.out.println("Pelicula no encotrada");
        }
    }
}
