package Util;

import java.util.Scanner;
import java.util.function.Function;

public class ScannerWrapper implements AutoCloseable {

    private static final Scanner scanner;
    private static final ScannerWrapper INSTANCE;

    static {
        scanner = new Scanner(System.in);
        INSTANCE = new ScannerWrapper();
    }

    public static final ScannerWrapper getInstance(){
        return INSTANCE;
    }

    private ScannerWrapper() {
    }

    public <T> T getUserInfo(String message, Function<String,T> converter) {
        System.out.println(message);
        try {
            return converter.apply(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Exception: Type of input is incorrect!");
            return getUserInfo(message,converter);
        }
    }


    @Override
    public void close() {
        scanner.close();
    }
}
