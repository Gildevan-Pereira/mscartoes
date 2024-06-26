package com.eureka.mscartoes.infra.repository;

import com.eureka.mscartoes.domain.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CardsRepository extends JpaRepository<Cards, Long> {

    List<Cards> findByIncomeLessThanEqual(BigDecimal income);
}
