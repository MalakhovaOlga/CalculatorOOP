import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorOOP {
    public static void main (String args[]) {
        String answer = "y";
        System.out.println("Enter two numbers to execute operation addition, subtraction, multiplication or division");
        System.out.println("Examples: 5.0+5.0, 3.2-2.3, 4.4*0, 7.4/2.8");
        do {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next(); // Считывается до первого пробела
//            System.out.println(input);
            try {
                String[] members = analyseInputString(input);
                Calculator calc = new Calculator(Float.parseFloat(members[0]), Float.parseFloat(members[1]), members[2].charAt(0));
                System.out.println("Result = " + String.valueOf(calc.getResult()));
                System.out.println("Would you like to continue? Enter 'y' or 'n'.");
                answer = scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println("Be careful inputting. Examples: 5.0+5.0, 3.2-2.3, 4.4*0, 7.4/2.8. Repeat input");
                System.out.println();
            }
        }
        while (answer.equals("y"));
    }

    public static String[] analyseInputString (String input) throws NullPointerException {
        String [] members = new String [3];
        int i = 0;

        Pattern pattern = Pattern.compile("\\-?\\d+(\\.\\d{0,})?");
        Matcher matcher = pattern.matcher(input);
//        System.out.println(input);

        while (matcher.find()) {
            members[i] = matcher.group();
//            System.out.println(members[i]);
            i++;
        }

        if (i != 2) {
            throw new IllegalArgumentException("Invalid input string format!");
        }

        pattern = Pattern.compile("[/*+-]");
        matcher = pattern.matcher(input);

        i = 0;
        while (matcher.find()) {
            members[2] = matcher.group();
//            System.out.println(members[2]);
            i++;
        }
//        System.out.println(i);
        if (i != 1) {
            throw new IllegalArgumentException("Invalid input string format!");
        }

        return members;
    }
}


