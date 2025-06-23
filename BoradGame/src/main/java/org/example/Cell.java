package org.example;

public class Cell {

    private char cellName;

    public Cell() {
        cellName = 'E';
    }

    public Cell(char cellName) {
        this.cellName = cellName;
    }

    public void performAction(Player player) {};
}
