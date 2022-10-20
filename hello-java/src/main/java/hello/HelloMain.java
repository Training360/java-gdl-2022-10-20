package hello;

public class HelloMain {

    public static void main(String[] args) {
        var message = new HelloService().sayHello("John Doe");
        System.out.println(message);
    }
}
