package bitz.controllertomock;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController("/")
public class ControllerImpl implements Controller {

    @Override
    public String getHome() {
        return "Hello";
    }

    @Override
    public String echo(String message) {
        return "hello, " + message;
    }

    private List<String> messages = new ArrayList<>();

    @Override
    public ResponseEntity<String> add(String element) {
        Objects.requireNonNull(element, "Element param is required");
        messages.add(element);
        return ResponseEntity.ok("Added");
    }

    @Override
    public ResponseEntity<List<String>> messages() {
        return ResponseEntity.ok(messages);
    }
}
