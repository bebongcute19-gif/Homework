StoreX Docker Compose - Minimal Backend

1. Copy the 'backend' folder into D:\StoreX-Docker.
2. Build the image:
   docker build -t storex-backend:latest .\backend
3. Check:
   docker images
4. Start the whole environment:
   docker compose up -d
5. Check containers:
   docker compose ps
6. Check PostgreSQL:
   docker compose logs postgres
7. Check Backend:
   docker compose logs backend
8. Test in browser:
   http://localhost:8080/
   http://localhost:8080/api/health

Important:
Inside the Docker Compose network, Backend connects to PostgreSQL with:
jdbc:postgresql://postgres:5432/storex

Do NOT use localhost in SPRING_DATASOURCE_URL inside the backend container.
