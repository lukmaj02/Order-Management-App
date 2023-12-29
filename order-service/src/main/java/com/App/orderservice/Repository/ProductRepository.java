package com.App.orderservice.Repository;

import com.App.orderservice.Model.Order;
import com.App.orderservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository <Product, String> {
}
