package main.java.trials;

public class AnonymousClasses {

    @FunctionalInterface
    public interface SquareNumber {
        public void execute();
    }

    interface HelloWorld {
        public void greet();
        public void greetSomeone(String name);
    }

    public void sayHelloInSpanish() {
        HelloWorld spanish = new HelloWorld() {
            String name = "mundo";
            @Override
            public void greet() {
                greetSomeone(name);
            }

            @Override
            public void greetSomeone(String name) {
                name = name;
                System.out.println("Hola, " + name);
            }
        };
        spanish.greet();
    }

    public static void main(String[] args) {
        AnonymousClasses ac = new AnonymousClasses();
        ac.sayHelloInSpanish();
    }
}
