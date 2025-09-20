# 📅 Event Code

Projeto de cadastro e gerenciamento de eventos desenvolvido em **Spring Boot**, seguindo boas práticas de **Clean Code** e **Clean Architecture**.  
O sistema permite criar e consultar eventos com diferentes formas de busca (**por ID, por identificador único e listagem completa**).

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.5**
    - Spring Web (APIs REST)
    - Spring Data JPA (persistência)
- **PostgreSQL** (banco de dados)
- **Flyway** (migração de banco de dados)
- **MapStruct** (mapeamento entre DTOs e entidades)
- **Lombok** (redução de boilerplate)
- **Maven** (gerenciamento de dependências e build)
- **JUnit 5** (testes unitários)

---

## 🏛️ Arquitetura

O projeto segue princípios de **Clean Architecture**, com separação clara entre camadas:

- **Controller (Presentation)** → expõe endpoints REST.
- **UseCases (Domínio)** → implementa regras de negócio (ex.: criar evento, buscar evento).
- **Gateway (Contrato)** → abstrai o acesso à infraestrutura.
- **Infrastructure** → implementações concretas (JPA, mapeadores, gerador de identificadores).
- **Repository** → comunicação com o banco via Spring Data JPA.

Fluxo simplificado ao criar um evento:

```
Controller → UseCase → Gateway → Repository → Banco de Dados
```

---

## 📂 Estrutura do Projeto

```
Event_Code/
├── cors/                # Configurações (CORS, filtros)
├── entitys/             # Entidades do domínio
├── enuns/               # Enumerações
├── gateway/             # Contratos do domínio
├── usecases/            # Casos de uso (regra de negócio)
│
├── infrastructure/      # Infraestrutura
│   ├── dto/             # DTOs
│   ├── gateway/         # Implementações dos gateways
│   ├── handle/          # Tratamento de exceções
│   ├── mapper/          # MapStruct (Entity ↔ DTO ↔ Domain)
│   ├── persistence/     # Repositórios Spring Data JPA
│   ├── presentation/    # Controllers REST
│   └── RandomIdentificador/ # Geração de identificadores
│
└── EventCodeApplication.java # Classe principal
```

---

## ⚙️ Configuração do Ambiente

### Pré-requisitos
- **Java 17**
- **Maven 3.9+**
- Banco **PostgreSQL** em execução

### Configuração do banco (`application.yml`)

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/event_code
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: true
```

As tabelas são controladas via **Flyway** em `src/main/resources/db/migration`.

---

## ▶️ Executando a Aplicação

```bash
mvn spring-boot:run
```

API disponível em:

```
http://localhost:8080/eventos
```

---

## 📌 Endpoints Disponíveis

### ➕ Criar Evento
`POST /eventos`

**Request body:**
```json
{
  "nome": "Hackathon Universitário",
  "descricao": "Competição de programação em equipe durante 48 horas",
  "capacidade": 200,
  "tipo": "NETWORK",
  "inicioevento": "2025-11-15T08:00:00",
  "terminoevento": "2025-11-17T20:00:00",
  "local_evento": "Centro de Convenções São Paulo",
  "identificador": "HCK2027",
  "organizador": "Associação Nacional de Tecnologia"
}
```

**Response (200):**
```json
{
  "Mensagem: ": "Evento criado com sucesso",
  "Evento: ": {
    "id": 1,
    "nome": "Hackathon Universitário",
    "descricao": "Competição de programação em equipe durante 48 horas",
    "capacidade": 200,
    "tipo": "NETWORK",
    "inicioevento": "2025-11-15T08:00:00",
    "terminoevento": "2025-11-17T20:00:00",
    "local_evento": "Centro de Convenções São Paulo",
    "identificador": "HCK2027",
    "organizador": "Associação Nacional de Tecnologia"
  }
}
```

---

### 🔍 Buscar Evento por ID
`GET /eventos/{id}`

---

### 📋 Listar Todos os Eventos
`GET /eventos/buscartodos`

---

### 🎯 Buscar Evento por Identificador
`GET /eventos/filtro/{identificador}`

---

## ✅ Boas Práticas Aplicadas

- Arquitetura limpa (**UseCases, Gateway, Infraestrutura, Controller**)
- **MapStruct** para conversão entre entidades, DTOs e domínio
- **Lombok** para evitar boilerplate
- **Flyway** para versionamento do banco
- Testes unitários com **JUnit 5**

---

## 🧑‍💻 Autor

Projeto desenvolvido por Felipe Neves como estudo e aplicação de **Spring Boot + Clean Code + Clean Architecture**.

---
