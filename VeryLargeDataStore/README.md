# VeryLargeDataStore

## Build instructions. 
All commands assume that this folder is your working directory.

```
mvn clean install

docker build . -t adamquan/verylargedatastore

docker push adamquan/verylargedatastore
```

## Run locally
All commands assume that this folder is your working directory.
```
./mvnw spring-boot:run
```
