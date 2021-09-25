start docker-compose -f src/main/resources/docker/db.yml up
pause
start mvn spring-boot:run
start http://localhost:8080/swagger-ui.html#/