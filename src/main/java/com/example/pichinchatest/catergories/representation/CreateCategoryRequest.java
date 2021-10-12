package com.example.pichinchatest.catergories.representation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Validated
@Builder
public class CreateCategoryRequest {

    @JsonProperty("category")
    private String category;

}

