package com.example.ecommerceapplication.DAO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CartDTO {
    private long id;
    private Long user_id;
    private Long product_id;
    private int qty;

}
