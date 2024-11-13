# Controle de Estoque

Este projeto visa desenvolver um sistema simples de controle de estoque como parte do projeto final (A3) da disciplina de Gestão e Qualidade de Software.


## Requisitos

- [Java 17](https://adoptium.net/temurin/releases/?os=windows&package=jdk&version=17) ou sperior;
- [Maven](https://maven.apache.org/download.cgi) para gerenciamento de dependências;
- [JUnit](https://junit.org/junit5/) para testes automatizados;


## Estrutura do Projeto

A estrutura do projeto segue a convenção do Maven, com o código-fonte localizado em `src/main/java` e os testes localizados em `src/test/java`.


## Testes

Os primeiros testes para este projeto foram realizados utilizando o **JUnit**. Os testes estão localizados no arquivo:

> src/test/java/com/controle_estoque/ControleEstoqueApplicationTests.java


### Testes Realizados

- **Testes nos métodos construtores**: Verificação se os objetos estão sendo corretamente inicializados com os valores passados para os construtores;
- **Testes nos métodos Getters e Setters**: Validação da correta manipulação de atributos através dos métodos *getters* e *setters*;
- **Testes no método toString()**: Verificação da saída do método **toString()**, garantindo que ele retorna a representação correta do objeto;


## Executando a Aplicação

Para rodar a aplicação, siga os seguintes passos:

- Clone o repositório:

```sh
git clone https://github.com/SEU_USUARIO/controle-estoque.git
```

- Crie o schema no banco de dados, por exemplo, `en_produto`.

- Modifique as configurações do banco de dados no arquivo `src/main/resources/application.properties`, ajustando o usuário, senha e URL conforme seu ambiente:

```sh
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_bd
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

- Compile o projeto utilizando Maven:

```sh
mvn clean install
```

- Para rodar os testes:

```sh
mvn test
```

---

## Licença

Este projeto está licenciado sob a [Licença MIT]().