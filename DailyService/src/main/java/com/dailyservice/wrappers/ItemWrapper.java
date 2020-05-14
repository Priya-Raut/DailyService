package com.dailyservice.wrappers;

import com.dailyservice.dto.ItemDto;

import java.util.List;

/**
 * This class is used to convert JSON array of item objects into Java List type.
 *
 * @author Priya Raut
 * @version 1.0
 */
public class ItemWrapper {
    private List<ItemDto> items;

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
