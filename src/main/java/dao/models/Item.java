package dao.models;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class Item {

    private int id;
    private String itemName;
    private int amount;

    public Item(String itemName, int amount) {
        this.itemName = itemName;
        this.amount = amount;
    }

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.itemName, this.amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Item that = (Item) obj;

        return Objects.equals(this.itemName, that.itemName) && Objects.equals(this.amount, that.amount);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Name", itemName)
                .add("Amount", amount)
                .toString();
    }
}
