package com.strategypattern.strategy;

import com.strategypattern.dtos.ManagementMessage;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface IManagementStrategy {
    void execute(ManagementMessage message) throws JsonProcessingException;
}