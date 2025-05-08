package com.example.demo.rest_service.impl;

import com.example.demo.dto.RequestQrDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.rest_service.QrService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class QrServiceImpl implements QrService {
    private final RestTemplate restTemplate = new RestTemplate();

    private final String url = "https://app-api.vietqr.io/organizations/2d1989fa2b0d11f0af1a00224817c240/templates/x5g5m26/testqr";

    String jsonBody = """
        {
          "accountName": "DO DUC DUONG",
          "accountNo": "0979719735",
          "acqId": "970415",
          "addInfo": "651651",
          "amount": "100000",
          "logo": "",
          "template": "compact",
          "theme": "compact"
        }
        """;


    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ResponseDto getQr(RequestQrDto requestQrDto) throws JsonProcessingException {
        requestQrDto.setAccountName("DO DUC DUONG");
        requestQrDto.setAmount("100000");
        requestQrDto.setAccountNo("0979719735");
        requestQrDto.setAddInfo("651651");

        HttpHeaders headers = getHttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImR1b25nZGQxNDExMDBAZ21haWwuY29tIiwiZmlyc3RfbmFtZSI6IkTGsMahbmciLCJsYXN0X25hbWUiOiLEkOG7lyDEkOG7qWMiLCJhdmF0YXJfdXJsIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUNnOG9jSkxMek43Y0trYVlyR0hLNTh0X2czUE5uVUpDcFE2eEVzTUhOTm5ESERPdzRrX3dwYz1zOTYtYyIsImlkIjoxODI0OCwib3JnYW5pemF0aW9uX2lkIjoiMmQxOTg5ZmEyYjBkMTFmMGFmMWEwMDIyNDgxN2MyNDAiLCJjcmVhdGVkX2F0IjoiMjAyNS0wNS0wN1QwNjozMzoyNC4wMDFaIiwiaWF0IjoxNzQ2NTk5NjA0LCJleHAiOjE3NDY4NTg4MDR9.bUhn0nTm7iDpa7Qo5JXyGXnnGZUe8Ib45Pn9r9E3iJg");
        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
            String responseDto = restTemplate.postForEntity(url, requestQrDto, String.class).getBody();
            log.info(responseDto.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return null;
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImR1b25nZGQxNDExMDBAZ21haWwuY29tIiwiZmlyc3RfbmFtZSI6IkTGsMahbmciLCJsYXN0X25hbWUiOiLEkOG7lyDEkOG7qWMiLCJhdmF0YXJfdXJsIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUNnOG9jSkxMek43Y0trYVlyR0hLNTh0X2czUE5uVUpDcFE2eEVzTUhOTm5ESERPdzRrX3dwYz1zOTYtYyIsImlkIjoxODI0OCwib3JnYW5pemF0aW9uX2lkIjoiMmQxOTg5ZmEyYjBkMTFmMGFmMWEwMDIyNDgxN2MyNDAiLCJjcmVhdGVkX2F0IjoiMjAyNS0wNS0wN1QwNjozMzoyNC4wMDFaIiwiaWF0IjoxNzQ2NTk5NjA0LCJleHAiOjE3NDY4NTg4MDR9.bUhn0nTm7iDpa7Qo5JXyGXnnGZUe8Ib45Pn9r9E3iJg");
        return headers;
    }
}
