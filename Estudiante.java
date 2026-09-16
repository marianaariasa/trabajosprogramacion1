package co.edu.uniquindio.poo;
public class Estudiante {
    String nombres;
    String apellidos;
    byte edad;
    String identificacion;
    String correo;
    String telefono;
    Nota[] notas;

    public Estudiante() {
        notas = new Nota[5];
    }
    public Estudiante(Nota[] notas, String telefono, String correo, String identificacion, byte edad, String apellidos, String nombres) {
        this.notas = notas;
        this.telefono = telefono;
        this.correo = correo;
        this.identificacion = identificacion;
        this.edad = edad;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Nota[] getNotas() {
        return notas;
    }

    public void setNotas(Nota[] notas) {
        this.notas = notas;
    }
}

