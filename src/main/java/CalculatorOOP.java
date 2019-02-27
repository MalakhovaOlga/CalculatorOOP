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
            String input = scanner.next();
            try {
                String[] members = analyseInputString(input);
                Calculator a = new Calculator(Float.parseFloat(members[0]));
                Calculator b = new Calculator(Float.parseFloat(members[1]));
                Calculator c = new Calculator(0);
                switch (members[2].charAt(0)) {
                    case '+':
                        c.set(a.executeAdditon(b));
                        break;
                    case '-':
                        c.set(a.executeSubtraction(b));
                        break;
                    case '*':
                        c.set(a.executeMultiplication(b));
                        break;
                    case '/':
                        c.set(a.executeDivision(b));
                        break;
                }

                System.out.println(input + " = " + c.toString());
                System.out.println("Would you like to continue? Enter 'y' or 'n'.");
                answer = scanner.next();

            } catch (NullPointerException e) {
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

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            members[i] = input.substring(start,end);
//            System.out.println(members[i]);
            i++;
        }

        if (i > 2) {
            throw new NullPointerException();
        }

        pattern = Pattern.compile("[/*+-]");
        matcher = pattern.matcher(input);

        i = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            members[2] = input.substring(start,end);
//            System.out.println(members[2]);
            i++;
        }

        if (i > 1) {
            throw new NullPointerException();
        }

        return members;
    }
}
