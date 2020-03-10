# Hotel API [![Build Status](https://travis-ci.com/mplanchant/springboot-raml-example.svg?branch=master)](https://travis-ci.com/mplanchant/springboot-raml-example)
## Brief 
You are required to create a basic booking system for a small hotel. 
The hotel has 5 rooms available to hire, 2 Single rooms charged at £100 per night and 3 double rooms at £200 per night. 
Front end access to the booking system is to be handled elsewhere you are only required to create RESTFUL services which expose specific functionality. 

## Requirements 
* A GET message which will retrieve any bookings for a specific room ID
* A GET message which will retrieve any bookings for a specific customer ID
* A GET message to determine the availability of a specific room during a given date range
* A POST message to create a new booking. 

The booking system must be written as a Spring Boot application. 
The resultant source code along with any tests or build scripts must be uploaded to a GIT based repository, (GitHub/BitBucket) and a URL provided 

## Considerations
* Persistence – In Memory DB is fine
* Stub test data – Can be hard coded POJOS or loaded in to the DB during deployment
* Object model – How is data transformed between the DB and response from the service
* Tests – Unit, Mock & Integration should be supplied. 
* UI – No UI is required services should be testable via CURL or Postman
* Documentation – A Readme should be provided to give a simple overview of the solution
* Deployment – Build scripts should be provided, a link to an instance running in AWS would be a nice to have but is not required. 
