Feature: Reserva de carro

  Scenario: Usuário realiza uma reserva de carro com sucesso
    Given que o usuário está autenticado
    And há um carro disponível com ID "123"
    When o usuário solicita a reserva do carro com ID "123"
    Then a reserva deve ser criada com sucesso
    And o status do carro deve ser "reservado"
