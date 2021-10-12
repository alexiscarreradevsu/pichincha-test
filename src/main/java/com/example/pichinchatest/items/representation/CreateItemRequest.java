package com.example.pichinchatest.items.representation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Validated
@Builder
public class CreateItemRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("categoryId")
    private Long categoryId;

}

