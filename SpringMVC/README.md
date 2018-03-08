# Spring MVC Boilerplate

This is Spring MVC boilerplate used by Multiplica Mexico.

# Dependencies 

* Spring Core
* Spring MVC
* Spring Boot
* Maven
* Docker(Optional)

# Local environment 

## Create WAR 

````shell
make build-maven
````

## Run in development mode

````shell
make run-maven
````

# Docker environment

Docker allow us to isolate the dev environment

## Create War

````shell
make build
````

## Run Docker in production mode

````shell
make run-production
````

## Run Docker in development mode

````shell
make run-develop
````