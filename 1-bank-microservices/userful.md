https://github.com/JavatoDev-com/internet-banking-concept-microservices

create a mysql user and password
CREATE USER 'user1'@'%' IDENTIFIED BY 'user1';
give it to right to handle actions
GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES on *.* TO 'user1'@'%';
FLUSH PRIVILEGES;

custome a mysql file in docker-compose use docker 
pull the image
set the password
execute the provide sql file


in docker-compose file
    can create a network use ipam to config a subnet
    assign each container a different ip in this subnet
    

Micrometer — For code instrumentation & provide tracing bridge to OpenZipkin Brave.
    Brave — Distributed tracing Instrumentation library supporting both W3C & B3 trace context and propagation formats.
    Zipkin — For visualizing, monitoring & troubleshooting distributed systems micro-service traces.

    https://renilvincent.com/distributed-tracing-for-spring-boot-apps-using-micrometer-and-openzipkin


flyway db  is a database migration tool
    The naming convention for versioned migrations is:{Prefix}{Version}{Separator}{Description}{Suffix}
    By default, for versioned migrations, {Prefix} is V, {Separator} is __, and {Suffix} is .sql.

    V1__Init_Setup.sql
    V2__Add_status_col.sql
    V3.1__create_url_index.sql
    V3.2__add_updated_by_column_to_bookmarks_table.sql
    V4__Add_tags_table.sql

    https://blog.jetbrains.com/idea/2024/11/how-to-use-flyway-for-database-migrations-in-spring-boot-applications/
    https://www.baeldung.com/database-migrations-with-flyway

spring boot boot-strap.yml why exits

    when using Spring Cloud Config Server, you should specify spring.application.name and spring.cloud.config.server.git.uri inside bootstrap.yml
    some encryption/decryption information
    Technically, bootstrap.yml is loaded by a parent Spring ApplicationContext. That parent ApplicationContext is loaded before the one that uses application.yml.



The BeanUtils.copyProperties 
    method from the Spring Framework can be used with any Java objects, not just Spring beans. The term "bean" in this context refers to Java objects that follow the JavaBeans convention, which means they have getter and setter methods for their properties.

    The BeanUtils.copyProperties method works with any instances of classes that have these getter and setter methods, regardless of whether they are managed by the Spring container or not. Therefore, entity and dto can be used with BeanUtils.copyProperties because they are instances of classes that follow the JavaBeans convention.






