package programation.conectacuatro;

import java.util.Scanner;

public class Estructure {

    Scanner reader = new Scanner(System.in);
    public String[][] board;
    public String[][] fill;
    public String[] player;
    public int x, y = 0;

    public Estructure(int x, int y) {
        board = new String[x][y];
        fill = new String[x][y];
    }
    // ¿Por qué X y Y?
    // R.- Por el eje de coordenadas.

    public void baseTable() {//Base principal de inicio.
        System.out.println("WELCOME TO CONECT4");
        for (int large = 0; large < board[0].length; large++) {
            System.out.print(" " + (large + 1) + " ");
        }
        System.out.println(" ");
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                fill[x][y] = (board[x][y] != null) ? board[x][y] : "[ ]";
                System.out.print(fill[x][y]);
            }
            System.out.println(" ");
        }
    }

    public void lastTable() {//Base repetitiva acumuladora de coins.
        for (int large = 0; large < board[0].length; large++) {
            System.out.print(" " + (large + 1) + " ");
        }

        System.out.println(" ");
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                System.out.print(fill[x][y]);
            }
            System.out.println(" ");
        }
    }

    public void insert(int player, int column) {//Inserción de coins de acuerdo al jugador.
        for (int x = fill.length - 1; x >= 0; x--) {
            if (x == fill.length - 1) {
                if (fill[x][column - 1].equals("[X]") || fill[x][column - 1].equals("[O]")) {
                    for (int y = fill.length - 1; y >= 0; y--) {
                        if (fill[y][column - 1].equals("[ ]")) {
                            if (player == 1) {
                                fill[y][column - 1] = "[X]";
                                break;
                            } else {
                                fill[y][column - 1] = "[O]";
                                break;
                            }

                        }
                    }
                } else {
                    if (player == 1) {
                        fill[x][column - 1] = "[X]";
                    } else {
                        fill[x][column - 1] = "[O]";
                    }

                }
            }
        }
    }

    public boolean fullTop(int column) {//Verificación de tope.
        boolean message = false;
        if (fill[0][column - 1].equals("[X]") || fill[0][column - 1].equals("[O]")) {
            message = true;
        }
        return message;
    }

    public boolean theWinnerHorizontal() {//Vericicación Horizontal
        boolean winnerHorizontal = false;
        for (int x = 0; x < fill.length; x++) {
            int pointsX = 0;
            int pointsO = 0;
            for (int y = 0; y < fill[0].length; y++) {
                switch (fill[x][y]) {
                    case "[X]":
                        pointsX++;
                        pointsO = 0;
                        break;
                    case "[O]":
                        pointsO++;
                        pointsX = 0;
                        break;
                    case "[ ]":
                        pointsX = 0;
                        pointsO = 0;
                        break;
                }
                if (pointsX == 4 || pointsO == 4) {
                    winnerHorizontal = true;
                }
            }
        }
        return winnerHorizontal;
    }

    public boolean theWinnerVertical() {//Vericicación Vertical
        boolean winnerVertical = false;
        for (int x = 0; x < fill[0].length; x++) {
            int pointsX = 0;
            int pointsO = 0;
            for (int y = 0; y < fill.length; y++) {
                switch (fill[y][x]) {
                    case "[X]":
                        pointsX++;
                        pointsO = 0;
                        break;
                    case "[O]":
                        pointsO++;
                        pointsX = 0;
                        break;
                    case "[ ]":
                        pointsX = 0;
                        pointsO = 0;
                        break;
                }
                if (pointsX == 4 || pointsO == 4) {
                    winnerVertical = true;
                }
            }
        }
        return winnerVertical;
    }

    public boolean theWinnerDiagonalLeft(int position) {//Vericicación Diagonal <--
        position = position - 1;
        boolean WinnerDiagonal = false;
        for (int i = 0; i < fill.length; i++) {
            x = i;
            y = i;
            int pointsX = 0;
            int pointsO = 0;
            if (fill[i][position].equals("[X]") || fill[i][position].equals("[O]")) {
                try {
                    switch (fill[i][position]) {
                        case "[X]":

                            for (int j = position; j >= position - 3; j--) {
                                if (fill[x][j].equals("[X]")) {
                                    pointsX++;
                                }
                                x++;
                            }
                            break;
                        case "[O]":
                            for (int j = position; j >= position - 3; j--) {
                                if (fill[y][j].equals("[O]")) {
                                    pointsO++;
                                }
                                y++;
                            }
                            break;
                    }
                    if (pointsX == 4 || pointsO == 4) {
                        WinnerDiagonal = true;
                    }
                } catch (Exception e) {
                    break;
                }
            }
        }
        return WinnerDiagonal;
    }

    public boolean theWinnerDiagonalRight(int position) {//Vericicación Diagonal -->
        position = position - 1;
        boolean WinnerDiagonalRight = false;
        for (int i = 0; i < fill.length; i++) {
            x = i;
            y = i;
            int pointsX = 0;
            int pointsO = 0;
            if (fill[i][position].equals("[X]") || fill[i][position].equals("[O]")) {
                try {
                    switch (fill[i][position]) {
                        case "[X]":
                            for (int j = position; j < position + 4; j++) {
                                if (fill[x][j].equals("[X]")) {
                                    pointsX++;
                                }
                                x++;
                            }
                            break;
                        case "[O]":
                            for (int j = position; j < position + 4; j++) {
                                if (fill[y][j].equals("[O]")) {
                                    pointsO++;
                                }
                                y++;
                            }
                            break;
                    }
                    if (pointsX == 4 || pointsO == 4) {
                        WinnerDiagonalRight = true;
                    }
                } catch (Exception e) {
                    break;
                }
            }
        }
        return WinnerDiagonalRight;
    }

    public boolean loseAll() {//Tablero lleno.
        boolean BothLose = false;
        for (int x = 0; x < fill[0].length; x++) {
            if (fill[0][x].equals("[X]") || fill[0][x].equals("[O]")) {
                if (x == fill[0].length - 1) {
                    System.out.println("LOSE ALL");
                    System.out.println("Anyone's won");
                    BothLose = true;
                }
            } else {
                break;
            }
        }
        return BothLose;
    }
}
