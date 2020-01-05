# Java Microservices with Spring Cloud: Developing Services

```
curl -X POST \
  http://localhost:9000/services/oauth/token \
  -H 'authorization: Basic amF2YUhlbHBlcjpqYXZhSGVscGVyc2VjcmV0' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: 2967c947-c706-6a6f-a0ea-254e0511bd3f' \
  -d 'grant_type=password&client_id=javaHelper&username=test&password=test'
```

Response

```
{
    "access_token": "b0800bd0-bc6d-4a65-9e90-c593341cb094",
    "token_type": "bearer",
    "refresh_token": "c0560a58-08c3-401d-aa96-3a910f1b0a9b",
    "expires_in": 43199,
    "scope": "toll_read toll_report"
}
```

Use this only !!




# Issue:
Handling error: IllegalArgumentException, There is no PasswordEncoder mapped for the id "null"

Prior to Spring Security 5.0 the default PasswordEncoder was NoOpPasswordEncoder which required plain text passwords. In Spring Security 5, the default is DelegatingPasswordEncoder, which required Password Storage Format.

- https://www.mkyong.com/spring-boot/spring-security-there-is-no-passwordencoder-mapped-for-the-id-null/
- https://spring.io/blog/2017/11/01/spring-security-5-0-0-rc1-released#password-storage-format
- https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#pe-dpe


```
curl -X POST \
  http://localhost:9000/services/oauth/token \
  -H 'authorization: Basic amF2YUhlbHBlcjpqYXZhSGVscGVyc2VjcmV0' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: 531c7bb6-7ed3-7659-3c6a-b7965ee1e474' \
  -d 'grant_type=password&client_id=javaHelper&username=alpha&password=pass1'
```

Response

```
{
    "access_token": "4d0cb5e6-5f72-4b09-9088-b32aeff9f20f",
    "token_type": "bearer",
    "refresh_token": "2c17abb4-48f4-4ca7-991a-aed9dd59a70d",
    "expires_in": 43199,
    "scope": "toll_read toll_report"
}
```


# Steps to follow:

Firstly get the token..

```
curl -X POST \
  http://localhost:9000/services/oauth/token \
  -H 'authorization: Basic amF2YUhlbHBlcjpqYXZhSGVscGVyc2VjcmV0' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: 481bf402-ac9e-b708-e0f2-b1d1e62b68e2' \
  -d 'grant_type=password&client_id=javaHelper&username=alpha&password=pass1'
```
  
```
{
    "access_token": "61aa26fb-91fc-4550-8fa9-ef93dd15c0d7",
    "token_type": "bearer",
    "refresh_token": "2fc49bce-0046-49e5-918d-eb79061f4257",
    "expires_in": 43199,
    "scope": "toll_read toll_report"
}
```

Use the access_token and call the Rest endpoint 

```
curl -X GET \
  http://localhost:9001/services/tolldata \
  -H 'authorization: Bearer 61aa26fb-91fc-4550-8fa9-ef93dd15c0d7' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 449cbf24-3e72-9142-0723-3e2f6b6669df'
```