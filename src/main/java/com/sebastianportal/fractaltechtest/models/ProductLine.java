package com.sebastianportal.fractaltechtest.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
public class ProductLine {
     private Product product;
     private Long qty;
     private Double totalPrice;
}
