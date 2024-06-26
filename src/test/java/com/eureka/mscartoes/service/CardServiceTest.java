package com.eureka.mscartoes.service;

import com.eureka.mscartoes.domain.CardBrand;
import com.eureka.mscartoes.domain.Cards;
import com.eureka.mscartoes.infra.repository.CardsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {

    @InjectMocks
    CardsService cardsService;

    @Mock
    CardsRepository cardsRepository;

    Cards cards;

    @BeforeEach
    void setUp() {
        cards = new Cards( 1L, "Bradesco Mastercard", CardBrand.MASTERCARD, BigDecimal.valueOf(5000.00), BigDecimal.valueOf(8000.00));
    }

    @Test
    public void testSaveCard() {
        when(cardsRepository.save(cards)).thenReturn(cards);

        Cards card = cardsService.save(cards);

        assertEquals(cards, card);
        verify((cardsRepository)).save(cards);

    }

}
