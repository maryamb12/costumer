import View.ConsoleUI;

public class AplicatoinRunner {
    public static void main(String[] args) {
        ConsoleUI consoleUI =new ConsoleUI();
        try{
            consoleUI.startMenu();
        }catch (Throwable ex){
            System.out.println("System Error!");
            ex.printStackTrace();
        }
        finally {
            consoleUI.close();
        }
    }
}
