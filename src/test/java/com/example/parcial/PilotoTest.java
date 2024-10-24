package com.example.parcial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PilotoTest {
    @Test
    void crear_Piloto() {
        Piloto piloto = new Piloto("Juan", "Argentina");
        assertEquals("Juan", piloto.getNombre());
        assertEquals("Argentina", piloto.getNacionalidad());
    }


    @Test
    void prueba_de_que_anda_la_interfaz_test(){
        Piloto piloto = new Piloto("Juan", "Argentina");
        SponsorContrato contrato = new SponsorContrato(new Sponsor("Coca Cola"), "Argentina", null, null);
        
        piloto.agregar(contrato);
        assertEquals(1, piloto.getSponsors().size());
    }

    
}
