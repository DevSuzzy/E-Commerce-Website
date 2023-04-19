package com.example.ecommerceapplication.Repository.UserRep;

import com.example.ecommerceapplication.DAO.CartDTO;

public interface CartRep {
    int increaseCartOrAddCart(CartDTO cartDTO);
    Long countCart(Long user_id);
}
