package runner;

import org.junit.jupiter.api.Test;
import reserva.ReservaService;

import static org.junit.jupiter.api.Assertions.*;

class ReservaServiceTest {

    @Test
    void deveReservarCarroDisponivelComSucesso() {
        ReservaService service = new ReservaService();
        service.adicionarCarroDisponivel("123");

        boolean resultado = service.reservarCarro("123", "usuario1");

        assertTrue(resultado);
        assertEquals("reservado", service.getStatusCarro("123"));
        assertEquals("usuario1", service.getUsuarioReserva("123"));
    }

    @Test
    void naoDeveReservarCarroIndisponivel() {
        ReservaService service = new ReservaService();
        boolean resultado = service.reservarCarro("999", "usuario2");

        assertFalse(resultado);
    }
}
