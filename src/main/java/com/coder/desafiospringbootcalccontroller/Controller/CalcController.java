package com.coder.desafiospringbootcalccontroller.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalcController {

    @GetMapping
    public String CalculadoraIndex(){
        return "Working";
    }
}
