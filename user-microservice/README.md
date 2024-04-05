#test

#Repository

```
$ https://github.com/breuer/gltest.git
```

#Clone from repository


```
$ git clone https://github.com/breuer/gltest.git
```

#Requirements (run by console)

```
Java
Gradle
```

#Run the aplicacion
_from project folder: user-microservice_

```
$ gradle bootRun
```

#Run unit test
_from project folder: user-microservice_

```
$ gradle test
```
_Path to report test:_


```
$ user-microservice/build/reports/tests/test/index.html
```

#h2-console to check the database:

```
http://localhost:8080/h2-console
```


#Example requests with Postman:

Request "sign-up":

```
POST 
http://localhost:8080/sign-up

Header:
Content-Type: application/json

Body:
{
	"name": "name1",
	"email": "email1@gmail.com",
	"password": "Q1ssword3",
	"phones": [
		{
			"number": 3,
			"citycode": 3,
			"contrycode": "contrycode"
		}
	]
}
```


Response example "sign-up":

```
{
    "id": "28d428fc-e3b2-4f20-84fb-171f29c0372b",
    "created": "05-04-2024 15:24:32",
    "lastLogin": "05-04-2024 15:24:32",
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImVtYWlsMUBnbWFpbC5jb20iLCJleHAiOjE3MTIzNDIzNzJ9.uN4gLtd7nW_TK4br90VGS-EIknQJzOz9hprP6u74c2c",
    "active": true
}
```


Request "login" with token from response sign-up:

```
POST
http://localhost:8080/login
Header:
Content-Type: application/json
Authorization: eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Im5vbWJyZTAxQGdtYWlsLmNvbSIsImV4cCI6MTY0NDkwMTQxMn0.21JOZvsLxo1be1ZWsZ3HbBEh3CwQbG5VXcN4RXXwZzM

Body: Empty
```

Response "login":

```
{
    "id": "28d428fc-e3b2-4f20-84fb-171f29c0372b",
    "created": "2024-04-05T15:24:32.33069",
    "lastLogin": "2024-04-05T15:26:06.046355",
    "name": "name1",
    "email": "email1@gmail.com",
    "password": "$2a$10$U4cG.fybJmjB2HxC7zGxFeGm231.F227RcoV1GcJc0Xzc8M7EQzsS",
    "phones": [
        {
            "number": 3,
            "citycode": 3,
            "contrycode": "contrycode"
        }
    ],
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImVtYWlsMUBnbWFpbC5jb20iLCJleHAiOjE3MTIzNDI0NjZ9._6TA6fsXEtC877yBt_7RxTGp1w_LDbr7tEvTpav5gFo",
    "active": true
}
```