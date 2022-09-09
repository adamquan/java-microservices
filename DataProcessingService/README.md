# DataProcessingService

## Build instructions. 
All commands assume that this folder is your working directory.

```
mvn clean install

docker build . -t adamquan/dataprocessingservice

docker push adamquan/dataprocessingservice
```

## Run locally
All commands assume that this folder is your working directory.
```
./mvnw spring-boot:run
```