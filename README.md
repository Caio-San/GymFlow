# GymFlow
### Sistema de Otimização de Lotação e Controle de Horários para Academias

Este projeto de backend, desenvolvido em Java e Spring Boot, tem como objetivo principal o controle de acesso e a otimização da lotação em ambientes de academia. Ele permite o cadastro de alunos e administradores, o agendamento de intenções de presença e o registro de presenças em tempo real, fornecendo uma visão clara da capacidade do local.


### Tecnologias

* **Linguagem:** Java 17
* **Framework:** [Spring Boot](https://spring.io/projects/spring-boot)
* **Persistência:** [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* **Gerenciador de Dependências:** [Maven](https://maven.apache.org/)
* **Banco de Dados:** [H2 Database](https://www.h2database.com/html/main.html) (para testes e desenvolvimento)
* **Validação:** [Spring Validation](https://docs.spring.io/spring-framework/reference/core/validation/overview.html)



### Como Rodar o Projeto

1.  **Pré-requisitos:**
    * Java Development Kit (JDK) 17 ou superior
    * Maven

2.  **Clonar o Repositório:**
    ```bash
    git clone [https://github.com/SeuUsuario/GymFlow.git](https://github.com/SeuUsuario/GymFlow.git)
    cd GymFlow
    ```

3.  **Executar a Aplicação:**
    ```bash
    mvn spring-boot:run
    ```
    A aplicação estará disponível em `http://localhost:8080`.




### Endpoints da API

A API foi desenvolvida seguindo o padrão RESTful. A seguir, uma lista dos principais endpoints:

| URL                      | Método | Descrição                                    |
| ------------------------ | ------ | -------------------------------------------- |
| `/alunos`                | `POST`   | Cadastra um novo aluno.                      |
| `/alunos`                | `GET`    | Lista todos os alunos cadastrados.           |
| `/administradores`       | `POST`   | Cadastra um novo administrador.              |
| `/administradores`       | `GET`    | Lista todos os administradores.              |
| `/intencoes`             | `POST`   | Cria uma intenção de presença para um aluno. |
| `/intencoes`             | `GET`    | Lista todas as intenções de presença.        |
| `/presencas`             | `POST`   | Registra a presença de um aluno.             |
| `/presencas`             | `GET`    | Lista todas as presenças.                    |
| `/presencas/lotacao-tempo-real` | `GET`    | Retorna a contagem atual de pessoas na academia. |

---

#### Exemplo de Requisições

```markdown
**Cadastrar um Aluno (POST)**

* **URL:** `http://localhost:8080/alunos`
* **Headers:** `Content-Type: application/json`
* **Body:**
    ```json
    {
      "cpf": "12345678900",
      "nome": "Caio Santana"
    }
```

