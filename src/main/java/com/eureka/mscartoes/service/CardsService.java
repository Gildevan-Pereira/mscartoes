package com.eureka.mscartoes.service;

import com.eureka.mscartoes.domain.Cards;
import com.eureka.mscartoes.infra.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsService {

    private final CardsRepository cardsRepository;

    @Transactional
    public Cards save(Cards cards) {
        return cardsRepository.save(cards);
    }

    public List<Cards> getCardsEqualsLowerIncome(Long renda) {
        BigDecimal incomeBigDecimal = BigDecimal.valueOf(renda);
        return cardsRepository.findByIncomeLessThanEqual(incomeBigDecimal);
    }
}
