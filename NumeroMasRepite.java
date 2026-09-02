import javax.swing.JOptionPane;
public class NumeroMasRepite {
    public static void main(String[] args) {
        int[] arreglo = {5, 8, 12, 20, 35, 20, 1, 5, 12, 5};
        int numeroMasRepetido = encontrarNumeroMasRepetido(arreglo);
        mostrarMensaje(numeroMasRepetido);
    }

    public static int encontrarNumeroMasRepetido(int[] arreglo) {
        int masRepetido = arreglo[0];
        int cantidad = 0;
        for (int i = 0; i < arreglo.length; i++) {
            int contador = 0;
            for (int j = 0; j < arreglo.length; j++) {
                if (arreglo[i] == arreglo[j]) {
                    contador++;
                }
                if (contador > cantidad) {
                    cantidad = contador;
                    masRepetido = arreglo[i];
                }
            }
        }
        return masRepetido;
    }
    public static void mostrarMensaje( int numeroMasRepetido) {
        JOptionPane.showMessageDialog(null, "El número que más se repite en el arreglo es: "+ numeroMasRepetido);
    }
}






