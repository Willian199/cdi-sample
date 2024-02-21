./mvnw clean package -DskipTests -Dnative -Dquarkus.native.container-build=true
docker build -f src/main/docker/Dockerfile.native-micro -t quay.io/will/cdi-sample .