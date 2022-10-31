package archunit.kata.examples.controllers;

import archunit.kata.examples.models.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping
    public ApiResponse<Integer> matching() {
        return new ApiResponse<Integer>(42, null);
    }

    public void notMatching() {
    }

    public int universe() {
        return 42;
    }
}
