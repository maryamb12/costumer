import View.ConsoleIU;
import service.CostumerService;

public class AplicatoinRunner {
    public static void main(String[] args) {
        try(ConsoleIU consoleIU =new ConsoleIU()) {
            consoleIU.startMenu();
        }
    }
}
