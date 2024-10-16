package com.example.Test_FrayogiSitorus.repository;

import com.example.Test_FrayogiSitorus.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
