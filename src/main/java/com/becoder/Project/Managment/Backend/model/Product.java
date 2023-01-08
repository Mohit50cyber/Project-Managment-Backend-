package com.becoder.Project.Managment.Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product {

    @Id
    private Integer id;
    private String productName;
    private String description;
    private Double price;
    private String status;

}
