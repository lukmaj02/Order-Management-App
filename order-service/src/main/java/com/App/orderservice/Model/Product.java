package com.App.orderservice.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_table")
public class Product {
    @Id
    private String productId;
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order productOrder;
}
