package com.market.her.domain.service;


import com.market.her.domain.User;
import com.market.her.domain.dto.LoginRequest;
import com.market.her.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(int userId) {
        return userRepository.getUser(userId);
    }
    public Optional<User> userLogin(String user, String password) {
        return userRepository.loginUser(user,password);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }
/*
    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }*/
}
