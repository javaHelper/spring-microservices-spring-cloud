# Spring Cloud Latest

1) Make sure "config-server" is up, execute 

```
http://localhost:9000/guestservices/default
```

Response

```
{
    "name": "guestservices",
    "profiles": [
        "default"
    ],
    "label": null,
    "version": "1a449dcb2c213554a88107065d20ab86ac8adea6",
    "state": null,
    "propertySources": [
        {
            "name": "C:/config/guestservices.properties",
            "source": {
                "server.port": "8800"
            }
        }
    ]
}
```

This will give guests data

http://localhost:8800/guests

http://localhost:8801/reservations

http://localhost:8802/rooms

http://localhost:8080/room-reservations
