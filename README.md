# GastroHub - Tech Challenge (Fase 01)
<p align="center">
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java badge" />
<img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring badge" />
<img src="https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white" alt="Swagger badge" />
<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL badge" />
<img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white" alt="Docker badge" />  
<img src="https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white" alt="Git badge" />
</p>
<hr>
  
Trabalho da fase 01 da Pós Tech em Arquitetura e Desenvolvimento Java da FIAP.
## Instruções de execução
1. **Crie o arquivo `.env`:**  
   No diretório raiz do projeto, crie um arquivo chamado `.env` contendo as variáveis abaixo:

   ```shell
   POSTGRES_PASSWORD=mayra
   POSTGRES_USER=mayra
   POSTGRES_DB=tech_challenge
   POSTGRES_URL=jdbc:postgresql://postgres_container:5432/tech_challenge
   SPRING_PROFILES_ACTIVE=docker  
   ```

   Os valores de `POSTGRES_PASSWORD` e `POSTGRES_USER` podem ser definidos de acordo com a sua preferência.

2. **Suba os containers:**  
   No terminal, no diretório raiz do projeto, execute o comando abaixo para iniciar os containers:

   ```shell
   docker compose up -d
   ```

3. **Acesse a aplicação:**  
   Após os containers estarem em execução, você pode acessar:
   - A **documentação da aplicação**, [http://localhost/docs/swagger-ui](http://localhost/docs/swagger-ui).
    
4. **Desligue os containers:**  
   Para parar e remover os containers da aplicação, execute o comando abaixo no terminal:

   ```shell
   docker compose down
   ```
