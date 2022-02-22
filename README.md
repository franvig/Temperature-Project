# Temperature Project

REST API que recibe una lista de lecturas de temperatura obtenidas por termostatos inteligentes y determina el mayor incemento de temperatura entre dos lecturas.

##Getting Started
Versión: 0.0.1-SNAPSHOT
Generar JAR: mvn clean package spring-boot:repackage

##Technologies
Java 11
Spring Boot 2.6.3 (Starter Spring Web)

##Utils
Ejemplo para enviar peticiones REST desde POSTMAN en localhost: POST > http://localhost:8080/v2/stats/compute
Body > RAW > json > {"readings": ["1", "2", "3", "4", "5", "6"]}


"# temperature" 
