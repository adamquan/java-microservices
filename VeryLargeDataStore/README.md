# VeryLargeDataStore

## Build instructions. 
All commands assume that this folder is your working directory.

```
mvn clean install

docker build . -t adamquan/verylargedatastore

docker push adamquan/verylargedatastore
```

If you are building the image from an ARM machine for AMD target, run

```
docker build . -t adamquan/verylargedatastore --platform amd64
```

## Run locally
All commands assume that this folder is your working directory.
```
./mvnw spring-boot:run --server.port=4000
```
