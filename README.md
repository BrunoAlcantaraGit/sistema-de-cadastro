```mermaid
classDiagram
    class Cliente {
        Long id
        String nome
        String email
        String telefone
    }

    class Endereco {
        Long id
        String rua
        String cidade
        String estado
    }

    class Contato {
        Long id
        String tipo
        String valor
    }

    class Veiculo {
        Long id
        String marca
        String modelo
        String placa
    }

    Cliente "1" --> "0..*" Endereco : possui
    Cliente "1" --> "0..*" Contato : possui
