package com.example.ecommerceapplication.Service;

import com.example.ecommerceapplication.Config.CloudinaryConfig;
import com.example.ecommerceapplication.DAO.ProductDTO;
import com.example.ecommerceapplication.Entity.Product;
import com.example.ecommerceapplication.Entity.UsersModel;
import com.example.ecommerceapplication.Repository.ProductRepository;
import com.example.ecommerceapplication.Repository.UsersRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Data
@Service
@RequiredArgsConstructor
public class AdminService  {

    private final UsersRepository userRepository;
    private final ProductRepository productRepository;


    public Long findsUserLength(){
        return userRepository.count();
    }
    public Long findsProductLength(){
        return productRepository.count();
    }
    public List<Product> allProductJson(){
        return productRepository.findAll();
    }
    public List<UsersModel> allUser(){
        return userRepository.findAll();
    }
    public boolean saveProduct(Product product, MultipartFile image) throws IOException {
        boolean status = false;
        if (product.getName().isEmpty()){
            status=false;
        }else{
            Product products = new Product();
            products.setQty(product.getQty());
            products.setName(product.getName());
            products.setCategory(product.getCategory());
            products.setPrice(product.getPrice());
            CloudinaryConfig config = new CloudinaryConfig();
            String images = config.insert(image,product.getName());

            products.setImage(images);

            productRepository.save(products);
            status=true;


        }
        return status;

    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

}
