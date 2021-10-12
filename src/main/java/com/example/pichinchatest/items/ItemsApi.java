package com.example.pichinchatest.items;

import com.example.pichinchatest.items.model.ItemsLogs;
import com.example.pichinchatest.items.representation.CreateItemRequest;
import com.example.pichinchatest.items.representation.ItemIdListRequest;
import com.example.pichinchatest.items.representation.ItemListRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface ItemsApi {

    @PostMapping(value = "/item",
            produces = {"application/json"},
            consumes = {"application/json"})
    ItemsLogs createItemInCategory(@Valid @RequestBody CreateItemRequest request);

    @PatchMapping(value = "/item/{itemId}/category/{categoryId}",
            produces = {"application/json"},
            consumes = {"application/json"})
    ItemsLogs updateItemInCategory(@PathVariable("itemId") long itemId,@PathVariable("categoryId") long categoryId);

    @DeleteMapping(value = "/item/{itemId}/category/{categoryId}",
            produces = {"application/json"},
            consumes = {"application/json"})
    ItemsLogs deleteItemInCategory(@PathVariable("itemId") long itemId,@PathVariable("categoryId") long categoryId);

    @PatchMapping(value = "/itemlist/category/{categoryId}",
            produces = {"application/json"},
            consumes = {"application/json"})
    List<ItemsLogs> addItemListInCategory(@PathVariable("categoryId") long categoryId, @Valid @RequestBody ItemListRequest request);

    @DeleteMapping(value = "/itemlist/category/{categoryId}",
            produces = {"application/json"},
            consumes = {"application/json"})
    List<ItemsLogs> deleteItemListInCategory(@PathVariable("categoryId") long categoryId,@Valid @RequestBody ItemIdListRequest request);



}