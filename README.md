<!--
*** Igor Andrzejewski Readme.md
-->
# Task: REST Service for collecting geolocation data from mobile devices

"Zaimplementować wydajną usługę REST, której zadaniem będzie odbieranie i
zapisywanie informacji o pozycjach (geolokalizacji) z urządzeń mobilnych
np. telefon/lokalizator GPS.
Przykład formatu danych z urządzeń:
{'deviceId':'12345', 'latitude': 505430, 'longitude': 1423412}."

## Technology stack

Application generated with [Spring Initializr](http://start.spring.io)

* Maven
* Java 11
* Spring Boot 2.5.4
    * Spring Web
    * Spring Data JPA
    * Spring Security
* H2 Database

## Information

* Endpoints in this project are secured with Basic authentication.
  Use "admin:password" for tests.
* The console commands in this document are relevant to the Windows command line.
## How to run the app
To run the app on your local machine please run the following command
```shell
./mvnw spring-boot:run
```
## Rest API

### POST new data
```shell
curl -X POST -H "Content-Type: application/json" -u admin:password http://localhost:8080/geolocation -d "{\"deviceId\":\"12345\", \"latitude\":505430, \"longitude\":1423412}"
```
Response example
```json
{
  "id":1,
  "deviceId":"12345",
  "latitude":505430,
  "longitude":1423412,
  "dateTimeNow":"2021-09-11T16:28:40.7939968"
}
```
### Get saved data
####For the convenience of checking the application, the following endpoints return the saved data.

Get all available records
```shell
curl -X GET -u admin:password http://localhost:8080/geolocation
```
response example
```json
[
  {
    "id":1,"deviceId":"12345",
    "latitude":505430,
    "longitude":1423412,
    "dateTimeNow":"2021-09-12T16:48:50.589325"
  },
  {
    "id":2,
    "deviceId":"12345",
    "latitude":505430,
    "longitude":1423412,
    "dateTimeNow":"2021-09-12T16:48:52.45534"
  },
  {
    "id":3,
    "deviceId":"12345",
    "latitude":505430,
    "longitude":1423412,
    "dateTimeNow":"2021-09-12T16:48:53.545206"
  }
]
```

Get one record with a specific index
```shell
curl -X GET -u admin:password http://localhost:8080/geolocation/1
```
response example
```json
{
  "id":1,
  "deviceId":"12345",
  "latitude":505430,
  "longitude":1423412,
  "dateTimeNow":"2021-09-12T16:48:50.589325"
}
```
## Test
The project implements tests:
* 1 attempt to add the correct JSON
* 7 attempts to add JSON containing incorrect data

To run the tests on your local machine please run the following command
```shell
mvn test
```