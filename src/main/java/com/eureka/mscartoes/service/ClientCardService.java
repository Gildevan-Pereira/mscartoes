package com.eureka.mscartoes.service;

import com.eureka.mscartoes.domain.ClientCard;
import com.eureka.mscartoes.infra.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final ClientCardRepository clientCardRepository;

    public List<ClientCard> listCardByCpf(String cpf) {
        return clientCardRepository.findByCpf(cpf);
    }
}
