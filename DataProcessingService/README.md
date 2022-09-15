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
export JAVA_TOOL_OPTIONS="-javaagent:./opentelemetry-javaagent.jar"
export OTEL_TRACES_EXPORTER=otlp
export OTEL_EXPORTER_OTLP_TRACES_ENDPOINT=https://tempo-us-central1.grafana.net:443
export OTEL_SERVICE_NAME=verylargejavaservice
export OTEL_EXPORTER_OTLP_TRACES_HEADERS="Authorization=Bearer 160639:eyJrIjoiYjkzMDA1NDE0ODRhYWRjYzgwNjg0YTJlNzcyZmY0MThmMDNiOTRjMiIsIm4iOiJ0ZXN0IiwiaWQiOjYwMTM4MH0="
./mvnw spring-boot:run -Dspring-boot.run.arguments="--app.default.datastore.url=http://localhost:4000"
```
