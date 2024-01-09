package com.strategypattern.dtos;

import com.strategypattern.enums.TransactionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ManagementMessage {
    private String name;
    private TransactionType type;
}