package com.example.pichinchatest.catergories.representation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RetrieveAllInfoPerCategoryResponse {

    @JsonProperty("categoryId")
    private Long categoryId;

    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("itemsInformationList")
    private List<ItemsInCategoryResponse> itemsInformationList;

}
