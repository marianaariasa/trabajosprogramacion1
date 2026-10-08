package co.edu.uniquindio.poo;
import java.util.ArrayList;
public class Curso {
    String nombre;
    String codigo;
    ArrayList<Estudiante> listaEstudiantes;
    public Curso(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.listaEstudiantes = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes= listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }
}

