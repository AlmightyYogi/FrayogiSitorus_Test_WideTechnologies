package com.example.Test_FrayogiSitorus.repository;

import com.example.Test_FrayogiSitorus.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
