# springboot-microservice-practice
my practice for microservices

Eureka:
    server:
        in main funtion put @EnableEurekaServer
        config application.yml
            url.....
config server
    in main fucntion put @EnableConfigServer
    config application.yml
        give a centenralise path
    if the config file has conflict with the local config file application.yml after running it will replace the local config file
    