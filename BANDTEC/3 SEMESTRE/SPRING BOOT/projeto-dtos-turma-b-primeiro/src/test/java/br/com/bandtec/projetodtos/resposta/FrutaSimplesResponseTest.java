package br.com.bandtec.projetodtos.resposta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrutaSimplesResponseTest {

    @Test // do pacote org.junit.jupiter.api...
    void construtorIdNome_devePreencherIdNome() {
        FrutaSimplesResponse response =
                new FrutaSimplesResponse(100, "uva");

        assertEquals(100, response.getId());
        assertEquals("uva", response.getNome());
    }

}