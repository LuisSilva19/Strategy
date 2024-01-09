package com.strategypattern.config;

import com.strategypattern.service.PlanTypePre;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.strategypattern.enums.TransactionType;
import com.strategypattern.strategy.IManagementStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Map;

@Configuration
public class StrategyConfig {

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper().findAndRegisterModules().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @Bean
    @Scope("singleton")
    public Map<TransactionType, IManagementStrategy> strategies(PlanTypePre typePre,
                                                                PlanTypePre typePos) {

        return Map.of(
                TransactionType.PRE, typePre,
                TransactionType.POS, typePos);
    }



}
