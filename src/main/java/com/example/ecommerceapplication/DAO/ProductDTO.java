package com.example.ecommerceapplication.DAO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String category;
    private Integer price;
    private String image;
    private int qty;

    public ProductDTO(String name,String category,String image,Integer price,int qty) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.qty = qty;
        this.image = image;

    }
}
