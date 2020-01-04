# Java Microservices with Spring Cloud: Developing Services

Make sure RateController and thymeleaf will work with the @Controller annotation only.

Please make sure ``spring-boot-cloud-chap2-config-server-git`` is up & running.

```
JavaHelper Training: Spring Cloud Config Client
Your rate is: 2.00, number of lanes is 1, toll start time is 05:00 and encrypted value is db24ba12fdfbd64ad916605c2a4754e7e205b17e3bec97eab03e05ddcfc0d72f26dca00ff0be5b34d45533b2665f945303d8254eb842964cbac64379e144494e553a96baa8c913fdb84eacfee7c09fdd!
```

Now, change the ``spring.profiles.active=qa``, you should see different output

```
JavaHelper Training: Spring Cloud Config Client
Your rate is: 1.99, number of lanes is 2, toll start time is 05:00 and encrypted value is db24ba12fdfbd64ad916605c2a4754e7e205b17e3bec97eab03e05ddcfc0d72f26dca00ff0be5b34d45533b2665f945303d8254eb842964cbac64379e144494e553a96baa8c913fdb84eacfee7c09fdd!
```

RefreshScope added 

HTTP POST with the Basic Auth

``
http://localhost:8080/refresh
``

Response

```
[
   "config.client.version",
   "rate"
]
```