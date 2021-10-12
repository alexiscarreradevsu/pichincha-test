package com.example.pichinchatest.items.model;


import com.example.pichinchatest.api.audit.AuditModel;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "itemslogs")
public class ItemsLogs extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    @OneToOne
    @JoinColumn(name = "items_id", referencedColumnName = "id")
    private Items items;

    private Long categoryId;

    private boolean isIntoCategory;
}