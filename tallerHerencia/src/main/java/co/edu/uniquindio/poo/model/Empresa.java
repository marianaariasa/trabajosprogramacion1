package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Optional;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<ResumenPago> listaResumenPago;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
        this.listaResumenPago = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        if (buscarEmpleadoPorDocumento(empleado.getDocumento()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un empleado con el documento " + empleado.getDocumento());
        }
        listaEmpleados.add(empleado);
    }

    public void mostrarEmpleados() {
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        for (Empleado aux : listaEmpleados) {
            aux.mostrarInformacion();
            System.out.println("-----------------------------");
        }
    }
    public Optional<Empleado> buscarEmpleadoPorDocumento(String documento) {
        for (Empleado aux : listaEmpleados) {
            if (aux.getDocumento().equals(documento)) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Empleado empleadoMayorSalario() {
        if (listaEmpleados.isEmpty()) {
            return null;
        }
        Empleado empleadoMayor = listaEmpleados.get(0);
        for (Empleado empleadoActual : listaEmpleados) {
            if (empleadoActual.calcularSalarioNeto() > empleadoMayor.calcularSalarioNeto()) {
                empleadoMayor = empleadoActual;
            }
        }
        return empleadoMayor;
    }

    public float calcularNominaTotal() {
        float total = 0;
        for (Empleado aux: listaEmpleados) {
            total += aux.calcularSalarioNeto();
        }
        return total;
    }

    public ArrayList<ResumenPago> generarResumenesPago() {
        listaResumenPago.clear();
        for (Empleado aux : listaEmpleados) {
            listaResumenPago.add(aux.generarResumenPago());
        }
        return listaResumenPago;
    }

    public void mostrarResumenesPago() {
        ArrayList<ResumenPago> resumenes = generarResumenesPago();
        if (resumenes.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        }
        for (ResumenPago aux : resumenes) {
            System.out.println(aux);
        }
    }

}

