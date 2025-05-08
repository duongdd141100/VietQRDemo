package com.example.demo.rest_service.impl;

import com.example.demo.dto.RequestQrDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.rest_service.QrService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class QrServiceImpl implements QrService {
    private final RestTemplate restTemplate = new RestTemplate();

    private final String url = "https://app-api.vietqr.io/organizations/2d1989fa2b0d11f0af1a00224817c240/templates/x5g5m26/testqr";

    @Override
    public ResponseDto getQr(RequestQrDto requestQrDto) {
        HttpHeaders headers = getHttpHeaders();

        HttpEntity<RequestQrDto> entity = new HttpEntity<>(requestQrDto, headers);
        ResponseDto responseDto = restTemplate.postForEntity(url, entity, ResponseDto.class).getBody();
        log.info(responseDto.toString());
        return responseDto;
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImR1b25nZGQxNDExMDBAZ21haWwuY29tIiwiZmlyc3RfbmFtZSI6IkTGsMahbmciLCJsYXN0X25hbWUiOiLEkOG7lyDEkOG7qWMiLCJhdmF0YXJfdXJsIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUNnOG9jSkxMek43Y0trYVlyR0hLNTh0X2czUE5uVUpDcFE2eEVzTUhOTm5ESERPdzRrX3dwYz1zOTYtYyIsImlkIjoxODI0OCwib3JnYW5pemF0aW9uX2lkIjoiMmQxOTg5ZmEyYjBkMTFmMGFmMWEwMDIyNDgxN2MyNDAiLCJjcmVhdGVkX2F0IjoiMjAyNS0wNS0wN1QwNjozMzoyNC4wMDFaIiwiaWF0IjoxNzQ2NTk5NjA0LCJleHAiOjE3NDY4NTg4MDR9.bUhn0nTm7iDpa7Qo5JXyGXnnGZUe8Ib45Pn9r9E3iJg");
        return headers;
    }
}
