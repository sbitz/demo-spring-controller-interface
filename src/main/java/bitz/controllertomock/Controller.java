package bitz.controllertomock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface Controller {

    @Operation(summary = "The default initial response")
    @GetMapping
    String getHome();

    @Operation(summary = "Return the passed message as part of the response.")
    @GetMapping("/echo")
    String echo(
            @Parameter(description = "Description: The message text to include in the response.")
            @RequestParam String message
    );

    @PutMapping("/add")
    ResponseEntity<String> add(@RequestParam String element);

    @GetMapping("/messages")
    ResponseEntity<List<String>> messages();

}
