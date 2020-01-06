#

Go to the location C:\spring-cloud-linkedin-config and perform below steps

```
user  /c/spring-cloud-linkedin-config
$ git init
Initialized empty Git repository in C:/spring-cloud-linkedin-config/.git/

user  /c/spring-cloud-linkedin-config (master)
$ ls -la
total 25
drwxr-xr-x 1 User 1049089  0 Jan  6 10:58 ./
drwxr-xr-x 1 User 1049089  0 Jan  6 10:56 ../
drwxr-xr-x 1 User 1049089  0 Jan  6 10:57 .git/
-rw-r--r-- 1 User 1049089 51 May 23  2017 guestservices.properties
-rw-r--r-- 1 User 1049089 51 May 23  2017 reservationapp.properties
-rw-r--r-- 1 User 1049089 51 May 23  2017 reservationbusinessservices.properties
-rw-r--r-- 1 User 1049089 51 May 23  2017 reservationservices.properties
-rw-r--r-- 1 User 1049089 51 May 23  2017 roomservices.properties

user  /c/spring-cloud-linkedin-config (master)
$ git add --all
warning: LF will be replaced by CRLF in guestservices.properties.
The file will have its original line endings in your working directory
warning: LF will be replaced by CRLF in reservationapp.properties.
The file will have its original line endings in your working directory
warning: LF will be replaced by CRLF in reservationbusinessservices.properties.
The file will have its original line endings in your working directory
warning: LF will be replaced by CRLF in reservationservices.properties.
The file will have its original line endings in your working directory
warning: LF will be replaced by CRLF in roomservices.properties.
The file will have its original line endings in your working directory

user  /c/spring-cloud-linkedin-config (master)
$ git commit -m "Adding Properties file for Spring Cloud Tutorial"
[master (root-commit) e0f5cb0] Adding Properties file for Spring Cloud Tutorial
 5 files changed, 10 insertions(+)
 create mode 100644 guestservices.properties
 create mode 100644 reservationapp.properties
 create mode 100644 reservationbusinessservices.properties
 create mode 100644 reservationservices.properties
 create mode 100644 roomservices.properties

user  /c/spring-cloud-linkedin-config (master)
```

http://localhost:9000/roomservices/default

```
{
    "name": "roomservices",
    "profiles": [
        "default"
    ],
    "label": null,
    "version": "e0f5cb03799a7e865d403b1f1f240acd35f63fb7",
    "state": null,
    "propertySources": [
        {
            "name": "C:/spring-cloud-linkedin-config/roomservices.properties",
            "source": {
                "server.port": "8101",
                "management.security.enabled": "false"
            }
        }
    ]
}
```

# NOTE: Please make sure you config-server has to be run all the time when working with any other service.

Sequence to run the App Server - 

1) config-server
2) eureka-server
3) room-services
4) guests-services
