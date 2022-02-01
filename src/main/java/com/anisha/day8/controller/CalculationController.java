package com.anisha.day8.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "calculation")

public class CalculationController {
    @GetMapping(value = "addition")
    public int add() {
        int s = 1 + 2 + 3;
        return s;
    }

    @PostMapping(value = "multiply")
    public int mul(@RequestBody VarClass varClass) {
        int m = varClass.getA() * varClass.getB();
        return m;
    }

    @RequestMapping(value = "subtract", method = RequestMethod.GET)
    public double sub() {
        return 5 - 6;
    }

    @RequestMapping(value = "divide/{a}/{b}", method = RequestMethod.GET)
    public int div(@PathVariable int a, @PathVariable int b) {
        log.info("Path variables : a{}, b{}", a, b);
        int d = a / b;
        return d;
    }

    @RequestMapping(value = {"simplify", "simplify/{b}"}, method = RequestMethod.GET)
    public int simp(@PathVariable(required = false) Integer b) {

        if (b != null) {
            int num1 = 1;
            log.info("Path variables : a{}, b{}", num1, b);
            int d = -(num1 + b);
            return d;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "dialog")
    public String message(@RequestParam(name = "name", defaultValue = "Anisha") String name) {
        return name;
    }

}
