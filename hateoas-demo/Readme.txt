HATEOAS is a constraint of the REST architecture that keeps REST APIs self-descriptive by including hyperlinks (or links) in responses. 
These links guide clients on what actions are available next.


GET http://localhost:8080/users
GET http://localhost:8080/users/1
GET http://localhost:8080/users/1/orders