# Microservices Sample App

Sample Microservices application instrumented with OpenTelementry. Traces are sent to Grafana Cloud.

[Original Doc](https://www.getambassador.io/docs/telepresence/latest/quick-start/qs-java/) and [Blog](https://dzone.com/articles/rapidly-develop-java-microservices-on-kubernetes-w)

# Deploy in GKE

1. Create k8s cluster in GKE
2. Deploy from cloud shell
```
kubectl apply -f https://raw.githubusercontent.com/adamquan/java-microservices/main/k8s-config/edgey-corp-web-app-no-mapping.yaml
```
or locally

```
gcloud config set project solutions-engineering-248511
gcloud config set compute/zone us-central1-c
gcloud config set container/cluster adam-demo
gcloud auth login
gcloud container clusters get-credentials adam-demo --zone us-central1-c --project solutions-engineering-248511
kubectl create clusterrolebinding cluster-admin-binding --clusterrole=cluster-admin --user=adam.quan@grafana.com
kubectl create clusterrolebinding adam.quan-cluster-admin-binding --clusterrole=cluster-admin --user=adam.quan@grafana.com

kubectl apply -f https://raw.githubusercontent.com/adamquan/java-microservices/main/k8s-config/edgey-corp-web-app-no-mapping.yaml
```


3. Clean up
```
kubectl delete -f https://raw.githubusercontent.com/adamquan/java-microservices/main/k8s-config/edgey-corp-web-app-no-mapping.yaml
```

# Deploy in Docker

```
docker-compose up
```

Open browser and point to [http://localhost:8080](http://localhost:8080)

# Run locally

Start each serivce separately, see: 
- [VeryLargeJavaService](https://github.com/adamquan/java-microservices/tree/main/VeryLargeJavaService)
- [DataProcessingService](https://github.com/adamquan/java-microservices/blob/main/DataProcessingService/README.md)
- [VeryLargeDataStore](https://github.com/adamquan/java-microservices/blob/main/VeryLargeDataStore/README.md)
