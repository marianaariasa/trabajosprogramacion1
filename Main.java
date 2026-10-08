package co.edu.uniquindio.poo;

public class Main {
        public static void main(String[] args) {
            Nota nota1 = new Nota("Parcial 1", 4.5f);
            Nota nota2 = new Nota("Parcial 2", 3.8f);
            Nota nota3 = new Nota("Parcial 3", 4.0f);
            Nota nota4 = new Nota("Seguimiento", 4.7f);
            Nota nota5 = new Nota("Proyecto", 4.2f);
            Nota[] notas = {nota1, nota2, nota3, nota4, nota5};

            Estudiante estudiante1 = new Estudiante(notas, "3113456211","mariana.gomezg@uniquindio.edu.co",
                    "1094281623", (byte) 20,
                    "Gomez", "Mariana");

            Estudiante[] estudiantes = {estudiante1};
            Curso curso = new Curso(
                    "Programación I",
                    "PROG1");
            System.out.println("Curso: " + curso.getNombre());
            System.out.println("Código: " + curso.getCodigo());
            for (Estudiante estudiante : curso.getListaEstudiantes()) {
                System.out.println("Estudiante:");
                System.out.println("Nombre: " + estudiante.getNombres());
                System.out.println("Apellidos: " + estudiante.getApellidos());
                System.out.println("Edad: " + estudiante.getEdad());
                System.out.println("Identificación: " + estudiante.getIdentificacion());
                System.out.println("Correo: " + estudiante.getCorreo());
                System.out.println("Teléfono: " + estudiante.getTelefono());
                System.out.println("Notas:");
                for (Nota nota : estudiante.getNotas()) {
                    System.out.println(nota.getNombre() + ": " + nota.getValor());
                }
            }
        }
}
