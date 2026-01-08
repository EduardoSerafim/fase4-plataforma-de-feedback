# Fase 4 - Plataforma de Feedback
Projeto desenvolvido no Tech Challenge Fase 4 da Pós em Arquitetura e Desenvolvimento JAVA - FIAP

Aplicação backend em Java, Spring Boot, Quarkus e Cloud para receber e consultar feedbacks de alunos sobre as aulas.

**Branch principal: main**

## 2. Como rodar o projeto

### Executar localmente

```
mvn clean package
mvn spring-boot:run
```

### Executar com Docker

```
mvn clean package -DskipTests
docker build -t plataforma-feedback:latest .
docker run --rm -p 8081:8080 plataforma-feedback:latest
```

## Como testar o projeto inteiro

### Testes automatizados

```
mvn clean test
```

### Testes manuais com curl

#### Criar feedback (endpoint público)

```
curl -X POST http://localhost:8081/avaliacao -H "Content-Type: application/json" -d '{"descricao":"Aula de matemática excelente","nota":9}'
```

#### Listar (ADMIN)

```
curl -u admin:Admin@123 http://localhost:8081/avaliacao
```

#### Listar por urgência

```
curl -u admin:Admin@123 "http://localhost:8081/avaliacao/por-urgencia?tipo=ALTA"
```

#### Listar por período

```
curl -u admin:Admin@123 "http://localhost:8081/avaliacao/por-periodo?dataInicio=2025-11-24&dataFim=2025-11-24"
```

#### Resumo semanal

```
curl -u admin:Admin@123 http://localhost:8081/avaliacao/resumo-semanal
```
