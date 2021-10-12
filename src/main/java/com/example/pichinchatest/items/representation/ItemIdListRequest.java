package com.example.pichinchatest.items.representation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Validated
@Builder
public class ItemIdListRequest {

    @JsonProperty("itemIdList")
    private List<Long> itemIdList;

}