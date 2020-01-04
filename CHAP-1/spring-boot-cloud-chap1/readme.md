# Java Microservices with Spring Cloud: Developing Services


http://localhost:8080/greeting

```
Hi, from Spring Boot!
```

Actuator is mainly used to expose operational information about the running application – health, metrics, info, dump, env, etc. It uses HTTP endpoints or JMX beans to enable us to interact with it.

Monitoring our app, gathering metrics, understanding traffic or the state of our database becomes trivial with this dependency.

The main benefit of this library is that we can get production grade tools without having to actually implement these features ourselves.


# Spring Boot 1.x Actuator
In 1.x Actuator follows a R/W model, that means we can either read from it or write to it. E.g. we can retrieve metrics or the health of our application. Alternatively, we could gracefully terminate our app or change our logging configuration.

In order to get it working, Actuator requires Spring MVC to expose its endpoints through HTTP. No other technology is supported.

# Endpoints
In 1.x, Actuator brings its own security model. It takes advantage of Spring Security constructs, but needs to be configured independently from the rest of the application.

Also, most endpoints are sensitive – meaning they're not fully public, or in other words, most information will be omitted – while a handful is not e.g. /info.

Here are some of the most common endpoints Boot provides out of the box:

- /health – Shows application health information (a simple ‘status' when accessed over an unauthenticated connection or full message details when authenticated); it's not sensitive by default
- /info – Displays arbitrary application info; not sensitive by default
- /metrics – Shows ‘metrics' information for the current application; it's also sensitive by default
- /trace – Displays trace information (by default the last few HTTP requests)
We can find the full list of existing endpoints over on the official docs.

3.2. Configuring Existing Endpoints
Each endpoint can be customized with properties using the following format: endpoints.[endpoint name].[property to customize]

Three properties are available:

id – by which this endpoint will be accessed over HTTP
enabled – if true then it can be accessed otherwise not
sensitive – if true then need the authorization to show crucial information over HTTP
For example, add the following properties will customize the /beans endpoint:

1. endpoints.beans.id=springbeans
2. endpoints.beans.sensitive=false
3. endpoints.beans.enabled=true


Would we want to enable all of them, we could set ``management.endpoints.web.exposure.include=*``. Alternatively, we could list endpoints which should be enabled.

Actuator now shares the security config with the regular App security rules. Hence, the security model is dramatically simplified.

Therefore, to tweak Actuator security rules, we could just add an entry for /actuator/**:

```
@Bean
public SecurityWebFilterChain securityWebFilterChain(
  ServerHttpSecurity http) {
    return http.authorizeExchange()
      .pathMatchers("/actuator/**").permitAll()
      .anyExchange().authenticated()
      .and().build();
}
```

@ Result

http://localhost:8080/actuator

```
{
    "_links": {
        "self": {
            "href": "http://localhost:8080/actuator",
            "templated": false
        },
        "beans": {
            "href": "http://localhost:8080/actuator/beans",
            "templated": false
        },
        "caches-cache": {
            "href": "http://localhost:8080/actuator/caches/{cache}",
            "templated": true
        },
        "caches": {
            "href": "http://localhost:8080/actuator/caches",
            "templated": false
        },
        "health-path": {
            "href": "http://localhost:8080/actuator/health/{*path}",
            "templated": true
        },
        "health": {
            "href": "http://localhost:8080/actuator/health",
            "templated": false
        },
        "info": {
            "href": "http://localhost:8080/actuator/info",
            "templated": false
        },
        "conditions": {
            "href": "http://localhost:8080/actuator/conditions",
            "templated": false
        },
        "configprops": {
            "href": "http://localhost:8080/actuator/configprops",
            "templated": false
        },
        "env": {
            "href": "http://localhost:8080/actuator/env",
            "templated": false
        },
        "env-toMatch": {
            "href": "http://localhost:8080/actuator/env/{toMatch}",
            "templated": true
        },
        "loggers": {
            "href": "http://localhost:8080/actuator/loggers",
            "templated": false
        },
        "loggers-name": {
            "href": "http://localhost:8080/actuator/loggers/{name}",
            "templated": true
        },
        "heapdump": {
            "href": "http://localhost:8080/actuator/heapdump",
            "templated": false
        },
        "threaddump": {
            "href": "http://localhost:8080/actuator/threaddump",
            "templated": false
        },
        "metrics": {
            "href": "http://localhost:8080/actuator/metrics",
            "templated": false
        },
        "metrics-requiredMetricName": {
            "href": "http://localhost:8080/actuator/metrics/{requiredMetricName}",
            "templated": true
        },
        "scheduledtasks": {
            "href": "http://localhost:8080/actuator/scheduledtasks",
            "templated": false
        },
        "mappings": {
            "href": "http://localhost:8080/actuator/mappings",
            "templated": false
        }
    }
}
```

http://localhost:8080/actuator/env

