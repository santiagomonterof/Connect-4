package Practice;

public class Prueba {

    String[][] matriz = new String[5][5];

    public void mostrarMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (matriz[i][j] == null) ? "[ ]" : matriz[i][j];
                System.out.print(matriz[i][j]);
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        Prueba prueba = new Prueba();
        prueba.mostrarMatriz();

    }

}
