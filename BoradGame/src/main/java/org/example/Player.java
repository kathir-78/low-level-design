package org.example;

public class Player {

    private final int INITIAL_AMOUNT = 1000;

    private int balanceAmount = INITIAL_AMOUNT;
    private int chances = 10;
    private final int playerId;
    private int playerPosition = -1;

    private int hotelHasOwned = 0;

    public Player(int playerId) {
        this.playerId = playerId;
    }

    private void deductBalance(int amount) {
        if(balanceAmount >= amount) {
            balanceAmount -= amount;
        }
    }

    private void addBalance(int amount) {
        balanceAmount += amount;
    }

    public void payFine(int fineAmount) {
       deductBalance(fineAmount);
    }

    public void addRent(int rentAmount) {
        addBalance(rentAmount);
    }

    public void addTreasure(int treasureAmount) {
        addBalance(treasureAmount);
    }

    public void payRent(int rentAmount) {
        deductBalance(rentAmount);
    }

    public void buyHotel(int hotelPrice) {
        deductBalance(hotelPrice);
        hotelHasOwned++;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void updatePlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getChanges() {
        return chances;
    }

    public void reduceChanges() {
        if(chances > 0) {
            chances -= 1;
        }
    }

    public int getWorth() {
        int HOTEL_WORTH = 200;
        return balanceAmount + hotelHasOwned * HOTEL_WORTH;
    }

    public int getPlayerId() {
        return playerId;
    }

}
