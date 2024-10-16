package com.example.Test_FrayogiSitorus.service;

import com.example.Test_FrayogiSitorus.model.OrderCart;
import com.example.Test_FrayogiSitorus.model.OrderItem;
import com.example.Test_FrayogiSitorus.model.Product;
import com.example.Test_FrayogiSitorus.repository.OrderCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCartService {

    @Autowired
    private OrderCartRepository orderCartRepository;

    @Autowired
    private ProductService productService;

    public OrderCart addItemsToCart(OrderCart orderCart) {
        for (OrderItem item : orderCart.getItems()) {
            Product product = productService.getProductById(item.getProduct().getId());

            if (product == null) {
                throw new IllegalArgumentException("Produk tidak ditemukan untuk ID: " + item.getProduct().getId());
            }

            item.setProduct(product);
            item.setPrice(product.getPrice());
            item.setName(product.getName());
            item.setType(product.getType());

            double total = item.getPrice() * item.getQuantity();
            item.setTotal(total);

            item.setOrderCart(orderCart);
        }

        return orderCartRepository.save(orderCart);
    }
}
