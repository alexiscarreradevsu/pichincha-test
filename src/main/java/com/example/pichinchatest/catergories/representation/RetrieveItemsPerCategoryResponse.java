package com.example.pichinchatest.catergories.representation;


import com.example.pichinchatest.items.model.Items;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetrieveItemsPerCategoryResponse {

    @JsonProperty("categoryId")
    private Long categoryId;

    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("itemsList")
    private List<Items> itemsList;

}
