package com.example.demo.rest_service;

import com.example.demo.dto.RequestQrDto;
import com.example.demo.dto.ResponseDto;

public interface QrService {
    ResponseDto getQr(RequestQrDto requestQrDto);
}
