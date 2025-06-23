package org.example;

public class JailCell extends Cell {

    private final int JAIL_FINE = 150;

    public JailCell() {
        super('J');
    }

    @Override
    public void performAction(Player player) {
        player.payFine(JAIL_FINE);
    }
}
