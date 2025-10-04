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

