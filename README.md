# ShopApp
## Spring Boot / Spring Data Jpa / Hibernate / MySQL / OAuth2 Application

This is a simple Online Shop application that provides a RESTful service protected by OAuth 2. We use a MySQL database for store OAuth tokens and user data (BCrypt).

## Frameworks

This app use following Spring projects, libraries and frameworks:

* [Spring Boot](http://projects.spring.io/spring-boot/)
* [Spring Security](http://projects.spring.io/spring-security/)
* [Spring Security OAuth](http://projects.spring.io/spring-security-oauth/)
* [Spring Data JPA](http://projects.spring.io/spring-data-jpa/)
* [Hibernate](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/orm.html#orm-hibernate)

## How to build and run

Just run with maven

```
mvn clean package spring-boot:run
```

## Spring Security and OAuth2

You can find more information about Spring Security and OAuth2 integration by [following this link](https://github.com/handioq/spring-boot-security-oauth2/).
