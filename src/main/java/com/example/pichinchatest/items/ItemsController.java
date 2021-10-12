package com.example.pichinchatest.items;

import com.example.pichinchatest.items.model.ItemsLogs;
import com.example.pichinchatest.items.representation.CreateItemRequest;
import com.example.pichinchatest.items.representation.ItemIdListRequest;
import com.example.pichinchatest.items.representation.ItemListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemsController implements ItemsApi {

    private final ItemsService itemsService;

    @Autowired
    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @Override
    public ItemsLogs createItemInCategory(CreateItemRequest request) {
        return itemsService.createItemInCategory(request);
    }

    @Override
    public ItemsLogs updateItemInCategory(long itemId, long categoryId) {
        return itemsService.updateItemInCategory(itemId,categoryId);
    }

    @Override
    public ItemsLogs deleteItemInCategory(long itemId, long categoryId) {
        return itemsService.deleteItemInCategory(itemId,categoryId);
    }

    @Override
    public List<ItemsLogs>  addItemListInCategory(long categoryId, ItemListRequest request) {
        return itemsService.updateItemListInCategory(categoryId,request);
    }

    @Override
    public List<ItemsLogs> deleteItemListInCategory(long categoryId, ItemIdListRequest request) {
        return itemsService.deleteItemListInCategory(categoryId,request);
    }

}