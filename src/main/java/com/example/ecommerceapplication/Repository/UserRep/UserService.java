package com.example.ecommerceapplication.Repository.UserRep;
import com.example.ecommerceapplication.DAO.UserDTO;
import com.example.ecommerceapplication.Entity.Product;
import com.example.ecommerceapplication.Entity.UsersModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {
    boolean save(UserDTO userDTO);
    UsersModel authenticate(UserDTO userDTO);
    Model saveAllSession(Model model,UserDTO userDTO, HttpServletRequest https, String status);
    List<Product> listsLimit();
    List<Product> listsAll();
}