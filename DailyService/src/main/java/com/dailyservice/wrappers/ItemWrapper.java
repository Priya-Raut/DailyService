package com.dailyservice.wrappers;

import com.dailyservice.dto.ItemDto;

import java.util.List;

public class ItemWrapper {
    private List<ItemDto> items;

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
