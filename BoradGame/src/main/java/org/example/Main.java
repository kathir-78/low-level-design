package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Character[] boardCells = {'E', 'J', 'H', 'T'};

        Board board = new Board();
        BoardGame boardGame = new BoardGame();
        Scanner input = new Scanner(System.in);

        System.out.println("Number Of Players");
        int numberOfPlayer = input.nextInt();
        boardGame.createPlayer(numberOfPlayer);

        System.out.println("Enter the cells Input");

        boolean isValidateCell  = false;
        while(true) {
            char inputCell = input.next().charAt(0);
            for(char ch : boardCells) {
                if(ch == inputCell) {
                    isValidateCell = true;
                    break;
                }
                else
                    isValidateCell = false;
            }
            if(isValidateCell)
                board.addCells(inputCell);
            else
                break;
        }


        boardGame.getBoardInstance(board);

        System.out.println("Enter the dice rolled number");
        while(true) {
            int diceNumber = input.nextInt();
            if(diceNumber >= 2 && diceNumber <= 12) {
                boardGame.diceRole(diceNumber);
            }
            else
                break;
        }

        boardGame.startTheGame();
    }
}