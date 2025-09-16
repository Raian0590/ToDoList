# 📝 Todo List API - Spring Boot

Uma **API RESTful** completa para gerenciamento de tarefas desenvolvida com **Spring Boot**.

## 🚀 Funcionalidades

- ✅ **CRUD Completo**: Criar, listar, editar e excluir tarefas via API
- ✅ **Status de Conclusão**: Marcar/desmarcar tarefas como concluídas
- ✅ **API RESTful**: Endpoints padronizados e bem documentados
- ✅ **Tratamento de Erros**: Validações e mensagens de erro estruturadas
- ✅ **Persistência de Dados**: Integração com banco MySQL


## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **Spring Web**
- **MySQL Database**
- **Lombok**
- **Maven**

## 📋 Pré-requisitos

- Java 21 ou superior
- Maven 3.6+
- MySQL 8.0+
- Navegador web moderno

## ⚙️ Configuração e Instalação

### 1. Clone o repositório
```bash
git clone https://github.com/Raian0590/ToDoList
cd todo-list
```

### 2. Configure o banco de dados
```sql
CREATE DATABASE todolist;
```

### 3. Configure as propriedades da aplicação
Edite o arquivo `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todolist
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
```

### 4. Execute a aplicação
```bash
# Usando Maven Wrapper (recomendado)
./mvnw spring-boot:run

# Ou usando Maven instalado
mvn spring-boot:run
```

### 5. Teste a API
A aplicação estará rodando em: http://localhost:8080

Teste os endpoints:
```bash
# Listar todas as tarefas
curl http://localhost:8080/tasks

# Criar uma nova tarefa
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"name": "Minha primeira tarefa", "description": "Descrição da tarefa", "completed": false}'
```

## 📚 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/raian/todo_list/
│   │   ├── config/
│   │   │   └── WebConfig.java              # Configuração CORS
│   │   ├── controllers/
│   │   │   └── TaskController.java         # Endpoints REST
│   │   ├── entities/
│   │   │   └── Task.java                   # Entidade JPA
│   │   ├── exceptions/
│   │   │   ├── ErrorResponse.java          # Resposta de erro
│   │   │   ├── GlobalExceptionHandler.java # Tratamento global de erros
│   │   │   └── TaskNotFoundException.java  # Exceção personalizada
│   │   ├── repositories/
│   │   │   └── TaskRepository.java         # Interface JPA Repository
│   │   ├── services/
│   │   │   └── TaskService.java            # Lógica de negócio
│   │   └── TodoListApplication.java        # Classe principal
│   └── resources/
│       └── application.properties          # Configurações da aplicação
└── test/
    └── java/com/raian/todo_list/
        └── TodoListApplicationTests.java
```

## 🌐 Endpoints da API

| Método | Endpoint | Descrição | Corpo da Requisição |
|--------|----------|-----------|-------------------|
| `GET` | `/tasks` | Lista todas as tarefas | - |
| `GET` | `/tasks/{id}` | Busca tarefa por ID | - |
| `POST` | `/tasks` | Cria nova tarefa | `{"name": "string", "description": "string", "completed": boolean}` |
| `PUT` | `/tasks/{id}` | Atualiza tarefa completa | `{"name": "string", "description": "string", "completed": boolean}` |
| `DELETE` | `/tasks/{id}` | Exclui tarefa | - |

### Exemplo de Requisição
```bash
# Criar nova tarefa
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Estudar Spring Boot",
    "description": "Aprender sobre desenvolvimento de APIs REST",
    "completed": false
  }'
```

### Exemplo de Resposta
```json
{
  "id": 1,
  "name": "Estudar Spring Boot",
  "description": "Aprender sobre desenvolvimento de APIs REST",
  "completed": false
}
```

## 🧪 Testando a API

### Usando cURL

```bash
# Listar todas as tarefas
curl http://localhost:8080/tasks

# Buscar tarefa por ID
curl http://localhost:8080/tasks/1

# Criar uma nova tarefa
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Estudar Spring Boot",
    "description": "Aprender sobre desenvolvimento de APIs REST",
    "completed": false
  }'

# Atualizar uma tarefa
curl -X PUT http://localhost:8080/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Estudar Spring Boot - Concluído",
    "description": "Aprendi sobre desenvolvimento de APIs REST",
    "completed": true
  }'

# Excluir uma tarefa
curl -X DELETE http://localhost:8080/tasks/1
```

### Usando Postman ou Insomnia

1. **GET** `http://localhost:8080/tasks` - Listar tarefas
2. **POST** `http://localhost:8080/tasks` - Criar tarefa
3. **GET** `http://localhost:8080/tasks/{id}` - Buscar por ID
4. **PUT** `http://localhost:8080/tasks/{id}` - Atualizar tarefa
5. **DELETE** `http://localhost:8080/tasks/{id}` - Excluir tarefa

## 🚨 Tratamento de Erros

A aplicação trata os seguintes cenários:
- **Tarefa não encontrada** (404): Quando ID não existe
- **Dados inválidos** (400): Validação de campos obrigatórios
- **Erro de servidor** (500): Problemas internos da aplicação

## 🔧 Possíveis Melhorias

- [ ] Documentação com Swagger/OpenAPI
- [ ] Autenticação e autorização (JWT)
- [ ] Paginação e ordenação
- [ ] Filtros e busca por tarefas
- [ ] Validações mais robustas
- [ ] Categorias ou tags para tarefas
- [ ] Data de vencimento para tarefas
- [ ] Testes unitários e de integração
- [ ] Docker containerization
- [ ] CI/CD pipeline
- [ ] Logs estruturados
- [ ] Métricas e monitoramento

## 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👤 Autor

**Raian** - [GitHub](https://github.com/Raian0590)

## 📞 Suporte

Se você tiver alguma dúvida ou sugestão, sinta-se à vontade para abrir uma issue no repositório.

---

⭐ **Se este projeto te ajudou, não se esqueça de dar uma estrela!**
