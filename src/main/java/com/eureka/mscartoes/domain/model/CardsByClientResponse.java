package com.eureka.mscartoes.domain.model;

import com.eureka.mscartoes.domain.ClientCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardsByClientResponse {

    private String name;
    private String brand;
    private BigDecimal limitReleased;

    public static CardsByClientResponse fromEntity(ClientCard card) {
        return new CardsByClientResponse(
                card.getCard().getName(),
                card.getCard().getBrand().toString(),
                card.getCardLimit()
        );
    }

}
