package com.sebastianportal.fractaltechtest.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
@NoArgsConstructor
public class Order {
    @Id
    private String id;
    @Indexed(unique=true)
    private Long orderNo;
    private LocalDateTime date;
    private List<Product> products;
    private double finalPrice;

}
