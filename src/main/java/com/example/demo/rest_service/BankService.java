package com.example.demo.rest_service;

import com.example.demo.dto.BankDto;

import java.util.List;

public interface BankService {
    List<BankDto> getAllBanks();
}
