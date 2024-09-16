+---------------------+      1       +------------------+
|      Cliente         |<-------------|     Endereco     |
+---------------------+               +------------------+
| - id: Long           |               | - id: Long       |
| - nome: String       |               | - rua: String    |
| - email: String      |               | - cidade: String |
| - telefone: String   |               | - estado: String |
+---------------------+               +------------------+
        | 1
        |        +-------------------+
        +-------<|     Contato        |
                 +-------------------+
                 | - id: Long         |
                 | - tipo: String     |
                 | - valor: String    |
                 +-------------------+

+---------------------+
|      Veículo         |
+---------------------+
| - id: Long           |
| - marca: String      |
| - modelo: String     |
| - placa: String      |
+---------------------+
