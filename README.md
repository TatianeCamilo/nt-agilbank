# 🐶 Dog API Test Automation

Projeto de automação de testes para a [Dog API](https://dog.ceo/dog-api/), desenvolvido com **Java**, **JUnit 5** e **RestAssured**, aplicando também **validação por JSON Schema**.

---

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone <URL_DO_REPO>
   cd dog-api-automation
   ```

2. Execute os testes com Maven:
   ```bash
   mvn clean test
   ```

3. Os relatórios de execução estarão em:
   ```
   target/surefire-reports
   ```

---

## ✅ Testes Implementados

- ✔️ **GET** `/breeds/list/all` – Listagem de todas as raças
- ✔️ **GET** `/breed/{breed}/images` – Imagens de uma raça específica
- ✔️ **GET** `/breeds/image/random` – Imagem aleatória de cachorro
- ⚠️ Testes negativos:
  - 🚫 Breed inválida (404)
  - 🚫 Método POST em endpoint GET (405)

---

## 🗂️ Estrutura do Projeto

```
dog-api-automation/
├── pom.xml                         # Gerenciador de dependências Maven
├── README.md                       # Documentação do projeto
├── src/
│   ├── main/
│   │   └── java/api/
│   │       ├── client/             # Cliente HTTP (RestAssured)
│   │       └── utils/              # Utilitários (ex: validador de JSON Schema)
│   └── test/
│       ├── java/tests/             # Casos de teste automatizados
│       └── resources/jsonSchemas/  # Schemas para validação de resposta
```

---

## 👩‍💻 Autor(a)

**Tatiane Correa Camilo**

---

## 📌 Requisitos

- Java 11+
- Maven 3.6+
