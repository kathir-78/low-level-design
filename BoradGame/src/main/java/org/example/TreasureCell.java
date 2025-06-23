package org.example;

public class TreasureCell extends Cell {

    private final int TREASURE = 200;

    public TreasureCell() {
        super('T');
    }

    @Override
    public void performAction(Player player) {
        player.addTreasure(TREASURE);
    }

}
