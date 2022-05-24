# translucent-challenge-API

### 🔧 Settins

to install the dependencies of this project just run the maven command.

```
mvn clean install
```
## ⚙️ Unitary tests

This project contains unit and integration tests to test both the Service and the EndPoints available.

## 📦 Development

To start the application just run the class:
```
TranslucentApiApplication
```
There are an RDS MySQL database available on AWS and the port configured to run is the ```8081```, but it can be changed in the YAML file
```
application.yaml
```
A Swagger documentation page for the application endpoints is also available, where the service can be queried and tested.
```
http://localhost:8081/swagger-ui.html
```

## 🛠️ Dependencies

The main dependencies used were:

* [Spring Framework](https://spring.io/) 
* [Maven](https://maven.apache.org/)
* [MySQL](https://www.mysql.com/) 
* [Lombok](https://projectlombok.org/)


## ✒️ Developers

This application was developed by:

* **Lucas Paglia**  - [Linkedin](https://www.linkedin.com/in/lucas-paglia-bb0b33163/)
