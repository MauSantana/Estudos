package br.com.bandtec.projetodtos.controle;

import br.com.bandtec.projetodtos.dominio.Fruta;
import br.com.bandtec.projetodtos.repositorio.FrutaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class FrutaControllerTest {

    @Autowired
    FrutaController controller;

    @MockBean
    FrutaRepository repository;

    @Test
    void get_semFrutas_status204SemCorpo(){

        when(repository.findAll()).thenReturn(new ArrayList<>());



        ResponseEntity resposta = controller.get();

        assertEquals(204, resposta.getStatusCodeValue());

        assertNull(resposta.getBody());

        assertFalse(resposta.hasBody());
    }

    @Test
    void get_comFrutas_status200ListaNoCorpo() {

        List<Fruta> frutasMock = List.of(mock(Fruta.class), mock(Fruta.class));
        when(repository.findAll()).thenReturn(frutasMock);

        ResponseEntity resposta = controller.get();

        assertEquals(200, resposta.getStatusCodeValue());

        assertTrue(resposta.hasBody());

        assertEquals(frutasMock, resposta.getBody());

    }

}