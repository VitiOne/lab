package com.lab.infrastructure.h2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "prices")
@Entity(name = "prices")
public class Prices {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "price_Id")
    private Long priceId;

    @Column(name = "price_list")
    private Long priceList;

    @Column(name = "brand_Id")
    private Long brandId;

    @Column(name = "start_Date")
    private LocalDateTime startDate;

    @Column(name = "end_Date")
    private LocalDateTime endDate;

    @Column(name = "product_Id")
    private Long productId;

    @Column(name = "priority")
    private Long priority;

    @Column(name = "price")
    private Double price;

    @Column(name = "curr")
    private String currency;
}
