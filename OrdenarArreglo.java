import javax.swing.JOptionPane;
public class OrdenarArreglo {
    public static void main(String[] args) {
        int[] arreglo= {8, 2, 12, 5, 1, 9, 4};
        int[] arregloOrdenado= ordenarArreglo(arreglo);
        mostrarMensaje(arreglo);
    }
    public static int[] ordenarArreglo(int[] arreglo) {
        int temporal;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    temporal = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temporal;
                }
            }
        }
        return arreglo;
    }
    public static void mostrarMensaje(int[] arreglo) {
        String mensaje = "Arreglo ordenado: ";
        for (int i = 0; i < arreglo.length; i++) {
            mensaje = mensaje + arreglo[i] + " ";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
}