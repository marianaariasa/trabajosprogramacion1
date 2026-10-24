package co.edu.uniquindio.poo.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class EmpresaMensajeria {

    private String nombre;
    private List<Envio> listaEnvios = new LinkedList<>();

    public EmpresaMensajeria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Envio> getListaEnvios() {
        return listaEnvios;
    }

    public void setListaEnvios(List<Envio> listaEnvios) {
        this.listaEnvios = listaEnvios;
    }

    public String registrarEnvio(Envio envio) {
        if (envio == null) {
            return "No se puede registrar un envío vacío";
        }
        Optional<Envio> encontrado =
                buscarEnvio(envio.getCodigo());
        if (encontrado.isPresent()) {
            return "El envío ya existe";
        }
        listaEnvios.add(envio);
        return "Envío registrado exitosamente";
    }

    private Optional<Envio> buscarEnvio(String codigo) {
        return listaEnvios.stream()
                .filter(envio ->
                        envio.getCodigo().equals(codigo))
                .findFirst();
    }

    public boolean eliminarEnvio(String codigo) {
        Optional<Envio> encontrado = buscarEnvio(codigo);
        if (!encontrado.isPresent()) {
            return false;
        }
        listaEnvios.remove(encontrado.get());
        return true;
    }

    public Optional<Envio> masCostoso() {
        if (listaEnvios.isEmpty()) {
            return Optional.empty();
        }

        Envio envioMayor = listaEnvios.get(0);
        for (int i = 1; i < listaEnvios.size(); i++) {
            Envio envioActual = listaEnvios.get(i);
            if (envioActual.calcularCostoTotal()
                    > envioMayor.calcularCostoTotal()) {
                envioMayor = envioActual;
            }
        }

        return Optional.of(envioMayor);
    }

    public double calcularTotalCostos() {
        double total = 0;
        for (Envio envio : listaEnvios) {
            total += envio.calcularCostoTotal();
        }

        return total;
    }

    @Override
    public String toString() {
        return "EmpresaMensajeria{" +
                "nombre='" + nombre + '\'' +
                ", listaEnvios=" + listaEnvios +
                '}';
    }
}