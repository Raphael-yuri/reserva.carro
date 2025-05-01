package reserva;

import java.util.HashMap;
import java.util.Map;

public class ReservaService {
    private final Map<String, String> carrosDisponiveis = new HashMap<>();
    private final Map<String, String> reservas = new HashMap<>();

    public void adicionarCarroDisponivel(String idCarro) {
        carrosDisponiveis.put(idCarro, "disponível");
    }

    public boolean isCarroDisponivel(String idCarro) {
        return "disponível".equals(carrosDisponiveis.get(idCarro));
    }

    public boolean reservarCarro(String idCarro, String usuario) {
        if (isCarroDisponivel(idCarro)) {
            reservas.put(idCarro, usuario);
            carrosDisponiveis.put(idCarro, "reservado");
            return true;
        }
        return false;
    }

    public String getStatusCarro(String idCarro) {
        return carrosDisponiveis.getOrDefault(idCarro, "desconhecido");
    }

    public String getUsuarioReserva(String idCarro) {
        return reservas.get(idCarro);
    }
}
