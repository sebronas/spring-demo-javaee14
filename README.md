### MVC pattern
- Model (data + operations on data)
- View (views presented to user)
- Controller (handling incoming requests and provides views for clients/users)

### Application architecture with MVC
* View
* [Controller](https://github.com/sebronas/spring-demo-javaee14/tree/master/src/main/java/com/sda/springdemojavaee14/controller/rest/ReservationRestController.java)
* Model (service + Repository)

### Application architecture with MVC - second view
- View, presented to user
- Controller (should have reference to Service), handling incoming requests and provides views for clients/users
- Service (should have reference to Repository), processed data
- Repository, stores and provides access to data (eg. database)
