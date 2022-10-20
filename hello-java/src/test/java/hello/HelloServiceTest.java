package hello;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloServiceTest {

    @Tag("fast")
    @Test
    void testSayHello() {
        assertEquals("Hello John Doe", new HelloService().sayHello("John Doe"));
    }

    @Slow
    @RepeatedTest(5)
    void testSayHelloNTimes() {
        assertEquals("Hello John Doe", new HelloService().sayHello("John Doe"));
    }
}
