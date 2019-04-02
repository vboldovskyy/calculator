import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Hello! Enter expression to evaluate. Type exit to quit.");
        Scanner input = new Scanner(System.in);
        while (true) {
            String inputLine = input.nextLine();
            if (inputLine.equals("exit")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            try {
                Expression exp = new Expression(inputLine);
                System.out.println(exp.evaluate());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }


    }
}
