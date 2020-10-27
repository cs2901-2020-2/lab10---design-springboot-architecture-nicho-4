package com.example2.demo;

import business.UsuarioService;
import data.entities.Usuario;
import data.repositories.UsuarioRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

//import org.junit.jupiter.api.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class DemoApplicationTests {
    SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private UsuarioService service;

    @MockBean
    private UsuarioRepository repository;

    @Test (expectedExceptions=IllegalStateException.class)
    public void testCreateUsuario()throws ParseException{
        Usuario usuario = new Usuario("1234", 1, (long) 2018104,"Luis", 1, "Cordero", "Pinela", "luis.cordero@utec.edu.pe","Luis", "gatito123", "Alejandro", DateFor.parse("08/07/2019"), "1029384");
        repository.save(usuario);
    }

    @Test (expectedExceptions=IllegalStateException.class)
    public void getUsersTest() throws ParseException{
        Usuario usuario1 = new Usuario("1234", 1, (long) 2018104,"Luis", 1, "Cordero", "Pinela", "luis.cordero@utec.edu.pe","Luis", "gatito123", "Alejandro", DateFor.parse("08/07/2019"), "1029384");
        Usuario usuario2 = new Usuario("0987", 0, (long) 2019103,"Angela", 1, "Riveros", "Molina", "angela.riveros@utec.edu.pe","Angela", "qwerty", "Alexandra", DateFor.parse("10/05/2020"), "0192837");
        when(repository.findAll()).thenReturn(Stream
                .of(usuario1, usuario2).collect(Collectors.toList()));

        assertEquals(2, service.findAll().size());

    }

}
