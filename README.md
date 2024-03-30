# customqueries01
- write a Spring Boot application with the necessary dependencies that:
    - has an entity `Flight` with the following columns:
        - a primary key
        - a string `description`
        - a string `fromAirport`
        - a string `toAirport`
        - an enum `status`
            - the possible values are `ONTIME`, `DELAYED` and `CANCELLED`
    - has a dedicated repository
    - has a `FlightController`:
        - mapped on `flights`
        - for the provisioning of 50 flights where:
            - all the string values are randomly generated (using `random.ints()`)
            - the default status is `ON_TIME`
        - for retrieving all the flights in the db
- test the 2 endpoints with `Postman`
 
**Also added CRUD**
