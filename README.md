
# Sistema de Ponto

## Descrição
Este é o projeto **Sistema de Ponto**, uma aplicação de gerenciamento de ponto de funcionários, onde é possível registrar, editar e consultar informações sobre funcionários, turnos, justificativas e pontos.

## Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA
- Thymeleaf
- MySQL

## Como rodar o projeto

1. Certifique-se de ter o Java 17 e o MySQL instalados em sua máquina.
2. Clone este repositório:
   ```
   git clone https://github.com/salomaotech/projeto-ponto.git
   ```
3. Navegue até o diretório do projeto:
   ```
   cd projeto-ponto
   ```
4. Configure o banco de dados no arquivo `application.properties`:
   ```properties
   spring.application.name=projeto-ponto
   spring.datasource.url=jdbc:mysql://localhost:3307/ascamara_database
   spring.datasource.username=root
   spring.datasource.password=123456
   spring.jpa.hibernate.ddl-auto=update
   ```
5. Execute o projeto usando o comando Maven:
   ```
   mvn spring-boot:run
   ```

## Endpoints

1. **Home**
   - **URL**: `localhost:8080/tela/home`
   - **Descrição**: Página inicial.

2. **Cadastro de Funcionário**
   - **URL**: `localhost:8080/tela/cadastro_funcionario`
   - **Descrição**: Página para cadastrar um novo funcionário.

3. **Edição de Funcionário**
   - **URL**: `localhost:8080/tela/cadastro_funcionario/{id}`
   - **Descrição**: Página para editar os dados de um funcionário existente, onde `{id}` é o ID do funcionário.

4. **Cadastro de Turno**
   - **URL**: `localhost:8080/tela/cadastro_turno`
   - **Descrição**: Página para cadastrar um novo turno.

5. **Edição de Turno**
   - **URL**: `localhost:8080/tela/cadastro_turno/{id}`
   - **Descrição**: Página para editar um turno existente, onde `{id}` é o ID do turno.

6. **Cadastro de Justificativa**
   - **URL**: `localhost:8080/tela/cadastro_justificativa`
   - **Descrição**: Página para cadastrar uma nova justificativa.

7. **Edição de Justificativa**
   - **URL**: `localhost:8080/tela/cadastro_justificativa/{id}`
   - **Descrição**: Página para editar uma justificativa existente, onde `{id}` é o ID da justificativa.

8. **Cadastro de Ponto**
   - **URL**: `localhost:8080/tela/cadastro_ponto`
   - **Descrição**: Página para cadastrar um novo ponto.

9. **Edição de Ponto**
   - **URL**: `localhost:8080/tela/cadastro_ponto/{id}`
   - **Descrição**: Página para editar um ponto existente, onde `{id}` é o ID do ponto.

## Dependências

As principais dependências do projeto são:

- `spring-boot-starter-web`: Para configuração do servidor web.
- `spring-boot-starter-data-jpa`: Para integração com o banco de dados MySQL usando JPA.
- `spring-boot-starter-thymeleaf`: Para a renderização de páginas HTML.

## Configuração do Banco de Dados

O arquivo `application.properties` deve conter as informações de conexão com o banco de dados MySQL:

```properties
spring.application.name=projeto-ponto
spring.datasource.url=jdbc:mysql://localhost:3307/ascamara_database
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
```

## Contribuição

Se você deseja contribuir com o projeto, por favor, siga as etapas abaixo:

1. Faça um fork do repositório.
2. Crie uma nova branch para suas alterações (`git checkout -b minha-branch`).
3. Realize as alterações e faça um commit (`git commit -am 'Adiciona nova funcionalidade'`).
4. Envie para o repositório remoto (`git push origin minha-branch`).
5. Crie um Pull Request.

## Licença

Este projeto é licenciado sob a MIT License.
