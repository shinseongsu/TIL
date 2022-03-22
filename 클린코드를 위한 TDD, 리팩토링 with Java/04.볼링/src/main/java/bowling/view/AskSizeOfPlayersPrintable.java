package bowling.view;

public class AskSizeOfPlayersPrintable extends Printable {
    AskSizeOfPlayersPrintable() {
        append(lineSeparator);
        append("How many people? ");
    }
}