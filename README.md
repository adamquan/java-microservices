# Microservices Sample App

Sample Microservices application instrumented with OpenTelementry. Traces are sent to Grafana Cloud.

[Original Doc](https://www.getambassador.io/docs/telepresence/latest/quick-start/qs-java/)

1. Create k8s cluster in GKE
2. Deploy 
```
kubectl apply -f https://raw.githubusercontent.com/adamquan/java-microservices/main/k8s-config/edgey-corp-web-app-no-mapping.yaml
```


3. Clean up
```
kubectl delete -f https://raw.githubusercontent.com/adamquan/java-microservices/main/k8s-config/edgey-corp-web-app-no-mapping.yaml
```
