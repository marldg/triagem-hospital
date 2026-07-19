# Sistema de Triagem Hospitalar

API REST em Java/Spring Boot para gerenciar fila de atendimento hospitalar, priorizando pacientes por nível de gravidade (Protocolo de Manchester).

## Tecnologias
- Java + Spring Boot
- Spring Data JPA + H2 (banco em memória)
- Lombok + Maven

## Como rodar
```bash
git clone https://github.com/seu-usuario/hospital-triagem.git
cd hospital-triagem
./mvnw spring-boot:run
```
Servidor sobe em `http://localhost:8080`.

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| POST | `/triagem/entrada` | Cadastra um paciente |
| GET | `/triagem/fila` | Lista a fila ordenada por prioridade |
| POST | `/triagem/chamar-proximo` | Chama e remove o mais prioritário |

**Exemplo de cadastro:**
```json
{
  "nome": "Carlos Mendes",
  "gravidade": "VERMELHO"
}
```

**Níveis de gravidade:** `VERMELHO` · `LARANJA` · `AMARELO` · `VERDE` · `AZUL`
