package com.strategypattern.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.strategypattern.dtos.ManagementMessage;
import com.strategypattern.service.StrategyService;
import com.strategypattern.service.kafka.KafkaConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/strategy")
@RequiredArgsConstructor
public class StrategyController {
    private final StrategyService strategyService;
    private final KafkaConsumer kafkaConsumer;

    @PostMapping
    public void create(@RequestBody ManagementMessage message) throws JsonProcessingException {
        strategyService.getStrategy(message);
    }

    @PostMapping("/msg")
    public void createMsg(@RequestBody ManagementMessage message) throws JsonProcessingException {
        kafkaConsumer.execute("{\"name\": \"luis\", \"type\": \"PRE\"}");
    }
}