package com.App.orderservice.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    private String orderId;
    private LocalDateTime orderDate;
    private String clientId;

    @OneToMany(
            mappedBy = "productOrder",
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Product> orderProducts;
}
