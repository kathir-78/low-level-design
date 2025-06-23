package org.example;

public class HotelCell extends Cell {

    private final int HOTEL_WORTH = 200;
    private final int HOTEL_RENT = 50;

    private Player ownerId;

    public HotelCell() {
        super('H');
    }

    @Override
    public void performAction(Player player) {
        if(this.ownerId == null) {
            player.buyHotel(HOTEL_WORTH);
            this.ownerId = player;
        }
        else if(this.ownerId != player) {
            player.payRent(HOTEL_RENT);
            ownerId.addRent(HOTEL_RENT);
        }
    }

}
