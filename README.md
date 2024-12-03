# Controle de Estoque

Este projeto visa desenvolver um sistema simples de controle de estoque como parte do projeto final (A3) da disciplina de Gestão e Qualidade de Software.


## Requisitos

- [Java 17](https://adoptium.net/temurin/releases/?os=windows&package=jdk&version=17) ou sperior;
- [Maven](https://maven.apache.org/download.cgi) para gerenciamento de dependências;
- [JUnit](https://junit.org/junit5/) para testes automatizados;


## Estrutura do Projeto

A estrutura do projeto segue a convenção do Maven, com o código-fonte localizado em `src/main/java` e os testes localizados em `src/test/java`.


## Testes

Os primeiros testes para este projeto foram realizados utilizando o **JUnit**. Os testes estão localizados no diretório:

> src/test/java/com/controle_estoque

<br>

### Testes Realizados

- **Testes unitários**:
    - **testConstrutorCompleto**: Verifica se o construtor completo inicializa corretamente os atributos `nome`, `descricao`, `preco`, `quantidadeEstoque` e `ativo`;
    - **testConstrutorSemAtivo**: Testa o construtor sem o parâmetro `ativo`, garantindo que o valor padrão de ativo seja `true`;
    - **testGettersAndSetters**: Confirma se os métodos `getters` e `setters` estão funcionando corretamente para todos os atributos da classe;
    - **testToString**: Verifica se o método `toString()` retorna a representação correta do objeto Produto;

- **Testes de integração (Repository)**:
  - **testSalvarProduto**: Verifica se um produto é salvo corretamente e se o `ID` é gerado;
  - **testBuscarProdutoPorId**: Testa a busca de um produto pelo seu `ID`, garantindo que o produto salvo seja encontrado corretamente;
  - **testAtualizarProduto**: Verifica se um produto pode ser atualizado corretamente no banco de dados;
  - **testDeletarProduto**: Testa a exclusão de um produto, garantindo que ele seja removido do banco de dados;
  - **testSalvarProdutoInvalido**: Verifica se uma exceção é lançada ao tentar salvar um produto com dados inválidos (campos obrigatórios ausentes);

- **Testes de integração (Resource)**:
  - **testPostProduto**: Testa a criação de um novo produto através do endpoint `POST /api/produtos`, verificando o retorno correto do produto com `ID` gerado e atributos correspondentes.
  - **testListProduto**: Testa a listagem de produtos no endpoint `GET /api/produtos`, garantindo que pelo menos um produto seja retornado e tenha os valores esperados.
  - **testGetProdutoById**: Verifica a busca de um produto por `ID` no endpoint `GET /api/produtos/{id}`, confirmando os atributos corretos do produto retornado.
  - **testPutProduto**: Testa a atualização de um produto existente via `PUT /api/produtos/{id}`, verificando se as alterações são refletidas corretamente.
  - **testDeleteProduto**: Verifica a exclusão de um produto através do `DELETE /api/produtos/{id}` e garante que o produto não seja encontrado após a exclusão.

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
