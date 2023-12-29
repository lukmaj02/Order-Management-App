package com.App.orderservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_table")
public class Product {
    @Id
    private String productOrderId;
    private String productName;
    private String productId;
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    @JsonIgnore
    private Order productOrder;
}
