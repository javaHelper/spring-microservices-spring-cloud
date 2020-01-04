# Java Microservices with Spring Cloud: Developing Services

Note: The current setup will not understand the PATH /tree/master/, If you pull your properties file outside of /tree/master/, then it works.

http://localhost:8888/s1rates/default

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

http://localhost:8888/s1rates/master

```
{
    "name": "s1rates",
    "profiles": [
        "master"
    ],
    "label": null,
    "version": "fd8bd59e46727dcdba7373b13b139f4c3d8bc3df",
    "state": null,
    "propertySources": [
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

Once you add the ``spring.cloud.config.server.git.search-paths=station*`` then you should be getting `rate` and `lanecount`.'

http://localhost:8888/s1rates/master

```
{
    "name": "s1rates",
    "profiles": [
        "master"
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

http://localhost:8888/s1rates/dev

```
{
    "name": "s1rates",
    "profiles": [
        "dev"
    ],
    "label": null,
    "version": "fd8bd59e46727dcdba7373b13b139f4c3d8bc3df",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/rseroter/pluralsight-spring-cloudconfig-wa-tolls/station1/s1rates-dev.properties",
            "source": {
                "rate": "1.91",
                "lanecount": "1",
                "environment": "development"
            }
        },
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

http://localhost:8888/s2rates/qa

```
{
    "name": "s2rates",
    "profiles": [
        "qa"
    ],
    "label": null,
    "version": "fd8bd59e46727dcdba7373b13b139f4c3d8bc3df",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/rseroter/pluralsight-spring-cloudconfig-wa-tolls/station2/s2rates.properties",
            "source": {
                "rate": "1.65",
                "lanecount": "3"
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

http://localhost:8888/s1rates-default.properties

```
connstring: db24ba12fdfbd64ad916605c2a4754e7e205b17e3bec97eab03e05ddcfc0d72f26dca00ff0be5b34d45533b2665f945303d8254eb842964cbac64379e144494e553a96baa8c913fdb84eacfee7c09fdd
lanecount: 1
rate: 2.00
tollstart: 05:00
tollstop: 22:00
```

http://localhost:8888/s1rates-default.yml

```
connstring: db24ba12fdfbd64ad916605c2a4754e7e205b17e3bec97eab03e05ddcfc0d72f26dca00ff0be5b34d45533b2665f945303d8254eb842964cbac64379e144494e553a96baa8c913fdb84eacfee7c09fdd
lanecount: '1'
rate: '2.00'
tollstart: 05:00
tollstop: '22:00'
```

http://localhost:8888/s1rates-default.json

```
{
    "connstring": "db24ba12fdfbd64ad916605c2a4754e7e205b17e3bec97eab03e05ddcfc0d72f26dca00ff0be5b34d45533b2665f945303d8254eb842964cbac64379e144494e553a96baa8c913fdb84eacfee7c09fdd",
    "lanecount": "1",
    "rate": "2.00",
    "tollstart": "05:00",
    "tollstop": "22:00"
}
```

Note - If you look at the logs, the spring boot project automatically adds application.properties.

```
2020-01-04 19:22:04.286  INFO 26972 --- [nio-8888-exec-6] o.s.c.c.s.e.NativeEnvironmentRepository  : Adding property source: file:/C:/Users/user/AppData/Local/Temp/1/config-repo-9094371031344757874/application.properties
```

http://localhost:8888/s1rates-dev.json

```
{
    "connstring": "db24ba12fdfbd64ad916605c2a4754e7e205b17e3bec97eab03e05ddcfc0d72f26dca00ff0be5b34d45533b2665f945303d8254eb842964cbac64379e144494e553a96baa8c913fdb84eacfee7c09fdd",
    "environment": "development",
    "lanecount": "1",
    "rate": "1.91",
    "tollstart": "05:00",
    "tollstop": "22:00"
}
```

If I give wrong profile, still I get the default profile value.

http://localhost:8888/s1rates-america.json

```
{
    "connstring": "db24ba12fdfbd64ad916605c2a4754e7e205b17e3bec97eab03e05ddcfc0d72f26dca00ff0be5b34d45533b2665f945303d8254eb842964cbac64379e144494e553a96baa8c913fdb84eacfee7c09fdd",
    "lanecount": "1",
    "rate": "2.00",
    "tollstart": "05:00",
    "tollstop": "22:00"
}
```

Now, see the magic

http://localhost:8888/s1rates/perf

```
{
    "name": "s1rates",
    "profiles": [
        "perf"
    ],
    "label": null,
    "version": "2cc6b761633c5495b9f20278c203dde56400876c",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/rseroter/pluralsight-spring-cloudconfig-wa-tolls-perf/station1/s1rates.properties",
            "source": {
                "rate": "5",
                "lanecount": "5"
            }
        },
        {
            "name": "https://github.com/rseroter/pluralsight-spring-cloudconfig-wa-tolls-perf/application.properties",
            "source": {
                "rate": "1.55",
                "tollstart": "05:00",
                "tollstop": "22:00",
                "lanecount": "0"
            }
        }
    ]
}
```

http://localhost:8888/s3rates/perf

```
{
    "name": "s3rates",
    "profiles": [
        "perf"
    ],
    "label": null,
    "version": "2cc6b761633c5495b9f20278c203dde56400876c",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/rseroter/pluralsight-spring-cloudconfig-wa-tolls-perf/station3/s3rates.properties",
            "source": {
                "rate": "9.10",
                "lanecount": "8"
            }
        },
        {
            "name": "https://github.com/rseroter/pluralsight-spring-cloudconfig-wa-tolls-perf/application.properties",
            "source": {
                "rate": "1.55",
                "tollstart": "05:00",
                "tollstop": "22:00",
                "lanecount": "0"
            }
        }
    ]
}
```