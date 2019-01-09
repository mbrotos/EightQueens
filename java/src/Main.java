/**
 * @author Adam Sorrenti
 * @date 2019-01-09
 * @description Have the function EightQueens(strArr) read strArr which will be an array consisting of the locations
 * of eight Queens on a standard 8x8 chess board with no other pieces on the board. The structure of strArr will be the
 * following: ["(x,y)", "(x,y)", ...] where (x,y) represents the position of the current queen on the chessboard (x and
 * y will both range from 1 to 8 where 1,1 is the bottom-left of the chessboard and 8,8 is the top-right). Your program
 * should determine if all of the queens are placed in such a way where none of them are attacking each other. If this
 * is true for the given input, return the string true otherwise return the first queen in the list that is attacking
 * another piece in the same format it was provided.
 *
 */
import java.util.*;
import java.io.*;

class Main {
    public static String EightQueens(String[] strArr) {

        //Parse string array
        int[][] queens = new int[strArr.length][2];
        for (int i = 0; i < strArr.length; i++) {

            String[] tuple = strArr[i].replaceAll("[^1-8.]", "").split("");
            queens[i][0] = Integer.parseInt(tuple[0]) - 1;
            queens[i][1] = Integer.parseInt(tuple[1]) - 1;
        }

        //Check for attacking queens
        for (int i = 0; i < strArr.length; i++) {
            int currentX = queens[i][0];
            int currentY = queens[i][1];
            for (int y = 1; y < 8; y++) {
                if (y != queens[i][1])
                    if (Arrays.asList(queens).contains(new int[]{currentX, y}))
                        return "(" + currentX + "," + currentY + ")";
            }
        }

        return "true";
    }


    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String[] board = {"(2,1)", "(4,3)", "(6,3)", "(8,4)", "(3,4)", "(1,6)", "(7,7)", "(5,8)"};
        System.out.print(EightQueens(board));

    }

}
