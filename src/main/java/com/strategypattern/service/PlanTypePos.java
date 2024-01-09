package com.strategypattern.service;

import com.strategypattern.strategy.IManagementStrategy;
import com.strategypattern.dtos.ManagementMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlanTypePos implements IManagementStrategy {

    @Override
    public void execute(ManagementMessage message) {
        log.info("test POS");
    }
}