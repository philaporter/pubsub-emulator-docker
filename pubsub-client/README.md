## Sample Java PubSub Client

### Requirements
```
Java 11
Maven
```

### Getting started
```
mvn clean install
export GOOGLE_APPLICATION_CREDENTIALS=src/main/resources/fake-keyfile.json
java -jar target/pubsub-client-1.0.jar
```

### Sending in messages to the "test-topic" topic
POST to `localhost:8080/publish`. The request body will be written to the topic.

Sample input:
```
{
    "id": "123-abc",
    "description": "sample message"
}
```