package com.eureka.mscartoes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CardBrand brand;
    private BigDecimal income;
    private BigDecimal basicLimit;

    public Cards(String name, CardBrand brand, BigDecimal income, BigDecimal basicLimit) {
        this.name = name;
        this.brand = brand;
        this.income = income;
        this.basicLimit = basicLimit;
    }
}
