package com.example.pichinchatest.catergories.model;

import com.example.pichinchatest.api.audit.AuditModel;
import com.example.pichinchatest.items.model.ItemsRecord;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "categories")
@ToString(exclude = {"listItemsRecord"})
public class Category extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemsRecord> listItemsRecord;

}
