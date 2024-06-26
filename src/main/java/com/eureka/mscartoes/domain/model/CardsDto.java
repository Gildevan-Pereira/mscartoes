package com.eureka.mscartoes.domain.model;

import com.eureka.mscartoes.domain.CardBrand;
import com.eureka.mscartoes.domain.Cards;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardsDto {

    private String name;
    private CardBrand brand;
    private BigDecimal income;
    private BigDecimal basicLimit;

    public Cards toDto() {
        return new Cards(name, brand, income, basicLimit);
    }

}
