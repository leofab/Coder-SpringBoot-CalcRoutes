package com.coder.desafiospringbootcalccontroller.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

    @GetMapping(path = "/calculadora")
    public String CalculadoraIndex(){
        return "Working";
    }
}
