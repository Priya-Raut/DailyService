package com.dailyservice.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Map;

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
    //TODO Use a unique key for the map, e.g itemId by overriding hashCode(), maintaining contract with equals
    private Map<ItemDto, Integer> itemsQuantityMap;

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public double getBillAmount(Map<ItemDto, Integer> itemsQuantityMap) {
        for( ItemDto itemDto : itemsQuantityMap.keySet()){
            billAmount += itemDto.getItemPrice() * itemsQuantityMap.get(itemDto);
        }
        return billAmount;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Map<ItemDto, Integer> getItemsQuantityMap() {
        return itemsQuantityMap;
    }

    public void setItemsQuantityMap(Map<ItemDto, Integer> itemsQuantityMap) {
        this.itemsQuantityMap = itemsQuantityMap;
    }
}
