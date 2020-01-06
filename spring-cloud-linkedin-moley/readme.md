# Spring: Spring Cloud

Execute the ``http://localhost:8600/reservations``, you should be able to see the page

![Alt text](images/cloud.png?raw=true "Title")

Now, simply off the guest-services and fallback should work.

Then first enrty

![Alt text](images/cloud2.png?raw=true "Title")

http://localhost:8500/rooms - This works.

# Hystrix

- http://localhost:8500/hystrix

![Alt text](images/hystrix.png?raw=true "Title")

Use below - ``http://localhost:8500/hystrix.stream`` and hit the ``http://localhost:8600/reservations?date=2017-01-01``

![Alt text](images/hystrix.png?raw=true "Title")


Shutdown the ``guest-service`` and hit the ``http://localhost:8600/reservations?date=2017-01-01``

![Alt text](images/socket.png?raw=true "Title")