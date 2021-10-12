package com.example.pichinchatest.items;

import com.example.pichinchatest.catergories.model.Category;
import com.example.pichinchatest.catergories.repository.CategoriesRepository;
import com.example.pichinchatest.items.model.Items;
import com.example.pichinchatest.items.model.ItemsLogs;
import com.example.pichinchatest.items.model.ItemsRecord;
import com.example.pichinchatest.items.repository.ItemsLogsRepository;
import com.example.pichinchatest.items.repository.ItemsRecordRepository;
import com.example.pichinchatest.items.repository.ItemsRepository;
import com.example.pichinchatest.items.representation.CreateItemRequest;
import com.example.pichinchatest.items.representation.ItemIdListRequest;
import com.example.pichinchatest.items.representation.ItemListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemsService {
    private final ItemsRepository itemsRepository;
    private final ItemsRecordRepository itemsRecordRepository;
    private final ItemsLogsRepository itemsLogsRepository;
    private final CategoriesRepository categoriesRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository, ItemsRecordRepository itemsRecordRepository, ItemsLogsRepository itemsLogsRepository, CategoriesRepository categoriesRepository) {
        this.itemsRepository = itemsRepository;
        this.itemsRecordRepository = itemsRecordRepository;
        this.itemsLogsRepository = itemsLogsRepository;
        this.categoriesRepository = categoriesRepository;
    }

    public ItemsLogs createItemInCategory(CreateItemRequest categoryRequest){
        Items newItem = Items.builder()
                .name(categoryRequest.getName())
                .type(categoryRequest.getType())
                .build();
        if(!categoriesRepository.findById(categoryRequest.getCategoryId()).isPresent()){
            throw new RuntimeException("Category Id not exist", new Exception());
        }
        Category category = categoriesRepository.findById(categoryRequest.getCategoryId()).get();
        itemsRepository.save(newItem);
        ItemsRecord newItemsRecord = ItemsRecord.builder()
                .items(newItem)
                .category(category)
                .isIntoCategory(true)
                .build();
        itemsRecordRepository.save(newItemsRecord);
        ItemsLogs itemsLogs = ItemsLogs.builder()
                .items(newItem)
                .categoryId(category.getId())
                .isIntoCategory(true)
                .updatedAt(new Date())
                .build();
        itemsLogsRepository.save(itemsLogs);
        return itemsLogs;
    }

    public ItemsLogs updateItemInCategory(Long itemId, Long categoryId){
        if(!categoriesRepository.findById(categoryId).isPresent()){
            throw new RuntimeException("Category Id not exist", new Exception());
        }
        Category category = categoriesRepository.findById(categoryId).get();
        if(!itemsRepository.findById(itemId).isPresent()){
            throw new RuntimeException("Item Id not exist", new Exception());
        }
        Items item = itemsRepository.findById(itemId).get();
        ItemsRecord newItemsRecord = ItemsRecord.builder()
                .items(item)
                .category(category)
                .isIntoCategory(true)
                .build();
        itemsRecordRepository.save(newItemsRecord);
        ItemsLogs itemsLogs = ItemsLogs.builder()
                .items(item)
                .categoryId(category.getId())
                .isIntoCategory(true)
                .updatedAt(new Date())
                .build();
        itemsLogsRepository.save(itemsLogs);
        return itemsLogs;
    }

    public ItemsLogs deleteItemInCategory(Long itemId, Long categoryId){
        if(!categoriesRepository.findById(categoryId).isPresent()){
            throw new RuntimeException("Category Id not exist", new Exception());
        }
        Category category = categoriesRepository.findById(categoryId).get();
        if(!itemsRepository.findById(itemId).isPresent()){
            throw new RuntimeException("Item Id not exist", new Exception());
        }
        Items item = itemsRepository.findById(itemId).get();
        if(!itemsRecordRepository.findByCategoryAndItems(category,item).isPresent()){
            throw new RuntimeException("Internal API Error", new Exception());
        }
        ItemsRecord itemsRecord = itemsRecordRepository.findByCategoryAndItems(category,item).get();
        ItemsRecord updateItemsRecord = ItemsRecord.builder()
                .id(itemsRecord.getId())
                .items(item)
                .category(category)
                .isIntoCategory(false)
                .build();
        itemsRecordRepository.save(updateItemsRecord);
        ItemsLogs itemsLogs = ItemsLogs.builder()
                .items(item)
                .categoryId(category.getId())
                .isIntoCategory(false)
                .updatedAt(new Date())
                .build();
        itemsLogsRepository.save(itemsLogs);
        return itemsLogs;
    }


    public List<ItemsLogs> updateItemListInCategory(long categoryId, ItemListRequest request){
        if(!categoriesRepository.findById(categoryId).isPresent()){
            throw new RuntimeException("Category Id not exist", new Exception());
        }
        Category category = categoriesRepository.findById(categoryId).get();
        List<ItemsLogs> itemsLogsList = new ArrayList();
        request.getItemList().forEach(
                item ->{
                    Items newItem = Items.builder().build();
                    if(item.getId() == null){
                        newItem = Items.builder()
                                .name(item.getName())
                                .type(item.getType())
                                .build();
                    }
                    else{
                        if(itemsRepository.findById(item.getId()).isPresent()){
                            newItem = itemsRepository.findById(item.getId()).get();
                        }
                        else{
                            newItem = Items.builder()
                                    .name(item.getName())
                                    .type(item.getType())
                                    .build();
                        }
                    }
                    itemsRepository.save(newItem);
                    ItemsRecord newItemsRecord = ItemsRecord.builder()
                            .items(newItem)
                            .category(category)
                            .isIntoCategory(true)
                            .build();
                    itemsRecordRepository.save(newItemsRecord);
                    ItemsLogs itemsLogs = ItemsLogs.builder()
                            .items(newItem)
                            .categoryId(category.getId())
                            .isIntoCategory(true)
                            .updatedAt(new Date())
                            .build();
                    itemsLogsRepository.save(itemsLogs);
                    itemsLogsList.add(itemsLogs);
                }
        );
        return itemsLogsList;
    }

    public List<ItemsLogs> deleteItemListInCategory(long categoryId, ItemIdListRequest request){
        if(!categoriesRepository.findById(categoryId).isPresent()){
            throw new RuntimeException("Category Id not exist", new Exception());
        }
        Category category = categoriesRepository.findById(categoryId).get();
        List<ItemsLogs> itemsLogsList = new ArrayList();
        request.getItemIdList().forEach(
                item ->{
                    if(!itemsRepository.findById(item).isPresent()){
                        throw new RuntimeException("Item Id not exist", new Exception());
                    }
                    Items updateItem = itemsRepository.findById(item).get();
                    if(!itemsRecordRepository.findByCategoryAndItems(category,updateItem).isPresent()){
                        throw new RuntimeException("Internal API Error", new Exception());
                    }
                    ItemsRecord itemsRecord = itemsRecordRepository.findByCategoryAndItems(category,updateItem).get();
                    ItemsRecord updateItemsRecord = ItemsRecord.builder()
                            .id(itemsRecord.getId())
                            .items(updateItem)
                            .category(category)
                            .isIntoCategory(false)
                            .build();
                    itemsRecordRepository.save(updateItemsRecord);
                    ItemsLogs itemsLogs = ItemsLogs.builder()
                            .items(updateItem)
                            .categoryId(category.getId())
                            .isIntoCategory(false)
                            .updatedAt(new Date())
                            .build();
                    itemsLogsRepository.save(itemsLogs);
                    itemsLogsList.add(itemsLogs);
                }
        );
        return itemsLogsList;
    }

}
