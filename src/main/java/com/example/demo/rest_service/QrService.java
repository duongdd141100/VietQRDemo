package com.example.demo.rest_service;

import com.example.demo.dto.RequestQrDto;
import com.example.demo.dto.ResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface QrService {
    ResponseDto getQr(RequestQrDto requestQrDto) throws JsonProcessingException;
}
