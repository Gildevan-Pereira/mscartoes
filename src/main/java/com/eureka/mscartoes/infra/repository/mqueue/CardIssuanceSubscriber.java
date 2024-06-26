package com.eureka.mscartoes.infra.repository.mqueue;

import com.eureka.mscartoes.domain.Cards;
import com.eureka.mscartoes.domain.ClientCard;
import com.eureka.mscartoes.domain.model.RequestDataForCardIssue;
import com.eureka.mscartoes.infra.repository.CardsRepository;
import com.eureka.mscartoes.infra.repository.ClientCardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CardIssuanceSubscriber {

    private final CardsRepository cardsRepository;
    private final ClientCardRepository clientCardRepository;

    @RabbitListener(queues = "${mq.queues.card-issuance}")
    public void receiveIssuanceRequest(@Payload String payload) {

        try {
            var mapper = new ObjectMapper();
            RequestDataForCardIssue data = mapper.readValue(payload, RequestDataForCardIssue.class);
            Cards card = cardsRepository.findById(data.getCardId()).orElseThrow();

            ClientCard clientCard = new ClientCard();
            clientCard.setCard(card);
            clientCard.setCpf(data.getCpf());
            clientCard.setCardLimit(data.getLimitReleased());

            clientCardRepository.save(clientCard);

        }catch (JsonProcessingException e){
            log.error("Erro ao receber solicitação de emissão de cartão: {} ", e.getMessage());
        }
    }
}
