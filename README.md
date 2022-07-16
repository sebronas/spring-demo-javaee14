### MVC pattern
- Model (data + operations on data)
- View (views presented to user)
- Controller (handling incoming requests and provides views for clients/users)

### Application architecture with MVC
* View
* Controller
* Model (service + Repository)

### Application architecture with MVC - second view
- View, presented to user
- Controller (should have reference to Service), handling incoming requests and provides views for clients/users
- Service (should have reference to Repository), processed data
- Repository, stores and provides access to data (eg. database)

### HTTP
Request consist of:
  - url
  - headers
  - params
  - body
Response consist of:
  - status code
  - body
  - cookies
  - headers


Status codes:
- 1xx - confirmed - processing in progress
- 2xx - success;
- 3xx - redirects;
- 4xx - client fault;
- 5xx - server fault

### REST API
- for exchanging data in universal formats- JSON/XML
- for sharing resources
- CRUD - create, read, update, delete
- resources should be plural nouns and organized in hierarchical way
- Reservation - it's resource
- first and second proposal:
  - /reservations - for reading all reservations - with GET Http method
  - /reservations - for creation/adding - with POST Http method
  - /deletereservations - for deleting reservation - with DELETE Http method
  - /updatereservation - for updating reservation - with PUT Http method
- third proposal:
  - /reservations - GET - for Reading all resources (R - CRUD) 
    - status code 200 OK
  - /reservations/{id} - GET - for Reading one resource (R - CRUD) 
    - status code 200 with response body if ok
    - status code 404 with no response body (or error object) 
  - /reservations - POST
  - /reservations/{id} (/reservations/1234555) - DELETE - for Deletion (D from CRUD)
  - /reservations/{id} (/reservations/1234555) - PUT - for Update (U from CRUD)
  - /reservations/{id} (/reservations/1234555) - PATCH - for Update (partial) (U from CRUD)