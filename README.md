# Gerenciador de Produtos com Spring Data

Projeto Spring Boot 3 com persistência em JPA (H2 em memória) e MongoDB, além de integração com API externa via Retrofit.

## Stack
- Java 17
- Spring Boot 3.3.x
- Maven
- Spring Data JPA
- Spring Data MongoDB
- H2 Database
- Retrofit 2 + Gson

## Estrutura de pacotes
- `controller`
- `model`
- `repository`
- `service`
- `client`

## Como executar
```bash
mvn spring-boot:run
```

## Endpoints principais
### Produtos
- `POST /api/produtos` - cadastra um produto e grava um log no MongoDB
- `GET /api/produtos` - lista todos os produtos
- `GET /api/produtos/consultar-cep/{cep}` - exemplo de consumo de API externa via Retrofit

## Exemplo de payload
```json
{
  "nome": "Notebook Dell",
  "preco": 4500.00
}
```

## Observações
- O banco relacional é em memória H2, acessível em: `http://localhost:8080/h2-console`
- O MongoDB local deve estar disponível em `mongodb://localhost:27017`

## Configuração de banco
No arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:h2:mem:produtosdb;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.data.mongodb.uri=mongodb://localhost:27017/gerenciador_produtos
```
