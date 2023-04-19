package com.example.ecommerceapplication.Repository.Products;

import com.example.ecommerceapplication.DAO.ProductDTO;
import com.example.ecommerceapplication.Entity.Product;

import java.util.List;

public interface ProductRep {
    List<Product> listsLimit();
    List<Product> listsAll();
    List<ProductDTO> getProductById(Long id);
}