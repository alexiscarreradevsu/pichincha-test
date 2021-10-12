package com.example.pichinchatest.catergories.representation;

import com.example.pichinchatest.items.model.Items;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemsInCategoryResponse {

    @JsonProperty("items")
    private Items items;

    @JsonProperty("isIntoCategory")
    private boolean isIntoCategory;

}
