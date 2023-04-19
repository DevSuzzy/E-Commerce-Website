package com.example.ecommerceapplication.Service;

import com.example.ecommerceapplication.DAO.ProductDTO;
import com.example.ecommerceapplication.Entity.Cart;
import com.example.ecommerceapplication.Entity.Product;
import com.example.ecommerceapplication.Repository.CartRepository;
import com.example.ecommerceapplication.Repository.ProductRepository;
import com.example.ecommerceapplication.Repository.Products.ProductRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService implements ProductRep {
    private  final ProductRepository productRepository;

    private final CartRepository cartRepository;
    private final UsersServices usersServices;

   @Override
    public List<Product> listsLimit() {
        return productRepository.findByLimit();
    }

    @Override
    public List<Product> listsAll() {
        return  productRepository.findAll();
    }
    @Override
    public List<ProductDTO> getProductById(Long id) {
        List<Cart> cart = cartRepository.finds(id);
        List<ProductDTO> list = new ArrayList<>();
        for(int i=0;i<cart.size();i++){
            System.out.println(cart.get(i).getProduct_id());
            System.out.println(cart.get(i).getUser().getEmail());
            Product productList = productRepository.findProductById(cart.get(i).getProduct_id());
            ProductDTO product = new ProductDTO();
            product.setQty(cart.get(i).getQty());
            product.setId(productList.getId());
            product.setPrice(productList.getPrice());
            product.setName(productList.getName());
            product.setImage(productList.getImage());
            product.setCategory(productList.getCategory());
            list.add(product);
        }
        System.out.println(list);


        return list;
    }
}