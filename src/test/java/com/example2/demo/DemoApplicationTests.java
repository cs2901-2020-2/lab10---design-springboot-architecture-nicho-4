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

//@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@Test
public class DemoApplicationTests {
    SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private UsuarioService service;

    @MockBean
    private UsuarioRepository repository;

    @Test //(expectedExceptions=IllegalStateException.class)
    public void testCreateUsuario() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setHash("1234");
        usuario.setSexo(1);
        usuario.setCodigo((long) 2018104); 
        usuario.setPrimerNombre("Luis");
        usuario.setVigencia(1); 
        usuario.setApellidoPaterno("Cordero");
        usuario.setApellidoMaterno("Pinela"); 
        usuario.setEmail("luis.cordero@utec.edu.pe"); 
        usuario.setNombre("Luis"); 
        usuario.setPasswd("gatito123");
        usuario.setSegundoNombre("Alejandro"); 
        usuario.setFechaCese(DateFor.parse("08/07/2019"));
        usuario.setDni("1029384");
        //repository.save(usuario);
        assertEquals("1234", usuario.getHash());
        assertEquals(1, usuario.getSexo());
        assertEquals("Luis", usuario.getPrimerNombre());
        assertEquals(1, usuario.getVigencia());
        assertEquals("Cordero", usuario.getApellidoPaterno());
        assertEquals("Pinela", usuario.getApellidoMaterno());
        assertEquals("luis.cordero@utec.edu.pe", usuario.getEmail());
        assertEquals("Luis", usuario.getNombre());
        assertEquals("gatito123", usuario.getPasswd());
        assertEquals("Alejandro", usuario.getSegundoNombre());
        assertEquals(DateFor.parse("08/07/2019"), usuario.getFechaCese());
        assertEquals("1029384", usuario.getDni());
    }

    @Test //(expectedExceptions=IllegalStateException.class)
    public void getUsersTest() throws Exception{
        Usuario usuario1 = new Usuario();
        usuario1.setHash("1234");
        usuario1.setSexo(1);
        usuario1.setCodigo((long) 2018104);
        usuario1.setPrimerNombre("Luis");
        usuario1.setVigencia(1);
        usuario1.setApellidoPaterno("Cordero");
        usuario1.setApellidoMaterno("Pinela");
        usuario1.setEmail("luis.cordero@utec.edu.pe");
        usuario1.setNombre("Luis");
        usuario1.setPasswd("gatito123");
        usuario1.setSegundoNombre("Alejandro");
        usuario1.setFechaCese(DateFor.parse("08/07/2019"));
        usuario1.setDni("1029384");

        Usuario usuario2 = new Usuario();
        usuario2.setHash("0987");
        usuario2.setSexo(0);
        usuario2.setCodigo((long) 2019103); 
        usuario2.setPrimerNombre("Angela");
        usuario2.setVigencia(1); 
        usuario2.setApellidoPaterno("Riveros");
        usuario2.setApellidoMaterno("Molina"); 
        usuario2.setEmail("angela.riveros@utec.edu.pe"); 
        usuario2.setNombre("Angela"); 
        usuario2.setPasswd("qwerty");
        usuario2.setSegundoNombre("Alexandra"); 
        usuario2.setFechaCese(DateFor.parse("10/05/2020"));
        usuario2.setDni("0192837");
        //when(repository.findAll()).thenReturn(Stream
                //.of(usuario1, usuario2).collect(Collectors.toList()));
        //assertEquals(2, service.findAll().size());
        assertEquals("1234", usuario1.getHash());
        assertEquals(1, usuario1.getSexo());
        assertEquals("Luis", usuario1.getPrimerNombre());
        assertEquals(1, usuario1.getVigencia());
        assertEquals("Cordero", usuario1.getApellidoPaterno());
        assertEquals("Pinela", usuario1.getApellidoMaterno());
        assertEquals("luis.cordero@utec.edu.pe", usuario1.getEmail());
        assertEquals("Luis", usuario1.getNombre());
        assertEquals("gatito123", usuario1.getPasswd());
        assertEquals("Alejandro", usuario1.getSegundoNombre());
        assertEquals(DateFor.parse("08/07/2019"), usuario1.getFechaCese());
        assertEquals("1029384", usuario1.getDni());
    }

}
