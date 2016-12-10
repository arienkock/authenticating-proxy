# HTTP Basic Authenticating Proxy
Proxy server with configurable HTTP basic authentication. Useful for sitting in front of a web-application that is lacking basic security, like Solr and Elasticsearch.
Built using Spring Boot.

# Build
```
mvn package
```

# Usage
```
java -Xmx25m -jar target/authenticating-proxy-1.0-SNAPSHOT.jar --destination.url=http://docs.spring.io/ --security.user.password=testing
```

Now you can visit `http://localhost:8080/proxy/spring-boot/docs/1.4.1.RELEASE/reference/htmlsingle/`, which will require logging in with username/password: `user`/`testing`.
Supports all configuration methods of Spring Boot. 
