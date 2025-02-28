# Projeto Finance System

Este projeto é uma aplicação web para agendamento de transferências financeiras, onde o backend é construído com **Spring Boot** e o frontend é desenvolvido com **Vue.js** e **DaisyUI**. A aplicação permite que os usuários agendem transferências financeiras, consultem as transferências agendadas e recebam feedback instantâneo sobre o sucesso ou falha dos agendamentos.

## Arquitetura do Sistema

O sistema é composto por duas principais camadas:

1. **Backend**:
    - Construído com **Spring Boot**.
    - Fornece uma API RESTful para o frontend interagir.
    - O backend gerencia as transferências, aplica regras de negócio e validação de dados (exemplo: cálculo de taxas).
    - **Banco de Dados**: Utiliza **H2** como banco de dados em memória.
    - **CORS Configurations** são usadas para gerenciar o compartilhamento de recursos entre diferentes origens.
  
2. **Frontend**:
    - Desenvolvido com **Vue.js** e **DaisyUI**.
    - A interface de usuário permite agendar transferências, visualizar agendamentos e obter feedback do sistema.
    - Consome a API RESTful fornecida pelo backend.

## Decisões Arquiteturais

### Backend

- **Spring Boot** foi escolhido devido à sua robustez e escalabilidade para sistemas baseados em microserviços.
- **JPA (Java Persistence API)** foi utilizado para persistência de dados com o banco de dados **H2**.
- **RESTful API** foi escolhida para a comunicação entre o frontend e o backend, garantindo flexibilidade e escalabilidade.
- **CORS (Cross-Origin Resource Sharing)** foi configurado para permitir a comunicação entre o frontend e o backend, que rodam em portas diferentes durante o desenvolvimento.

### Frontend

- **Vue.js** foi escolhido por sua simplicidade e reatividade.
- **DaisyUI** foi utilizado para criar uma interface de usuário limpa e responsiva, aproveitando a simplicidade e poder do **TailwindCSS**.
- **Axios** para realizar as requisições HTTP ao backend, garantindo uma comunicação simples e direta com a API.
- **Vite** ferramenta de build rápida e moderna para o frontend

## Ferramentas Utilizadas

- **Backend**:
    - **Spring Boot** (versão: `2.5.0`)
    - **JPA (Hibernate)** para ORM
    - **H2 Database** (em memória)
    - **Maven** para gerenciamento de dependências

- **Frontend**:
    - **Vue.js** (versão: `3.5.13`)
    - **DaisyUI** (baseado em **TailwindCSS**)
    - **Axios** para chamadas HTTP
    - **Node.js** (versão: `14.x.x` ou superior)

## Versões de Linguagens e Ferramentas

- **Java**: 11
- **Spring Boot**: 2.5.0
- **Node.js**: 22.14.0
- **Vue.js**: 3.5.13
- **TailwindCSS**: CDN Version
- **DaisyUI**: 4.12.24
- **Maven**: 4.0.0
- **Maven**: 6.2.0

## Como Rodar o Projeto

### 1. **Rodar o Backend (Spring Boot)**

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/finance-system.git
    cd finance-system
    ```

2. Navegue até a pasta do backend:

    ```bash
    cd backend
    ```

3. Instale as dependências do backend:

    ```bash
    mvn install
    ```

4. Para rodar o backend, execute o seguinte comando:

    ```bash
    mvn spring-boot:run
    ```

5. O backend estará disponível em `http://localhost:8080`.

### 2. **Rodar o Frontend (Vue.js)**

1. Navegue até a pasta do frontend:

    ```bash
    cd frontend
    ```

2. Instale as dependências do frontend:

    ```bash
    npm install
    ```

3. Para rodar o frontend, execute o seguinte comando:

    ```bash
    npm run serve
    ```

4. O frontend estará disponível em `http://localhost:5173`.
