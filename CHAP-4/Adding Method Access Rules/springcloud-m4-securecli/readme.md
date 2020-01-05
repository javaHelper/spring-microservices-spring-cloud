# Java Microservices with Spring Cloud: Developing Services

This client only perform the combine action on the Auth Server and Secure Service

With this code we will check fine grain authorization

- alpha user has USER role
- beta user has both USER and OPERATOR role.

As per ``TollUsageController`` and ``getTollData`` has mentioned ``toll_read`` scope and ``ROLE_OPERATOR`` authority.

# SUCCESS REQ-1
- Scope: toll_read
- Username: beta
- Password: pass2

```
  ____  _____ ____ _   _ ____  _____    ____ _     ___ 
 / ___|| ____/ ___| | | |  _ \| ____|  / ___| |   |_ _|
 \___ \|  _|| |   | | | | |_) |  _|   | |   | |    | | 
  ___) | |__| |___| |_| |  _ <| |___  | |___| |___ | | 
 |____/|_____\____|\___/|_| \_\_____|  \____|_____|___|
                                                       
2020-01-05 20:36:26.110  INFO 20624 --- [           main] c.p.SpringcloudM4SecurecliApplication    : No active profile set, falling back to default profiles: default
2020-01-05 20:36:26.574  INFO 20624 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=7b16dedd-40e2-376c-bab7-b4f96fbfa171
2020-01-05 20:36:27.952  INFO 20624 --- [           main] c.p.SpringcloudM4SecurecliApplication    : Started SpringcloudM4SecurecliApplication in 3.533 seconds (JVM running for 4.627)
Perform Fine Grain Authorization - FGA
Token: af1fd567-ed36-4b8b-b871-27dd2e0a6924
Result: [{"Id":"200","stationId":"station150","licensePlate":"B65GT1W","timestamp":"2016-09-30T06:31:22"},{"Id":"201","stationId":"station119","licensePlate":"AHY673B","timestamp":"2016-09-30T06:32:50"},{"Id":"202","stationId":"station150","licensePlate":"ZN2GP0","timestamp":"2016-09-30T06:37:01"}]

```


# FAILURE REQ-1

We know toll_report is the valid scope, but ``TollUsageController`` and ``getTollData`` doesn't support that request, hence its invalid request.

```
Caused by: org.springframework.security.oauth2.common.exceptions.InsufficientScopeException: Insufficient scope for this resource
```

# FAILURE REQ-2

Now alpha user doesn't have access to the resource and trying to make the call gives



