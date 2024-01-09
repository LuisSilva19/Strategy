package com.strategypattern.strategy;

import com.strategypattern.enums.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagementFactory {
    private final Map<TransactionType, IManagementStrategy> strategies;

    public IManagementStrategy getStrategy(TransactionType type) {
        return Optional.ofNullable(type)
                .map(strategies::get)
                .orElseThrow(IllegalArgumentException::new);
    }

}