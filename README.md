# Trabalho Final - Parser de Arquivos - TDD & Refactoring

## Alunos

|Nome            |Matrícula |
|----------------|----------|
|Bruno Duarte    |17/0138551|
|Eugênio Sales   |17/0033112|
|Gustavo Nogueira|17/0144259|

## Commits de Refactoring

- [Extrair Método](https://github.com/Tec-Prog-2021/trabalho-1-parser-de-resultados/commit/5f1a0efb3648bd29129c57f85f1b9fada8695da9)
- [Substituir Método por Objeto-método](https://github.com/Tec-Prog-2021/trabalho-1-parser-de-resultados/commit/3b1c2ee52cc47df08bd4e97110bc91654ff608d5)
- [Extrair Classe](https://github.com/Tec-Prog-2021/trabalho-1-parser-de-resultados/commit/e7b43aaed9254af7ef1a5e79558ec474d23a87aa)

## Uso

Para baixar as dependências:

```
$ mvn dependency:resolve
```

Para compilar:

```
$ mvn compile
```

Para executar:

```
$ mvn exec:java -Dexec.mainClass="parserapp.Main"
```

Para rodar os testes:

```
$ mvn test
```

Os arquivos de saída estarão localizados em: "./src/files"
