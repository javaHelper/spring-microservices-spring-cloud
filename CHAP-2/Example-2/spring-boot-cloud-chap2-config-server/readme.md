
http://localhost:8888/app1/default

```
{
    "name": "app1",
    "profiles": [
        "default"
    ],
    "label": null,
    "version": null,
    "state": null,
    "propertySources": [
        {
            "name": "classpath:/config/app1.properties",
            "source": {
                "greeting": "hi"
            }
        }
    ]
}
```

http://localhost:8888/app2/default

```
{
    "name": "app2",
    "profiles": [
        "default"
    ],
    "label": null,
    "version": null,
    "state": null,
    "propertySources": [
        {
            "name": "classpath:/config/app2.properties",
            "source": {
                "greeting": "howdy, partner"
            }
        }
    ]
}
```

http://localhost:8888/app3/default

```
{
    "name": "app3",
    "profiles": [
        "default"
    ],
    "label": null,
    "version": null,
    "state": null,
    "propertySources": [
        {
            "name": "classpath:/config/app3.properties",
            "source": {
                "greeting": "hello there"
            }
        }
    ]
}
```