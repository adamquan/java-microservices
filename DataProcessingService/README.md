# DataProcessingService

## Build instructions. 
All commands assume that this folder is your working directory.

```
mvn clean install

docker build . -t adamquan/dataprocessingservice

docker push adamquan/dataprocessingservice
```

If you are building the image from an ARM machine for AMD target, run

```
docker build . -t adamquan/dataprocessingservice --platform amd64
```

## Run locally
All commands assume that this folder is your working directory.
```
./mvnw spring-boot:run -Dspring-boot.run.arguments="--app.default.datastore.url=http://localhost:4000"
```
