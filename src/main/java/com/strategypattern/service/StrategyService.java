package com.strategypattern.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.strategypattern.dtos.ManagementMessage;
import com.strategypattern.enums.TransactionType;
import com.strategypattern.strategy.IManagementStrategy;
import com.strategypattern.strategy.ManagementFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StrategyService {
    private final ManagementFactory factory;

    public void getStrategy(ManagementMessage message) throws JsonProcessingException {
        var strategy = factory.getStrategy(message.getType());
        strategy.execute(message);
    }
}
