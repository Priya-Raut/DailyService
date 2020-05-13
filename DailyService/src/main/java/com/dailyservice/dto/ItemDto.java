package com.dailyservice.dto;

import java.math.BigInteger;
import java.util.Objects;

/**
 * A Data Transfer Object for an item being delivered by the DailyService.
 *
 * @author Priya Raut
 * @version 1.0
 */
public class ItemDto {
    private BigInteger itemId;
    private String itemName;
    private double itemPrice;
    private double itemQuantity;

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPRice) {
        this.itemPrice = itemPRice;
    }

    public double getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemQuantity=" + itemQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDto itemDto = (ItemDto) o;
        return Double.compare(itemDto.itemPrice, itemPrice) == 0 &&
                Double.compare(itemDto.itemQuantity, itemQuantity) == 0 &&
                itemId.equals(itemDto.itemId) &&
                itemName.equals(itemDto.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, itemPrice, itemQuantity);
    }
}
