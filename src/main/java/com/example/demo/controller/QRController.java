package com.example.demo.controller;

import com.example.demo.rest_service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QRController {

    @Autowired
    private BankService bankService;

    @RequestMapping("/qr")
    public String qr(Model model) {
        model.addAttribute("banks", bankService.getAllBanks());
        return "qr";
    }

}
