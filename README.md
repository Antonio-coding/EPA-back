## README: EPA-back

**Introdução:**

O projeto EPA-back é uma aplicação Spring Boot que atua como backend para um sistema de controle de acesso a áreas restritas. Este README fornece instruções para executar a aplicação localmente pela primeira vez.

**Pré-requisitos:**

- Java 11 ou superior instalado
- Maven instalado
- PostgreSQL instalado e configurado com um banco de dados chamado `epa_test`
- Usuário e senha de acesso ao banco de dados PostgreSQL

**Etapas de Instalação:**

1. **Clonar o Repositório:**

   ```bash
   git clone https://github.com/your-username/epa-back.git
   cd epa-back
   ```

2. **Instalar Dependências:**

   Execute o seguinte comando no diretório do projeto:

   ```bash
   mvn install
   ```

   Este comando baixará e instalará todas as dependências necessárias para o projeto.

3. **Configurar o Banco de Dados:**

   Abra o arquivo `application.properties` localizado em `src/main/resources`. Substitua os valores de placeholder pelas suas credenciais de banco de dados:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/epa_test
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. **Executar a Aplicação:**

   Execute o seguinte comando no diretório do projeto:

   ```bash
   mvn spring-boot:run
   ```

   Este comando iniciará a aplicação Spring Boot em segundo plano. Abra seu navegador e acesse `http://localhost:8080` para visualizar a aplicação.

5. **Testar a Conexão com o Banco de Dados:**

   Você pode verificar se a aplicação está se conectando corretamente ao banco de dados acessando o endpoint `/api/health`. Se a resposta for `{"status":"OK"}`, a conexão está funcionando.

**Observações:**

- O arquivo `application.properties` contém outras configurações que você pode ajustar de acordo com suas necessidades.
- Se você não tiver o PostgreSQL instalado, pode usar outro banco de dados compatível com Hibernate.
- Para mais informações sobre a aplicação, consulte o código-fonte e a documentação.

**Contribuições:**

Se você tiver alguma sugestão ou melhoria para o projeto, sinta-se à vontade para contribuir no repositório GitHub.

**Agradecimentos:**

Agradeço a todos que contribuíram para o desenvolvimento deste projeto.
