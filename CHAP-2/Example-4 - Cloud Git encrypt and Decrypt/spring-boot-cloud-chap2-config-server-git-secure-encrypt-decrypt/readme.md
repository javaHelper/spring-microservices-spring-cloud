# Java Microservices with Spring Cloud: Developing Services

We're going to perform the encryption and decryption of the property values mentioned in GIT. 

Note: Please make sure to download latest version of ``JCE`` files and change/add those files to ``jre\lib\security`` of your Java PATH.

In my case its ``C:\Softwares\Java\jdk1.8.0_171\jre\lib\security``, path will be different as per machine setup.

Now perform HTTP POST: ``http://localhost:8888/encrypt`` and make sure you select HTTP Basic Auth - username and password ``test``.

CURL command - 

```
curl -X POST \
  http://localhost:8888/encrypt \
  -H 'authorization: Basic dGVzdDp0ZXN0' \
  -d 'connectionstring=server123;username=root;password=pass@word1'
```

This gives me below value

```
cb9efdcde675def7e6a2dd79a58f5552073cbb02e8efc339422a7746b46031b92cc9d65e7bf49086068589e0585acd486ecfc281bb714ea493ea41674de200a5e647797e7ad9475f4bddd966b2cdfcfb
```


# Now decrypt this value

Now perform HTTP POST: ``http://localhost:8888/decrypt`` and make sure you select HTTP Basic Auth - username and password ``test``.

You should get original text now.

```
curl -X POST \
  http://localhost:8888/decrypt \
  -H 'authorization: Basic dGVzdDp0ZXN0' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 4cdbb04c-48d7-caa8-3638-68069ff4259a' \
  -d cb9efdcde675def7e6a2dd79a58f5552073cbb02e8efc339422a7746b46031b92cc9d65e7bf49086068589e0585acd486ecfc281bb714ea493ea41674de200a5e647797e7ad9475f4bddd966b2cdfcfb
```

Response - 

```
connectionstring=server123;username=root;password=pass@word1
```

Now simply perform

``http://localhost:8888/s1rates/default``

Now you should see original text in connstring. 

```
{
    "name": "s1rates",
    "profiles": [
        "default"
    ],
    "label": null,
    "version": "fd8bd59e46727dcdba7373b13b139f4c3d8bc3df",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/rseroter/pluralsight-spring-cloudconfig-wa-tolls/station1/s1rates.properties",
            "source": {
                "rate": "2.00",
                "lanecount": "1"
            }
        },
        {
            "name": "https://github.com/rseroter/pluralsight-spring-cloudconfig-wa-tolls/application.properties",
            "source": {
                "rate": "1.55",
                "tollstart": "05:00",
                "tollstop": "22:00",
                "lanecount": "0",
                "connstring": "connectionstring=server123;user=root;password=pass@word1"
            }
        }
    ]
}
```

Now you can also call the value from the Client. Now make config-client is working.

http://localhost:8080/rate

```
JavaHelper Training: Spring Cloud Config Client
Your rate is: 1.99, number of lanes is 2, toll start time is 05:00 and encrypted value is connectionstring=server123;user=root;password=pass@word1!
```

# This will not decrypt the cipher values and will give original text.
spring.cloud.config.server.encrypt.enabled=false

Request

```
http://localhost:8888/s1rates/default
```

Response

```
{
    "name": "s1rates",
    "profiles": [
        "default"
    ],
    "label": null,
    "version": "fd8bd59e46727dcdba7373b13b139f4c3d8bc3df",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/rseroter/pluralsight-spring-cloudconfig-wa-tolls/station1/s1rates.properties",
            "source": {
                "rate": "2.00",
                "lanecount": "1"
            }
        },
        {
            "name": "https://github.com/rseroter/pluralsight-spring-cloudconfig-wa-tolls/application.properties",
            "source": {
                "rate": "1.55",
                "tollstart": "05:00",
                "tollstop": "22:00",
                "lanecount": "0",
                "connstring": "db24ba12fdfbd64ad916605c2a4754e7e205b17e3bec97eab03e05ddcfc0d72f26dca00ff0be5b34d45533b2665f945303d8254eb842964cbac64379e144494e553a96baa8c913fdb84eacfee7c09fdd"
            }
        }
    ]
}
```

If you wants to access it from client add ``encrypt.key: ABCDEFGHIJKLMNOPQRSTUVWXYZ`` to clients bootstrap.properties file..
