package co.edu.uniquindio.poo;
public class Curso {
    String nombre;
    String codigo;
    Estudiante[] estudiante;
    public Curso(String nombre) {
        this.nombre = nombre;
    }
    public Curso(String nombre, String codigo, Estudiante[] estudiante) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estudiante = estudiante;
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

    public Estudiante[] getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante[] estudiante) {
        this.estudiante = estudiante;
    }
}

