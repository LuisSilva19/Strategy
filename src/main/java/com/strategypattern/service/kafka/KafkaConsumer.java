package com.strategypattern.service.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.strategypattern.dtos.ManagementMessage;
import com.strategypattern.service.StrategyService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final StrategyService strategyService;
    private final ObjectMapper mapper;

    @KafkaListener(topics = "str-topic",
            groupId = "group-1",
            containerFactory = "jsonContainerFactory")
    public void execute(@Payload String message) throws JsonProcessingException {
        var msg = mapper.readValue(message, ManagementMessage.class);
        strategyService.getStrategy(msg);
    }
}