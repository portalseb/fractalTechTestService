package com.sebastianportal.fractaltechtest.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private Double unitPrice;
}
