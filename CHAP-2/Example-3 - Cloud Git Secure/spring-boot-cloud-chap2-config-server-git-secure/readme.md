# Java Microservices with Spring Cloud: Developing Services

Now if you try to call http://localhost:8888/s1rates/default you should get error message !! We need to authenticate in order to call this service.

http://localhost:8888/s1rates/default

```
{
    "timestamp": "2020-01-04T15:45:32.186+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Unauthorized",
    "path": "/s1rates/default"
}
```

``security.basic.enabled = false`` you basically tell the application that I don't care about security and allow all the request what so ever. After spring boot 2.0 , you cant just write that 1 configuration to make the app insecure. You need to write some code to do that . Or you can just copy the following.


Simply try to call ``http://localhost:8888/s1rates/default``, you should ask for username and password and enter ``test`` or ``admin``
which we've configured in ``WebSecurityConfigurerAdapter``.


![Alt text](2.png?raw=true "Title")


# Best Links To Setup Security

- https://stackoverflow.com/questions/55087745/how-to-disable-default-spring-security-with-spring-boot

- https://stackoverflow.com/questions/33207448/spring-security-in-spring-boot

- https://stackoverflow.com/questions/49405290/java-spring-basic-authentication-how-to-hash-the-password-defined-in-appli

- https://stackoverflow.com/questions/45556821/spring-security-how-to-change-default-user-and-password
