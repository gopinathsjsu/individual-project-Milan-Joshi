package model;

public class Order {
    private String item;
    private int quantity;
    private Card card;

    public Order(String item, int quantity, Card card) {
        this.item = item;
        this.quantity = quantity;
        this.card = card;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
