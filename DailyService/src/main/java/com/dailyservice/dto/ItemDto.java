package com.dailyservice.dto;

import java.math.BigInteger;

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

    @Override
    public String toString() {
        return "ItemDto{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
