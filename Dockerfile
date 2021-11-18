FROM openjdk:11

COPY ./wait-for-it.sh /usr/wait-for-it.sh
RUN chmod +x /usr/wait-for-it.sh

EXPOSE 8080
ADD target/neo4jTestApplication.jar neo4jTestApplication.jar