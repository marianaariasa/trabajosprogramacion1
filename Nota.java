package co.edu.uniquindio.poo;
public class Nota {
    String nombre;
    float valor;

    public Nota(String nombre) {
        this.nombre = nombre;
    }
    public Nota(String nombre, float valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
