# spring-data-neo4j-blockhound
To demonstrate blocking call on Spring Data 

Spring Data gets "Blocking Call" exception while projection. 
![image](https://user-images.githubusercontent.com/21952165/142402555-225adb7b-61de-457e-9e33-b90a8517ea73.png)


# Installation
Use maven to build;
###### mvn clean install -DskipTests
Use Docker compose to run Application and Neo4j
###### docker-compose -f docker-compose.yml up -d --build

# Test
Open http://localhost:8080/people from browser then check the logs.
