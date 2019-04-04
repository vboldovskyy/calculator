import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        if (args.length > 0) {
            StringBuffer argument = new StringBuffer();
            for (int i = 0; i < args.length; i++) {
                argument.append(args[i]);
            }
            try {
                Expression exp = new Expression(argument.toString());
                System.out.println(exp.evaluate());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
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
