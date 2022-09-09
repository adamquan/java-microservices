# VeryLargeJavaService

## Build instructions. 
All commands assume that this folder is your working directory.

```
mvn clean install

docker build . -t adamquan/verylargejavaservice

docker push adamquan/verylargejavaservice
```

If you are building the image from an ARM machine for AMD target, run

```
docker build . -t adamquan/verylargejavaservice --platform amd64
```

## Run locally
All commands assume that this folder is your working directory.
```
./mvnw spring-boot:run -Dspring-boot.run.arguments="--nodeservice.host=localhost"
```
