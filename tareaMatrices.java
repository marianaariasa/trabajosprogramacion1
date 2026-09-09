package co.edu.uniquindio.poo;
public class tareaMatrices {
    public static void main(String[] args){
    int[][] matriz = {
            {4, 2, 5},
            {1, 3, 6},
            {9, 8, 7}
    };
    int tamano= 5;
    int sumaMatriz = sumarMatriz(matriz);
    int sumaDiagonal = sumarDiagonal(matriz);
    int[][] matrizX = dibujarMatrizX(tamano);
    int[][] cuadroSuperior = dibujarCuadroSuperior(tamano);
    int[][] espiral = crearEspiral(tamano);
    generarMensaje(matriz, sumaMatriz, sumaDiagonal, matrizX, cuadroSuperior, espiral);
}
public static int sumarMatriz (int[][] matriz){
    int suma= 0;
    for(int i=0; i< matriz.length; i++){
        for (int j=0; j< matriz[i].length;j++){
            suma+= matriz[i][j];
        }
    }
    return suma;
}
public static int sumarDiagonal(int[][] matriz){
    int sumaD= 0;
    for(int i=0; i< matriz.length; i++){
        sumaD+= matriz[i][i];
        }
    return sumaD;
}
public static int[][] dibujarMatrizX(int tamano) {
    int[][] matriz = new int[tamano][tamano];
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (i == j || i + j == matriz.length - 1) {
                matriz[i][j] = 1;
            }
        }
    }
    return matriz;
}
public static int[][] dibujarCuadroSuperior(int tamano){
    int[][] matriz = new int[tamano][tamano];
    int limite= tamano / 2;
    for (int i = 0; i <= limite; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (i == 0 || i == limite || j == 0 || j == matriz[i].length - 1) {
                matriz[i][j] = 1;
            }
        }
    }
        return matriz;
        }
public static int [][] crearEspiral(int tamano) {
    int[][] matriz = new int[tamano][tamano];
    int n = tamano;
    int a = 0;
    int b = n - 1;
    int valor = 1;
    while (a <= b) {
        for (int i = a; i <= b; i++) {
            matriz[a][i] = valor;
            valor++;
        }
        for (int i = a + 1; i <= b; i++) {
            matriz[i][b] = valor;
            valor++;
        }
        for (int i = b - 1; i >= a; i--) {
            matriz[b][i] = valor;
            valor++;
        }
        for (int i = b - 1; i > a; i--) {
            matriz[i][a] = valor;
            valor++;
        }
        a++;
        b--;
    }
    return matriz;
}
    public static void generarMensaje(int [][] matriz, int sumaMatriz, int sumaDiagonal, int[][] matrizX, int [][] cuadroSuperior,int [][] espiral){
        System.out.println("1. La matriz original es: ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("2. La suma de la matriz es: "+ sumaMatriz);
        System.out.println("3. La suma de las diagonales de la matriz es: "+ sumaDiagonal);
        System.out.println("4. MatrizX: ");
        for (int i = 0; i < matrizX.length; i++) {
            for (int j = 0; j < matrizX[i].length; j++) {
                System.out.print(matrizX[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("5. Cuadro superior: ");
        for (int i = 0; i < cuadroSuperior.length; i++) {
            for (int j = 0; j < cuadroSuperior[i].length; j++) {
                System.out.print(cuadroSuperior[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("6. Espiral de numeros: ");
        for (int i = 0; i < espiral.length; i++) {
            for (int j = 0; j < espiral[i].length; j++) {
                System.out.print(espiral[i][j] + " ");
            }
            System.out.println();
        }
    }
}