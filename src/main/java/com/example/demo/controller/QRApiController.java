package com.example.demo.controller;

import com.example.demo.dto.RequestQrDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.rest_service.QrService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/qr")
public class QRApiController {

    @Autowired
    private QrService qrService;

    @PostMapping("/generate")
    public ResponseDto generateQR(@RequestBody RequestQrDto requestQrDto) {
        log.info(requestQrDto.toString());
        return qrService.getQr(requestQrDto);
    }
}
