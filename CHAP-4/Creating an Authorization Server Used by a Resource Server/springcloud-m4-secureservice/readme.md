# Java Microservices with Spring Cloud: Developing Services


```
curl -X GET \
  http://localhost:9001/services/tolldata \
  -H 'authorization: Basic dXNlcjo1ODIwN2U5OS0wYWM4LTRjN2YtOTEyYS0xMmE4ZjI4Y2Y1MzE=' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 1238fed9-6b70-11ca-7d10-63fc05a687b4'
```
 
Look for Using generated security password: 58207e99-0ac8-4c7f-912a-12a8f28cf531 when the app started.

![Alt text](SecureUi.png?raw=true "Title")

After this annotate SecureserviceApp with ``@EnableResourceServer`` and ``security.oauth2.resource.user-info-uri=https://api.github.com/user`` to ``application.properties``

Then simply hit 

```
curl -X GET \
  http://localhost:9001/services/tolldata \
  -H 'authorization: Basic dXNlcjo1ODIwN2U5OS0wYWM4LTRjN2YtOTEyYS0xMmE4ZjI4Y2Y1MzE=' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 1238fed9-6b70-11ca-7d10-63fc05a687b4'
```

Response

```
{
    "error": "unauthorized",
    "error_description": "Full authentication is required to access this resource"
}
```