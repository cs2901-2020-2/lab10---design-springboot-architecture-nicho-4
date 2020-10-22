package com.example2.demo;

import data.entities.Usuario;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class DemoApplicationTests {

    @RepeatedTest(10)
    void contextLoads() {
        Usuario usuario = new Usuario("1234",1,20181044,"Luis", 7, "Cordero", "Pinela", "luis.cordero@utec.edu.pe", "Luis Alejandro", "gatito43", "Alejandro", 29/9/1988, "1029384");

    }

}
