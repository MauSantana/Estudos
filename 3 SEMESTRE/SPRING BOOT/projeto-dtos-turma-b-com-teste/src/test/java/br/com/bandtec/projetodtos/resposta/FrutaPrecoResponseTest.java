package br.com.bandtec.projetodtos.resposta;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrutaPrecoResponseTest {

    @Test // do pacote org.junit.jupiter.api...
    @DisplayName("valorTotalEstoque deve ser calculado corretamente")
    void valorTotalEstoque_deveEstarCalculadoCorretamente() {
        FrutaPrecoResponse resonse =
                new FrutaPrecoResponse(100,"maça", 10, 2.5);
        FrutaPrecoResponse resonse2 =
                new FrutaPrecoResponse(200,"morango", 3, 15.0);
        FrutaPrecoResponse resonse3 =
                new FrutaPrecoResponse(300,"banana", 1000, 50.5);

        assertEquals(25, resonse.getValorTotalEstoque());
        assertEquals(45, resonse2.getValorTotalEstoque());
        assertEquals(50500, resonse3.getValorTotalEstoque());
    }

    @Test
    @DisplayName("Construtor não deve aceitar preço e quant negativos")
    void construtor_naoDeveAceitar_nagativos() {

        assertThrows(IllegalArgumentException.class, () -> {
            new FrutaPrecoResponse(11, "melão", -50, -2.5);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new FrutaPrecoResponse(11, "melão", 50, -2.5);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new FrutaPrecoResponse(11, "melão", -50, 2.5);
        });
    }
}