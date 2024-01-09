package com.strategypattern.service;

import com.strategypattern.strategy.IManagementStrategy;
import com.strategypattern.dtos.ManagementMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlanTypePre implements IManagementStrategy {

    @Override
    public void execute(ManagementMessage message) throws JsonProcessingException {
        log.info("test PRE");
    }
}