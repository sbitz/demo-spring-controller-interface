# Demo Spring Controller Interface

This repository contains an example Spring application where a controller is decorated with OpenApi specification annotations, but the implementation is separated.

An example controller interface:

```java
public interface Controller {

    @Operation(summary = "This shows in Swagger")
    //...
    @GetMapping
    String getRoot();
}
```

And the implementation, which is marked as the RestController to be configured by Spring.

```java

@RestController("/")
public class ControllerImpl implements Controller {

    @Override
    public String getRoot() {
        return "Hello";
    }
}
```

The benefit of using this pattern is that the controller implementation remains clear, while the Swagger interface can be updated to include examples and descriptions of parameters. This is a separation of concerns between the interface and implementation.


## Run the code

```shell
./gradlew bootRun
```

Once running, Open Swagger ([localhost:8090/swagger-ui/index.html](https://localhost:8090/swagger-ui/index.html)) to view the result of Interface annotations and execute requests against endpoints, or continue below to test functionality from the CLI.

And in another window, make a request

```shell
curl localhost:8090
```
.. the server replies 'Hello'
```console
Hello
```

Check messages which are empty
```shell
curl localhost:8090/messages
```
No messages, so an empty array is returned
```console
[]
```

Add a message
```shell
curl -X 'PUT' localhost:8090/add?element=foo
```
the response indicates that an element was added.
```console
Added
```

Check messages again
```shell
curl localhost:8090/messages
```
The element is returned in the array.
```console
["foo"]
```

## Mock with Wiremock

See the [Docker Readme](src/main/docker/README.md)
Create mappings there to prepare a response to an endpoint.