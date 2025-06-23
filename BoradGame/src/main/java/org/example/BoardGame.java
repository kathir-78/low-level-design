package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class BoardGame {

    private Board board;

    private final ArrayList<Player> listOfPlayers = new ArrayList<>();
    private final ArrayList<Integer> diceNumber = new ArrayList<>();
    private ArrayList<Cell> boardCells = new ArrayList<>();

    private int dicePosition = 0;
    private int boardCellSize = 0 ;

    public void createPlayer(int numberOfPlayers) {
        for(int i=1; i<=numberOfPlayers; i++) {
            listOfPlayers.add(new Player(i));
        }
    }

    public void getBoardInstance(Board board) {
        this.board = board;
        addBoardCells();
        boardCellSize = boardCells.size();
        System.out.println(boardCells.size());

    }

    public void diceRole (int number) {
        diceNumber.add(number);
    }

    public void startTheGame() {
        int turn = 0;

        while(diceIsHaveInput()) {
            Player player = listOfPlayers.get(turn);
            if(player.getChanges() > 0) {
                playTheGame(player);
            }
            turn = (turn +1) % listOfPlayers.size();
        }
        displayPlayers();
    }

    private boolean diceIsHaveInput() {
        return dicePosition < diceNumber.size();
    }

    private void addBoardCells() {
        boardCells = board.getBoardCells();
    }


    private void playTheGame(Player player) {
        int currentPlayerPosition = player.getPlayerPosition();
        int movedPlayerPosition = (diceNumber.get(dicePosition++) + currentPlayerPosition ) %  boardCellSize;
        boardCells.get(movedPlayerPosition).performAction(player);
        player.updatePlayerPosition(movedPlayerPosition);
        player.reduceChanges();
    }

    public void displayPlayers() {
        listOfPlayers.sort(Comparator.comparingInt(Player::getWorth).reversed());
        for(Player player: listOfPlayers) {
            System.out.println(player.getPlayerId()+"\t has the total worth " + player.getWorth());
        }
    }
}

