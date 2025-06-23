package org.example;

import java.util.ArrayList;

public class Board {

    private ArrayList<Cell> boardCells = new ArrayList<>();

    public void addCells(char cellName) {
        switch (cellName) {
            case 'E':
                boardCells.add(new Cell());
                break;
            case 'J':
                boardCells.add(new JailCell());
                break;
            case 'H':
                boardCells.add(new HotelCell());
                break;
            case 'T':
                boardCells.add(new TreasureCell());
                break;
            default:
                throw new IllegalArgumentException("Invalid cell type: " + cellName);
        }
    }


    public ArrayList<Cell> getBoardCells() {
        return boardCells;
    };

}
