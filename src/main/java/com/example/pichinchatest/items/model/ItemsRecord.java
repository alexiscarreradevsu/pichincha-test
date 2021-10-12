package com.example.pichinchatest.items.model;

import com.example.pichinchatest.api.audit.AuditModel;
import com.example.pichinchatest.catergories.model.Category;
import lombok.*;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "itemsrecord")
public class ItemsRecord extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isIntoCategory;

    @OneToOne
    @JoinColumn(name = "items_id", referencedColumnName = "id")
    private Items items;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}