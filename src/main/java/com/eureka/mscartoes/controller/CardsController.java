package com.eureka.mscartoes.controller;

import com.eureka.mscartoes.domain.Cards;
import com.eureka.mscartoes.domain.ClientCard;
import com.eureka.mscartoes.domain.model.CardsByClientResponse;
import com.eureka.mscartoes.domain.model.CardsDto;
import com.eureka.mscartoes.service.CardsService;
import com.eureka.mscartoes.service.ClientCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardsController {

    private final CardsService cardsService;
    private final ClientCardService clientCardService;

    @GetMapping
    public String status(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity register(@RequestBody CardsDto request){
        Cards cards = request.toDto();
        cardsService.save(cards);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Cards>> getCardsIncomeTo(@RequestParam("income") Long income){
        List<Cards> list = cardsService.getCardsEqualsLowerIncome(income);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardsByClientResponse>> getCardsByClient(
            @RequestParam("cpf") String cpf){

        List<ClientCard> list = clientCardService.listCardByCpf(cpf);
        List<CardsByClientResponse> responseList = list.stream()
                .map(CardsByClientResponse::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }
}
