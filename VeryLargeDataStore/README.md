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
All commands assume that this folder is your working directory. The `server.port` option configures the port the service is listening on. Default is `8080`, which might conflict with the `VeryLargeJavaService` service if you run them on the same host.

To run the service without OTEL instrumentation:
```
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=4000"
```

To run the service with OTEL instrumentation:
```
export JAVA_TOOL_OPTIONS="-javaagent:./opentelemetry-javaagent.jar"
export OTEL_TRACES_EXPORTER=otlp
export OTEL_EXPORTER_OTLP_TRACES_ENDPOINT=https://tempo-us-central1.grafana.net:443
export OTEL_SERVICE_NAME=verylargedatastore
export OTEL_EXPORTER_OTLP_TRACES_HEADERS="Authorization=Bearer 160639:eyJrIjoiYjkzMDA1NDE0ODRhYWRjYzgwNjg0YTJlNzcyZmY0MThmMDNiOTRjMiIsIm4iOiJ0ZXN0IiwiaWQiOjYwMTM4MH0="
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=4000"
```
