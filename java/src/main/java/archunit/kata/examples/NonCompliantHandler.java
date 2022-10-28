package archunit.kata.examples;

import archunit.kata.examples.commands.Order;

public class NonCompliantHandler implements CommandHandler<Order> {

    @Override
    public int handle(Order command) {
        return 42;
    }
}