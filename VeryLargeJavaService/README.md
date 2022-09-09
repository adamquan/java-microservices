# VeryLargeJavaService

## Build instructions. 
All commands assume that this folder is your working directory.

```
mvn clean install

docker build . -t adamquan/verylargejavaservice

docker push adamquan/verylargejavaservice
```

## Run locally
All commands assume that this folder is your working directory.
```
./mvnw spring-boot:run -Dspring-boot.run.arguments="--nodeservice.host=localhost"
```
