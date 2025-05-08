package com.example.demo.rest_service.impl;

import com.example.demo.dto.BankDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.rest_service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BankServiceImpl implements BankService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<BankDto> getAllBanks() {
        ResponseDto response = restTemplate.getForEntity("https://api.vietqr.io/v2/banks", ResponseDto.class).getBody();
        log.info(response.toString());
        return (List<BankDto>) response.getData();
    }
}
