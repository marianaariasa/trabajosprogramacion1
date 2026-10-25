package co.edu.uniquindio.poo.app;
import co.edu.uniquindio.poo.model.*;

import java.util.Optional;
import java.util.Scanner;
public class Main {
    static Scanner consulta = new Scanner(System.in);

    public static void main(String[] args) {
        Empresa empresa = new Empresa("Postobon");
        int opcion = 0;
        while (opcion != 9) {
            System.out.println("SISTEMA DE NOMINA");
            System.out.println("1. Agregar empleado de planta");
            System.out.println("2. Agregar empleado de ventas");
            System.out.println("3. Agregar empleado temporal");
            System.out.println("4. Mostrar todos los empleados");
            System.out.println("5. Buscar empleado por documento");
            System.out.println("6. Mostrar empleado con mayor salario neto");
            System.out.println("7. Mostrar nomina total");
            System.out.println("8. Mostrar resumen de pagos");
            System.out.println("9. Salir");
            opcion = leerEntero("Seleccione una opcion: ");

            try {
                if (opcion == 1) {
                    agregarEmpleadoPlanta(empresa);
                } else if (opcion == 2) {
                    agregarEmpleadoVentas(empresa);
                } else if (opcion == 3) {
                    agregarEmpleadoTemporal(empresa);
                } else if (opcion == 4) {
                    empresa.mostrarEmpleados();
                } else if (opcion == 5) {
                    buscarEmpleado(empresa);
                } else if (opcion == 6) {
                    mostrarMayorSalario(empresa);
                } else if (opcion == 7) {
                    System.out.println("Nomina total: " + empresa.calcularNominaTotal());
                } else if (opcion == 8) {
                    empresa.mostrarResumenesPago();
                } else if (opcion == 9) {
                    System.out.println("Saliendo del sistema...");
                } else {
                    System.out.println("Opcion no valida.");
                }
            } catch (IllegalArgumentException errorValidacion) {
                System.out.println("Error: " + errorValidacion.getMessage());
                System.out.println("El empleado no fue registrado.");
            }
        }
        consulta.close();
    }
    static void agregarEmpleadoPlanta(Empresa empresa) {
        System.out.println(" Nuevo empleado de planta ");
        String nombre = leerTexto("Nombre: ");
        String documento = leerTexto("Documento: ");
        int edad = leerEntero("Edad: ");
        float salarioBase = leerDecimal("Salario base: ");
        CategoriaEmpleado categoria = leerCategoria();
        float descuentoSalud = leerDecimal("Descuento salud (%): ");
        float descuentoPension = leerDecimal("Descuento pension (%): ");
        String cargo = leerTexto("Cargo: ");
        int horasExtra = leerEntero("Horas extra: ");
        float valorHoraExtra = leerDecimal("Valor hora extra: ");
        float auxilioTransporte = leerDecimal("Auxilio de transporte: ");

        EmpleadoPlanta nuevoEmpleadoPlanta = new EmpleadoPlanta(nombre, documento, edad, salarioBase,
                categoria, descuentoSalud, descuentoPension, cargo, horasExtra, valorHoraExtra,
                auxilioTransporte);
        empresa.agregarEmpleado(nuevoEmpleadoPlanta);
        System.out.println("Empleado de planta registrado.");
    }

    static void agregarEmpleadoVentas(Empresa empresa) {
        System.out.println(" Nuevo empleado de ventas ");
        String nombre = leerTexto("Nombre: ");
        String documento = leerTexto("Documento: ");
        int edad = leerEntero("Edad: ");
        float salarioBase = leerDecimal("Salario base: ");
        CategoriaEmpleado categoria = leerCategoria();
        float descuentoSalud = leerDecimal("Descuento salud (%): ");
        float descuentoPension = leerDecimal("Descuento pension (%): ");
        float totalVentas = leerDecimal("Total de ventas: ");
        float porcentajeComision = leerDecimal("Porcentaje de comision (%): ");

        EmpleadoVentas nuevoEmpleadoVentas = new EmpleadoVentas(nombre, documento, edad, salarioBase,
                categoria, descuentoSalud, descuentoPension, totalVentas, porcentajeComision);
        empresa.agregarEmpleado(nuevoEmpleadoVentas);
        System.out.println("Empleado de ventas registrado.");
    }

    static void agregarEmpleadoTemporal(Empresa empresa) {
        System.out.println(" Nuevo empleado temporal ");
        String nombre = leerTexto("Nombre: ");
        String documento = leerTexto("Documento: ");
        int edad = leerEntero("Edad: ");
        float salarioBase = leerDecimal("Salario base: ");
        CategoriaEmpleado categoria = leerCategoria();
        float descuentoSalud = leerDecimal("Descuento salud (%): ");
        float descuentoPension = leerDecimal("Descuento pension (%): ");
        int diasTrabajados = leerEntero("Dias trabajados: ");
        float valorDia = leerDecimal("Valor por dia: ");

        EmpleadoTemporal nuevoEmpleadoTemporal = new EmpleadoTemporal(nombre, documento, edad,
                salarioBase, categoria, descuentoSalud, descuentoPension, diasTrabajados, valorDia);
        empresa.agregarEmpleado(nuevoEmpleadoTemporal);
        System.out.println("Empleado temporal registrado.");
    }

    static void buscarEmpleado(Empresa empresa) {
        String documentoBuscado = leerTexto("Documento a buscar: ");
        Optional<Empleado> empleadoEncontrado = empresa.buscarEmpleadoPorDocumento(documentoBuscado);
        if (empleadoEncontrado.isEmpty()) {
            System.out.println("No se encontro un empleado con ese documento.");
        } else {
            empleadoEncontrado.get().mostrarInformacion();
        }
    }

    static void mostrarMayorSalario(Empresa empresa) {
        Empleado empleadoMayorSalario = empresa.empleadoMayorSalario();
        if (empleadoMayorSalario == null) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("Empleado con mayor salario neto:");
            empleadoMayorSalario.mostrarInformacion();
        }
    }

    //  Metodos de lectura de datos

    static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return consulta.nextLine().trim();
    }

    static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String textoIngresado = consulta.nextLine().trim();
            try {
                return Integer.parseInt(textoIngresado);
            } catch (NumberFormatException errorFormato) {
                System.out.println("Debe escribir un numero entero.");
            }
        }
    }

    static float leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String textoIngresado = consulta.nextLine().trim();
            try {
                return Float.parseFloat(textoIngresado);
            } catch (NumberFormatException errorFormato) {
                System.out.println("Debe escribir un numero valido.");
            }
        }
    }

    static CategoriaEmpleado leerCategoria() {
        while (true) {
            System.out.println("Categoria: 1. Junior  2. Semi senior  3. Senior");
            int opcionCategoria = leerEntero("Seleccione la categoria: ");
            if (opcionCategoria == 1) {
                return CategoriaEmpleado.JUNIOR;
            } else if (opcionCategoria == 2) {
                return CategoriaEmpleado.SEMI_SENIOR;
            } else if (opcionCategoria == 3) {
                return CategoriaEmpleado.SENIOR;
            } else {
                System.out.println("Categoria no valida.");
            }
        }
    }
}

