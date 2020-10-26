package com.example2.demo;

import data.entities.Usuario;
import data.repositories.UsuarioRepository;
import io.jsonwebtoken.lang.Assert;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Replace;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.*;
import java.text.*;

@SpringBootTest
@DataJpaTest
class DemoApplicationTests {

    private UsuarioRepository repo;

    @Test
    void contextLoads() throws ParseException {
        Usuario usuario = new Usuario("1234",1,(long) 20181044,"Luis", 7, "Cordero", "Pinela", "luis.cordero@utec.edu.pe", "Luis Alejandro", "gatito43", "Alejandro",  new SimpleDateFormat("dd/MM/yyyy").parse("17/07/1989"), "1029384");
        Usuario saveUsuario = repo.save(usuario);

    }

}
