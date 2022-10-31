package archunit.kata.examples;

public interface CommandHandler<TCommand extends Command> {
    int handle(TCommand command);
}