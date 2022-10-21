package training.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MessageController {

    @GetMapping("/")
    public Message getMessage() {
        return new Message("Hello " + LocalDateTime.now());
    }
}
