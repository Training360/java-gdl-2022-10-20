package hello;

import java.nio.file.Path;

public class HelloMain {

    public static void main(String[] args) {
        var message = new HelloService().sayHello("John Doe");
        System.out.println(message);

        // Paths.
        new HelloService().writeCodeToFile("John Doe", Path.of("johndoe.png"));
    }
}
