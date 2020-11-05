<img src="https://i.ibb.co/5xLcGM0/f3b4238175fc8c88229595b50f514d09.gif" width="1013" height="422" />

# University Application

## Purpose

Small console-based app created as a test task for BotsCrew. I wish you like it :smile:

There is a university, where we have a lot of departments, lectors and degrees. How are we supposed to deal with that? 
This app have been created for getting details about lectors in university. 
Here we have 4 entities:
* Person - an abstract entity, which was created due to possible cpmplement with other entities, like students, etc;
* Lector - general entity which contains business information about lector;
* Degree - simple entity with information about degree;
* Department - general entity with information about department.

## How-To-Use

Start application, write one of the following commands:

* head {department_name} - get head of department           
* statistics {department_name} - department statistics         
* salary {department_name} - get average salary by department
* count {department_name} - get amount of employee by department   
* search {suffix} - global search    

## How-To-Run

* Fork project to your local device;
* Download and install MySQL Workbench for better understanding DB structure;
* Instantiate DB:
    * Create DB with name "root" and password "123456v", create schema named "uni";
    * OR insert name of your DB to field "spring.datasource.username" and password to "spring.datasource.password", additionaly change name of used schema in "spring.datasource.url"

## Used Technologies

* Spring Boot
* Spring Data
* JPA
* Lombok
* MySQL

# Thank you for reviewing!
