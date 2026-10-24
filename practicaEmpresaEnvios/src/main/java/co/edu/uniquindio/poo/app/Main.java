package co.edu.uniquindio.poo.app;
import co.edu.uniquindio.poo.model.EmpresaMensajeria;
import co.edu.uniquindio.poo.model.Envio;
import co.edu.uniquindio.poo.model.EnviosExpres;
import co.edu.uniquindio.poo.model.EnviosInternacionales;
import co.edu.uniquindio.poo.model.EnviosNacionales;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner consulta = new Scanner(System.in);
        EmpresaMensajeria empresa = new EmpresaMensajeria("Envios UQ");

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("MENU DE ENVIOS");
            System.out.println("1. Registrar envio nacional");
            System.out.println("2. Registrar envio internacional");
            System.out.println("3. Registrar envio expres");
            System.out.println("4. Mostrar envios");
            System.out.println("5. Calcular costo total");
            System.out.println("6. Mostrar envio mas costoso");
            System.out.println("7. Eliminar envio");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = Integer.parseInt(consulta.nextLine());

            if (opcion == 1) {

                System.out.print("Codigo: ");
                String codigo = consulta.nextLine();

                System.out.print("Peso: ");
                double peso = Double.parseDouble(consulta.nextLine());

                System.out.print("Destinatario: ");
                String destinatario = consulta.nextLine();

                System.out.print("Ciudad destino: ");
                String ciudad = consulta.nextLine();

                System.out.print("Requiere domicilio si o no: ");
                boolean domicilio = consulta.nextLine().equalsIgnoreCase("si");

                Envio envio = new EnviosNacionales( EnviosNacionales.COSTO_FIJO, codigo, peso,
                        EnviosNacionales.COSTO_KILO, destinatario, empresa, ciudad, domicilio);
                System.out.println(empresa.registrarEnvio(envio));

            } else if (opcion == 2) {

                System.out.print("Codigo: ");
                String codigo = consulta.nextLine();

                System.out.print("Peso: ");
                double peso = Double.parseDouble(consulta.nextLine());

                System.out.print("Destinatario: ");
                String destinatario = consulta.nextLine();

                System.out.print("Pais destino: ");
                String pais = consulta.nextLine();

                System.out.print("Tiene seguro si o no: ");
                boolean seguro = consulta.nextLine().equalsIgnoreCase("si");

                Envio envio = new EnviosInternacionales(EnviosInternacionales.COSTO_FIJO, codigo,
                        peso, EnviosInternacionales.COSTO_KILO, destinatario, empresa, pais, seguro);
                System.out.println(empresa.registrarEnvio(envio));

            } else if (opcion == 3) {

                System.out.print("Codigo: ");
                String codigo = consulta.nextLine();

                System.out.print("Peso: ");
                double peso = Double.parseDouble(consulta.nextLine());

                System.out.print("Destinatario: ");
                String destinatario = consulta.nextLine();

                System.out.print("Ciudad destino: ");
                String ciudad = consulta.nextLine();

                System.out.print("Requiere domicilio si o no: ");
                boolean domicilio = consulta.nextLine().equalsIgnoreCase("si");

                System.out.print("Horas maximas de entrega: ");
                int horas = Integer.parseInt(consulta.nextLine());

                Envio envio = new EnviosExpres(EnviosExpres.COSTO_FIJO, codigo, peso,
                        EnviosNacionales.COSTO_KILO, destinatario, empresa, ciudad, domicilio, horas);
                System.out.println(empresa.registrarEnvio(envio));

            } else if (opcion == 4) {

                if (empresa.getListaEnvios().isEmpty()) {
                    System.out.println("No hay envios registrados.");
                } else {
                    for (Envio envio : empresa.getListaEnvios()) {
                        System.out.println(envio);
                        System.out.println("Costo: $" + envio.calcularCostoTotal());
                    }
                }

            } else if (opcion == 5) {

                System.out.println(
                        "Costo total: $" + empresa.calcularTotalCostos());

            } else if (opcion == 6) {

                Optional<Envio> envioMayor = empresa.masCostoso();

                if (envioMayor.isPresent()) {
                    System.out.println("Envio mas costoso:");
                    System.out.println(envioMayor.get());
                    System.out.println("Costo: $" + envioMayor.get().calcularCostoTotal());
                } else {
                    System.out.println("No hay envios registrados.");
                }

            } else if (opcion == 7) {

                System.out.print("Codigo del envio que desea eliminar: ");
                String codigo = consulta.nextLine();

                if (empresa.eliminarEnvio(codigo)) {
                    System.out.println("Envio eliminado correctamente.");
                } else {
                    System.out.println("No se encontro el envio.");
                }

            } else if (opcion == 0) {

                System.out.println("Programa finalizado.");

            } else {
                System.out.println("Opcion no valida.");
            }
        }
        consulta.close();
    }
}