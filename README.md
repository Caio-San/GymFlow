# GymFlow API 🏋️‍♂️
API para gerenciamento de alunos, administradores e controle de presença em academias.
Permite cadastrar alunos e administradores, registrar intenções de presença,
confirmar presenças e visualizar lotação em tempo real.


Tecnologias utilizadas:
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (em memória para testes)



Para executar:
- Clonar repositório
 git clone https://github.com/caioSantana/GymFlow.git

- Entrar na pasta
 cd GymFlow

- Rodar com Maven
 mvn spring-boot:run



Endpoints principais:

POST /alunos → Cadastrar aluno

GET /alunos → Listar alunos

POST /administradores → Cadastrar administrador

POST /intencoes → Criar intenção de presença

GET /intencoes → Listar intenções

POST /presencas → Confirmar presença

GET /presencas/lotacao-tempo-real → Ver lotação em tempo real

Exemplos de Requisições estão no arquivo aluno_test.http
