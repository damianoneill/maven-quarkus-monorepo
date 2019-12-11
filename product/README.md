# quarkus based monorepo

```console
product
├── Dockerfile
├── README.md
├── build-tools
│   ├── pom.xml
│   └── src
│       └── main
│           └── resources
├── common
│   ├── pom.xml
│   └── src
│       ├── main
│       │   └── java
│       └── test
│           └── java
├── parent
│   └── pom.xml
├── pom.xml
└── service
    ├── common
    │   ├── pom.xml
    │   └── src
    │       ├── main
    │       └── test
    ├── customers
    │   ├── pom.xml
    │   └── src
    │       ├── main
    │       └── test
    ├── orders
    │   ├── pom.xml
    │   └── src
    │       ├── main
    │       └── test
    ├── parent
    │   └── pom.xml
    └── pom.xml
```

## CVE Checks

```console
mvn clean install -Pcve
```

## Building the native binary

Before running this, ensure you've looked in [graalvm-setup.sh](../graalvm-setup.sh).

```console
mvn package -Pnative -pl service/customers
```

## Running the native binary

```console
./service/customers/target/customers-0.0.1-SNAPSHOT-runner
2019-12-11 22:00:08,794 INFO  [io.quarkus] (main) customers 0.0.1-SNAPSHOT (running on Quarkus 1.0.1.Final) started in 0.025s. Listening on: http://0.0.0.0:8080
2019-12-11 22:00:08,795 INFO  [io.quarkus] (main) Profile prod activated.
2019-12-11 22:00:08,795 INFO  [io.quarkus] (main) Installed features: [cdi, resteasy, smallrye-health]
```

## Building a native image

```console
docker build --build-arg MICROSERVICE=customers -t acme.org/product/customers:latest .
```

## Running the native image

```console
docker run -i --rm -p 8080:8080 acme.org/product/customers:latest
```
