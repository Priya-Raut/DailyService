package com.dailyservice.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * A Data Transfer Object for a delivery order of items by a customer.
 *
 *  @author Priya Raut
 *  @version 1.0
 */
public class DeliveryOrderDto {
    private BigInteger orderId;
    private double billAmount;
    private LocalDateTime orderDateTime;
    private List<ItemDto> items;

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public double getBillAmount(List<ItemDto> items) {
        for( ItemDto item : items){
            billAmount += item.getItemPrice() * item.getItemQuantity();
        }
        return billAmount;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
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
                ", billAmount=" + billAmount +
                ", orderDateTime=" + orderDateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryOrderDto that = (DeliveryOrderDto) o;
        return Double.compare(that.billAmount, billAmount) == 0 &&
                orderId.equals(that.orderId) &&
                orderDateTime.equals(that.orderDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, billAmount, orderDateTime);
    }
}
