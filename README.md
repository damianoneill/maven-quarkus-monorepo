# Maven Quarkus Monorepo

The reference material used to influence decisions for this projects structure are available here:

- [Create an Aggregate Maven Project](https://access.redhat.com/documentation/en-US/Fuse_ESB_Enterprise/7.1/html/Getting_Started/files/Develop-Aggregator.html)
- [POM Best Practices](https://books.sonatype.com/mvnref-book/reference/pom-relationships-sect-pom-best-practice.html)
- [Using Aggregate and Parent POMs](https://www.smartics.eu/confluence/display/BLOG/2013/07/22/Using+Aggregate+and+Parent+POMs)
- [Aggregator vs Parent](http://rostislav-matl.blogspot.com/2011/12/maven-aggregator-vs-parent.html)

## Structure

The following principles will be adopted:

- A separate parent and aggregator POM will exist at the top-level (or any other grouping for e.g. the services folder) to support independent module versioning.
- Build Tools will have their own configuration module, per the [Apache recommendations](https://maven.apache.org/plugins/maven-pmd-plugin/examples/multi-module-config.html)
- Profiles will be used to allow building of nested modules e.g. -Pservices, -Pcve
- Quarkus Services will be modules below the service directory
- common modules will be created for both service and non-service (generic) code

## Quarkus specific

- To ensure that beans in a dependency get scanned when building a Quarkus service, [jandex](https://quarkus.io/guides/cdi-reference#how-to-generate-a-jandex-index) is used
- service application.properties includes a property quarkus.native.additional-build-args=-H:ResourceConfigurationFiles=resources-config.json to get the native build to load extra resources defined in resources-config.json

## Generic functionality

- includes pmd / checkstyle / cve checks plugins
- provides a generic endpoint /version (in services/common) for all services - info populated from git stats, as proof of CDI bean loading from a dependency
- provide a multi-stage Dockerfile for building native images
