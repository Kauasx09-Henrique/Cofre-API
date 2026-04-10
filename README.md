# 🛡️ Cofre API - Backend

Esta é a API robusta do **Cofre-API**, desenvolvida para gerenciar o armazenamento seguro de credenciais. O sistema foca em segurança, utilizando padrões modernos de autenticação e criptografia para proteger os dados dos usuários.

---

## 🚀 Tecnologias Utilizadas

O projeto foi construído utilizando as melhores práticas com as seguintes tecnologias:

* **Java 17**: Linguagem principal pela sua robustez e performance.
* **Spring Boot 3.x**: Framework para agilizar o desenvolvimento da aplicação.
* **Spring Security**: Camada de segurança para autenticação e autorização.
* **JSON Web Token (JWT)**: Para comunicação segura entre Front-end e Back-end.
* **PostgreSQL**: Banco de dados relacional para persistência de dados.
* **Maven**: Gerenciador de dependências e automação de build.

---

## 🛠️ Funcionalidades Principal

* **Cadastro de Usuários**: Registro de novos usuários com senhas criptografadas.
* **Autenticação**: Sistema de Login seguro que retorna um token JWT.
* **Cofre Seguro**: Endpoints protegidos que exigem o token para acesso.
* **Middleware de Segurança**: Validação de todas as requisições via Security Filter.

---

## ⚙️ Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/Kauasx09-Henrique/Cofre-API.git](https://github.com/Kauasx09-Henrique/Cofre-API.git)
    ```

2.  **Configure o banco de dados:**
    Certifique-se de ter o PostgreSQL rodando e ajuste as credenciais no arquivo `src/main/resources/application.properties`.

3.  **Compile e execute:**
    ```bash
    ./mvnw spring-boot:run
    ```

---

## 📁 Estrutura de Pastas (Back-end)

```text
src/main/java/com/kaua/api/
├── config/       # Configurações gerais
├── controller/   # Endpoints da API
├── model/        # Entidades do banco de dados
├── repository/   # Interface de comunicação com o banco
├── security/     # Filtros e configurações de segurança (JWT)
└── service/      # Regras de negócio
