package com.eureka.mscartoes.infra.repository;

import com.eureka.mscartoes.domain.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {

    List<ClientCard> findByCpf(String cpf);
}
