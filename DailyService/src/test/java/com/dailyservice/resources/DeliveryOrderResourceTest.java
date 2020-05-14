package com.dailyservice.resources;

import com.dailyservice.dto.DeliveryOrderDto;
import com.dailyservice.dto.ItemDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This test class tests DeliveryOrderResource class.
 *
 * @author  Priya Raut
 * @version 1.0
 */
public class DeliveryOrderResourceTest {

    /**
     * Test to confirm if billAmount is getting properly calculated or not.
     */
    @Test
    public void shouldGetProperBillAmountForGivenItems() {
        List<ItemDto> items = new ArrayList<ItemDto>();
        ItemDto item_1 = new ItemDto();
        item_1.setItemName("Salt");
        item_1.setItemPrice(25);
        item_1.setItemQuantity(4);
        items.add(item_1);

        ItemDto item_2 = new ItemDto();
        item_2.setItemName("Tea Powder");
        item_2.setItemPrice(50);
        item_2.setItemQuantity(1);
        items.add(item_2);

        DeliveryOrderDto deliveryOrderDto = new DeliveryOrderDto();
        deliveryOrderDto.setBillAmount(items);

        Assert.assertEquals("The billAmount is different than expected.", 150, deliveryOrderDto.getBillAmount(), 0);
    }
}