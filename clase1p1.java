package co.edu.uniquindio.poo;
public class clase1p1 {
    public static void main(String[] args) {
        int[] numeros = {5, 4, 9, 8, 1, 12, 2};
        int numeroBuscar = 9;
        int suma = sumarArreglo(numeros);
        boolean existe = buscarNumero(numeros, numeroBuscar);
        boolean numeroRepetido = verificarNumeroRepetido(numeros);
        generarMensaje(suma, numeroBuscar, existe, numeroRepetido);
    }
    public static int sumarArreglo(int[] numeros) {
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }
        return suma;
    }
    public static boolean buscarNumero(int[] numeros, int numeroBuscar) {
        boolean encontrado= false;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroBuscar) {
                encontrado= true;
                break;
            }
        }
        return encontrado;
    }
public static boolean verificarNumeroRepetido(int[] numeros){
    boolean repetido= false;
    for(int i = 0; i < numeros.length; i++){
       for(int j = i + 1; j < numeros.length; j++){
           if (numeros[i] == numeros[j]){
               repetido= true;
               break;
           }
       }
    }
    return repetido;
}
public static void generarMensaje (int suma, int numeroBuscar, boolean existe, boolean repetido){
    String mensaje= "";
    System.out.println("La suma de los números es:" + suma);
    if (existe){
        System.out.println("El número " + numeroBuscar+ " está dentro del arreglo");
    }
    else{
        System.out.println("El número " + numeroBuscar+ " no está dentro del arreglo");
    }
    if (repetido) {
        System.out.println("Hay números repetidos en el arreglo.");
    } else {
        System.out.println("No hay números repetidos en el arreglo.");
    }
}
}
