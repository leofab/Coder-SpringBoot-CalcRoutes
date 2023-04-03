package com.coder.desafiospringbootcalccontroller.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalcController {

    @GetMapping("{firstValue}")
    public Integer CalculadoraIndex(@PathVariable(name = "firstValue") Model model, Integer firstValue){
        System.out.println(firstValue);
        return firstValue;
    }

}
