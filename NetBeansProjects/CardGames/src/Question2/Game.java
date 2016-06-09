
package Question2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ysj13kxu
 */

//PLEASE NOTE: A HIGH NUMBER OF RUNS SOMETIMES WORKS AND SOMETIMES DOESN'T
//IT MAY WORK IF YOU RE-RUN
public class Game {

    public static void main(String[] args) throws FileNotFoundException,
            IOException {
        System.out.println("\n" + "CONTINUE TO GAMES? y/n");
        Scanner scan = new Scanner(System.in);
        String cont;
        cont = scan.next();
        if (cont.contains("Y") || cont.contains("y")) {
            System.out.println("\n" + "Which game?");
            System.out.println("Type 'b' for Basic Game");
            System.out.println("Type 'h' for Human Game");
            System.out.println("Type 'a' for Advanced Game");
            cont = scan.next();
            if (cont.contains("b") || cont.contains("B")) {
                BlackjackTable.basicGame();
            }
            if (cont.contains("h") || cont.contains("H")) {
                BlackjackTable.humanGame();
            }
            if (cont.contains("a") || cont.contains("A")) {
                BlackjackTable.advancedGame();
            }
        } else {
            System.exit(0);
        }
    }
}
