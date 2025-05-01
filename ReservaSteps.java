package steps;

import io.cucumber.java.pt.*;
import reserva.ReservaService;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaSteps {

    private ReservaService reservaService;
    private boolean reservaCriada;

    @Dado("que o usuário está autenticado")
    public void usuarioAutenticado() {
        reservaService = new ReservaService(); // Simulação de autenticação
    }

    @E("há um carro disponível com ID {string}")
    public void carroDisponivel(String idCarro) {
        reservaService.adicionarCarroDisponivel(idCarro);
    }

    @Quando("o usuário solicita a reserva do carro com ID {string}")
    public void solicitarReserva(String idCarro) {
        reservaCriada = reservaService.reservarCarro(idCarro, "usuario1");
    }

    @Entao("a reserva deve ser criada com sucesso")
    public void verificarReservaCriada() {
        assertTrue(reservaCriada);
    }

    @E("o status do carro deve ser {string}")
    public void verificarStatus(String statusEsperado) {
        assertEquals(statusEsperado, reservaService.getStatusCarro("123"));
    }
}