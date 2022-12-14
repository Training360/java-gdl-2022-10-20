package training.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MessageControllerIT {

    @Autowired
    WebTestClient webClient;

    @Test
    void testGetMessage() {
        webClient
                .get()
                .uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Message.class).value(
                        m -> assertThat(m.getText()).startsWith("Hello"));
    }
}
