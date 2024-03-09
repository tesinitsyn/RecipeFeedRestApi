FROM openjdk:21
COPY target/RecipeFeedRestApi-0.0.1-SNAPSHOT.jar RecipeFeedRestApi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/RecipeFeedRestApi-0.0.1-SNAPSHOT.jar"]