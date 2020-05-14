package com.dailyservice.dto;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * This class contains all the attributes of a delivery order of items by a customer.
 *
 *  @author Priya Raut
 *  @version 1.0
 */
public class DeliveryOrderDto {
    private BigInteger orderId;
    private BigInteger customerId;
    private double billAmount;
    private Timestamp orderDateTime;
    private List<ItemDto> items;

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public void setBillAmount(List<ItemDto> items) {
        for(ItemDto item : items){
            billAmount += item.getItemPrice() * item.getItemQuantity();
        }
    }

    public Timestamp getOrderDateTime() {
        orderDateTime = new Timestamp(System.currentTimeMillis());
        return orderDateTime;
    }

    public void setOrderDateTime(Timestamp orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "DeliveryOrderDto{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", billAmount=" + billAmount +
                ", orderDateTime=" + orderDateTime +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryOrderDto that = (DeliveryOrderDto) o;
        return Double.compare(that.billAmount, billAmount) == 0 &&
                orderId.equals(that.orderId) &&
                customerId.equals(that.customerId) &&
                orderDateTime.equals(that.orderDateTime) &&
                items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, billAmount, orderDateTime, items);
    }
}
