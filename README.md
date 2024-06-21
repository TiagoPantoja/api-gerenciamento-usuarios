# API Gerenciamento de Usuários

API de Gerenciamento de usuários desenvolvido em Java com Spring Boot, Hibernate para utilizar o JPA, banco de dados PostgreSQL e Flyway para organizar as migrações do banco.

## Arquitetura

A arquitetura é dividida em duas camadas:
1. **Back-end com Java 17 e Spring Boot**: Lógica de negócios, serviços, controle de exceções e comunicação com o banco de dados.

2. **Banco de dados PostgreSQL**: Armazenamento dos dados dos usuários e departamentos.

## Tecnologias Utilizadas
- Java 17;
- Spring Boot;
- PostgreSQL;
- JPA e Hibernate;
- Flyway para migração do banco de dados;
- Swagger para documentação da API;
- JUnit e Mockito para testes unitários.

## Configuração e Execução

### Pré-requisitos
Certifique-se de ter instalado em sua máquina:
- Java 17;
- Maven;
- Docker e Docker Compose (opcional, para executar o projeto com contêineres Docker)

### Configuração
1. Clone o repositório: `git clone https://github.com/TiagoPantoja/api-gerenciamento-usuarios.git`
2. Navegue até o diretório: `cd api-gerenciamento-usuarios`
3. Abra o arquivo `application.properties` em `src/main/resources` e configure o acesso ao banco de dados PostgreSQL.
4. Execute o projeto com Maven: `./mvnw spring-boot:run`

### Swagger
- Para acessar a documentação Swagger: `http://localhost:8080/swagger-ui/`

## Execução com Docker
Você pode executar a aplicação usando Docker e Docker Compose:
1. Certifique-se de ter Docker e Docker Compose instalados.
2. No diretório raiz, execute: `docker-compose up --build`

## Testes
Para executar os testes unitários:
1. Navegue até o diretório raiz do projeto.
2. Execute os testes com Maven: `./mvnw test`