package com.app.pickupservice.Model;

import com.app.pickupservice.Enums.OrderType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="order")
public class Order {
    @Id
    public String id;
    private LocalDateTime orderedDate;
    private OrderType orderType;
}
