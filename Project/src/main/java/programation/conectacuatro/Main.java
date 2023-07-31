package programation.conectacuatro;

import java.util.Scanner;

public class Main {

    public static Scanner data;
    public static boolean flag = true;

    public Main() {
        data = new Scanner(System.in);
    }

    //Por Consola
    public static void main(String[] args) {
        int position = 0;
        Main main = new Main();
        Estructure Panel = new Estructure(5, 8);
        Panel.baseTable();
        while (flag == true) {
            for (int player = 1; player <= 2; player++) {
                boolean compare = false;
                do {
                    try {
                        System.out.println("-=[+]=-");
                        System.out.println("Insert a position between 1-" + Panel.fill[0].length);
                        System.out.println("Player " + player);
                        String auxiliar = data.nextLine();
                        position = Integer.parseInt(auxiliar);
                        if (position >= 1 && position <= Panel.fill[0].length) {
                            if (Panel.fullTop(position) == true) {
                                System.out.println("Column Full");
                                System.out.println("Insert Another Position");
                            } else {
                                Panel.insert(player, position);
                                Panel.lastTable();
                                compare = true;
                            }
                        } else {
                            System.out.println("You Have to Insert a Number Between 1-" + Panel.fill[0].length);
                        }
                    } catch (Exception e) {
                        System.out.println("Insert an Integer Number");
                    }
                } while (compare == false);
                if (Panel.theWinnerHorizontal() == true || Panel.theWinnerVertical() == true
                        || Panel.theWinnerDiagonalLeft(position) == true || Panel.theWinnerDiagonalRight(position) == true) {
                    System.out.println("Player " + player);
                    System.out.println("IS THE WINNER");
                    flag = false;
                    break;
                } else {
                    if (Panel.loseAll() == true) {
                        System.out.println("CHAN CHAN CHAN");
                        flag = false;
                        break;

                    }
                }

            }
        }
    }
}
